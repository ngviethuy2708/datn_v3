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
  										<p><span class="animated flash animation-delay-11">GIỎ HÀNG CỦA BẠN </span></p>
									</nav>
							
								</div>
							</div>
							<div class="row main-section" style="height: 709px;">
								<div class="col-md-12">
								<%
								ArrayList<Product> arPro = (ArrayList)request.getAttribute("alPro");
								if(arPro != null && arPro.size()>0){
								%>
								<form class="form-horizontal form_addRegister" role="form" method="post" action="<%=request.getContextPath()%>/editCart">
											<table class="table table-bordered table-hover">
												<thead>
													<tr>
														<th style="text-align:center;">Xóa</th>
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
														<td align="center"><input type="checkbox" name="maSanPham[]" value="<%=index%>"></td>
														<td align="center"><%=pro.getNameProduct() %></td>
														<td align="center"><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=pro.getPicture()%>" width="50px" height ="50px"></td>
														<td align="center"><input type="" name="soLuong[<%=pro.getIdProduct() %>]" value ="<%=pro.getNumber()%>"></td>
														<td align="center"><%=pro.getPriceProduct() %></td>
													</tr>
													<% index ++; %>
													<%tongTien += pro.getPriceBuy(); %>
												<%} %>
													<tr>
														<td colspan="4" style = "font-weight:bold;">Thành tiền</td>
														<td align="center"><%=tongTien %></td>
													</tr>
												</tbody>
											</table>
											<div>
													<input sytle="margin-right:416px;" class="button-add btn btn-danger create-button" name="submit" type="submit" value="Cập nhật" />
													<a href="<%=request.getContextPath()%>/pay"><button style="margin-left: 408px;" type="button" class="btn btn-primary">Thanh toán</button></a>
													<a href="<%=request.getContextPath()%>/indexProduct"><button type="button" class="btn btn-primary">Mua thêm</button></a>
												
											</div>	
										</form>
									<%}else{ %>
									<p style="font-weight:bold;">Giỏ hàng của bạn rỗng!</p>
									<%} %>						
								</div>
							
									
							</div>
						</div>
						<!-- end section 1 -->
						
					</div>
					<%@include file="/templates/public/inc/rightbarProduct.jsp" %>
		<%@include file="/templates/public/inc/footer.jsp" %>