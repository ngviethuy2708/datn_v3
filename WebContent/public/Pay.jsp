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
				<div class="row main-section" style="height: 730px;">
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
							<div class="row main-section" style="height: 709px;">
								<div class="col-md-12">
									<p style="font-weight:bold; color:black;">Địa chỉ giao hàng </p>
												<div class="detail" style="    background: #F7F7F7;
												border: 1px solid #dddddd;
												padding: 8px;
												line-height: 20px;
												margin-top: 5px;
												">
													<p style="color:black"><span style="font-weight:bold; ">Họ và tên</span>: <%=objUsers.getFullName() %></p>
													<p  style="color:black"><span style="font-weight:bold;">Địa chỉ</span>: <%=objUsers.getAddDress() %></p>
													<p  style="color:black"><span style="font-weight:bold;">Số điện thoại</span>: <%=objUsers.getPhoneNumber() %></p>
												</div>
								</div>
								<form class="form-horizontal form_addRegister" role="form" method="post" action="<%=request.getContextPath()%>/pay2">
								<div class="col-md-12" style = "margin-top: 40px;">
									<p style="font-weight:bold; color:black;">Phương thức thanh toán </p>
												<div class="detail" style="    background: #F7F7F7;
												border: 1px solid #dddddd;
												padding: 8px;
												line-height: 20px;
												margin-top: 5px;
												">
													
														<%
														ArrayList<Payments> alPay = (ArrayList)request.getAttribute("alPayment"); 
														for(Payments objPay:alPay){
														%>
														<input type="radio" name="thanhtoan" value="<%=objPay.getIdPayments()%>"> <%=objPay.getNamePayMents() %> </br>
														<%} %>
													
												</div>
								</div>	
								<div class="col-md-12" style = "margin-top: 40px;">
									<p style="font-weight:bold; color:black;">Thông tin thêm </p>
												<div class="detail" style="    background: #F7F7F7;
												border: 1px solid #dddddd;
												padding: 8px;
												line-height: 20px;
												margin-top: 5px;
												">	
													
													<textarea style = "width: 680px;" name="thongtinthem"></textarea>
													
												</div>
								</div>
								<div class="col-md-12" style = "margin-top: 40px; margin-left:316px;">	
								
									
								<input  class="button-add btn btn-primary create-button" name="submit" type="submit" value="Xác nhận" />
								
								
								</div>
								</form>
							</div>
						</div>
						<!-- end section 1 -->
						
					</div>
					<%@include file="/templates/public/inc/rightbarProduct.jsp" %>
		<%@include file="/templates/public/inc/footer.jsp" %>