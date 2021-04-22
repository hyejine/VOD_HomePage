package com.tp.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.join.Member;

@WebServlet("/UpdateReviewC")
public class UpdateReviewC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("r_no", request.getParameter("r_no"));
		request.setAttribute("mo_no", request.getParameter("mo_no"));
		ReviewDAO.getAllReview(request);
		request.setAttribute("contentPage", "Review/updateReview.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 받아지게
		request.setCharacterEncoding("UTF-8");
		System.out.println("후기 : "+request.getParameter("plot"));
		
		
		ReviewDAO.updateReview(request);
		//평점이 수정됐을 수도 있으니 평점을 다시 꺼내서 계산 후 movieDB에 업데이트
		ReviewDAO.calcRating(request);
		
		ReviewDAO.getAllReview(request);
		
		request.setAttribute("contentPage", "Review/reviewReg.jsp");
		request.setAttribute("showReviewPage", "MyReview.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
