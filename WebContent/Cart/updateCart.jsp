<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function but1() {
		let aa = $("#op option:selected").val();
		let a = $("#no").val();
		
		location.href = "updateCartC?c_no="+a+"&c_quantity="+aa;
	}

</script>

</head>
<body>

 <div class ="buytable3">
	 
	
		 <table style="width: 100%;" class="top3"  >
		 
		 <tr>
			<td class="cart2"><h1>
					수정
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
			<td >상품정보</td>
			<td>수량</td>
			<td>가격</td>
			
		</tr>
		
			
				<tr>
					<td>${cart.c_no }</td> 
					<td><fmt:formatDate value="${cart.c_date }" pattern="yyyy/MM/dd "/>  <input type="hidden" name="c_no" value="${c.c_no }"> </td> 
					
					
					<c:choose>
					<c:when test="${cart.c_type=='t' }">
					<td><a  onclick="loaction.href='TicketInfoC?t_no=${cart.c_p_no }&c_p_no=${cart.c_p_no }'"><img src="${cart.c_img }" style="object-fit: contain; width: 30%;" ></a></td>
					</c:when>
					<c:otherwise>
					<td><a onclick="location.href='ProductInfoC?p_no=${cart.c_p_no }&c_p_no=${cart.c_p_no }'"><img src="${cart.c_img }" style="object-fit: contain; width: 30%;" ></a></td>
					</c:otherwise>
					</c:choose>
					
					
					
				
				<!-- 	<td  ><h4><p> ${c.p_name}</p></h4>
					${c.p_info}</td>  -->
					<td>
					<select name="c_p_quantity" id="op">
					<c:forEach begin="1" end="8" var="q">
					<option value="${q}"> ${q }
					
					</option> 
					</c:forEach>
					</select>
					
					</td>
					<td class="c_price"><fmt:formatNumber value="${cart.c_price }" type="currency" /></td>
					<td>
				</td>
				</tr>
			<tr>
				<td colspan="8" align="center">
					<button class="body6" onclick="but1()">수정</button> 
					<input id="no" name="c_no" type="hidden" value="${cart.c_no }">
				</td>
				
			</tr>
		</table>
	</div>
	
	

</body>
</html>