<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 내가 예매 티켓 목록 출력 >> 구매 내역의 pu_type이 t이면서 id가 세션에 로그인 된 사람의 것만 조회-->
	<table border="1">
		<tr>
			<td>영화명</td>
			<td>장르</td>
		</tr>
		<c:forEach var="m" items="${movies}">
			<tr>
				<td><a onclick="location.href='TheaterC?no=${m.mo_no}'">${m.mo_name }</a>
				</td>
			</tr>
		</c:forEach>
	</table>











</body>
</html>