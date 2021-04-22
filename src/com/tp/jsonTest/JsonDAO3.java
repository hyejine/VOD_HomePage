package com.tp.jsonTest;

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
import com.tp.hc.DBManager_new;

//openweathermap
public class JsonDAO3 {
	

	public static void JsonMovie(HttpServletRequest request) {
	

	
		HttpsURLConnection huc = null;
		//Api를 호출하기 위해 사용하게 되며, 결과 데이터를 스트림 형식으로 제공받아 이용이 가능
	
		
		// db에 저장해야함 
		
		try {
			SqlSession ss = DBManager_new.connect();
			String url2 = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=6fd4cb6041d3d374568d4c9c69633ecd&targetDt=20210215";
			URL u2 = new URL(url2);
			HttpURLConnection huc2 = (HttpURLConnection)u2.openConnection();
			
			InputStream is2 = huc2.getInputStream();
			InputStreamReader isr2 = new InputStreamReader(is2);
			JSONParser jp2 = new JSONParser();
			JSONObject jo2 = (JSONObject) jp2.parse(isr2);
			System.out.println(jo2);
			
			JSONObject ja = (JSONObject) jo2.get("boxOfficeResult");
			//System.out.println(ja);
			JSONArray ja2 = (JSONArray) ja.get("dailyBoxOfficeList");
			//System.out.println(ja2);
			
			
//			JSONObject ja3 = (JSONObject) ja2.get(0);
//			System.out.println("ja3"+ja3);
			
			ArrayList<Movie2> movies5 = new ArrayList<Movie2>();
			for (int j = 0; j < ja2.size(); j++) {
				JSONObject movies6 = (JSONObject) ja2.get(j);
				// 확인용 
//				System.out.println(j+ "번째");
//				System.out.println(movies6.get("movieNm"));
//				System.out.println(movies6.get("prdtStatNm"));
				movies5.add(new Movie2((String)movies6.get("movieNm")));
//				System.out.println("---------------");
				
//				https://img.megabox.co.kr/SharedImg/2021/01/25/dd9e2Z3oYfQLVER7qBvpnBBAG3JOZ81j_420.jpg
//			    https://img.megabox.co.kr/SharedImg/2021/03/03/Pu4sv6WSu8qn9i6H7DvvSE32Jo7SPQDI_420.jpg	
					
			
			String ja4 = (String) movies6.get("movieNm");
			
			String str = ja4; 
			// 검색어 (어떤 키워드로 검색할 것인가?)
			str = URLEncoder.encode(str, "utf-8");
			// 영화라는 정보를 불러 올때 인코더를 한국어로 한다?
			
			// json parsing -> json-simple 자르 필요 
			
			String url = "https://openapi.naver.com/v1/search/movie.json?query="+str+"&start=2&yearfrom=2018&yearto=2021&display=100";
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
				
//				movies.add(new Movie((String) movies2.get("actor"), (String) movies2.get("image"), (String) movies2.get("director"),
//						(String) movies2.get("subtitle"), (String) movies2.get("title"), (String) movies2.get("pubDate")));
//				String actor = (String) movies2.get("actor");
//				m.setActor(actor);
				
			//	Date pubDate = (Date) movies2.get("pubDate");
				
//				String saveDirectory = request.getServletContext().getRealPath("img");
//				MultipartRequest mr= new MultipartRequest(request, saveDirectory, 31457280,"utf-8", new DefaultFileRenamePolicy());
				
				SimpleDateFormat dt = new SimpleDateFormat("yyyy");
				Date pubDate = dt.parse((String)movies2.get("pubDate"));
				
				
				m.setMo_actor((String) movies2.get("actor"));
				m.setMo_director((String) movies2.get("director"));
				m.setMo_img((String) movies2.get("image"));
				m.setMo_name((String) movies2.get("title"));
				m.setMo_release(pubDate);
				m.setMo_rating(new BigDecimal(0));
				
//				movies.add(m);
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
				ss.commit();
				
				String img = (String) movies2.get("image"); 
				request.setAttribute("movieee2",  img); 
			}
			
			}
			
			// 영화 조회 
			List<Movie> movies = ss.selectList("tp.getAllMovie");
			
			
			request.setAttribute("movieee", movies); 
			
			
			// jsp에 보내기 위해서
			// movies 객체를 movie라는 이름으로
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}


}

