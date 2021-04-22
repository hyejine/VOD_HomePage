package com.tp.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.tp.hc.DBManager_new;
import com.tp.join.Member;

// 로그인 하기
public class LoginDAO {
	public static void login(HttpServletRequest request, HttpServletResponse response) {

		try {
			String id = request.getParameter("userId");
			String pw = request.getParameter("userPw");

			Member m = new Member();
			m.setM_id(id);                                               // 위에서 선언한 m 이라는 객체에 setter를 이용해서 id 와pw을 세팅해준다. 
			m.setM_pw(pw);
			//m= new Member(id, null, pw, null, null);
			
			
			SqlSession ss = DBManager_new.connect();                     
			// login이란 리스트가 있는데 타입이 Member다     list 가 arraylist의 상위 버전  = > 메이븐으로 들어오고 부터 arraylist를 쓰면 안담김 
			List<Member> login = ss.selectList("tp.login", m);    
			List<Member> login1 = ss.selectList("tp.login1", m);
			
			
			  if (!login.isEmpty()) {
				// db에 있는 값과 input값이 같을때

					// 세션 사용(값이 유지되야할때 사용)
					HttpSession hs = request.getSession();
					// 세션은 시간 제한이 있음
					hs.setMaxInactiveInterval(30*60);                  // 30분
					hs.setAttribute("accountInfo", login.get(0));      //   아이디는 pk값으로 지정 해줬기 때문에 하나 밖에 없고 => 0번째 자리 => 인덱스 0번째꺼를 accountIngo에 담아준다. 
					request.setAttribute("contentPage", "home.jsp");
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
				} else if(!login1.isEmpty()){
					request.setAttribute("r", "* 비번 오류");
					request.setAttribute("contentPage", "Login/login.jsp");
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
				}
			 else {
				request.setAttribute("r", "* ID없음");
				
				request.setAttribute("contentPage", "Login/login.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "* DB서버 실패");

		}
	}

}

//			login - arraylist - get -getter
//			login.get(x) - array - .getter 
//			
//			서울시 성동구 xx동(get) -11(getter)
//			서울시 성동구 용답동 -11