/*
 *    Copyright 2009-2014 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.callback.DAOCallback;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.util.POIdentifyMapper;

/**
 * @author Clinton Begin
 * @author Eduardo Macarron
 */
public class POMapperProxy<T> implements InvocationHandler, Serializable
{

	private static final long serialVersionUID = -6424540398559729838L;

	private final SqlSession sqlSession;

	private final Class<T> mapperInterface;

	private final Map<Method, MapperMethod> methodCache;

	public POMapperProxy(SqlSession sqlSession, Class<T> mapperInterface, Map<Method, MapperMethod> methodCache)
	{
		this.sqlSession = sqlSession;
		this.mapperInterface = mapperInterface;
		this.methodCache = methodCache;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		try
		{
			Object result;
			if (method.getName().equalsIgnoreCase("select"))
			{
				result = (List<Object>)sqlSession.select(args[0], (DAOCallback)args[1]);
			}
			else if (method.getName().equalsIgnoreCase("update"))
			{
				result = sqlSession.update(args[0], args[1]);
			}
			else if (method.getName().equalsIgnoreCase("delete"))
			{
				result = sqlSession.delete(args[0]);
			}
			else if(method.getName().equalsIgnoreCase("insert"))
			{
				result = sqlSession.insert(args[0]);
			}
			else
			{
				throw new BindingException("Unknown execution method for: " + method.getName());
			}
			return result;
		}
		catch (Throwable t)
		{
			throw ExceptionUtil.unwrapThrowable(t);
		}
	}

	
	

}
