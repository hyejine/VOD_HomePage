package com.tp.showingmovie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.manager.TheaterDAO;

@WebServlet("/ShowingMovieChooseTheaterC")
public class ShowingMovieChooseTheaterC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TheaterDAO.getAllTheatersByMovie(request);
		
		request.setAttribute("contentPage", "ShowingMovie/regSMChooseTheater.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
