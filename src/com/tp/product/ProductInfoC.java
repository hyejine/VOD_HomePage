package com.tp.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.ticket.TicketDAO;

@WebServlet("/ProductInfoC")
public class ProductInfoC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		장바구니에서 그림을 눌렀을 때 그 상품에 대한 정보
		ProductDAO.getTheProductInfo(request);
		
		request.setAttribute("contentPage", "Product/showProduct.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
