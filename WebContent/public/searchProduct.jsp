<%@page import="bean.News"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp" %>
	<!-- body -->
	<div class="main-content">
			<div class="container">
				<div class="row main-section">
					<div class="col-md-8" style="margin-bottom:30px;">
					<!-- section1 -->
						<div class="section">
						 	<div class="title-section">
						 		<div class="col-md-12">	
						 			<nav class="navbar navbar-inverse">
  										<p><span class="animated flash animation-delay-11">Sản phẩm</span></p>
									</nav>
							
								</div>
							</div>

							<div class="row main-section">
							<%
							ArrayList<Product> alProduct = (ArrayList<Product>)request.getAttribute("alPro"); 
							for(Product objPro: alProduct){
							%>
								<div class="col-md-12">
									<div class="row detail-section-index">
										<div class="col-md-12">
											<a href="#" class=""><h4><%=objPro.getNameProduct()%></h4></a>
										</div>
										<div class="review">
											
										<div class="col-md-6">
											<div class="col-md-12">
												<img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objPro.getPicture()%>" width="250px" height ="200px">
											</div>
										</div>
										<div class="col-md-6">
											<p><%=objPro.getPreviewProduct()%></p>
											<div class="wraper">
												<a href="<%=request.getContextPath()%>/detailIntroduces?iid=<%=objPro.getIdProduct()%>"><button type="button" class="btn btn-info">Xem chi tiết</button></a>
											</div>
										</div>
										</div>
									</div>
								</div>
								<%} %>	
							</div>
						</div>
						<!-- end section 1 -->
						
					</div>
					<%@include file="/templates/public/inc/rightbarProduct.jsp" %>
		<%@include file="/templates/public/inc/footer.jsp" %>