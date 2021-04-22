package com.tp.memberInfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;
import com.tp.join.Member;

public class InfoDAO {

	//회원 정보 조회 
	public static void lookInfo(HttpServletRequest request) {

		try {
			SqlSession ss= DBManager_new.connect();
			
			// Getattribute는 object,  Getparameter는 스트링
			Member m1 =  (Member) request.getSession().getAttribute("accountInfo");
			String id = m1.getM_id();
			
			Member m2 = new Member();
			m2.setM_id(id);
			
			List<Member> m = ss.selectList("tp.selectInfo",m2);
			request.setAttribute("member", m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
