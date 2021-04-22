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
 <link rel="stylesheet" href="Css/join.css">
</head>

<script type="text/javascript">
	// 빈칸 없이 
	function isEmpty(input) {
		return !input.value;
	}
	
	//한글 입력 불가능 하게 
	function noHG(input) { 
		var ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@_."
		for (let i = 0; i < input.value.length; i++) {
			if (ok.indexOf(input.value[i]) == -1) {
				// ok.indexOf를 사용하여 input.value[i] 가 ok안에 몇번째 위치에 있는지 찾아낸다 
				// -1 은 배열에 해당되지 않는 번호기 때문에 false를 반환한다. 
				return true;
			}
		}
	}
	// 한글만 입력 
	function noEng(input) {
		var ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@_."
		for (let i = 0; i < input.value.length; i++) {
			if (ok.indexOf(input.value[i]) !== -1) {
				return true;
			}
		}
	}
	//비번 일치 불일치 검사
	function same(input, input2) {
		return input.value != input2.value;
	}
	//숫자만 입력
	function isNotNum(input) {
		return isNaN(input.value);
	}
</script>

<script type="text/javascript">
	function Check() {
		let idCInput = document.getElementById('idC'); // id가 idC를 찾아간다. 
		let pwCInput = document.getElementById('pwC');
		let nameCInput = document.getElementById('nameC');
		let phoneCInput = document.getElementById('phone');
		let eMailCInput = document.getElementById('eMailC');

		if (isEmpty(idCInput) || noHG(idCInput)) {
			alert('아이디를 입력해주세요.');
			idCinput.focus();
			return false;
		}
		
		if (isEmpty(pwCInput)) {
			alert('패스워드를 입력해주세요.');
			pwCInput.focus();
			return false;
		}

		if (isEmpty(nameCInput) || noEng(nameCInput)) {
			alert('이름를 입력해주세요.');
			nameCInput.focus();
			return false;
		}
		
		if (isEmpty(phoneCInput) || isNotNum(phoneCInput)) {
			alert('번호를 입력해주세요.');
			phone2CInput.focus();
			return false;
		}
	
		
		if (isEmpty(eMailCInput) || noHG(eMailCInput)) {
			alert('이메일을 입력해주세요.');
			eMailCInput.focus();
			return false;
		}

		return true;
	}
</script>
<body>
	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
				<h3>Welcome</h3>
				<p>
					회원 가입을 통해 <br>간편하게 예매해요 !<br> 가입 시 나쵸 무료 증정 <br>혜택이
					있답니다!
				</p>

			</div>

			<div class="col-md-9 register-right">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading">회원 가입</h3>
						<form action="JoinRegC">
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" name="id" id="idC" pattern="^[a-zA-Z]*$"
											placeholder="아이디" value="" />
									</div>
									<div class="form-group">
										<input type="password" class="form-control" name="pw"  id="pwC"
											placeholder="비밀번호" value="" />
									</div> <span class ="noId">${r }</span>
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
										<input class="form-control" name="name" id="nameC"   pattern="^[가-힣]*$"
											placeholder="이름" value="" />
									</div>
									<div class="form-group">
										<input name="phone" id="phone" maxlength="11"    pattern= "^[0-9]*$"
											placeholder="전화번호" class="form-control" value="" />
									</div>

									<div class="form-group">
										<input class="form-control" name="eMail" id="eMailC"  pattern="^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$"
											placeholder="이메일 주소 " />
									</div>
									<div class="RegReg2">
									
										<button onclick="return Check();">회원 가입</button>
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