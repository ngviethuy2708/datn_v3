<%@page import="bean.Statictis"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/admin/inc/header.jsp" %>
	<div class="container">
		<div class="row review-index">
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading"><strong><div class="animated flash animation-delay-11">THỐNG KÊ DOANH THU</div></strong></div>
  					<div class="panel-body">
    					<div class="container">
    	
							<div class="col-md-3" style="margin-left: -9px;">
								<select id="year" name="sortMember" class="form-control" style="margin-left:24px; width: 350px;">
								<%
								ArrayList<Statictis> alYear = (ArrayList<Statictis>)request.getAttribute("alYear");
								for(Statictis year:alYear){
								%>
  									<option value="<%=year.getYear() %>">------------------------<%=year.getYear() %>----------------------</option>
  								<%} %>
								</select>
							</div>
							<div class= "col-md-3" style="margin-left: 91px;">
								<a href="javascript:void(0)"><input id="sortYear" class="button-add btn btn-danger create-button"
									name="submit" type="submit" value="SẮP XẾP" /></a>	
							</div>
    					</div>
  					</div>
  					 <div class="table-responsive" >
        				<table class="table table-bordered table-hover" style="margin-bottom: 52px; margin-top: 10px;">
        					<thead>
        						<tr>
        							<th style="width: 261px;">THÁNG</th>
        							<th>TỔNG TIỀN</th>
        						</tr>
        					</thead>
        					<tbody id="tbSortYear">
        						<%
        						ArrayList<Statictis> alSta = (ArrayList<Statictis>)request.getAttribute("alSta"); 
        						for(Statictis objSta:alSta){
        							String total = String.format("%,d", objSta.getTotal());
        						%>	<tr>
        							<td>THÁNG <%=objSta.getMonth() %></td>
        							<td><%=total %> VND</td>
        							</tr>
        						<%} %>
        					</tbody>
        				</table>
    				</div>
				</div>
			</div>
			<% 
			int totaluser = (Integer)request.getAttribute("totalUser");
			int totalMember = (Integer)request.getAttribute("totalMember");
			int totalPost = (Integer)request.getAttribute("totalPost");
			%>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading"><strong><div class="animated flash animation-delay-11">QUẢN TRỊ HỆ THỐNG</div></strong></div>
  					<div class="panel-body">
    					<ul>
    						<li style="display:inline-block;">
    						
    								<div class="panel panel-danger" style="WIDTH: 215px;">
    									<div class="panel-heading" style="background-color:#00AEEF;"><strong><div class="animated flash animation-delay-11" style="text-align:center; color:white;"><i class="fa fa-users" style="margin-right:5px; font-size:15px;"></i>HỘI VIÊN</div></strong></div>
    									<div class="panel-body" style="background-color:#787878;">
    										<span style="margin: 82px;; font-weight:bold; color:white;font-size: 50px;"><%=totalMember %></span>
    									</div>
    								</div>
    						</li>
    						<li style="display:inline-block;">
    								<div class="panel panel-danger" style="WIDTH: 215px;">
    									<div class="panel-heading" style="background-color:#00AEEF;"><strong><div class="animated flash animation-delay-11" style="text-align:center; color:white;"><i class="fa fa-user" style="margin-right:5px; font-size:15px;"></i>KHÁCH HÀNG</div></strong></div>
    									<div class="panel-body" style="background-color:#787878;">
    										<span style="margin: 82px;; font-weight:bold; color:white;font-size: 50px;"><%=totaluser%></span>
    									</div>
    								</div>
    						</li>
    						<li style="display:inline-block;">
    						
    								<div class="panel panel-danger" style="WIDTH: 215px;">
    									<div class="panel-heading" style="background-color:#00AEEF;"><strong><div class="animated flash animation-delay-11" style="text-align:center; color:white;"><i class="fa fa-newspaper-o" style="margin-right:5px; font-size:15px;"></i>BÀI ĐĂNG</div></strong></div>
    									<div class="panel-body" style="background-color:#787878;">
    										<span style="margin: 82px;; font-weight:bold; color:white;font-size: 50px;"><%=totalPost %></span>
    									</div>
    								</div>
    						</li>
    						<li style="display:inline-block;">
    						
    								<div class="panel panel-danger" style="WIDTH: 215px;">
    									<div class="panel-heading" style="background-color:#00AEEF;"><strong><div class="animated flash animation-delay-11" style="text-align:center; color:white;"><i class="fa fa-product-hunt" style="margin-right:5px; font-size:15px;"></i>SẢN PHẨM</div></strong></div>
    									<div class="panel-body" style="background-color:#787878;">
    										<span style="margin: 82px;; font-weight:bold; color:white;font-size: 50px;">0</span>
    									</div>
    								</div>
    						</li>
    					</ul>
  					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$('#sortYear').click(function(){
		var year = $('#year option:selected').val();
		$.ajax({
			type: 'POST',
			async: false,
			url:'<%=request.getContextPath() %>/admin/sortYear',
			data:{'year':year},
			success:function(response){
				$('#tbSortYear').html(response);
			}
		});
	});
</script>
</html>