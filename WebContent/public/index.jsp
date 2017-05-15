<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/templates/public/inc/header.jsp" %>
    <section id="slider">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="<%=request.getContextPath() %>/templates/public/images/daidien1.jpg" alt="Chania">
                </div>

                <div class="item">
                    <img src="<%=request.getContextPath() %>/templates/public/images/daidien2.jpg" alt="Chania">
                </div>

                <div class="item">
                    <img src="<%=request.getContextPath() %>/templates/public/images/daidien3.jpg" alt="Flower">
                </div>
            </div>
			 <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                 <span class="sr-only">Next</span>
            </a>
        </div>
    </section>
    <div class="space-medium">
        <div class="container">
            <div class="row">
                <div class="col-md-offset-2 col-md-8">
                    <div class="mb60 text-center section-title">
                        <!-- section title start-->
                        <h5>CLB ĐÀ NẴNG</h5> 
                        <h1>GIỚI THIỆU CÂU LẠC BỘ TẠI THÀNH PHỐ ĐÀ NẴNG</h1>
                        <p>Từ năm 2030 và tầm nhìn đến năm 2050, Đà Nẵng được chủ trương phát triển thành thành phố cấp quốc gia, hiện đại; là đô thị trung tâm góp phần thúc đẩy phát triển kinh tế-xã hội vùng miền Trung và Tây Nguyên. Trên tinh thần đó, phòng tập gym Tài Nguyên Đà Nẵng đã đánh dấu sự xuất hiện của mình từ đầu năm 2015 bằng buổi lễ ra mắt ấn tượng.</p> 
                    </div>
                    <!-- /.section title start-->
                </div>
            </div>
            <div class="row">
    			<%
    			ArrayList<Post> alPost = (ArrayList<Post>)request.getAttribute("alIntro");
    			for(Post objPost:alPost){
    			%>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                    <div class="service-block">
                        <!-- service block -->
                        <div class="service-img mb20">
                            <!-- service img -->
                            <a href="<%=request.getContextPath()%>/detailIntroduce?id=<%=objPost.getId() %>"><img src="<%=request.getContextPath() %>/files/<%=objPost.getImage() %>" alt="" class="img-responsive" style="height:200px;"></a>
                        </div>
                        <!-- service img -->
                        <div class="service-content">
                            <!-- service content -->
                            <h2><a href="<%=request.getContextPath()%>/detailIntroduce?id=<%=objPost.getId() %>" class="title"><%=objPost.getName() %></a></h2>
                            <p><%=objPost.getPreview() %></p>
                        </div>
                        <!-- service content -->
                    </div>
                    <!-- /.service block -->
                </div>
                <%} %>
            </div>
        </div>
    </div>
    <div class="space-small bg-primary">
        <!-- call to action -->
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-sm-8 col-md-8 col-xs-12">
                    <h1 class="cta-title">Chọn loại Thẻ Hội Viên phù hợp</h1>
                    <p class="cta-text">Chúng tôi cung cấp nhiều loại Thẻ Hội Viên cho bạn lựa chọn để sử dụng các dịch vụ, nhận tư vấn thể chất chuyên sâu, bao gồm đo chỉ số cơ thể Inbody.

                    </p>
                </div>
                <div class="col-lg-4 col-sm-4 col-md-4 col-xs-12">
                    <a href="<%=request.getContextPath() %>/indexTraining" class="btn btn-white btn-lg mt20">Tham khảo các gói tập tại đây</a>
                </div>
            </div>
        </div>
    </div>
    <!-- /.call to action -->
    <div class="space-medium">
        <div class="container">
            <div class="row">
                <div class="col-lg-offset-2 col-lg-8 col-md-offset-2 col-md-8 col-sm-12 col-xs-12">
                    <div class="section-title mb60 text-center">
                        <!-- section title start-->
                        <h1>SẢN PHẨM ĐƯỢC ĐÁNH GIÁ CAO NHẤT</h1>
                        <p>Những sản phẩm chức năng hiệu quả giúp bạn sớm thực hiện được ước mơ</p> 
                    </div>
                    <!-- /.section title end-->
                </div>
            </div>
            <div class="row">
            	<%
            		ArrayList<Product> alPro = (ArrayList<Product>)request.getAttribute("alProduct");
                    for(Product objPro:alPro){
                    	String price = String.format("%,d",objPro.getPrice());
                 %>
                <div class="col-lg-3 col-sm-3 col-sm-6 col-xs-12">
                    <div class="team-block">
                        <!-- team block start-->
                       	<%if(objPro.getDiscount() != 0){ %>
                       		<div class="offer-tag" style="margin-left:50px;">
                                <p class="off-price"><%=objPro.getDiscount()%>% 0ff</p>
                            </div>
                       	<%} %>
                        <div class="team-img" style="text-align:center;"><a href="<%=request.getContextPath()%>/detailProduct?id=<%=objPro.getId()%>"><img style="width:153px; height:200px;" src="<%=request.getContextPath() %>/files/<%=objPro.getImage()%>"></a></div>
                        <div class="team-content">
                            <h2 class="team-title"><a href="<%=request.getContextPath()%>/detailProduct?id=<%=objPro.getId()%>"><%=objPro.getName() %></a></h2>
                            <input id="star-rating-demo" value="<%=objPro.getTbc() %>" type="number" productId = "<%=objPro.getId() %>" class="rating" min=0 max=5 step=0.1 data-size="lg">
                            <p><%=objPro.getPreview() %></p>
                            <div class="team-meta"><span class="team-designation" style="font-size:25px;"><%=price %> VNĐ</span></div>
                        </div>
                    </div>
                    <!-- team block end -->
                </div>
               <%} %>
            </div>
        </div>
    </div>
    <div class="space-medium bg-default" style="background-image:url('<%=request.getContextPath()%>/templates/public/images/dongluc.jpg');background-size:100%;">
        <div class="container">
            <div class="row">
                <div class="col-lg-offset-2 col-lg-8 col-md-offset-2 col-md-8 col-sm-12 col-xs-12">
                    <div class="section-title mb60 text-center">
                        <!-- section title start-->
                        <h1 style="color:white;">Anh em đang mệt mỏi, chán nản với việc tập luyện? Anh em cần một động lực nhấc mông khỏi giường và đến phòng gym ngay hôm nay? </h1>
                    </div>
                    <!-- /.section title start-->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="testimonial-block">
                        <!-- testimonial block -->
                        <div class="testimonial-content">
                            <p class="testimonial-text" style="color:white;">“Luôn trân trọng, và đừng bao giờ đánh giá thấp sức mạnh từ bên trong chúng ta.”</p>
                        </div>
                        <div class="testimonial-info">
                            <h4 class="testimonial-name" style="color:white;">Noah Galloway</h4>
                            <span class="testimonial-meta" style="color:white;">Cựu binh quân đội Mỹ, người đàn ông phi thường nhất 2014 do tạp chí Men's health bình chọn.</span>
                        </div>
                    </div>
                    <!--/. testimonial block -->
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="testimonial-block">
                        <!-- testimonial block -->
                        <div class="testimonial-content">
                            <p class="testimonial-text" style="color:white;">“Khi bạn có tầm nhìn rỏ ràng về mục tiêu của mình, bạn sẽ dễ dàng bước những bước đầu tiên.”</p>
                        </div>
                        <div class="testimonial-info">
                            <h4 class="testimonial-name" style="color:white;">Rose Jacq</h4>
                            <span class="testimonial-meta" style="color:white;">8 lần vô địch Mr.Olympia</span>
                        </div>
                    </div>
                    <!--/. testimonial block -->
                </div>
            </div>
        </div>
    </div>
    <div class="space-medium">
        <div class="container">
            <div class="row">
                <div class="col-lg-offset-2 col-lg-8 col-md-offset-2 col-md-8 col-sm-12 col-xs-12">
                    <div class="section-title mb40 text-center">
                        <h1>CÁC GÓI ĐĂNG KÝ HỘI VIÊN KHẢ DỤNG</h1>
                        <p>Hiện nay các gói đăng ký hội viên đang khả dụng tại phòng tập,hãy đến đăng ký tham gia để rèn luyện sức khỏe cùng chúng tôi</p> 
                    </div>
                    <!-- /.section title start-->
                </div>
            </div>
            <div class="row">
           	<%
           	ArrayList<Training> alTraining = (ArrayList<Training>)request.getAttribute("alTraining"); 
           	for(Training objTraining: alTraining){
           		String price = String.format("%,d",objTraining.getPrice());
           	%>
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                    <div class="post-block">
                     	<%if(objTraining.getDiscount() != 0){ %>
                       		<div class="offer-tag" >
                                <p class="off-price"><%=objTraining.getDiscount()%>% 0ff</p>
                            </div>
                       	<%} %>
                        <!-- post block -->
                        <div class="post-img">
                            <a href="#"><img style="width:360px; height:204px; " src="<%=request.getContextPath() %>/files/<%=objTraining.getPicture()%>" alt="" class="img-responsive"></a>
                        </div>
                        <div class="post-content">
                            <h2><a href="#" class="title"><%=objTraining.getName() %></a></h2>
                            <p class="meta"> <span class="meta-date" style="color:#0eb769; font-size:20px;"> <%=price %> VNĐ</span>  </p>
                            <p><%=objTraining.getPreview() %></p>
                        </div>
                    </div>
                    <!-- /.post block -->
                </div>
        	<%} %>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="container ">
                <p>Copyright © 2016 - 2017 Thể hình - Tập thể hình - Thể hình đẹp - Phương pháp tập thể hình nam, nữ - Thể lực</p>
                <p>CODE BY: Nguyễn Viết Huy</p>
            </div>
        </div>

</body>
<script>

$('.rating').on('change', function () {
	var productId = $(this).attr('productId');
	var rate = $(this).val();
	console.log(productId);
	console.log(rate);
	$.ajax({
		type: 'GET',
		url: '<%=request.getContextPath()%>/rateProduct',
		data: {'productId': productId, 'rate': rate },
		success: function(response) {
			if(response == "error"){
				$('#login').modal('show'); 
			}else{
				$('#login').modal('hide');
				swal("", "Cảm ơn bạn đã ủng hộ sản phẩm của chúng tôi!", "success");
			}
		}
	});
});

</script>
</html>
