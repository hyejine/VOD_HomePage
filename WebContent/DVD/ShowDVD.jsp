<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function but(a,b) {
	let ok = confirm('구매합니까?');
	if (ok) {
		
	location.href = "PrurchaseDVDC?d_no="+a+"&d_quantity="+b;
	}
}
</script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<div class="movieWrap">
<div class="movieWrapT">
 
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
</div>  

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
<c:forEach var="d" items="${ dvds}">
<div class="Movieflot"style="float: left">
<div class="blackBa ">
<p id = 'explain'>상영 시간: ${d.d_runningTime }시간<br>
<fmt:formatNumber value="${d.d_price }" type="currency" />
<br>
감독: ${d.d_director }
</p>
<div class="Mimg"><img src="${d.d_img }">
</div>
 </div>
<div class="text_line">${d.d_name }</div>
<div class="text_line2">개봉일 <fmt:formatDate value="${d.d_release }" type="date"  pattern = "yyyy.MM.dd" /></div>

<div class="movieButtonC">
<div class="movieButton2">
<a onclick="but(${d.d_no },1)" class="buyA">구매하기</a>
</div>
<div class="movieButton2">
<a href="ReviewC?mo_no=${d.d_no }">리뷰</a>
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
	
	<a href="DVDDAOPageController?p=${curPageNo - 1 }" class="page">«</a>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${curPageNo == pageCount }">
	<span class="page2">
	»</span></c:when>
	<c:otherwise>
	<a href="DVDDAOPageController?p=${curPageNo + 1 }" class="page2">»</a>
	</c:otherwise>
</c:choose>
</div>
</div>	
</body>
</html>
