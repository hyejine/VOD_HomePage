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
<h1>예매 좌석 선택</h1>

<form action="TicketRegC">

<c:forEach var="es" items="${EmptySeats }">

<input type="hidden" name="th_no" value="${rTBRSDTO.t_theater_no}">
<input type="hidden" name="mo_no" value="${rTBRSDTO.t_movie}">
<input type="hidden" name="t_start" value="${rTBRSDTO.t_start}">
<input type="hidden" name="t_end" value="${rTBRSDTO.t_end}">
<input type="hidden" name="t_seat" value="${es}">
<input type="hidden" name="t_price" value="10000">
<button> ${es}번 좌석 예매 </button>

</c:forEach>

</form>

</body>
</html>