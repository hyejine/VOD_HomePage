package com.tp.dvd;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;
import com.tp.jsonTest.Movie;
import com.tp.movie.MovieDAO;

public class DADDAO {
	private List<DVD> dvd;
	
	private static final DADDAO DDAO = new DADDAO();
	
	  private DADDAO() {
		  
		}
	  
	public static DADDAO getDdao() {
		
		return DDAO;
	}
	
	

	public void getAllDVD(HttpServletRequest request) {

		try {
			SqlSession ss = new DBManager_new().connect();
			
			List<DVD> dvds = ss.selectList("tp.getAllDVD");
			
			request.setAttribute("dvds", dvds);
			
			this.dvd = ss.selectList("tp.getAllDVD");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void paging(int page, HttpServletRequest request) {
		// 몇 페이지인지 알려고
		request.setAttribute("curPageNo", page);
		
		// 전체 페이지 수 계산 
		int cnt = 20;  // 한 페이지당 보여줄 개수 
		int total = dvd.size();  // 데이터 총 개수  // 
		
		System.out.println(total);
		// 총 페이지수 
		int pageCount = (int) Math.ceil((total/(double)cnt));
		request.setAttribute("pageCount", pageCount);
		
		int start = total - (cnt*(page-1));
		
		// 
		int end = (page==pageCount)? -1 : start-(cnt+1);
		
		ArrayList<DVD> its = new ArrayList<DVD>();
		// 
		for (int i = start-1; i > end; i--) {
			its.add(dvd.get(i));	// 0~19 => 1페이지에 나오는 데이터
		}
		
		request.setAttribute("dvds", its);
		
	}
	

}
