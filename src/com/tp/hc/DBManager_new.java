  package com.tp.hc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager_new {

	public static SqlSession connect() throws IOException {
		
    		//String cfgName ="com/hj/_Mybatis/config.xml";  // 서버 정보가 담긴 파일
    		
    		//config.xml에서 정보를 읽어낼수 있는 빨대 =>is
    		InputStream is= Resources.getResourceAsStream("config.xml");
    		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
    		//SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
    		//SqlSessionFactory ssf= ssfb.build(is); 
    		//SqlSession ss =ssf.openSession();

    	return ssf.openSession();	
    	}
	}


