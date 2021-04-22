package com.tp.dvd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowAllDVD")
public class ShowAllDVD extends HttpServlet {

	//판매 중인 DVD 보여주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DADDAO.getDdao().getAllDVD(request);
		DADDAO.getDdao().paging(1, request);
		
		request.setAttribute("contentPage", "DVD/ShowDVD.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
