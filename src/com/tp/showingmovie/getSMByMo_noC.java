package com.tp.showingmovie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getSMByMo_noC")
public class getSMByMo_noC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//영화 예매하기 누르면 여기로 와서 영화(mo_no를 넘겨받는다) 영화관, 시간, 좌석 선택하는 페이지로 넘겨줌.
		
		
		request.setAttribute("contentPage", "ShowingMovie/regSM.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
