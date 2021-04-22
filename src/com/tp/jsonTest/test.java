package com.tp.jsonTest;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.tp.hc.DBManager_new;

public class test {
public static void main(String[] args) {
	//날씨 데이터를 파씽 -> DB	
	
	//객체 지향에서 발전된 형태 =>AOP(관점지향)
	//DBmanager와 같은 걸 만들자 l

HttpsURLConnection huc = null;
			//Api를 호출하기 위해 사용하게 되며, 결과 데이터를 스트림 형식으로 제공받아 이용이 가능

			try {
				
				String str = "시리즈"; 
				// 검색어 (어떤 키워드로 검색할 것인가?)
				str = URLEncoder.encode(str, "utf-8");
				// 영화라는 정보를 불러 올때 인코더를 한국어로 한다?
				
				SqlSession ss = DBManager_new.connect();
				// db에 저장해야함 
				
				// json parsing -> json-simple 자르 필요 
				
				String url = "https://openapi.naver.com/v1/search/movie.json?query="+str+"&display=100&yearfrom=2019&yearto=2021";
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
//				System.out.println("json객체 : " + movie);
			    
				// 내가 원하는 자료 뽑기 
				JSONArray item = (JSONArray) movie.get("items");
				System.out.println(item.get(0));
//				JSONObject actor = (JSONObject) item.get(0);
//				System.out.println(actor.get("actor"));
//				JSONObject image = (JSONObject) item.get(0);
//				System.out.println(actor.get("image"));
//				JSONObject director = (JSONObject) item.get(0);
//				System.out.println(actor.get("director"));
//				JSONObject subtitle = (JSONObject) item.get(0);
//				System.out.println(actor.get("subtitle"));
//				JSONObject title = (JSONObject) item.get(0);
//				System.out.println(actor.get("title"));
//				JSONObject pubDate = (JSONObject) item.get(0);
//				System.out.println(actor.get("pubDate"));
				
				ArrayList<Movie> movies = new ArrayList<Movie>();
				for (int i = 0; i < item.size(); i++) {
					JSONObject movies2 = (JSONObject) item.get(i);
					// 확인용 
					System.out.println(i + "번째");
					System.out.println(movies2.get("actor"));
					System.out.println(movies2.get("director"));
					movies.add(new Movie((String) movies2.get("actor"), (String) movies2.get("image"), (String) movies2.get("director"),
							(String) movies2.get("subtitle"), (String) movies2.get("title"), (String) movies2.get("pubDate")));
					System.out.println("---------------");
					
				}
				request.setAttribute("movie", movies); 
				// jsp에 보내기 위해서
				// movies 객체를 movie라는 이름으로
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
