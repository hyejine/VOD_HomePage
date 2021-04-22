<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
float: left;
}
</style>
</head>
<body>
등록된 영화명
<c:forEach var="m" items="${movie}">
<table border="1">
<tr>
<td>
<a onclick="location.href='TheaterC?no=${m.mo_no}'">${m.mo_name }</a>
</td>
</tr>
</table>
</c:forEach>


<c:if test="${m.mo_no == th_mo_no}">
<c:forEach var="t" items="${Theater1}">
<table>
<tr>
<td>
<a onclick="location.href='TicketTimeC?no=${t.th_no}'">${t.th_place }</a>
</td>
</tr>
</table>
</c:forEach>
</c:if>




</body>
</html>