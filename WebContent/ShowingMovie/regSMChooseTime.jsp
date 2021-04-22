<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>영화 등록</h1>
<h3>영화 선택 >> 극장 선택 >> 시간 선택</h3>
<form action="ShowingMovieRegC">
	<table>
		<tr>
			<td>시간</td>
		</tr>
		<c:forEach var="sm" items="${SM }">
		
			<c:forEach begin="0" end="1320" step="120" var="time">
				
				<!-- time은 영화 시작 시간 -->
				
				<c:choose>
					<c:when test="${time >= sm.sm_t_start-120 && time <= sm.sm_t_start}">
								<tr> <td> ${time/60 }:${time%60 }~${(time+120)/60 }:${(time+120)%60 } </td> </tr>
					</c:when>

					<c:otherwise>
								<tr> <td> <button> ${time/60 }:${time%60 }~${(time+120)/60 }:${(time+120)%60 } </button> </td> </tr>
					</c:otherwise>
				<input type="hidden" name="mo_no" value="${mo_no }"> 
				<input type="hidden" name="th_no" value="${t.th_no }"> 
				<input type="hidden" name="sm_start" value="${time }"> 
				<input type="hidden" name="sm_end" value="${time+120 }"> 
				<td> <button>좌석 선택</button> </td>
				</c:choose>
			</c:forEach>
						
		</c:forEach>
		
		
	</table>
</form>

</body>
</html>