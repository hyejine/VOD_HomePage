<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><%--  --%>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<div class="movieWrap">
<div class="movieWrapT">
<!-- 
<div class="jb-box">
  <video muted autoplay loop>
    <source src="img/미나리.mp4" type="video/mp4">
    <strong>Your browser does not support the video tag.</strong>
  </video>
  <div class="jb-text">
    <p>
    Minari grows well anywhere.<br>
    Wonderful Minari, Wonderful</p>
  </div> 
</div>   -->

<!-- 타이틀 밑 부분 -->
<div class="movieTitleM">



<div class=movieS>

<form action="MovieSearchC"> 
<input name="search" placeholder="영화명 검색">
<button id="searchB"><span ><i class="fas fa-search"></i></span></button> 
</form> 
</div>
</div>

<!-- 영화 목록 조회 부분 -->
<div class ="poster">
<div class="contents2">

<ul class="Mcontents3">


<li>
<c:forEach var="m" items="${movieee }">
<div class="Movieflot"style="float: left">
<div class="blackBa">
<div class="Mimg"><img src="${m.mo_img}" ></div></div>
<div class="text_line">${m.mo_name}</div> 
<div class="text_line2">개봉일 <fmt:formatDate value="${m.mo_release}" type="date"  pattern = "yyyy.MM.dd" /></div>

<div class="movieButtonC">

<div class="movieButton3">
<a href="ReviewC?mo_no=${m.mo_no }">리뷰</a>
</div>
</div>

</div>
</c:forEach>
</li>

</ul>
</div>
</div>


</div>


 
<div class="bottonee">
<c:choose>
	<c:when test="${curPageNo == 1 }">
	<span class="page">
	« </span></c:when>
	<c:otherwise>
	
	<a href="MoviePageController?p=${curPageNo - 1 }" class="page">«</a>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${curPageNo == pageCount }">
	<span class="page2">
	»</span></c:when>
	<c:otherwise>
	<a href="MoviePageController?p=${curPageNo + 1 }" class="page2">»</a>
	</c:otherwise>
</c:choose>
</div>

</div>
</body>
</html>