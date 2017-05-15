<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/templates/public/inc/header.jsp" %>
    <div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="page-caption">
                        <h2 class="page-title">GÓI TẬP KHẢ DỤNG</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="page-breadcrumb">
        <div class="container">
            <div class="col-lg-12">
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">Gói tập khả dụng</li>
                </ol>
            </div>
        </div>
    </div>
    <div class="content">
         
        <div class="container">
            <div class="row">
                <div class="col-md-offset-2 col-md-8">
                    <div class="mb60 text-center section-title">
                        <!-- section title start-->
                        <h1>Gói tập thể hình</h1>
                        <p>Các bước ghi danh phòng tập Gym Tài Nguyên Đà Nẵng</p>
                       	<div class="row form-group">
                       		<div class="col-xs-12">
                       			 <ul class="nav nav-pills nav-justified thumbnail setup-panel">
                       			 	 <li class="" style="background-color:#00AEEF;">
                       			 	 	<h4 class="list-group-item-heading" style="color:white; font-weight:bold;">Bước 1</h4>
                    					<p class="list-group-item-text" style="color:white;">Đăng ký tài khoản website</p>
                       			 	 </li>
                       			 	 <li class="" style="background-color:#0EB769;">
                       			 	 	<h4 class="list-group-item-heading"  style="color:white; font-weight:bold;">Bước 2</h4>
                       			 	 	<p class="list-group-item-text" style="color:white;">Chọn gói tập phù hợp</p>
                       			 	 </li>
                       			 	 <li class="" style="background-color:#E55B3E;">
                       			 	 	<h4 class="list-group-item-heading"  style="color:white; font-weight:bold;">Bước 3</h4>
                       			 	 	<p class="list-group-item-text" style="color:white;">Đến phòng tập ghi danh</p>
                       			 	 </li>
                       			 </ul>
                       		</div>
                       	</div>
                    </div>
                    <!-- /.section title start-->
                </div>
            </div>
            <div class="row">
               <%ArrayList<Training> alTraining = (ArrayList<Training>)request.getAttribute("alTraining"); 
              	for(Training objTraining:alTraining){
              		String price = String.format("%,d",objTraining.getPrice());
              %>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" style="margin-bottom:50px;">
           
                    <div class="service-block">
                        <!-- service block -->
                        <%if(objTraining.getDiscount() != 0){ %>
                       		<div class="offer-tag" >
                                <p class="off-price"><%=objTraining.getDiscount()%>% 0ff</p>
                            </div>
                       	<%} %>
                        <div class="service-img mb20">
                            <!-- service img -->
                            <a href="javascript:;"><img style="width:260px; height:230px;" src="<%=request.getContextPath() %>/files/<%=objTraining.getPicture()%>"></a>
                        </div>
                        <!-- service img -->
                        <div class="service-content">
                            <!-- service content -->
                            <h2><a href="javascript:;" class="title"><%=objTraining.getName() %></a></h2>
                             <div class="team-meta"><span class="team-designation" style="font-size:25px;"><%=price %> VNĐ</span></div>
                            <p><%=objTraining.getPreview() %></p>
                        </div>
                        <!-- service content -->
                    </div>
				
                    <!-- /.service block -->
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

</html>
