/**
 * 
 */
package com.sandrew.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sandrew.mybatis.model.TmUserPO;

/**
 * @author Administrator
 *
 */
public class UpdateTest
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
			
			TmUserPO cond = new TmUserPO();
			cond.setUserId(new Integer(55));
			TmUserPO val = new TmUserPO();
			val.setMobile("135xxxxxxxx");
			int count = session.update(cond, val);
			//CommonMapper mapper = session.getMapper(CommonMapper.class);
			//int count = mapper.update(cond, val);
			System.out.println("update count ======" + count);
			
//			TmUserPOMapper mapper = session.getMapper(TmUserPOMapper.class);
//			TmUserPO cond = new TmUserPO();
//			cond.setUserId(new Integer(55));
//			cond.setMobile("444444444");
//			mapper.updateByPrimaryKey(cond);
			
			
//			TmUserPO user = new TmUserPO();
//			user.setUserId(new Integer(5));
//			user.setMobile("135xxxxxxxx");
//			int count = session.update("com.sandrew.mybatis.mapper.TmUserPOMapper.updateByPrimaryKeySelective", user);
//			System.out.println("update count ======" + count);
			session.commit();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
