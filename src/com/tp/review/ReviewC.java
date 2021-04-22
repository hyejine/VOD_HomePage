package com.tp.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewC")
public class ReviewC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//리뷰 등록하는 페이지로 이동만(영화번호 그대로 보내주면서)
		
		request.setAttribute("mo_no", request.getParameter("mo_no"));
		
		
		if (request.getParameter("r_rating")!=null) {
			
			ReviewDAO.regReview(request);//후기 및 평점 등록
			ReviewDAO.calcRating(request);//평점 평균계산 후 업데이트
		}
//		ReviewDAO.getReview2(request);
		ReviewDAO.getAllReview(request);//영화 번호로 후기 조회
		
		request.setAttribute("contentPage", "Review/reviewReg.jsp");
		
		//
		request.setAttribute("showReviewPage", "MyReview.jsp");
		//
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
