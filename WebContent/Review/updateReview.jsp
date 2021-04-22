<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%--  --%><link rel="stylesheet" href="Css/review.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
        crossorigin="anonymous">
        
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script> 
<script>
	$(function() {

		$('#star_grade a').click(function() {
			$(this).parent().children("a").removeClass("on"); /* 별점의 on 클래스 전부 제거 */
			$(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
			
			//alert($(this).attr("v"));
			//alert($("#asdasd").val());
			
			document.f.r_rating.value=$(this).attr("v");
			document.f.plot.value=$("#asdasd").val();
			document.f.mo_no.value=$("#m1").val();
			document.f.r_no.value=$("#r1").val();
			
			return false;
		});
	});
</script>
<style>
#star_grade a {
	text-decoration: none;
	color: gray;
}

#star_grade a.on {
	color: red;
}
</style>
</head>
<body>
<div class="bootss">
<nav class="navbar navbar-light bgwhite">
    <a href="#" >${list.mo_name }</a>
   
</nav>


<div class="container-fluid gedf-wrapper">
    <div class="row">
        <div class="col-md-3">
            <div class="card">
                <div class="card-body">  
                    <div class="h51">@${list.m_id }</div>
                    <div class="h7 text-muted">Fullname : ${list. m_name }</div>
                    <div class="h7">${list. m_name }님 ${list.mo_name } 재미있게 보셨나요? <br>
                    영화의 어떤 점이 좋았는지 이야기해주세요.
관람일 기준 7일 이내 등록 시 50P 가 적립됩니다.<br>
포인트는 관람평 최대 10편 지급가능합니다.
                    </div>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <div class="h61 text-muted">예매율</div>
                        <div class="h51">2위</div>
                    </li>
                    <li class="list-group-item">
                        <div class="h61 text-muted">실관람 평점</div>
                        <div class="h51">${list.mo_rating }</div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-md-6 gedf-main">



			
		<input type="hidden" name="mo_no" value="${mo_no }" id="m1"> 
			<input type="hidden" name="r_no" value="${r_no}" id="r1" >
	
	
            <!--- \\\\\\\Post-->
           <form action="UpdateReviewC" method="post" name="f" accept-charset="utf-8">
            <div class="card gedf-card">
                <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="posts-tab" data-toggle="tab" href="#posts" role="tab" aria-controls="posts" aria-selected="true">실관람평 </a>
                       </li>
                       <li>
                       <p id="star_grade">
		<a href="#" v="1">★</a>
		<a href="#" v="2">★</a>
		<a href="#" v="3">★</a>
		<a href="#" v="4">★</a>
		<a href="#" v="5">★</a>
		<input type="hidden" name="r_rating" value="3">
	</p>
	<input type="hidden" name="mo_no" value="${mo_no }">
	<input type="hidden" name="r_no" value="${r_no}" id="r1" >
                       
                       
                        </li>
                        
                    </ul>
                </div>
                <div class="card-body">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="posts" role="tabpanel" aria-labelledby="posts-tab">
                            <div class="form-group">
                                <label class="sr-only" for="message">post</label>
                                <textarea name ="plot" class="form-control" id="asdasd" rows="3" placeholder="후기를 수정해 주세요 ."></textarea>
                            </div>
                            
                        </div>
                       <!--   <div class="tab-pane fade" id="images" role="tabpanel" aria-labelledby="images-tab">
                         <div class="form-group">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="customFile">
                                    <label class="custom-file-label" for="customFile">Upload image</label>
                                </div>
                            </div>
                            <div class="py-4"></div>
                        </div>-->
                    </div>
                    <div class="btn-toolbar justify-content-between">
                    

                    
                    
                        <div class="btn-group">
                            <button type="submit" class="btn btn-primary1">수정하기</button>
                    <!-- 영화 사진, 이름, 줄거리 , 장르, 평점표시(include하는 것도 생각) -->

	
                        </div>
                        <div class="btn-group">
                            <button id="btnGroupDrop1" type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                                <i class="fa fa-globe"></i>
                            </button>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="btnGroupDrop1">
                                <a class="dropdown-item" href="#"><i class="fa fa-globe"></i> Public</a>
                                <a class="dropdown-item" href="#"><i class="fa fa-users"></i> Friends</a>
                                <a class="dropdown-item" href="#"><i class="fa fa-user"></i> Just me</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            	</form>

            <!--- \\\\\\\Post2---- 
           ] <!--  </c:forEach> -->
            </div>
            </div>
            </div>

</div>




                          




	
</body>
</html>