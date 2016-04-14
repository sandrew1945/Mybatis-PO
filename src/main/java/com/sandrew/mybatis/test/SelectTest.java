/**
 * 
 */
package com.sandrew.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.dbcp.PoolableCallableStatement;
import org.apache.ibatis.callback.POCallBack;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sandrew.mybatis.mapper.CommonMapper;
import com.sandrew.mybatis.mapper.TmUserPOMapper;
import com.sandrew.mybatis.model.TmUserPO;

/**
 * @author Administrator
 *
 */
public class SelectTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		try
		{
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			
			System.out.println("start search ---------------------------------");
//			TmUserPO user = (TmUserPO) session.selectOne("com.sandrew.mybatis.mapper.TmUserPOMapper.selectByPrimaryKey", 5);
//			System.out.println(user.getUserName());
			
			TmUserPOMapper mapper = session.getMapper(TmUserPOMapper.class);
			TmUserPO user2 = mapper.selectByPrimaryKey(new Integer(5));
			System.out.println(user2.getUserName());
			
			
//			CommonMapper commonMapper = session.getMapper(CommonMapper.class);
//			TmUserPO cond = new TmUserPO();
//			cond.setUserCode("sun.lao");
//			List<TmUserPO> list = commonMapper.select(cond, new POCallBack(TmUserPO.class));
//			System.out.println(list.size());
//			TmUserPO result = list.get(0);
//			System.out.println("result ===========" + result.getUserCode());
//			System.out.println("result ===========" + result.getUserName());
			
			
//			TmUserPO cond = new TmUserPO();
//			cond.setUserCode("sun.lao");
//			List<TmUserPO> list = session.select(cond, new POCallBack(TmUserPO.class));
//			System.out.println("list ===========" + list.size());
//			TmUserPO result = list.get(0);
//			System.out.println("result ===========" + result.getUserCode());
//			System.out.println("result ===========" + result.getUserName());
//			
//			List<TmUserPO> list2 = session.select(cond, new POCallBack(TmUserPO.class));
//			System.out.println("list2 ===========" + list2.size());
			
//			session.getMapper(TmUserPOMapper.class);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
