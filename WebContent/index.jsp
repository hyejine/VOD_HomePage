<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie</title>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/jQuery.js"></script>

<link rel="stylesheet" href="Css/login.css">
<link rel="stylesheet" href="Css/index.css">
<link rel="stylesheet" href="Css/font.css">
<link rel="stylesheet" href="Css/styles.css"> 
<script type="text/javascript">
	function logout() {

		alert("로그아웃 되었습니다.");

		location.href = "LogoutC"; // 로그아웃 페이지로 이동

	}
	function cart() {
		alert("로그인을 해주세요.");
		<%--location.href = "LoginC";--%>
	}
</script>
<%--로그인 모달창 --%>
<script type="text/javascript">
window.onload = function() {
	 
    function onClick() {
        document.querySelector('.modal_wrap').style.display ='block';
        document.querySelector('.black_bg').style.display ='block';
    }   
    function offClick() {
        document.querySelector('.modal_wrap').style.display ='none';
        document.querySelector('.black_bg').style.display ='none';
    }
 
    document.getElementById('modal_btn').addEventListener('click', onClick);
    document.querySelector('.modal_close').addEventListener('click', offClick);
 
};
</script>
</head>
<body id="page-top">
	<!--${r }-->
        <!-- Navigation
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="HC"> WithUs</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#about">About</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#services">Services</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#portfolio">Portfolio</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#contact">Contact</a></li>
                    </ul>
                </div>
            </div>
        </nav>-->
	
        

	<div class="wrap">
		<div class="header_bg">
			
			
			<div class="header">
				<div class="header_L">


					<!-- 수정 장바구니, 빠른예매 -->
					<c:choose>
						<c:when test="${sessionScope.accountInfo == null}">
							<li><span onclick="cart()">장바구니</span></li>
							<li><span onclick="cart()">구매내역</span></li>
						</c:when>
						<c:otherwise>
							<li><span onclick="location.href='CartC'">장바구니</span></li>
							<li><span onclick="location.href='MyReviewC'">내가 쓴 리뷰</span></li>
							<li><span onclick="location.href='ShowAllPurchaseC'">구매내역</span></li>
						</c:otherwise>
					</c:choose>

				</div>

				<!-- <div class=searchA>
				
					<form action="">
						<input> <span>검색</span>
					</form>
				</div> -->

				<div class="logo">
					<a href="HC"> <span class="logo_h"> WithUs</span>
					</a>
				</div>

				<ul class="header_R">
						
					<c:choose>
						<c:when test="${sessionScope.accountInfo == null }">
							<li ><a href="LoginC">로그인</button>

<!-- 로그인 모달창 
<div class="black_bg"></div>
<div class="modal_wrap">
<h3>로그인</h3>
    <div class="modal_close"><a href="#">close</a></div>
    
    <div class="loginWrap">
    <div class="loginInner">
    
    <div class="col_wrap">
    <div class="col_left">
    <div class="loginArea">
        <form action="LoginC" method="post">

<ul>        
<li><input name ="userId" placeholder="아이디"></li> 
<li><input name ="userPw" placeholder="비밀번호" type="password"></li>
</ul>

<div class="idCheckbox">
<input type="checkbox"> 아이디 저장
</div>

<div class="login1">
<button>로그인</button>
 </div>
 
 <div class="join1">
<a href="JoinC">회원가입</a>
</div>
</form>
</div>
</div>

<div class="col_Right">
<img src ="img/소울.png" style="width: 420px; height: 330px; ">  
</div>



</div>
</div>
</div>
</div>
</li>-->


							<li><a href="JoinC">회원가입 </a></li>
						</c:when>
						<c:otherwise>
						
						<c:choose>
						<c:when test="${sessionScope.accountInfo.m_id=='admin' }">
							<li><a href="MovieRegC">관리자 페이지 </a></li>
							<li class="logout"><a onclick="logout()">로그아웃 </a></li>
						</c:when>
						<c:otherwise>
							<li class="logout"><a onclick="logout()">로그아웃 </a></li>
							<li><a href="InfoC">회원정보 </a></li>
						</c:otherwise>
						</c:choose>
						</c:otherwise>
					</c:choose>

					
				</ul>
</div>

				<!-- 메뉴바 -->
				<div class="menu-1">
					<ul>
						
						<li><a href="ShowAllDVD">VOD </a>
						</li>
						<li><a href="ProductC">상품 </a>
							<!--<ul class="nav_b">
								 <li><a href="">콜라</a></li>
								<li><a href="">팝콘</a></li>
								<li><a href="">그 외 상품</a></li
							</ul>-->
							</li>
						<li><a href="LocationC">스토어 위치</a>
							</li>
							</ul>
				</div>

			</div>
		</div>

	<jsp:include page="${contentPage }"></jsp:include>

        

</body>
</html>