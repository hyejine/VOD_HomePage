package com.tp.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.cart.CartDAO;
import com.tp.movie.MovieDAO;

@WebServlet("/TicketRegC")
public class TicketRegC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자가 등록 if 세션 id = 관리자일 때

		//자리 데이터가 없으면 좌석선택페이지로
		if (request.getParameter("t_seat")==null) {
			
			TicketDAO.getAllTicket(request);
			
			regTicketBeforeRegSeatDTO rTBRSDTO = new regTicketBeforeRegSeatDTO();
			rTBRSDTO.setT_movie(request.getParameter("t_movie"));
			rTBRSDTO.setT_theater_no(request.getParameter("t_theater_no"));
			rTBRSDTO.setT_start(request.getParameter("t_start"));
			rTBRSDTO.setT_end(request.getParameter("t_end"));
			
			request.setAttribute("info", rTBRSDTO);
			
			request.setAttribute("contentPage", "Ticket/regSeat.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
		//상영 영화 보여주는 페이지에서 넘어옴(sm_no넘겨받음)
		TicketDAO.regTicket(request);  //ticket 테이블에 reg
		TicketDAO.getTheTicketInfo(request);
		
		//방금 예약한 티켓의 정보
		request.setAttribute("contentPage", "Ticket/resultT.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}
		
//		MovieDAO.GetAllMovie(request);
//		TicketDAO.getAllTicketInfo(request);
//		
//		request.setAttribute("contentPage", "Ticket/getTicket.jsp");
//		request.getRequestDispatcher("index.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
