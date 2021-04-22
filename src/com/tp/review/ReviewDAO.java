package com.tp.review;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;
import com.tp.join.Member;
import com.tp.movie.Movie;

public class ReviewDAO {

	public static void regReview(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();
			BigDecimal mo_no = new BigDecimal(request.getParameter("mo_no"));//영화정보에서 넘겨줄거
			Member m = (Member) request.getSession().getAttribute("accountInfo");
			BigDecimal m_rating = new BigDecimal(request.getParameter("r_rating"));
			String plot = request.getParameter("plot");
			plot.replace("\r\n","<br>");//줄거리 줄바꿈

			Review r = new Review();
			r.setR_mo_no(mo_no);
			r.setR_uId(m.getM_id());
			r.setR_rating(m_rating);
			r.setR_review(plot);
			
			System.out.println("mo_no: "+mo_no);
			System.out.println("id : "+m.getM_id());
			System.out.println("평점 : "+m_rating);
			System.out.println("줄거리 : "+plot);
			
			request.setAttribute("r1", r);
			
			if (ss.insert("tp.regReview",r)==1) {
				request.setAttribute("r", "후기 등록 성공");
			}
						
			ss.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB연결 실패");
		}
	}

	//등록된 전체 후기 출력
	public static void getAllReview(HttpServletRequest request) {

		try {
			SqlSession ss =DBManager_new.connect();
//			Member m = (Member) request.getSession().getAttribute("accountInfo");
//			
//			m.setM_id(m.getM_id());
			System.out.println("영화번호 : " +request.getParameter("mo_no"));
			
			BigDecimal mo_no= new BigDecimal(request.getParameter("mo_no"));
			Review r = new Review();
			r.setR_mo_no(mo_no);
			
			System.out.println(mo_no);
			
			
			List<ReviewInfo> reviewInfos = ss.selectList("tp.getReviewInfoByMo_no", r);
			request.setAttribute("reviewInfos", reviewInfos);
			
			Member m = (Member) request.getSession().getAttribute("accountInfo"); //object => member  , para => string
			String Id = m.getM_id();
			 
			ReviewInfo rI = new ReviewInfo();
			rI.setM_id(Id);
			rI.setMo_no(mo_no);
			
			ReviewInfo list = ss.selectOne("tp.getReview2", rI); 
			
			request.setAttribute("list", list);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();
			BigDecimal r_no = new BigDecimal(request.getParameter("r_no"));
			Review r = new Review();
			r.setR_no(r_no);
			
			
			if(ss.delete("tp.deleteReview",r)==1) {
				request.setAttribute("r", "삭제성공");
			}
			
			Review r1 = new Review();
			r1.setR_mo_no(new BigDecimal(request.getParameter("mo_no")));
			
			ss.commit();
			
			request.setAttribute("r1", r1);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB오류");
		}
	}

	public static void updateReview(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			
			String r_plot = request.getParameter("plot");
			BigDecimal r_rating = new BigDecimal(request.getParameter("r_rating"));
			
			System.out.println("후기 번호 : "+request.getParameter("r_no"));
			System.out.println("uR에서 영화 번호 : "+request.getParameter("mo_no"));

			BigDecimal r_no = new BigDecimal(request.getParameter("r_no"));
			
			Review r = new Review();
			r.setR_no(r_no);
			r.setR_review(r_plot);
			r.setR_rating(r_rating);
			
			if(ss.update("tp.updateReview",r)==1) {
				request.setAttribute("r", "후기 수정 성공");
			}
			
			ss.commit();
			
			Review r1 = new Review();
			r1.setR_mo_no(new BigDecimal(request.getParameter("mo_no")));
			
			System.out.println("보내는 객체 영화 번호 : "+ r1.getR_mo_no());
			
			request.setAttribute("r1", r1);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB연결 실패");
		}
	}
	
	
	public static void calcRating(HttpServletRequest request) {
		
		int mo_Rating = 0;
		double cnt= 0;
		BigDecimal sum = new BigDecimal(0);
		
		try {
			SqlSession ss = DBManager_new.connect();
			
			Review r11 = (Review) request.getAttribute("r1");
			
			System.out.println("받는 객체 영화 번호 : "+r11.getR_mo_no());
			
			//영화번호를 넘겨줬으므로 그걸 이용해서 후기데이터의 해당 영화의 rating을 조회해서 계산
			BigDecimal mo_no = r11.getR_mo_no();
			
			
			Review r1 = new Review();
			r1.setR_mo_no(mo_no);

			System.out.println("mo_no = "+mo_no);
			
			
			//특정 영화의 데이터(평점)만 추출(영화번호로)
			List<Review> r2 = ss.selectList("tp.getReviewsByMo_no",r1);
			
			
			for (Review review : r2) {
				mo_Rating += review.getR_rating().intValue();
				System.out.println(mo_Rating);
//				System.out.println("review.getR_rating() = "+review.getR_rating());
//				System.out.println("mo_Rating = "+sum );
				cnt+=1;
				
			}
			
			
			System.out.println("mo_Rating = "+mo_Rating);
			System.out.println("cnt = "+cnt);
			double result = mo_Rating/cnt;
			
			BigDecimal mo_rating = new BigDecimal(result);
			System.out.println("mo_rating = "+mo_rating);
			
			Movie m = new Movie();
			m.setMo_rating(mo_rating);
			m.setMo_no(mo_no);
			
			if(ss.update("tp.updateMo_Rating", m)==1) {
				request.setAttribute("r", "mo_rating 수정 성공");
			}
			
			ss.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB오류");
		}
		
	}

	//자기 자신이 쓴 후기만 보기
	public static void getReviewById(HttpServletRequest request) {
		
		try {
			SqlSession ss =DBManager_new.connect();
			Member m = (Member) request.getSession().getAttribute("accountInfo");
			
			ReviewInfo r1 = new ReviewInfo();
			r1.setM_id(m.getM_id());
			
			List<ReviewInfo> reviewInfoss = ss.selectList("tp.getTheReviewById", r1);
			List<ReviewInfo> reviewInfos = new ArrayList<ReviewInfo>();
			
			
			for (ReviewInfo review : reviewInfoss) {
				review.getR_no();
				review.getR_mo_no();
				review.getR_uId();
				
				//해당 후기의 영화번호, 후기번호, id를 이용해 정보 출력(무슨 영화인지, 후기 내용이 뭔지)
				
				reviewInfos.add(ss.selectOne("tp.getInfoByReview", review));
				
			}
			
			
			
			
			
			request.setAttribute("reviewInfos", reviewInfos);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	// 리뷰 (아이디, 이름, 영화이름) 가져오기
	public static void getReview2(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();
			
			
			Member m = (Member) request.getSession().getAttribute("accountInfo"); //object => member  , para => string
			String Id = m.getM_id();
			BigDecimal mo_no=new BigDecimal(request.getParameter("mo_no"));
			 
			ReviewInfo r = new ReviewInfo();
			r.setM_id(Id);
			r.setMo_no(mo_no);
			
			ReviewInfo list = ss.selectOne("tp.getReview2", r); 
			
			request.setAttribute("list", list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void getMemberInfo(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			
			Member m = (Member) request.getSession().getAttribute("accountInfo"); //object => member  , para => string
			String Id = m.getM_id();
			 
			Member rI = new Member();
			rI.setM_id(Id);
			
			Member list = ss.selectOne("tp.selectInfo", rI); 
			
			request.setAttribute("list", list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
