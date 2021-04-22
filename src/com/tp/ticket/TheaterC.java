package com.tp.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.movie.MovieDAO;

@WebServlet("/TheaterC")
public class TheaterC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieDAO.getMdao().GetAllMovie(request);
		//TicketDAO.getTheaterList(request);
		TicketDAO.getAllTheater(request);
		request.setAttribute("contentPage", "Ticket/gettheater.jsp"); 
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
