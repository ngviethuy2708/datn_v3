<%@page import="bean.News"%>
<%@page import="bean.Introduce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp" %>
	<!-- body -->
	<div class="main-content">
			<div class="container">
				<div class="row main-section">
					<div class="col-md-8">
					<!-- section1 -->
						<div class="section">
						 	<div class="title-section">
						 		<div class="col-md-12">	
						 			<nav class="navbar navbar-inverse">
  										<p><span class="animated flash animation-delay-11">GIỚI THIỆU PHÒNG GYM</span></p>
									</nav>
							
								</div>
							</div>
							<div class="row main-section">
							<%
							ArrayList<Introduce> alIntro = (ArrayList<Introduce>)request.getAttribute("alIntro"); 
							for(Introduce objIntro: alIntro){
							%>
								<div class="col-md-12">
									<div class="row detail-section-index">
										<div class="col-md-12">
											<a href="#" class=""><h4><%=objIntro.getNameIntroduce() %></h4></a>
										</div>
										<div class="review">
											
										<div class="col-md-6">
											<div class="col-md-12">
												<img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objIntro.getPicture()%>" width="300px" height ="200px">
											</div>
										</div>
										<div class="col-md-6">
											<p><%=objIntro.getPreviewIntroduce()%></p>
											<div class="wraper">
												<a href="<%=request.getContextPath()%>/detailIntroduces?iid=<%=objIntro.getIdIntroduce()%>"><button type="button" class="btn btn-info">Xem chi tiết</button></a>
											</div>
										</div>
										</div>
									</div>
								</div>
								<%} %>
								<div class="pagi">
					<ul class="pagination">
					<%
					String active="";
					int curentPage = (Integer)request.getAttribute("page");
					int soTrang = (Integer)request.getAttribute("soTrang");
					for(int i=1;i<=soTrang;i++){
						if(curentPage==i){
							active = "class=\"active\"";
						}else{
							active ="";
						}
					%>
  						<li <%=active %>><a href="<%=request.getContextPath() %>/indexIntroduce?page=<%=i%>"><%=i %></a></li>
  					<%} %>
					</ul>
				</div>		
							</div>
						</div>
						<!-- end section 1 -->
						
					</div>
					<%@include file="/templates/public/inc/rightbar.jsp" %>
		<%@include file="/templates/public/inc/footer.jsp" %>