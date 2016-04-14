package org.apache.ibatis.callback;

import java.sql.ResultSet;

public interface DAOCallback<T>
{
	public T wrapper(ResultSet rs, int index);
}
