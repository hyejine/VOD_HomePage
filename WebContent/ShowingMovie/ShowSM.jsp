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
	<!-- 상영영화 보여주는 페이지 -->
	<table>
		<c:forEach var="sm" items="${SM}">
		<tr>
			<td> <img src="img/${sm.mo_img }"> </td>
			<td>${sm.mo_name }</td>
			<td>${sm.sm_t_start/60 } : ${sm.sm_t_start%60 } ~ ${sm.sm_t_end/60 } : ${sm.sm_t_end%60 }</td>
			<td>${sm.mo_release }</td>
			<td>${sm.mo_actor }</td>
			<td>${sm.th_place }</td>
			<td>${sm.th_room }</td>
			<!-- t_seat 받으러 이동(좌석 선택) -->
			<td> <button onclick="location.href='TicketRegC?t_theater_no=${sm.th_no}&t_movie=${sm.mo_no}&t_start=${sm.sm_t_start}&t_end=${sm.sm_t_end}'"> 예매 </button> </td>
		</tr>

		</c:forEach>
	</table>

</body>
</html>