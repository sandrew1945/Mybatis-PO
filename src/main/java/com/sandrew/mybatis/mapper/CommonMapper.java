package com.sandrew.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.callback.DAOCallback;
import org.apache.ibatis.util.POIdentifyMapper;

public interface CommonMapper extends POIdentifyMapper
{
	int delete(Object po);

	int insert(Object po);

	<E> List<E> select(Object po, DAOCallback<E> callback);

	int update(Object condPO, Object valuePO);
}