/*
 *    Copyright 2009-2012 the original author or authors.
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
package org.apache.ibatis.scripting.defaults;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * @author Clinton Begin
 * @author Eduardo Macarron
 */
public class DefaultParameterHandler implements ParameterHandler
{

	private final TypeHandlerRegistry typeHandlerRegistry;

	private final MappedStatement mappedStatement;

	private final Object parameterObject;

	private BoundSql boundSql;

	private Configuration configuration;

	public DefaultParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql)
	{
		this.mappedStatement = mappedStatement;
		this.configuration = mappedStatement.getConfiguration();
		this.typeHandlerRegistry = mappedStatement.getConfiguration().getTypeHandlerRegistry();
		this.parameterObject = parameterObject;
		this.boundSql = boundSql;
	}

	public Object getParameterObject()
	{
		return parameterObject;
	}

	public void setParameters(PreparedStatement ps) throws SQLException
	{
		ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null)
		{
			for (int i = 0; i < parameterMappings.size(); i++)
			{
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT)
				{
					Object value;
					String propertyName = parameterMapping.getProperty();
					if (boundSql.hasAdditionalParameter(propertyName))
					{ // issue #448 ask first for additional params
						value = boundSql.getAdditionalParameter(propertyName);
					}
					else if (parameterObject == null)
					{
						value = null;
					}
					else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass()))
					{
						value = parameterObject;
					}
					else
					{
						MetaObject metaObject = configuration.newMetaObject(parameterObject);
						value = metaObject.getValue(propertyName);
					}
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					JdbcType jdbcType = parameterMapping.getJdbcType();
					if (value == null && jdbcType == null)
						jdbcType = configuration.getJdbcTypeForNull();
					typeHandler.setParameter(ps, i + 1, value, jdbcType);
				}
			}
		}
	}

	/**
	 * 	新增方法，设置Statement的参数
	 * @param ps
	 * @param params
	 * @throws SQLException
	 */
	public void setParameters(PreparedStatement ps, List<Object> params) throws SQLException
	{
		try
		{
			if (params != null)
			{
				for (int i = 0; i < params.size(); i++)
				{
					Object parameter = params.get(i);
					setParam(ps, i + 1, parameter);
				}
			}
		}
		catch (Exception e)
		{
			throw new SQLException(e.getMessage(), e);
		}

	}
	
	/**
	 * 
	 * Function    : 设置PreparedStatement的参数
	 * LastUpdate  : 2010-6-10
	 * @param ps
	 * @param idx
	 * @param obj
	 * @throws DAOException
	 */
	private void setParam(PreparedStatement ps, int idx, Object obj) throws Exception
	{
		try
		{
			if (obj instanceof java.util.Date)
			{
				ps.setTimestamp(idx, new Timestamp(((java.util.Date) obj).getTime()));
				return;
			}
			if (obj instanceof java.sql.Blob)
			{
				ps.setBlob(idx, (java.sql.Blob) obj);
				return;
			}
			if (obj instanceof java.sql.Clob)
			{
				ps.setClob(idx, (java.sql.Clob) obj);
				return;
			}
			if (obj instanceof java.math.BigDecimal)
			{
				ps.setBigDecimal(idx, (java.math.BigDecimal) obj);
				return;
			}
			if (obj instanceof java.math.BigInteger)
			{
				ps.setBigDecimal(idx, new BigDecimal((BigInteger) obj));
				return;
			}
			if (obj instanceof java.lang.Boolean)
			{
				ps.setInt(idx, (Boolean) obj ? 0 : 1);
				return;
			}
			if(obj instanceof java.lang.Integer)
			{
				ps.setInt(idx, ((Integer)obj).intValue());
				return;
			}
			if(obj instanceof java.lang.Long)
			{
				ps.setLong(idx, ((Long)obj).longValue());
				return;
			}
			if(obj instanceof java.lang.String)
			{
				ps.setString(idx, obj.toString());
				return;
			}
			ps.setObject(idx, obj);
		}
		catch (SQLException e)
		{
			throw new Exception("ps set params error!", e);
		}
	}

}
