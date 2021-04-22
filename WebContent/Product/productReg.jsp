<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="Css/product.css">
</head>
<body>


    <div class="container contact-form">
            <div class="contact-image">
          <!--   <img src="https://image.ibb.co/kUagtU/rocket_contact.png" alt="rocket_contact"/> -->    
            </div>
                    <form action="ProductRegC" method="post" enctype="multipart/form-data">
                <h3>상품 등록</h3>
               <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" name="name" class="form-control" placeholder="상품명 " value="" />
                        </div>
                        <div class="form-group">
                            <input type="text" name="price" class="form-control" placeholder="가격" value="" />
                        </div>
                        <div class="form-group">
                            <input type="text"  name ="quantity" class="form-control" placeholder="갯수" value="" />
                        </div>
                        <div class="form-group">
                            <input name="img" type="file" value="Send Message" />
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <textarea name="info" class="form-control" placeholder="상품 정보" style="width: 100%; height: 150px;"></textarea>
                        </div>
                        
                    </div>
                    <div class="RegReg">
<button>등록하기</button>
</div>
                </div>
            </form>
</div>



	
</body>
</html>