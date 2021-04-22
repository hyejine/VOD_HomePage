package com.tp.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.tp.dvd.DVD;
import com.tp.hc.DBManager_new;
import com.tp.join.Member;
import com.tp.product.Product;
import com.tp.product.ProductDAO;

public class CartDAO {

	public static void getAllCart(HttpServletRequest req) {
		try {

			SqlSession ss = DBManager_new.connect(); // 세션열려면 공장, 빌더

//			ArrayList<Cart_Prouct> cart0 = new ArrayList<Cart_Prouct>();

			Member m = (Member) req.getSession().getAttribute("accountInfo");

			Cart_Prouct cartt = new Cart_Prouct();
			cartt.setC_u_id(m.getM_id());

			List<Cart_Prouct> allproduct = ss.selectList("tp.getInfoForCart_jsp", cartt);

			req.setAttribute("carts", allproduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void regCart(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("accountInfo");

		System.out.println(m.getM_id());

		try {
			System.out.println(m.getM_id());
			SqlSession ss = DBManager_new.connect();

			System.out.println(m.getM_id());

			System.out.println(m.getM_name());

			String c_type = req.getParameter("c_type"); // 예매할 때 input name="c_type" type="hidden"

			System.out.println(m.getM_pw());

			System.out.println(c_type);

			String c_u_id = m.getM_id();
			BigDecimal c_p_no = new BigDecimal(req.getParameter("c_p_no")); // 상품번호 or 티켓번호
			BigDecimal c_price = new BigDecimal(req.getParameter("c_price"));
			String c_img = req.getParameter("c_img");

			if (c_type.equals("t")) {
				BigDecimal c_p_quantity = new BigDecimal(1);

				Cart c = new Cart(null, c_u_id, null, c_p_no, c_p_quantity, c_price, c_img, c_type);

				if (ss.insert("tp.regCart", c) >= 1) {
					System.out.println("등록성공");
				}
				ss.commit();
			} else {

				BigDecimal c_p_quantity = new BigDecimal(req.getParameter("c_p_quantity"));
				Cart c = new Cart(null, c_u_id, null, c_p_no, c_p_quantity, c_price, c_img, c_type);

				if (ss.insert("tp.regCart", c) >= 1) {
					System.out.println("등록성공");
				}
				ss.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "DB연결오류 (장바구니)");
		}

	}

	public static void delete(HttpServletRequest req) {
		try {
			SqlSession ss = DBManager_new.connect();

			BigDecimal c_no = new BigDecimal(req.getParameter("c_no"));

			Cart c = new Cart(c_no, null, null, null, null, null, null, null);

			if (ss.insert("tp.deleteCart", c) == 1) {
				System.out.println("삭제성공");
			}
			ss.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void regPurchase(HttpServletRequest req) {
		
		try {

			// c_u_id에 insert
			Member m = (Member) req.getSession().getAttribute("accountInfo");
			String c_u_id = m.getM_id();
			
			System.out.println("id :"+c_u_id);
			
			List<Cart> cart_checkbox = new ArrayList<Cart>();

			ArrayList<BigDecimal> c1 = new ArrayList<BigDecimal>();
			String[] c = req.getParameterValues("c_no");

			// c_no 배열(체크박스 때문) c1(arraylist에 담기)
			for (String c2 : c) {

				c1.add(new BigDecimal(c2));
				System.out.println("c2 : " +c2);
			}

			SqlSession ss = DBManager_new.connect();

			// 체크박스한 카트DB데이터들 배열에 담으려고 선언

			for (BigDecimal a_c : c1) {
				
				System.out.println("a_c : "+a_c);

				Cart cart = new Cart();
				cart.setC_no(a_c);
				cart_checkbox.add((Cart) ss.selectOne("tp.getAllCheckedCart", cart)); //여기
			}
				
				ArrayList<BigDecimal> C_p_quantity = new ArrayList<BigDecimal>();
				ArrayList<BigDecimal> c_p_no = new ArrayList<BigDecimal>();

				// select한 카트 배열 foreach해서 남은 재고 구하는 메소드 실행
				for (Cart cartSep : cart_checkbox) {

					System.out.println("cartSep : "+cartSep);
					
					if (cartSep.getC_type().equals("p")) {
						C_p_quantity.add(cartSep.getC_p_quantity());
						c_p_no.add(cartSep.getC_p_no());

						System.out.println("C_p_quantity : "+C_p_quantity);
						System.out.println("c_p_no : "+c_p_no);
						
						ProductDAO.restOfQuantity(req, C_p_quantity, c_p_no);
					}

				}
				// 요기까지
			

			BigDecimal sum_price = new BigDecimal(0);

			for (Cart cCB : cart_checkbox) {
				
				System.out.println("cCB : "+cCB);
				
				BigDecimal c_no = cCB.getC_no();
				BigDecimal c_p_no1 = cCB.getC_p_no(); // 상품번호 or 티켓번호
				BigDecimal c_p_quantity = cCB.getC_p_quantity();
				String c_type = cCB.getC_type();
				// 구매가격 : 1개당 가격 이 아니고 수량만큼의 가격
				sum_price = cCB.getC_price().multiply(c_p_quantity);
				
				String c_img = cCB.getC_img();
				
				
				System.out.println("---------------");
				System.out.println(c_img);
				System.out.println(c_p_no1);
				System.out.println(c_p_quantity);
				
				System.out.println("---------------");
				
				Purchase p = new Purchase(null, c_no, c_u_id, null, c_p_no1, c_p_quantity, sum_price, c_img, c_type );

				if (ss.insert("tp.regPurchase", p) >= 1) {
					req.setAttribute("r", "구매 db 등록성공");
				}

			}

			ss.commit();

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "구매 db 연결 실패");
		}
	}

	public static void getAllPurchaseHistory(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();

			Member m = (Member) request.getSession().getAttribute("accountInfo");
			String id = m.getM_id();

			Member m2 = new Member();
			m2.setM_id(id);

			List<Purchase> purchases = ss.selectList("tp.getAllPurchaseHistory", m2);
			
//			System.out.println("가격 : "+purchases.get(0).getPu_price());
//			System.out.println("사진 : "+purchases.get(0).getPu_img());
			
			request.setAttribute("purchases", purchases);
			request.setAttribute("r", "구매목록 조회 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB오류");
		}
	}

	public static void getAcartByNo(HttpServletRequest request) {
		
		try {
			SqlSession ss = DBManager_new.connect();
			
			Cart c = new Cart();
			c.setC_no(new BigDecimal(request.getParameter("c_no")));
			
			Cart cart = ss.selectOne("tp.getAllCheckedCart",c);
			
			request.setAttribute("cart", cart);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void regPurchaseDirectly(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
//			p_no=${p.p_no}&p_quantity=${q }
			
			BigDecimal p_no = new BigDecimal(request.getParameter("p_no"));
			BigDecimal p_quantity = new BigDecimal(request.getParameter("p_quantity"));
			Member m = (Member) request.getSession().getAttribute("accountInfo");
			
			//확인용
			System.out.println("regPurchaseDirectly's p_no = "+request.getParameter("p_no"));
			
			Product p = new Product();
			p.setP_no(p_no);
			
			//상품번호로 해당 상품 조회
			Product p1 = ss.selectOne("tp.getTheProductInfo", p);
			
			int price = p1.getP_price().intValue();
			int quantity = p_quantity.intValue();
			int priceAll = price*quantity;
			BigDecimal priceAll1 = new BigDecimal(priceAll);
			
			
			System.out.println("구매량 : "+ quantity);
			System.out.println("총 가격(구매db) : "+priceAll1);
//			tp.regPurchaseDirectly
			Purchase pu = new Purchase();
			pu.setPu_p_no(p_no);
			pu.setPu_p_quantity(p_quantity);
			pu.setPu_img(p1.getP_img());
			pu.setPu_u_id(m.getM_id());
			pu.setPu_price(priceAll1);
			pu.setPu_type("p");

			
			
			System.out.println("로그인 된 아이디 : "+pu.getPu_u_id());

			//			pu_c_no				널(카트번호 없음) - 바로 구매이므로 카트를 거치지 않는다
			
			//구매 등록
			if (ss.insert("tp.regPurchaseDirectly", pu)==1) {
				request.setAttribute("r", "구매 성공");
			}
			
			ss.commit();
			
//			updateTheProductQuantity(재고 업데이트)
			ProductDAO.restOfQuantityNotCheckBox(request, p_quantity, p_no);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void regPurchaseDVDDirectly(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			
			Member m = (Member) request.getSession().getAttribute("accountInfo");
			
			DVD d1 = new DVD();
			d1.setD_no(new BigDecimal(request.getParameter("d_no")));
			
			
			//상품번호로 해당 DVD 조회
			DVD d = ss.selectOne("tp.getTheDVD", d1);
			
			BigDecimal quantity = new BigDecimal(request.getParameter("d_quantity"));
			
			
			
			
			System.out.println("구매량 : "+ quantity);
			System.out.println("총 가격(구매db) : "+d.getD_price());
//			tp.regPurchaseDirectly
			Purchase pu = new Purchase();
			pu.setPu_p_no(d.getD_no());
			pu.setPu_p_quantity(quantity);
			pu.setPu_img(d.getD_img());
			pu.setPu_u_id(m.getM_id());
			pu.setPu_price(d.getD_price());
			pu.setPu_type("d");

			
			
			System.out.println("로그인 된 아이디 : "+m.getM_id());
			System.out.println("로그인 된 아이디 : "+pu.getPu_u_id());

			//			pu_c_no				널(카트번호 없음) - 바로 구매이므로 카트를 거치지 않는다
			
			//구매 등록
			if (ss.insert("tp.regPurchaseDirectly", pu)==1) {
				request.setAttribute("r", "구매 성공");
			}
			
			ss.commit();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deleteCheckedBox(HttpServletRequest req) {
		try {
			SqlSession ss = DBManager_new.connect();
//			BigDecimal c_no = new BigDecimal(req.getParameter("c_no"));

			String[] c_nos = req.getParameterValues("c_no");
			ArrayList<BigDecimal> cnos = new ArrayList<BigDecimal>();

			for (String cno1 : c_nos) {
				BigDecimal cno2 = new BigDecimal(cno1);

				Cart c = new Cart(cno2, null, null, null, null, null, null, null);

				if (ss.insert("tp.deleteCart", c) == 1) {
					System.out.println("삭제성공");
				}
			}
			ss.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void updateCart(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			
			BigDecimal c_no = new BigDecimal(request.getParameter("c_no"));
			BigDecimal c_quantity = new BigDecimal(request.getParameter("c_quantity"));
			
			Cart c = new Cart();
			c.setC_no(c_no);
			c.setC_p_quantity(c_quantity);
			
			ss.update("tp.updateCartqu", c);
			ss.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
