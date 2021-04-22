package com.tp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutC")
public class LogoutC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		세션 데이터 제거
		request.getSession().invalidate(); 
		
//		홈화면으로 include
		request.setAttribute("contentPage", "home.jsp");
		
//		index.jsp로 포워드
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
