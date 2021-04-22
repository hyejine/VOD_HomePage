package com.tp.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tp.hc.DBManager_new;

public class ProductDAO {

	public static void regProduct(HttpServletRequest req) {
		
		try {
			SqlSession ss = DBManager_new.connect();

			
			String path = req.getSession().getServletContext().getRealPath("/img");
			
			MultipartRequest mr = new MultipartRequest(req , path, 30 * 1024 * 1024 
					, "utf-8",new DefaultFileRenamePolicy()
			);
			
			String p_name = mr.getParameter("name");
			BigDecimal p_price = new BigDecimal(mr.getParameter("price"));
			BigDecimal p_quantity = new BigDecimal(mr.getParameter("quantity"));
			String p_img = mr.getFilesystemName("img");
			String p_info = mr.getParameter("info");
			Product p = new Product(null, p_name,p_info, p_price, p_quantity, p_img);
			
			if (ss.insert("tp.regProduct", p)==1) {
				req.setAttribute("r", "제품 등록 성공");
			}
			ss.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	
//ProductInfo (필요한 정보 다 Join) 스토어 상품 조회 
//	<!-- 존재하는 상품 전체를 보여주는 페이지 -->
	public static void getAllProduct(HttpServletRequest request) {
//		getAllProduct
		
		try {
			SqlSession ss = DBManager_new.connect();
			
			List<Product> products = ss.selectList("tp.getAllProduct");
			
			request.setAttribute("allProducts", products);
			request.setAttribute("r", "상품 조회 성공");
			
			for (Product product : products) {
				System.out.println(product.getP_img());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

// 장바구니에 들어간 상품의 상세 정보를 보여줌
	public static void getTheProductInfo(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			BigDecimal p_no = new BigDecimal(request.getParameter("p_no"));
			System.out.println("p_no : "+p_no);
			
			Product p = new Product();
			
			p.setP_no(p_no);
			
			Product p1 = ss.selectOne("tp.getTheProductInfo", p);
			
			request.setAttribute("product", p1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	public static void restOfQuantity(HttpServletRequest request, ArrayList<BigDecimal> c_p_quantity2, ArrayList<BigDecimal> c_p_no2) {
		
		
		
		
		BigDecimal result = new BigDecimal(0);

		
		try {
			SqlSession ss = DBManager_new.connect();
			
			
			
			Product p = new Product();
			for (int i = 0; i < c_p_no2.size(); i++) {
				
				p.setP_no(c_p_no2.get(i));
				System.out.println("제품 재고 수정 DB");
			
			Product product = ss.selectOne("tp.getTheProductQuantity", p);
	
			
				
				result = product.getP_quantity().subtract(c_p_quantity2.get(i));
				
				System.out.println("재고 수정 상품 번호 : "+c_p_no2.get(i));
				System.out.println("남은 재고량 : "+result);
				
			Product n_p = new Product();
			n_p.setP_quantity(result);
			n_p.setP_no(c_p_no2.get(i));
			
			if (result.intValue()>0) {
				if (ss.update("tp.updateTheProductQuantity", n_p)>=1) {
					request.setAttribute("r", "재고 수정 성공");
				}
			}
			else {
				n_p.setP_quantity(new BigDecimal(100));
				if (ss.update("tp.updateTheProductQuantity", n_p)>=1) {
					request.setAttribute("r", "재고 수정 성공");
				}
			}
			ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB오류(재고 수정)");
		}
		
	}

	//바로 구매이므로 체크박스 없이 구매 후 재고 수정
	public static void restOfQuantityNotCheckBox(HttpServletRequest request, BigDecimal p_quantity, BigDecimal p_no) {

		BigDecimal result = new BigDecimal(0);

		
		try {
			SqlSession ss = DBManager_new.connect();
			
			
			
			Product p = new Product();
				
				p.setP_no(p_no);
				System.out.println("제품 재고 수정 DB");
			
			Product product = ss.selectOne("tp.getTheProductQuantity", p);
	
//			result = product.getP_quantity().subtract(p_quantity);
			
			int quantityNow = product.getP_quantity().intValue();
			int purchasedQuantity = p_quantity.intValue();
			
			int result1 = quantityNow-purchasedQuantity;
			
			result = new BigDecimal(result1);
				
			Product n_p = new Product();
			n_p.setP_quantity(result);
			n_p.setP_no(p_no);
			
			if (ss.update("tp.updateTheProductQuantity", n_p)>=1) {
				request.setAttribute("r", "재고 수정 성공");
			}
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB오류(재고 수정)");
		}
		
		
	}

}
