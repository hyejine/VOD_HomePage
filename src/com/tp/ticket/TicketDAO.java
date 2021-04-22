package com.tp.ticket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;
import com.tp.join.Member;
import com.tp.manager.Theater;
import com.tp.movie.Movie;
import com.tp.showingmovie.ShowingMovie;
import com.tp.showingmovie.ShowingMovieInfo;

public class TicketDAO {

	//방금 등록한 그 티켓의 정보
	public static void getTheTicketInfo(HttpServletRequest req) {

		try {
			
			SqlSession ss = DBManager_new.connect();
			
			BigDecimal sm_no = new BigDecimal(req.getParameter("sm_no")); 
			
			ShowingMovie sm = new ShowingMovie();
			sm.setSm_no(sm_no);
			ShowingMovie sm1 = ss.selectOne("tp.getTheShowingMovie",sm );
//			BigDecimal startTime = sm1.getSm_t_start();
//			BigDecimal endTime = sm1.getSm_t_end();
			
			
			
			//showingMovie_db 정보로 극장, 영화 데이터 조회
			
			BigDecimal mo_no = sm1.getSm_mo_no();
			BigDecimal th_no =  sm1.getSm_th_no();
			String t_seat= (String) req.getAttribute("t_seat");
			
//			#{mo_no}#{th_no}#{t_seat}#{th_no}
//			ShowingMovieInfo smi = new ShowingMovieInfo();
//			smi.setMo_no(mo_no);
//			smi.setTh_no(th_no);
//			smi.setSm_no(sm_no);
//			
//			ShowingMovieInfo smi1 = ss.selectOne("tp.getTheShowingMovieInfo", smi);
			
			
			TicketInfoDTO TIDTO = new TicketInfoDTO();
			TIDTO.setMo_no(mo_no);
			TIDTO.setTh_no(th_no);
			TIDTO.setT_seat(t_seat);

			
			TicketInfoDTO ticketInfo = ss.selectOne("tp.getAllTicket",TIDTO);
			
			req.setAttribute("tickets", ticketInfo);
			
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	
	//티켓 예매하기
	public static void regTicket(HttpServletRequest req) {
		try {

			
			SqlSession ss = DBManager_new.connect();

			String t_seat = req.getParameter("t_seat");
			BigDecimal t_price = new BigDecimal(req.getParameter("t_price"));
			BigDecimal t_start = new BigDecimal(req.getParameter("t_start"));
			BigDecimal t_end = new BigDecimal(req.getParameter("t_end"));
			BigDecimal t_mo_no = new BigDecimal(req.getParameter("mo_no"));
			BigDecimal t_th_no = new BigDecimal(req.getParameter("th_no"));
			
			
			
//			t_price t_seat t_end t_start mo_no th_no
		
			//상영중인 영화 예매 - sm_no를 넘겨받아서 th_no,mo_no를 얻어서 ticket_db에 등록
//			BigDecimal sm_no = new BigDecimal(req.getParameter("sm_no")); 
//		
//			ShowingMovie sm = new ShowingMovie();
//			sm.setSm_no(sm_no);
//			ShowingMovie sm1 = ss.selectOne("tp.getTheShowingMovie",sm );
			
//			BigDecimal startTime = sm1.getSm_t_start();
//			BigDecimal endTime = sm1.getSm_t_end();
			
		
		
		
			//showingMovie_db 정보로 극장, 영화 데이터 조회
		
//			BigDecimal mo_no = sm1.getSm_mo_no();
//			BigDecimal th_no =  sm1.getSm_th_no();
		
			
			
			
			Member m = (Member)req.getSession().getAttribute("accountInfo");
		
			Ticket t = new Ticket();
			t.setT_movie(t_mo_no);
			t.setT_theater(t_th_no);
			t.setT_seat(t_seat);
			t.setT_start(t_start);
			t.setT_end(t_end);
			t.setT_price(t_price);
			t.setT_uid(m.getM_id());
			
			
			req.setAttribute("th_no", t_th_no);
			req.setAttribute("t_seat", t_seat);
		
			if(ss.insert("tp.regTicket",t) == 1) {
				System.out.println("등록성공");
			}
			ss.commit();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	//예매한 티켓 내역 확인용
	public static void getAllTicketById(HttpServletRequest req) {
		try {
			
			SqlSession ss = DBManager_new.connect();
			
			String m_id =(String) req.getSession().getAttribute("m_id");
			BigDecimal m_no = new BigDecimal(req.getParameter("m_no"));
			BigDecimal th_no = new BigDecimal(req.getParameter("th_no"));
			
			JoinGetAllTicketByIdDTO jgatbiDTO = new JoinGetAllTicketByIdDTO(m_id, m_no, th_no);
			
			List<TicketInfoDTO> tickets = ss.selectList("tp.getAllTicketById",jgatbiDTO);
			
			req.setAttribute("tickets", tickets);
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static void getTheTicketInfoByNo(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			
			BigDecimal t_no = new BigDecimal(request.getParameter("t_no"));
			
			Ticket t = new Ticket();
			t.setT_no(t_no);
			
			List<TicketInfoDTO> tickets = ss.selectList("tp.getTheTicketInfo", t);
			
			request.setAttribute("tickets", tickets);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 극장의 정보 가져오기 
	public static void getAllTheater(HttpServletRequest request) {
		try {
			SqlSession ss= DBManager_new.connect();
			List<Movie> Theater = ss.selectList("tp.getAllTheater");
			request.setAttribute("Theater", Theater);
			//System.out.println(movie.get(0).getMo_name());
		} catch (Exception e) {
			e.printStackTrace();
	}
		
	}

	// 영화 제목 클릭시 극장 위치 나오게 하기 (미완성)
	public static void getTheaterList(HttpServletRequest request) {
		try {
			SqlSession ss= DBManager_new.connect();
			
			//Join j =new Join();
			List<TicketInfoDTO> Theater1 = ss.selectList("tp.TheaterList");
			request.setAttribute("Theater1", Theater1);
		} catch (Exception e) {
			e.printStackTrace();
	}
		
	}


	public static void getAllTicket(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			
			List<Ticket> tickets = ss.selectList("tp.justGetAllTicket");
			
			ArrayList<Integer> EmptySeats = new ArrayList<Integer>();
			for (int i = 0; i < 40; i++) {
				
				for (Ticket t : tickets) {
					EmptySeats.add(i);
					if(i==Integer.parseInt(t.getT_seat())) {
						EmptySeats.remove(EmptySeats.size()-1);
						break;
					}
					else {
						
					}
				
				}
			}
			
			
			request.setAttribute("EmptySeats", EmptySeats);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
}	


