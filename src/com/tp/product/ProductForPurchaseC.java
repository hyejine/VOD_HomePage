package com.tp.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductForPurchaseC")
public class ProductForPurchaseC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//상품목록페이지에서 상품을 누르면 상품 상세정보를 보여주면서 장바구니 담기 버튼이 있는 페이지로
		ProductDAO.getTheProductInfo(request);
		
		request.setAttribute("contentPage", "Product/productInfo.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
