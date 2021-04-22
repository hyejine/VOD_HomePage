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
<form action="TheaterRegC">
<c:if test="${t.th_place!=null }">
<input name="moNumber" value="${t.th_mo_no }" type="hidden">
<input name="thPlace" value="${t.th_place }" type="hidden">
<input name="thSeat" value="${t.th_seat }" type="hidden">
</c:if>
<button>극장 등록하기</button>
</form>

<form action="StoreRegC" >
<button>스토어 상품 조회하기 </button>
</form>

<form action="AllRegC">
<button>등록된 정보 조회하기 </button>
</form>

</body>
</html>