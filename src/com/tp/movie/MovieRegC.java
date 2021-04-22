package com.tp.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieRegC")
public class MovieRegC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("contentPage", "Movie/movieReg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO.getMdao().regMovie(request);
//		MovieDAO.GetAllMovie(request);
		request.setAttribute("contentPage", "Movie/movieReg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
