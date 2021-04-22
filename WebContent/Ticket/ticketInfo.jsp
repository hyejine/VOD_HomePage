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

	<table>
		<tr>
			<td>예매 번호</td>
			<td>영화 이름</td>
			<td>좌석</td>
			<td>장소</td>
			<td>포스터</td>
			<td>가격 </td>
			<td>예매</td>
		</tr>

		<c:forEach var="t" items="${tickets}">
			<tr>
				<td>${t.t_no}</td>
				<td>${t.m_name}</td>
				<td>${t.t_seat}</td>
				<td>${t.th_place} ${t.th_company}극장</td>
				<td><img src="../img/${t.m_img}"></td>
				<td>${t.t_price } 원</td>
				<td>
				<form action="CartRegC">
					<input name="t_no" value="${t.t_no }" type="hidden">
					<input name="t_uid" value="${t.t_uid }" type="hidden">
					<input name="m_img" value="${t.m_img }" type="hidden">
					<input name="t_price" value="${t.t_price }" type="hidden">
					<input name="c_type" value="t" type="hidden">
					<button>예매하기</button>
				</form>
			</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center">
				<button onclick="location.href='HC'">홈으로</button>
				<button onclick="history.back()">뒤로가기</button>
			</td>
		</tr>
	</table>

</body>
</html>