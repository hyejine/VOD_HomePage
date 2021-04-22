package com.tp.movie;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tp.dvd.DVD;
import com.tp.hc.DBManager_new;
import com.tp.jsonTest.Movie;
import com.tp.jsonTest.Movie2;
import com.tp.product.Product;

public class MovieDAO {
	
	private List<Movie> movie; 
	private static final MovieDAO MDAO=new MovieDAO();
	
	  private MovieDAO() {
		}
	  
	public static MovieDAO getMdao() {
		
		return MDAO;
	}
	

	//영화 등록하기 
	public  void regMovie(HttpServletRequest request) {
		try {
			
			SqlSession ss = DBManager_new.connect();
			
			String saveDirectory = request.getServletContext().getRealPath("");
			MultipartRequest mr= new MultipartRequest(request, saveDirectory, 31457280,"utf-8",
            new DefaultFileRenamePolicy());
			
			//값 받기 1
			String name= mr.getParameter("name");
			String style= mr.getParameter("style");
			String date= mr.getParameter("date");
			String director= mr.getParameter("director");
			String price= mr.getParameter("price");
			String time= mr.getParameter("time");
			
			String img= mr.getFilesystemName("img");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			// date를 스트링으로 받아줬기 때문에 이것을 다시 date타입으로 변환 해줘야함.  
			
			BigDecimal rating = new BigDecimal(0);
            // 사람들이 매긴 평점으로 계산해서 업데이트 해줄꺼라서 0 
			
			Movie m = new Movie();
			m.setMo_time(time);
			m.setMo_price(new BigDecimal (price));
			m.setMo_director(director);
			m.setMo_img(img);
			m.setMo_name(name);
			m.setMo_release(sdf.parse(date));
			m.setMo_rating(rating);

			if (ss.insert("tp.regMovie1",m)==1) {
			 request.setAttribute("r", "* 등록성공");
			 
			 
			 
			 DVD d = new DVD();
				
				d.setD_name(name);
				d.setD_release(sdf.parse(date));
				d.setD_director(director);
				//d.setD_actor(actor);
				d.setD_img(img);
				d.setD_price(new BigDecimal(10000));//개당 만원
				d.setD_runningTime(new BigDecimal(2));//2시간
				
				if (ss.insert("tp.regDVD1", d)==1) {
					request.setAttribute("r", "* dvd 등록성공");
				}
			 
			 
			 ss.commit();
			}else {
				request.setAttribute("r", "* 등록실패");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "* DB 오류");
		}
	}

	//등록된 영화 보기 
	public  void GetAllMovie(HttpServletRequest request) {
		try {
			SqlSession ss= DBManager_new.connect();
			List<Movie> movie = ss.selectList("tp.getAllMovie");
			request.setAttribute("movieee", movie);
			//System.out.println(movie.get(0).getMo_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 영화 검색하기 
	public  void searchMovie(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();

			String search = request.getParameter("search");
			
			Movie m = new Movie();
			m.setMo_name(search);
			
			List<Movie> movies = ss.selectList("tp.searchMovie",m);  //  ("", 파라메터 타입이 들어와야함 ) 
			request.setAttribute("movieee", movies);
		
			this.movie = movies;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//페이징 처리 
	public void paging(int page, HttpServletRequest request) {
		// 몇 페이지인지 알려고
		request.setAttribute("curPageNo", page);
		
		// 전체 페이지 수 계산 
		int cnt = 20;  // 한 페이지당 보여줄 개수 
		int total = movie.size();  // 데이터 총 개수  // 
		
		//System.out.println(total);
		// 총 페이지수 
		int pageCount = (int) Math.ceil((total/(double)cnt));
		request.setAttribute("pageCount", pageCount);
		
		int start = total - (cnt*(page-1));
		
		// 
		int end = (page==pageCount)? -1 : start-(cnt+1);
		
		ArrayList<Movie> items = new ArrayList<Movie>();
		// 
		for (int i = start-1; i > end; i--) {
			items.add(movie.get(i));	// 0~19 => 1페이지에 나오는 데이터
		}
		
		request.setAttribute("movieee", items);
		
	}
	
	
	// 파씽
	public void JsonMovie(HttpServletRequest request) {

		
		HttpsURLConnection huc = null;
		//Api를 호출하기 위해 사용하게 되며, 결과 데이터를 스트림 형식으로 제공받아 이용이 가능
	
		// db에 저장해야함 
		try {
			SqlSession ss = DBManager_new.connect();
			
			String url2 = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=6fd4cb6041d3d374568d4c9c69633ecd&targetDt=20201201";
			URL u2 = new URL(url2);
			HttpURLConnection huc2 = (HttpURLConnection)u2.openConnection();
			
			InputStream is2 = huc2.getInputStream();
			InputStreamReader isr2 = new InputStreamReader(is2);
			JSONParser jp2 = new JSONParser();
			JSONObject jo2 = (JSONObject) jp2.parse(isr2);
			System.out.println(jo2);
			
			JSONObject ja = (JSONObject) jo2.get("boxOfficeResult");
			System.out.println(ja);
			JSONArray ja2 = (JSONArray) ja.get("dailyBoxOfficeList");
			System.out.println(ja2);
			
			
//			JSONObject ja3 = (JSONObject) ja2.get(0);
//			System.out.println("ja3"+ja3);
			
			for (int j = 0; j < ja2.size(); j++) {
				JSONObject movies6 = (JSONObject) ja2.get(j);   // ja2에 있는 모든 정보를 하나씩 movies6에 담아준다. 
				
			String ja4 = (String) movies6.get("movieNm");
			
			String str = ja4; 
			// 검색어 (어떤 키워드로 검색할 것인가?)
			str = URLEncoder.encode(str, "utf-8");
			// 영화라는 정보를 불러 올때 인코더를 한국어로 한다
			
			// json parsing -> json-simple 자르 필요 
			String url = "https://openapi.naver.com/v1/search/movie.json?query="+str+"&start=5&yearfrom=2017&yearto=2021&display=100";
			URL u = new URL(url);
			huc = (HttpsURLConnection)u.openConnection();
			// api를 연결
			
			huc.addRequestProperty("X-Naver-Client-Id", "QQq8ePubcK4IuL1SdvXm");
			huc.addRequestProperty("X-Naver-Client-Secret", "lx6XNuE8Ew");
			
			//QQq8ePubcK4IuL1SdvXm
			//lx6XNuE8Ew
			
			InputStream is = huc.getInputStream();
			// 굵은 빨대
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			// 굵은 빨대로 빨아들인 것을 인코딩
			
			JSONParser jp = new JSONParser();
			// 파씽을 하기 위해 사용하는 코드
			
			JSONObject movie = (JSONObject) jp.parse(isr);
			// json 객체 생성
//			System.out.println("json객체 : " + movie);
		    
			// 내가 원하는 자료 뽑기 
			JSONArray item = (JSONArray) movie.get("items");
//			System.out.println(item.get(0));
//			JSONObject actor = (JSONObject) item.get(0);
//			System.out.println(actor.get("actor"));
//			JSONObject image = (JSONObject) item.get(0);
//			System.out.println(actor.get("image"));
//			JSONObject director = (JSONObject) item.get(0);
//			System.out.println(actor.get("director"));
//			JSONObject subtitle = (JSONObject) item.get(0);
//			System.out.println(actor.get("subtitle"));
//			JSONObject title = (JSONObject) item.get(0);
//			System.out.println(actor.get("title"));
//			JSONObject pubDate = (JSONObject) item.get(0);
//			System.out.println(actor.get("pubDate"));
			
			
			
			Movie m = new Movie();
			for (int i = 0; i < item.size(); i++) {
				JSONObject movies2 = (JSONObject) item.get(i);
				// 확인용 
//				System.out.println(i + "번째");
//				System.out.println(movies2.get("actor"));
//				System.out.println(movies2.get("director"));
				
				SimpleDateFormat dt = new SimpleDateFormat("yyyy");
				Date pubDate = dt.parse((String)movies2.get("pubDate"));

				m.setMo_actor((String) movies2.get("actor"));
				m.setMo_director((String) movies2.get("director"));
				m.setMo_img((String) movies2.get("image"));
				m.setMo_name((String) movies2.get("title"));
				m.setMo_release(pubDate);
				m.setMo_rating(new BigDecimal(0));
				m.setMo_price(new BigDecimal(10000));
				m.setMo_time("2");
				System.out.println("--------------------");
				System.out.println((String) movies2.get("actor"));
				System.out.println((String) movies2.get("director"));
				System.out.println((String) movies2.get("image"));
				System.out.println((String) movies2.get("title"));
				System.out.println(pubDate);
				System.out.println("--------------------");
				
				
				if(ss.insert("tp.regMovie",m)==1) {
					request.setAttribute("r", "등록성공");
				}
				
				
				
				DVD d = new DVD();
				
				d.setD_name(ja4);
				d.setD_release(pubDate);
				d.setD_director((String) movies2.get("director"));
				d.setD_actor((String) movies2.get("actor"));
				d.setD_img((String) movies2.get("image"));
				d.setD_price(new BigDecimal(10000));//개당 만원
				d.setD_runningTime(new BigDecimal(2));//2시간
				
				if (ss.insert("tp.regDVD", d)==1) {
					request.setAttribute("r", "dvd 등록성공");
				}
				
				ss.commit();
				
				String img = (String) movies2.get("image"); 
				request.setAttribute("movieee2",  img); 
			}
			
			}
			
			// 영화 조회 
			this.movie = ss.selectList("tp.getAllMovie");
			//this.x -> 클래스 내부의 필드 x를 가리킴
			
//			request.setAttribute("movieee", movie); 
			
			
			// jsp에 보내기 위해서
			// movies 객체를 movie라는 이름으로
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	
	
	}


	

	
	

