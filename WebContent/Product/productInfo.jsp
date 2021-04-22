<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function purchaseDirectly() {
	let ok = confirm('구매합니까?');
	if (ok) {
		
	let aa = $("#op option:selected").val();
	let a = $("#no").val();
	
	
	if (aa!=null) {
		location.href="PurchaseDirectlyC?p_no="+a+"&p_quantity="+aa;
	}
	}
}

</script>

<title>Insert title here</title>
</head>
<body>


		<div class="show_Wrap">
			<div class="show_inner1">
				<h2>${product.p_name }</h2>
				<div class="show_info">
				<h2>${product.p_info }</h2>
				</div>
				
				<div class="show_wrap2">
					<ul class="show_intro">
						<li>
							<div class="show_img">
								<img src="${product.p_img }">
							</div>
						</li>

						<!-- 상품가격 -->
						<li>
							<div class="show_img2">
								<div class="a1">
								<p>주의 사항</p>
								<div class="a2">
								<p>	세탁시 드라이클리닝 권장합니다.</p>
								<p class="tex_min">30도 이하의 미지근한 물에 울샴푸를 풀어 <br>부드럽게 줄러주며 가볍게 단독 손 세탁해주세요. </p>
								</div>
								</div>
								
								<div class="a1">
								<p>판매수량</p>
								<div class="a2">
								<p>1회 8개 구매가능</p>
								</div>
								</div>
								
								<div class="a3">
								<p>구매 후 취소</p>
								<div class="a2">
								<p>구매일로부터 10일 이내 취소 가능하며, <br>부분취소는 불가능합니다.</p>
								</div>
								</div>
								</div>
								
								<div class="price2">
								<div class="a6">
								<p>수량/ 금액</p>
								</div>
								
								<div class="a4">
								
								
								
								<form action="CartRegC" >
								
								<select id="op" name="c_p_quantity" style="margin-right: 20px">
		<c:forEach begin="1" end="8" var="q">
			<option value="${q }"> ${q }개
			
			</option>
			
		
		</c:forEach>
		
		
		<del>
		<input name="c_p_quantity" value="${q }" type="hidden">
		</del>
		</select>
								
								
								
								
					<input name="c_p_no" id="no" value="${product.p_no }" type="hidden">
					<input name="c_price" value="${product.p_price }" type="hidden">
					<input name="c_img" value="${product.p_img }" type="hidden">

					<input name="c_type" value="p" type="hidden">
					<div class="a7"> 
					<p><fmt:formatNumber value="${product.p_price }" type="currency" /></p>
					</div>
					<div class="a5" >
					<button class="b1">상품 담기</button>
					
					<button type="button" name="b"  class="b2" onclick="purchaseDirectly()">구매하기</button>
					
					
					</div>			
								
				</form>
								</div>
								</div>
								

								




						
							

						</li>
					</ul>
							</div>
</div>
				</div>
				
				


	
</body>
</html>