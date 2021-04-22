<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 <link rel="stylesheet" href="Css/join.css">
<script type="text/javascript">
	function infoC() {
		alert("수정 완료 되었습니다.");
	}
</script>
</head>
<body>
	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
				<h3>Welcome</h3>

			</div>

			<div class="col-md-9 register-right">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading">정보 수정/조회</h3>
						<form action="ReviseOk" method="get">
								<div class="row register-form">
									<div class="col-md-6">
										<div class="form-group">
											이름: <input type="text" class="form-control" name="name"
												id="name" placeholder="${sessionScope.accountInfo.m_name}" value="" />
										</div>    <!--accountInfo라는 이름으로 세션에 로그인 정보를 담았고, 로그인의 타입이 멤버라서 멤버 빈에 있는 필드 이용  -->
										<div class="form-group">
											전화번호: <input type="text" class="form-control" name="number"
												maxlength="11" placeholder="${sessionScope.accountInfo.m_phone}" value="" />
										</div>
										<div class="form-group">
											<!-- <input type="password" class="form-control"  placeholder="비밀번호 확인" value="" /> -->
										</div>
										<!-- <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="male" checked>
                                                    <span> Male </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="female">
                                                    <span>Female </span> 
                                                </label>
                                            </div>
                                        </div> -->
									</div>
									<div class="col-md-6">
										<div class="form-group">
											비밀번호: <input class="form-control" name="pw" type='password'
												value="" />
										</div>
										<div class="form-group">
											이메일: <input class="form-control" name=email
												placeholder="${sessionScope.accountInfo.m_mail} " />
										</div>

										<div class="form-group">아이디 : ${sessionScope.accountInfo.m_id}</div>
										<div class="RegReg2">
											<button onclick="infoC()">정보 수정</button>
										</div>
									</div>
								</div>
						</form>
					</div>

				</div>
			</div>
		</div>

	</div>








</body>
</html>