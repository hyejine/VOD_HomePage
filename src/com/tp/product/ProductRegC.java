package com.tp.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductRegC")
public class ProductRegC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 관리자가 판매할 제품을 등록 if 세션 id = 관리자일 때

		// 파라메터에 값이 있을때 
		if (request.getParameterNames().hasMoreElements()) {
 
		} else{
			request.setAttribute("contentPage", "Product/productReg.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
//		ProductDAO.regProduct(request);
//		
//		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO.regProduct(request);
		request.setAttribute("contentPage", "Product/productReg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
