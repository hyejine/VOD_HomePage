package com.tp.showingmovie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.movie.MovieDAO;

@WebServlet("/ShowingMovieChooseMovieC")
public class ShowingMovieChooseMovieC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO.getMdao().GetAllMovie(request);
		request.setAttribute("contentPage", "ShowingMovie/regSMChooseMovie.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
