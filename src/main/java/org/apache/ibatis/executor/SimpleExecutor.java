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
package org.apache.ibatis.executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.callback.DAOCallback;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.transaction.Transaction;

/**
 * @author Clinton Begin
 */
public class SimpleExecutor extends BaseExecutor
{

	public SimpleExecutor(Configuration configuration, Transaction transaction)
	{
		super(configuration, transaction);
	}

	public int doUpdate(MappedStatement ms, Object parameter) throws SQLException
	{
		Statement stmt = null;
		try
		{
			Configuration configuration = ms.getConfiguration();
			// 这里是RoutingStatementHandler实例,RoutingStatementHandler中根据StatementType代理使用SimpleStatementHandler、PreparedStatementHandler或CallableStatementHandler
			StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, RowBounds.DEFAULT, null, null);
			stmt = prepareStatement(handler, ms.getStatementLog());
			return handler.update(stmt);
		}
		finally
		{
			closeStatement(stmt);
		}
	}
	
	/**
	 * 	新增方法，ORM形式的更新操作
	 */
	@Override
	protected int doUpdateForPO(MappedStatement ms, List<Object> parameter) throws SQLException
	{
		Statement stmt = null;
		try
		{
			Configuration configuration = ms.getConfiguration();
			StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, RowBounds.DEFAULT, null, null);
			stmt = prepareStatement(handler, ms.getStatementLog(), parameter);
			return handler.update(stmt);
		}
		finally
		{
			closeStatement(stmt);
		}
	}

	public <E> List<E> doQuery(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException
	{
		Statement stmt = null;
		try
		{
			Configuration configuration = ms.getConfiguration();
			StatementHandler handler = configuration.newStatementHandler(wrapper, ms, parameter, rowBounds, resultHandler, boundSql);
			// 设置SQL的参数
			stmt = prepareStatement(handler, ms.getStatementLog());
			return handler.<E> query(stmt, resultHandler);
		}
		finally
		{
			closeStatement(stmt);
		}
	}
	
	
	/**
	 *  新增方法，查询操作
	 */
	@Override
	protected <E> List<E> doQuery(MappedStatement ms, Object parameter, RowBounds rowBounds, DAOCallback<E> callback, BoundSql boundSql) throws SQLException
	{
		Statement stmt = null;
		try
		{
			Configuration configuration = ms.getConfiguration();
			StatementHandler handler = configuration.newStatementHandler(wrapper, ms, parameter, rowBounds, null, boundSql);
			
			// 设置SQL的参数
			stmt = prepareStatement(handler, ms.getStatementLog(), (List<Object>)parameter);
			return handler.<E> query(stmt, callback);
		}
		finally
		{
			closeStatement(stmt);
		}
	}

	public List<BatchResult> doFlushStatements(boolean isRollback) throws SQLException
	{
		return Collections.emptyList();
	}

	private Statement prepareStatement(StatementHandler handler, Log statementLog) throws SQLException
	{
		Statement stmt;
		Connection connection = getConnection(statementLog);
		stmt = handler.prepare(connection);
		handler.parameterize(stmt);
		return stmt;
	}
	
	private Statement prepareStatement(StatementHandler handler, Log statementLog, List<Object> params) throws SQLException
	{
		Statement stmt;
		Connection connection = getConnection(statementLog);
		stmt = handler.prepare(connection);
		handler.parameterize(stmt, params);
		return stmt;
	}
}
