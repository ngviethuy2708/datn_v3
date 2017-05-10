<%@page import="bean.Bill"%>
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
  										<p><span class="animated f    lash animation-delay-11">THÔNG TIN THANH TOÁN </span></p>
									</nav>
							
								</div>
							</div>
							<div class="row main-section" style="height: 870px;">
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
								<%
									float tongtien1 = 0;
									Bill bill1 = (Bill)session.getAttribute("objBill");
									ArrayList<Product> listPro1 =(ArrayList<Product>) session.getAttribute("alCart");
									for(Product p1 :listPro1){
										tongtien1 += (float)p1.getPriceBuy();
									}
								%>
								<form class="form-horizontal form_addRegister" role="form" method="post" action="<%if(bill1.getIdPayment() == 6){  %>https://www.nganluong.vn/button_payment.php?receiver=kuwin9zz@gmail.com&product_name=MHD-<%=bill1.getIdBill() +1 %>&price=<%=tongtien1 %>&return_url=http://sontx.no-ip.org:8080/Gym/index<% }else{out.print(request.getContextPath()+"/pay4");} %> ">
								
								<div class="col-md-12" style = "margin-top: 40px;"> 
									<%
								ArrayList<Product> arPro = (ArrayList)request.getAttribute("alPro");
								if(arPro != null && arPro.size()>0){
								%>
								<p style="font-weight:bold; color:black;">Sản phẩm mua </p>
											<table class="table table-bordered table-hover">
												<thead>
													<tr>
														<th style="text-align:center;">Sản phẩm</th>
														<th style="text-align:center;">Hình ảnh</th>
														<th style="text-align:center;">Số lượng</th>
														<th style="text-align:center;">Giá</th>
													</tr>
												</thead>
												<tbody>
												<%
												int tongTien = 0;
												int index = 0;
												for(Product pro: arPro){
												%>
													<tr>
														<td align="center"><%=pro.getNameProduct() %></td>
														<td align="center"><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=pro.getPicture()%>" width="50px" height ="50px"></td>
														<td align="center"><%=pro.getNumber() %></td>
														<td align="center"><%=pro.getPriceProduct() %></td>
													</tr>
													<% index ++; %>
													<%tongTien += pro.getPriceBuy(); %>
												<%} %>
													<tr>
														<td colspan="3" style = "font-weight:bold;">Tổng tiền</td>
														<td align="center"><%=tongTien %></td>
													</tr>
												</tbody>
											</table>
											
									<%} %>				
								</div>	
								<div class="col-md-12" style = "margin-top: 40px;">
									<p style="font-weight:bold; color:black;">Phương thức thanh toán</p>
												<div class="detail" style="    background: #F7F7F7;
												border: 1px solid #dddddd;
												padding: 8px;
												line-height: 20px;
												margin-top: 5px;
												">	
													<%Payments objPayment = (Payments)request.getAttribute("objPayment"); %>
													<%=objPayment.getDetail() %>
													
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