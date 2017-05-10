<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/templates/public/inc/header.jsp" %>
    <div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="page-caption">
                        <h2 class="page-title">SẢN PHẨM CHỨC NĂNG</h2>
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
                    <li class="active">Sản phẩm</li>
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
                        <h1>DINH DƯỠNG THỂ HÌNH</h1>
                        <p>dinh dưỡng thể hình rất quan trọng trong tập Gym, nếu bạn muốn cơ bắp phát triển toàn diện nhanh nhất và rút ngắn thời gian tập luyện thì dinh dưỡng đóng vao trò then chốt. Chính vì vậy tập gym ngoài kĩ thuật chuẩn thì dinh dưỡng phù hợp là không thể thiếu.</p>
                    </div>
                    <!-- /.section title start-->
                </div>
            </div>
            <div class="row">
               <%ArrayList<Product> alPro = (ArrayList<Product>)request.getAttribute("alProduct"); 
              	for(Product objPro:alPro){
              		String price = String.format("%,d",objPro.getPrice());
              %>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" style="margin-bottom:50px;">
           
                    <div class="service-block">
                        <!-- service block -->
                        <%if(objPro.getDiscount() != 0){ %>
                       		<div class="offer-tag" >
                                <p class="off-price"><%=objPro.getDiscount()%>% 0ff</p>
                            </div>
                       	<%} %>
                        <div class="service-img mb20">
                            <!-- service img -->
                            <a href="<%=request.getContextPath()%>/detailProduct?id=<%=objPro.getId()%>"><img style="width:153px; height:200px;" src="<%=request.getContextPath() %>/files/<%=objPro.getImage()%>"></a>
                        </div>
                        <!-- service img -->
                        <div class="service-content">
                            <!-- service content -->
                            <h2><a href="<%=request.getContextPath()%>/detailProduct?id=<%=objPro.getId()%>" class="title"><%=objPro.getName() %></a></h2>
                             <div class="team-meta"><span class="team-designation" style="font-size:25px;"><%=price %> VNĐ</span></div>
                             <input id="star-rating-demo" value="4" type="number" productId = "<%=objPro.getId() %>" class="rating" min=0 max=5 step=0.1 data-size="lg">
                            <p><%=objPro.getPreview() %></p>
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
