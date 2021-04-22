function logout() {
	
	alert("로그아웃 되었습니다.");

	location.href="LogoutC";                                    // 로그아웃 페이지로 이동

}
function cart(a) {
	if (a!=null) {
		

		location.href="CartC";  

	}
	else {
		
		alert("로그인을 해주세요.");
	
		location.href="Login.jsp";
	}
}




function deleteReview(n,b) {
	let ok = confirm('삭제합니까?');
	//확인을 누르면 아래의 조건문이 실행됨.	
	if (ok) {

		location.href = "DeleteReviewC?r_no=" + n+"&mo_no=" + b
	}
}



function deleteCart(n) {
	let ok = confirm('삭제합니까?');
	//확인을 누르면 아래의 조건문이 실행됨.	
	if (ok) {

		location.href = "DeleteCartC?c_no=" + n
	}
}


