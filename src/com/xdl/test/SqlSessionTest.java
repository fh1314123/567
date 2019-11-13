package com.xdl.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xdl.bean.XdlBankAccount;

public class SqlSessionTest {

	public static void main(String[] args) {
		// ����һ��SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder  ssfb = new SqlSessionFactoryBuilder();
		// ����һ��SqlSessionFactory
		InputStream  inputStream = SqlSessionTest.class
			.getClassLoader().getResourceAsStream("sqlmap-config.xml");
		SqlSessionFactory  ssf = ssfb.build(inputStream);
		// ���Ի�ȡSqlSession
		SqlSession ss = ssf.openSession();
		// ����sql ��id ��ѯ 
		XdlBankAccount  account = ss.selectOne("findById", 2);
		System.out.println(account);
        ss.close();
	}

}
