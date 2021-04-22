package com.tp.showingmovie;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;

public class ShowingMovieDAO {
	
	
	//관리자가 상영할 영화 등록하기
	public static void regSM(HttpServletRequest request) {

		try {
			
			//등록 불가능 여부 확인(장소(th_no) and 시간 겹치면 fail) -> select all
			
			
			SqlSession ss = DBManager_new.connect();

			
//			List<ShowingMovie> showingMovies = ss.selectList("pt.getAllSM");

//			th_place,th_room(th_no) startTime(극장 위치, 시작,끝시간(시작+120분), mo_no
			
			//값 받기
			BigDecimal mo_no =new BigDecimal(request.getParameter("mo_no"));
			BigDecimal th_no = new BigDecimal(request.getParameter("th_no"));
			//시간 sm_end
			BigDecimal sm_start =  new BigDecimal(request.getParameter("sm_start"));
			BigDecimal sm_end =  new BigDecimal(request.getParameter("sm_end"));
			
			
			ShowingMovie sm = new ShowingMovie();
			sm.setSm_mo_no(mo_no);
			sm.setSm_th_no(th_no);
			sm.setSm_t_start(sm_start);
			sm.setSm_t_end(sm_end);
			
			//상영 영화 등록
			ss.insert("jh.regShowingMovie",sm);

			
			//			같은 극장의 다른 영화 상영 시간대에는 데이터를 등록x
//			for (ShowingMovie smTest : showingMovies) {
				
//			int로 
//				int getStart = smTest.getSm_t_start().intValue();
//				int getEnd = smTest.getSm_t_end().intValue();
//				
//				if (smTest.getSm_th_no()!=th_no) {
//					if (getStart>=start && getStart<=end) {
//						request.setAttribute("r", "이미 다른 영화가 등록돼있습니다.");
//					}
//					
//					else if (getEnd>=start && getEnd<=end) {
//						request.setAttribute("r", "이미 다른 영화가 등록돼있습니다.");
//					}
//					
//					else {
//						ss.insert("jh.regShowingMovie",sm);
//						}
//				}
//			}
			
			
			ss.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//상영중인 영화 전체 조회
	public static void getAllSM(HttpServletRequest request) {
		
		try {
			SqlSession ss = DBManager_new.connect();
			
			
			List<ShowingMovie> showingMovies = ss.selectList("pt.getAllSM");
			
			request.setAttribute("SM", showingMovies);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
	//상영 예약이 안잡힌 영화관(sm- th_no, start, end로 정보가 없는 영화관만 출력)
		public static void getAllEmptyTime(HttpServletRequest request) {
			
			try {
				SqlSession ss = DBManager_new.connect();
//				0<=time<=1440;
//				!start<= time start+120>=time
				
				BigDecimal th_no = new BigDecimal(request.getParameter("th_no"));
				ShowingMovie movie = new ShowingMovie();
				movie.setSm_th_no(th_no);
				
				
				List<ShowingMovie> showingMovies = ss.selectList("tp.getAllSMByTh_no", movie);
				
				request.setAttribute("SM", showingMovies);
				request.setAttribute("mo_no", request.getParameter("mo_no"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

		public static void getTheTicketsTime(HttpServletRequest request) {

			try {
				SqlSession ss = DBManager_new.connect();
				
				request.getParameter("mo_no");
				request.getParameter("th_no");
				request.getParameter("sm_start");
				request.getParameter("sm_end");
				
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	
	
		
		
}
