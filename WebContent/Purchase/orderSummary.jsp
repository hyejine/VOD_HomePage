<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


 <div class ="buytable3">
	 
	<form action="PurchaseC">
	
		 <table style="width: 100%;" class="top3" >
		 <tr>
			<td class="cart2"><h1>
					구매내역
				</h1></td>
				
			<td align="right" id=body7><h5>주문/ 결제</h5></td>
			<td align="right" id=body8>
				<h5>> 완료</h5>
			</td>
		</tr>
	</table>
	
	<table style="width: 100%;" class="body4" >
			<tr class="body3">
			
			<td>상품번호</td>
			<td>주문날짜</td>
			<td colspan="2">상품정보</td>
			<td>수량</td>
			<td>가격</td>
		</tr>
		
			<c:forEach var="p" items="${purchases}">
			
				<tr>
					<td>${p.pu_no}</td> 
					<td> <fmt:formatDate value="${p.pu_date }" pattern="yyyy/MM/dd "/></td>
						<td> <img src="${p.pu_img }" style="object-fit: contain; width: 30%;" ></td>
					<td></td>
				<td>${p.pu_p_quantity }</td>
					<td><fmt:formatNumber value="${p.pu_price }" type="currency" /></td>
					
					
					
				</tr>
			</c:forEach>
			<tr>
				
			</tr>
		</table>
	</form>
	</div>




				
</body>
</html>