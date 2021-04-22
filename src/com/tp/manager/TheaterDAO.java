package com.tp.manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;
import com.tp.movie.Movie;
import com.tp.showingmovie.ShowingMovie;

public class TheaterDAO {

	public static void regTheater(HttpServletRequest request) {

		//반환용 리스트
        List<List<String>> ret = new ArrayList<List<String>>();
        BufferedReader br = null;
        
        try{
        	SqlSession ss = DBManager_new.connect();
        	
        	
            br = Files.newBufferedReader(Paths.get("C:\\Users\\User\\Desktop\\Theater.csv"));
            //Charset.forName("UTF-8");
            String line = "";
            
            while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",");
                //배열에서 리스트 반환
                tmpList = Arrays.asList(array);
                System.out.println(tmpList);
//                ret.add(tmpList);
                
                

                
                //영화관 마다 room이 다르므로 각 영화관의 1관부터 마지막 room까지를 db에 등록
                for (int i = 1; i < tmpList.size(); i=i+2) {
					for (int t = 1; t < Integer.parseInt(tmpList.get(i)); t++) {
						Theater th = new Theater();
						th.setTh_place(tmpList.get(i-1));
						th.setTh_room(new BigDecimal(t));
						
						//영화관 좌석 수는 40으로 고정
						th.setTh_seat("40");
						if(ss.insert("tp.regTheater", th)==1) {
							request.setAttribute("r", "영화관 등록 성공");
						}
						
					}
				}
                ss.commit();
                
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }




		
		
		
		
		
	}

	

	public static void getAllTheatersByMovie(HttpServletRequest request) {
		
		try {
			SqlSession ss =DBManager_new.connect();
			
			
			
			List<Theater> theaters = ss.selectList("tp.getAllTheater");
			
			request.setAttribute("theaters", theaters);
			request.setAttribute("mo_no", request.getParameter("mo_no"));
			
		} catch (Exception e) {

		}
		
	}



	public static void getTheatersByNo(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			
			ShowingMovie sm = (ShowingMovie) request.getAttribute("SM");
			BigDecimal sm_th_no = sm.getSm_th_no();
			
			ShowingMovie sm1 = new ShowingMovie();
			sm1.setSm_th_no(sm_th_no);
			
			List<Theater> theaters = ss.selectList("tp.getTheatersByNo", sm1);
			
			
			request.setAttribute("theaters", theaters);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}

