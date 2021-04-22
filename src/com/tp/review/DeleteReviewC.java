package com.tp.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteReviewC")
public class DeleteReviewC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO.delete(request);
		ReviewDAO.calcRating(request);
		ReviewDAO.getAllReview(request);
		request.setAttribute("contentPage", "Review/reviewReg.jsp");
		request.setAttribute("showReviewPage", "MyReview.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
