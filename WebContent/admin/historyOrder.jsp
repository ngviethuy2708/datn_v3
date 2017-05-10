<%@page import="bean.HistoryOrder"%>
<%@page import="bean.Product"%>
<%@page import="java.util.Date"%>
<%@page import="bean.Training"%>
<%@page import="library.TimeConvert"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<style>
button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 1px 7px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}
#edit {
    background-color: white; 
    color: black; 
    border: 2px solid #008CBA;
}

#edit:hover {
    background-color: #008CBA;
    color: white;
}
#banhang {
    background-color: white; 
    color: black; 
    border: 2px solid #f44336;
}

#banhang:hover {
    background-color: #f44336;
    color: white;
}
#add {
    background-color: white; 
    color: black; 
    border: 2px solid green;
}

#add:hover {
    background-color: green;
    color: white;
}
th {
	text-align:center;
}
td {
	text-align:center;
}
</style>
	<!-- body -->
	<style>
		th{
		text-align:center;
		}
	</style>
	<div class="container">
		<div class="row">
			<!-- main -->
			<div class="col-md-12 main">
				<div class="search-form">
					<div class="col-md-2">
						<p>
							<a href="<%=request.getContextPath()%>/admin/indexProduct" class="btn btn-success create-button" style="margin-left: -13px;">Quay lại</a>
		        		</p>
		    		</div>
		    		<!--search form  -->
		    		<div class="col-md-10">
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchTraining" method="post">
  							<div class="form-group" style="margin-left:635px;">
    							<input name="something" type="text" class="form-control" id="exampleInputPassword2" placeholder="keyword">
  							</div>
  							<input class="button-add btn btn-primary create-button" name="submit" type="submit" value="Tìm kiếm" /> 
						</form>
		    		</div>
		    	</div>
		    	
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th style="width:10px;">ID</th>
							<th style="width: 125px;">NGÀY BÁN</th>
							<th style="width: 125px;">TÊN SẢN PHẨM</th>
							<th style="width: 120px;">SỐ LƯỢNG BÁN</th>
							<th style="width: 96px;">TỔNG TIỀN</th>
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<HistoryOrder> alHitory = (ArrayList<HistoryOrder>)request.getAttribute("alHistory");
					for(HistoryOrder objH:alHitory){
						String price = String.format("%,d",objH.getTotalPrice());
					%>
						<tr>
							<td><%=objH.getId() %></td>
							<td><%=TimeConvert.getStringDatetime(objH.getDateOrder())%></td>
							<td><%=objH.getNameProduct() %></td>
							<td style="width: 168px;"><%=objH.getNumOfProduct()%></td>
							<td style="text-align:center;"><%=price%> VNĐ</td> 
						</tr>
					<%} %>

					</tbody>
				</table>
			</div>
			<!-- end main -->
		</div>
		
	</div>
</html>
