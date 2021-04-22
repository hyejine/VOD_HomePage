<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<td>상품 번호</td>
			<td>상품명</td>
			<td>상품 정보</td>
			<td>가격</td>
			<td>수량</td>
			<td>사진</td>
		</tr>
		
		<c:forEach var="p" items="products">
		<tr>
		<td>${p.p_no }</td>
		<td>${p.p_name }</td>
		<td>${p.p_info }</td>
		<td>${p.p_price } 원 </td>
		<td>${p.p_quantity }</td>
		<td> <img src="../img/${p.p_img }"> </td>
		</tr>
		
		</c:forEach>
		<tr>
		<td colspan="6" align="center">
		<button onclick="location.href='HC'">홈으로</button>
		<button onclick="history.back()">뒤로가기</button>
		</td>
		</tr>
	</table>
</body>
</html>