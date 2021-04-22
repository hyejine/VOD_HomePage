package com.tp.showingmovie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.manager.TheaterDAO;
import com.tp.movie.MovieDAO;

@WebServlet("/ShowSMC")
public class ShowSMC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShowingMovieDAO.getAllSM(request); //상영중인 영화 출력
//		setatt - SM(상영 영화 필드) showAllSMInfo.java
		
		
		request.setAttribute("contentPage", "ShowingMovie/ShowSM.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
