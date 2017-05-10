<%@page import="bean.Payments"%>
<%@page import="bean.News"%>
<%@page import="bean.Introduce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp" %>
	<!-- body -->
	<div class="main-content">
			<div class="container">
				<div class="row main-section" style="height: 900px;">
					<div class="col-md-8">
					<!-- section1 -->
						<div class="section">
						 	<div class="title-section">
						 		<div class="col-md-12">	
						 			<nav class="navbar navbar-inverse">
  										<p><span class="animated flash animation-delay-11">THÔNG TIN THANH TOÁN </span></p>
									</nav>
							
								</div>
							</div>
							<div class="row main-section" style="height: 870px;">
								<div class="col-md-12">
									<p style="font-weight:bold; color:black;">Đặt hàng đã được xử lý</p>
												<div class="detail" style="    background: #F7F7F7;
												border: 1px solid #dddddd;
												padding: 8px;
												line-height: 20px;
												margin-top: 5px;
												">
												<%String msg1 = (String)request.getAttribute("msg1"); %>
													<p style="color:red;"> <%=msg1 %></p>
												</div>
								</div>
								
								<div class="col-md-12" style = "margin-top: 40px; margin-left:316px;">	
								
									
								 <a href="<%=request.getContextPath()%>/endPay"><button  type="button" class="btn btn-primary">Tiếp tục</button></a>
								
								
								</div>
							</div>
						</div>
						<!-- end section 1 -->
						
					</div>
					<%@include file="/templates/public/inc/rightbarProduct.jsp" %>
		<%@include file="/templates/public/inc/footer.jsp" %>