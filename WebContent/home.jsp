<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <%----%>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script type="text/javascript">

function but(a,b) {
	location.href = "PrurchaseDVDC?d_no="+a+"&d_quantity="+b;
}

</script>

 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- Third party plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="Css/styles.css" rel="stylesheet" /> 
    <link rel="stylesheet" href="Css/index.css">  

</head>
<body>

 

        <!-- Masthead-->
        <header class="masthead" style=" background-size: 100%; background: url(img/반지.jpg );">
            <div class="container h-100">
                <div class="row h-100 align-items-center justify-content-center text-center">
                    <div class="col-lg-10 align-self-end">
                        <h1 class="text-uppercase text-white font-weight-bold">"The Lord Of The Rings : The Fellowship Of The Rings"</h1>
                        
                    </div>
                    <div class="col-lg-8 align-self-baseline">
                        <p class="text-white-75 font-weight-light mb-5">마지막 반지를 차지하는 자, 모든 힘을 지배하게 될 것이다!</p>
                        <a class="btn btn-primary btn-xl js-scroll-trigger" href="">구매하기</a>
                    </div>
                </div>
            </div>
        </header>
        <!-- About-->

            <div class="movieTop">
<h5>박스 오피스 </h5>
<!-- <h5>더 많은 영화보기</h5> -->
<div class="contents">
<ul class="Mcontents">


<!-- 1 -->
<li>
<div class="text_photo"> 
<p id = 'explain'>${movieee[2].mo_name}</p>
<img src ="${movieee[2].mo_img}">
</div>

<div class="movieButton">
<button onclick="but(${dvds[2].d_no },1)">구매</button>
</div>
</li>

<!-- 2 -->
<li>
<div class="text_photo"> 
<p id = 'explain'>${movieee[3].mo_name}</p>
<img src="${movieee[3].mo_img}"> 
</div>

<div class="movieButton"> 
<button onclick="but(${dvds[3].d_no },1)">구매</button>
</div>
</li>


<!-- 3 -->
<li>
<div class="text_photo"> 
<p id = 'explain'>${movieee[20].mo_name}</p>
<img src ="${movieee[20].mo_img}">  
</div>
<div class="movieButton">
<button onclick="but(${dvds[20].d_no },1)">구매</button>
</div>
</li>

<!-- 4 -->
<li>
<div class="text_photo"> 
<p id = 'explain'>${movieee[0].mo_name}</p>
<img src ="${movieee[0].mo_img}">  
</div>

<div class="movieButton">
<button onclick="but(${dvds[0].d_no },1)">구매</button>
</div>
</li>

 </ul>
</div>



 <ul class="movieDown">
<li><form action="MovieSearchC"> 
<div class="searchA">

<input name="search" placeholder="영화명을 입력해 주세요">
<button><i class="fas fa-search"></i></button>

</div>
</form></li>

<li><div>
<a href="MovieC">영화 목록 </a>
</div></li>

<li><div>
<a href="LocationC"><span>극장 위치</span> </a>
</div></li>


<li><div>
<a href="ProductC">굿즈 상품 </a>
</div></li>

</ul>
</div>  
        <!-- Services -->
        <section class="page-section" id="services">
            <div class="container">
                <h3 class="text-center mt-0">Introduce</h3>
                <div class="row">
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <i class="fas fa-4x fa-gem text-primary mb-4"></i>
                            <h3 class="h4 mb-2">열정</h3>
                            <p class="text-muted mb-0">어떠한 일도 열심히 하는 저희들의 <br>열정은 다이아몬드의 값어치와도 <br>같습니다.</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <i class="fas fa-4x fa-laptop-code text-primary mb-4"></i>
                            <h3 class="h4 mb-2">기본</h3>
                            <p class="text-muted mb-0">자바를 이해하고 있으며 기본적인 <br>자바 프로그래밍이 가능합니다.</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <i class="fas fa-4x fa-globe text-primary mb-4"></i>
                            <h3 class="h4 mb-2">글로벌</h3>
                            <p class="text-muted mb-0">일본어와 한국어 2개 국어 이상이<br> 가능한 글로벌 인재입니다.</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <i class="fas fa-4x fa-heart text-primary mb-4"></i>
                            <h3 class="h4 mb-2">배려</h3>
                            <p class="text-muted mb-0">함께 일하는 상대를 존중하고, <br>배려하며 어울려 일하실 수 있습니다.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Portfolio-->
      
       
        <!-- Contact-->
        <section class="page-section" id="contact">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8 text-center">
                        <h2 class="mt-0">함께 하고 싶습니다. </h2>
                        <p class="text-muted mb-5">Ready to start your next project with us? Give us a call or send us an email and we will get back to you as soon as possible! Thank you.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 ml-auto text-center mb-5 mb-lg-0">
                        <i class="fas fa-phone fa-3x mb-3 text-muted"></i>
                        <div><p class="font22">팀장: 정혜진 (010-5690-7222)</p>
                        <p class="font22">조원: 이지형 (010-4001-3775)</p>
                        </div>
                    </div>
                    <div class="col-lg-4 mr-auto text-center">
                        <i class="fas fa-envelope fa-3x mb-3 text-muted"></i>
                        <a class="d-block" href="mailto:contact@yourwebsite.com"><p class="font22">hyejine1997@naver.com</p>
                        <p class="font22"> comji94@naver.com</p></a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        
        <footer class="bg-light py-5">
            <div class="container"><div class="small text-center text-muted">Copyright © 2020 - Start Bootstrap</div></div>
        </footer>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
        <script src="js/scripts.js"></script>






























</body>
</html>