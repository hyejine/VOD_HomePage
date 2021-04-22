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
	<!-- th_place,th_room startTime(극장 위치, 시작,끝시간(시작+120분), mo_no(어떤 영화 등록할건지)  -->
	<!-- jsp 3개 만들어서 전체 영화 목록 불러주고 영화 선택(mo_no 전달) >>극장데이터 뽑아주고 선택 >> 시간 선택(smDB에 있으면 태그 x)-->
	<!-- 영화목록 불러서 선택하는 페이지 -->
	
<h1>영화 등록</h1>
<h3>영화 선택</h3>

<form action="ShowingMovieChooseTheaterC">
	<table>
		<tr>
			<td></td>
			<td>영화 이름</td>
			<td>출연진</td>
			<td>감독</td>
			<td>평점</td>
			<td>상영시간</td>
		</tr>
		<c:forEach var="m" items="${movies }">
			
			<tr>
				<td><img src="img/${m.mo_img }"> </td>
				<td>${m.mo_name }</td>
				<td>${m.mo_actor }</td>
				<td>${m.mo_director }</td>
				<td>${m.mo_rating }</td>
				<td> <input type="hidden" name="mo_no" value="${m.mo_no }"> ${m.mo_runningTime }</td>
			</tr>

		</c:forEach>
	</table>
</form>
</body>
</html>