package com.tp.manager;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;

public class ManagerDAO {

	// 극장 등록하기
	public static void regTheater(HttpServletRequest request) {
		
		try {

			SqlSession ss = DBManager_new.connect();

			// 값 받기 1
			String moNumber = request.getParameter("moNumber");
			String thPlace = request.getParameter("thPlace");
			String thSeat = request.getParameter("thSeat");

			System.out.println("moNumber2 : " + moNumber);
			System.out.println("thPlace2 : " + thPlace); 
			System.out.println("thSeat : " + thSeat); 

			Theater t = new Theater();
//			t.setTh_mo_no(new BigDecimal(moNumber));
			t.setTh_place(thPlace);
			t.setTh_seat(thSeat);

			request.setAttribute("t", t);

			if (ss.insert("tp.regTheater", t) == 1) {
				request.setAttribute("r", "등록성공");

				ss.commit();
			} else {
				request.setAttribute("r", "등록실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "db실패");
		}
	}

	// 값 보내기 
	public static void sendData(HttpServletRequest request) {
		System.out.println("-------"+request.getParameter("moNumber"));
		
		BigDecimal Th_m_no = new BigDecimal(request.getParameter("moNumber"));

		System.out.println("Th_m_no : "+Th_m_no);
		System.out.println("thPlace : "+request.getParameter("thPlace"));
		System.out.println("thSeat : "+request.getParameter("thSeat"));
		
		Theater t = new Theater();
//		t.setTh_mo_no(Th_m_no);
		t.setTh_place(request.getParameter("thPlace"));
		t.setTh_seat(request.getParameter("thSeat"));

		request.setAttribute("t", t);
		
	}

	public static void update(HttpServletRequest request) {
		
	}
	
	// 상품 수정하기
	
	

}
