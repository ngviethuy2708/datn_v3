<%@page import="bean.FitnessExcercises"%>
<%@page import="bean.FitnessCategory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/templates/public/inc/header.jsp" %>
    <div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="page-caption">
                        <h2 class="page-title">BÀI TẬP THỂ HÌNH</h2>
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
                    <li class="active">Bài tập thể hình</li>
                </ol>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                    <div class="row">
                    <%
                    ArrayList<FitnessExcercises> alEx = (ArrayList<FitnessExcercises>)request.getAttribute("alEx");
                    for(FitnessExcercises objEx : alEx){
                    %>
                        <div class="col-lg-12 col-sm-12 col-md-12 col-sm-12">
                            <div class="post-holder">
                                <!-- post holder -->
                                <div class="post-img">
                                    <!-- post img -->
                                    <a target="_blank" href="<%=request.getContextPath()%>/detailExcercises?id=<%=objEx.getId()%>"><img style="width:100%; height:200px;" src="<%=request.getContextPath() %>/files/<%=objEx.getImage() %>" alt="" class="img-responsive"></a>
                                    <div class="post-sticky"></div>
                                </div>
                                <!-- /.post img -->
                                <div class="post-content">
                                    <!-- post content -->
                                    <div class="post-header">
                                        <!-- post header -->
                                        <h1 class="post-title"><a href="blog-single.html" class="title"><%=objEx.getName() %></a></h1>
                                    </div>
                                    <!-- /.post header -->
                                    <p><%=objEx.getPreview() %></p>
                                    <a href="<%=request.getContextPath()%>/detailExcercises?id=<%=objEx.getId()%>" class="btn btn-default">Chi tiết</a>
                                </div>
                                <!-- /.post content -->
                            </div>
                            <!-- /.post holder -->
                        </div>
     				<%} %>
                    </div>
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
