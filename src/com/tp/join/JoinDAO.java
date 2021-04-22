package com.tp.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;

public class JoinDAO {

	// 회원가입 등록
	public static void regjoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SqlSession ss = DBManager_new.connect();

			// 값 받기 1
			String m_id = request.getParameter("id");
			String m_pw = request.getParameter("pw");
			String m_name = request.getParameter("name");
			String m_phone = request.getParameter("phone");
			String m_mail = request.getParameter("eMail");

			Member m = new Member();  // mapper에서 parametertype을 member 빈을 이용해서 값을 셋팅하기 위해서 
			m.setM_id(m_id);
			m.setM_pw(m_pw);
			m.setM_name(m_name);
			m.setM_phone(m_phone);
			m.setM_mail(m_mail);

			//request.setAttribute("Member", m);
			
			Member m1 = new Member();
			m1.setM_id(m_id);
			
			if (ss.insert("tp.regjoin", m) == 1) {

				// sql파일에 안나오면 커밋을 안쓴거
				ss.commit();     //셀렉트 빼고 다 써줘야댐
				request.setAttribute("contentPage", "home.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "* 아이디 중복");
			request.setAttribute("contentPage", "Join/join.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}

	}

	

	
	
	
	
}
