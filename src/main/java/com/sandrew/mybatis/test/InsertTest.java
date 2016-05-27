/**
 * 
 */
package com.sandrew.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sandrew.mybatis.mapper.TmUserPOMapper;
import com.sandrew.mybatis.model.TmUserPO;

/**
 * @author Administrator
 *
 */
public class InsertTest
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
			
			TmUserPO user = new TmUserPO();
			user.setMobile("135xxxxxxxx");
			user.setUserCode("test");
			user.setUserName("测试");
			user.setUserStatus(new Integer(10011001));
			user.setCreateDate(new Date());
			TmUserPOMapper mapper = session.getMapper(TmUserPOMapper.class);
			int count = mapper.insert(user);
//			int count = session.insert(user);
			System.out.println("update count ======" + count);
			
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
