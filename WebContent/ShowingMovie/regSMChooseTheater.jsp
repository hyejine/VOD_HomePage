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
<!-- 영화선택한 뒤 영화등록할 극장을 선택-->
<h1>영화 등록</h1>
<h3>영화 선택 >> 극장선택</h3>
<form action="ShowingMovieChooseTimeC">
	<table>
		<tr>
			<td>영화상영관명</td>
			<td>총 스크린수</td>
			<td>좌석 수</td>
		</tr>
		<c:forEach var="t" items="${theaters }">
			
			<tr>
				<td>${t.th_place }</td>
				<td>  ${t.th_room }</td>
				<td>  ${t.th_seat }</td>
			<td> <button>시간 선택</button> </td>
			</tr>
		</c:forEach>
		<tr>
			<td> <input type="hidden" name="mo_no" value="${mo_no }"> </td>
			<td> <input type="hidden" name="th_no" value="${t.th_no }"></td>
	</tr>
	</table>
</form>
</body>
</html>