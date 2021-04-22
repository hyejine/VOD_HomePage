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
public class JsonDAO4 {
	

	public static void JsonMovie(HttpServletRequest request) {
	

	
		HttpsURLConnection huc = null;
		//Api를 호출하기 위해 사용하게 되며, 결과 데이터를 스트림 형식으로 제공받아 이용이 가능
	
		
		// db에 저장해야함 
		
		try {
			SqlSession ss = DBManager_new.connect();
			String url2 = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=N&listCount=500&ServiceKey=V20O2Q99DJ50U1378729&releaseDts=20201201&releaseDte=20210302";
			URL u2 = new URL(url2);
			HttpURLConnection huc2 = (HttpURLConnection)u2.openConnection();
			
			InputStream is2 = huc2.getInputStream();
			InputStreamReader isr2 = new InputStreamReader(is2);
			JSONParser jp2 = new JSONParser();
			JSONObject jo2 = (JSONObject) jp2.parse(isr2);
			System.out.println(jo2);
			
			JSONArray ja = (JSONArray) jo2.get("Data");
			System.out.println(ja);
			
			JSONObject ja2 = (JSONObject) ja.get(0);
			System.out.println("ja2"+ja2);
			
			JSONArray ja3 = (JSONArray) ja2.get("Result");
			System.out.println("ja3"+ja3);
			
			JSONObject ja4 = (JSONObject) ja3.get(0);
			System.out.println(ja4);
			String ja5 = (String) ja4.get("title");
			System.out.println(ja5);
			
			
			
			
			
			
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

