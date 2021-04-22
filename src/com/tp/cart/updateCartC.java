package com.tp.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateCartC")
public class updateCartC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		해당 카트 데이터를 수집해서(c_no로) 수정할 페이지로 이동만
		if (request.getParameter("c_quantity")==null) {
			CartDAO.getAcartByNo(request);
			request.setAttribute("contentPage", "Cart/updateCart.jsp");
		}
		else {
			CartDAO.updateCart(request);
			CartDAO.getAllCart(request);
			request.setAttribute("contentPage", "Cart/cart.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
