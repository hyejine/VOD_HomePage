<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="movieWrap">
		<div class="movieWrapT">

			<div class="movieTitle">
				

				<div class="tab_list">
					<ul id="tab_list">
						<li>굿즈 스토어 </li>
						<h1 class="main_tit">
									<span>오직 withUs에서만 만나 볼 수 있는 해리포터 굿즈 상품 </span> 
								</h1>
					</ul>
				</div>
			</div>

		<!--  	<div class="Store">
				<section class="mainBG">
					<div class="containerS">
						<a href="ProductC">
							<div>
								<h1 class="main_tit">
									<span> 1인 1팝, 1인 1콜!</span> <br> 더블콤보로 함께 해요!
								</h1>
								<p>
									더블콤보 <br> 팝콘(R)2 + 탄산음료(R)2
								</p>
							</div>
						</a>
						<div>&nbsp;&nbsp;</div>
						<div class="main_img1">
							<img
								src="https://img.megabox.co.kr/SharedImg/store/2020/09/02/gi11s9ikY3chK4T9trUPyk8aKcHax7Rm_280.png">
						</div>
					</div>
				</section>

			</div>-->
		</div>
	</div>




	<div>
		<!-- 팝콘 -->
		<div class="meun">
			<h3>베스트 상품</h3>

			<div class="meunR">
				<c:if test="${sessionScope.accountInfo.m_id=='admin' }">
					<a onclick="location.href='ProductRegC'">상품 등록</a>
				</c:if>
			</div>

			<ul > 
	<c:forEach var="p" items="${allProducts}">		
		 <div class="i" style="float: left">
<a href="ProductForPurchaseC?p_no=${p.p_no }">
   <li> 
   <div class="meun_img">
   <img src="${p.p_img }">
   </div>
   
    <div class="Nname">
   ${p.p_name }
   </div>
  
   <div class="infoN">
   ${p.p_info }
   </div>
   
   <div class="price">
 <fmt:formatNumber type="currency">${p.p_price }</fmt:formatNumber>
   </div>
   </li> 
   </a>
   </div>
</c:forEach>
			</ul>
		</div>
	</div>


					

	









</body>
</html>