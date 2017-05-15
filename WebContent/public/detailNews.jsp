<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/templates/public/inc/header.jsp" %>
    <div class="page-header">
        <div class="container">
        <%
        Post objNews = (Post)request.getAttribute("objNews");
        %>
        
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="page-caption">
                        <h2 class="page-title">TIN TỨC-SỰ KIỆN</h2>
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
                    <li class="active">Tin tức - Sự kiện</li>
                </ol>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                 <h1><%=objNews.getName()%></h1>
                 		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                 			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                 				
                       			<img style="width:200px; height:200px;" src="<%=request.getContextPath() %>/files/<%=objNews.getImage()%>">
                       			
                       		</div>
                       		<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                       			 <p class="lead"><%=objNews.getPreview() %> </p>
                       			
                       		</div>
                       	</div>
                     
                        <p><%=objNews.getDetail() %></p>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                  	  <!-- widget start -->
                                         <div class="widget widget-recent-post"><!-- widget recent post -->
                                             <h2 class="widget-title">Sản phẩm đánh giá cao nhất</h2>
                                             <ul class="listnone widget-recent-post">
                                              	<%
                               					ArrayList<Product> alPro = (ArrayList<Product>)request.getAttribute("alProduct"); 
                                				for(Product objProduct:alPro){
                                					String price = String.format("%,d",objProduct.getPrice());
                                				%>
                                                 <li>
                                                     <div class="row">
                                                         <div class="col-md-4">
                                                         	<%if(objProduct.getDiscount() != 0){ %>
                       										<div class="offer-tag" >
                                								<p class="off-price"><%=objProduct.getDiscount()%>% 0ff</p>
                            								</div>
                       										<%} %>
                                                             <div class="recent-post-img">
                                                                 <a href="#"><img style="width:100%; height:100px;" src="<%=request.getContextPath() %>/files/<%=objProduct.getImage()%>" alt=""></a>
                                                                 <div class="team-meta"><span class="team-designation" style="font-size:12px;"><%=price %> VNĐ</span></div>
                                                             </div>
                                                         </div>
                                                         <div class="col-md-8">
                                                             <div class="recent-post-content">
                                                                 <h4><a href="#" class="title"><%=objProduct.getName() %></a></h4>
                                                                 <div class="meta"><span class="meta-date"><%=objProduct.getPreview() %></span>
                                                                 </div>
                                                             </div>
                                                         </div>
                                                     </div>
                                                 </li>
                                                 <%} %>
                                             </ul>
                                         </div><!-- /.widget recent post -->

                </div>
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
