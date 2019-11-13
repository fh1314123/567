package com.xdl.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xdl.bean.XdlBankAccount;

public class SqlSessionTest {

	public static void main(String[] args) {
		// 构建一个SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder  ssfb = new SqlSessionFactoryBuilder();
		// 构建一个SqlSessionFactory
		InputStream  inputStream = SqlSessionTest.class
			.getClassLoader().getResourceAsStream("sqlmap-config.xml");
		SqlSessionFactory  ssf = ssfb.build(inputStream);
		// 可以获取SqlSession
		SqlSession ss = ssf.openSession();
		// 根据sql 的id 查询 
		XdlBankAccount  account = ss.selectOne("findById", 2);
		System.out.println(account);
        ss.close();
	}

}
