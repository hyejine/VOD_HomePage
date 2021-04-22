<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 <link rel="stylesheet" href="Css/login1.css">
<script type="text/javascript">


</script>
</head>
<body>

	<section class="login-block">
		<div class="container">
			<div class="row">
				<div class="col-md-4 login-sec">
					<h2 class="text-center">Login Now</h2>
					<form action="LoginC" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1" class="text-uppercase">아이디</label>
							<input name="userId" class="form-control" 
								placeholder="아이디를 입력해주세요.">

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" class="text-uppercase">비밀번호</label>
							<input type="password" class="form-control" name="userPw"
								placeholder="비밀번호를 입력해주세요.">
						</div>


						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input"> <small>Remember Me</small>
							</label>
							<button type="submit" class="btn btn-login float-right" >확인</button>
						</div>
							<p class="loginCheck"> ${r }</p>

					</form>
					<div class="copy-text">
						Created with <i class="fa fa-heart"></i> by <a
							href="http://grafreez.com">Grafreez.com</a>
					</div>
				</div>
				<div class="col-md-8 banner-sec">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleIndicators" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block img-fluid" src="img/미나리.jpg"
									alt="First slide">
								<div class="carousel-caption d-none d-md-block">
									<div class="banner-text">
										<h2>미나리</h2>
										<p>
											어느 한국 가족의 원더풀한 이야기 <br> "미나리는 어디서든 잘 자라" <br> 낯선
											미국, 아칸소로 떠나온 한국 가족.<br>

										</p>
									</div>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid" src="img/아이씨유.jpg"
									alt="First slide">
								<div class="carousel-caption d-none d-md-block">
									<div class="banner-text">
										<h2>I See You</h2>
										<p>
											열 살 소년 실종 사건이 발생한 어느 교외 도시, <br> 사건 담당 형사 그렉은 이 사건이 15년
											전 일어났던 <br> 아동 연쇄 살인 사건과 관련이 있음을 직감한다.

										</p>
									</div>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid" src="img/모리타니안.jpg"
									alt="First slide">
								<div class="carousel-caption d-none d-md-block">
									<div class="banner-text">
										<h2>The Mauritanian</h2>
										<p>
											전세계를 충격에 빠뜨린 실화!<br> 재판을 원하는 한 남자!<br> 그는 테러리스트인가,
											무고한 피해자인가!
										</p>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>





</body>
</html>