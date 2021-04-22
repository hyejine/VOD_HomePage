package com.tp.showingmovie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowingMovieRegC")
public class ShowingMovieRegC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		th_place,th_room startTime(극장 위치, 시작,끝시간(시작+120분), mo_no(어떤 영화 등록할건지) 
		
		
		ShowingMovieDAO.regSM(request); //운영자가 상영 영화 등록
		
		request.setAttribute("contentPage", "ShowingMovie/ShowSM.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
