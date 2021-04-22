<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	</script>
</head>
<body>

	
		<!-- 
			<td width="30%"><img src="img/${product.photo }"
				style="object-fit: contain; width: 30%;"></td> -->
	
	 <div class ="buytable3">
	 
	<form action="PurchaseC">
	
		 <table style="width: 100%;" class="top3"  >
		 
		 <tr>
			<td class="cart2"><h1>
					장바구니
				</h1></td>
				
			<td align="right" id=body3><h5>주문/ 결제</h5></td>
			<td align="right" id=body5>
				<h5>> 완료</h5>
			</td>
		</tr>
	</table>
	
	<table style="width: 100%;" class="body4" >
			<tr class="body3">
			
			<td>주문번호</td>
			<td>주문날짜</td>
			<td colspan="2">상품정보</td>
			<td>수량</td>
			<td>가격</td>
			<td colspan="2">삭제 </td>
		</tr>
		
			<c:forEach var="c" items="${carts }">
			
				<tr>
					<td>${c.c_no }</td> 
					<td><fmt:formatDate value="${c.c_date }" pattern="yyyy/MM/dd "/></td>
					
					<c:choose>
					<c:when test="${c.c_type=='t' }">
					<td ><img src="${c.c_img }"  style="object-fit: contain; width: 30%;" ></td>
					</c:when>
					<c:otherwise>
					<td><img src="${c.c_img }"  style="object-fit: contain; width: 30%;"></td>
					</c:otherwise>
					</c:choose>
				
					<td class="c_name" ><h4><p> ${c.p_name}</p></h4>
					${c.p_info}</td> 
					<td>${c.c_p_quantity }개</td>
					<td class="c_price"><fmt:formatNumber value="${c.c_price }" type="currency" /></td>
					<td> 
					<input type="checkbox" name="c_no" value="${c.c_no }"> 
					</td>
					<td>
					<button type="button" onclick="deleteCart(${c.c_no })" class="body5">삭제</button>
	 <button class="body5" type="button" onclick="location.href='updateCartC?c_no=${c.c_no }'">수정</button> 
				</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8" align="center">
					<button class="body6" >결제</button>
				</td>
				
			</tr>
		</table>
	</form>
	</div>
	
	
	
</body>
</html>