package com.tp.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.product.ProductDAO;

@WebServlet("/PurchaseC")
public class PurchaseC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("진입");
		CartDAO.regPurchase(request);
		System.out.println("구매등록");
		
		CartDAO.deleteCheckedBox(request);
		System.out.println("카트 삭제");
		
		
		
		CartDAO.getAllPurchaseHistory(request);
		System.out.println("구매내역 조회");
		
		request.setAttribute("contentPage", "Purchase/orderSummary.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		//구매내역 확인 페이지(getAllPurchase)로
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}