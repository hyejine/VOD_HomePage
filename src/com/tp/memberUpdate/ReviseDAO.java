package com.tp.memberUpdate;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;
import com.tp.join.Member;

public class ReviseDAO {

	public static void reviseInfo(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();

			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String number = request.getParameter("number");
			String email = request.getParameter("email");
			
			Member m = (Member) request.getSession().getAttribute("accountInfo"); 
			String id2 = m.getM_id();
			
			MemberUdate m2= new MemberUdate();
			m2.setR_name(name);
			m2.setR_pw(pw);
			m2.setR_email(email);
			m2.setR_id2(id2);
			m2.setR_number(number);
			
//			System.out.println(m.getR_pw());
//			System.out.println(m.getR_name());
//			System.out.println(m.getR_number());
			
			if (ss.update("tp.updateMember",m2)==1) {
				 request.setAttribute("r", "수정 성공");
				 
				 ss.commit();
				}  else {
					request.setAttribute("r", "등록실패");
				}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB실패");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
