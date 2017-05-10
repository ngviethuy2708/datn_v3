<%@page import="model.modelProduct"%>
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
				<div class="search-form" style="margin-bottom:100px;">
					<div class="col-md-2">
						<p>
							<a href="<%=request.getContextPath()%>/admin/historyOrder2" class="btn btn-success create-button" style="margin-left: -13px;">Quay lại</a>
		        		</p>
		    		</div>
		    	</div>
		    	
				<div class="table-main">
					<%-- <table class="table table-bordered table-hover">
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
				</table> --%>
				<%
				
				ArrayList<HistoryOrder> alOrder = (ArrayList<HistoryOrder>)request.getAttribute("alOrder");
				for(HistoryOrder objOrder : alOrder){
				%>
				 <div class="panel panel-default">
                     <div class="panel-heading"  id="headingOne" onclick="showOrder(this)">
                     	 <div class="row">
                     	 	<div class="col-xs-6 col-md-11">
                     	 		  <h4 class="panel-title">
                     	 		   <a href="javascript:;" id="collapseOne">
                     	 		   		<p style="font-weight:bold;">Hóa đơn ngày <%=TimeConvert.getStringDatetime(objOrder.getDateOrder()) %></p>
                     	 		   </a>
                     	 	</div>
                     	 	<div class="col-xs-6 col-md-1">
                                 <i class="fa fa-download" aria-hidden="true"></i>
                            </div>
                     	 </div> 	
                     </div>
                      <div id="divCollapseOne" class="panel-collapse collapse ">
                      		<div class="panel-body">
                      			<div style="width:100%;background:#FFFFFF;float:left; padding:20px;">
                      				<div style="float:left; width:100%; margin-right:3%; margin-top:10px; font-size:14px; font-weight:normal; line-height:28px;  font-family:Arial, Helvetica, sans-serif; color:#000; overflow:hidden;">
                      					 <table width="100%" border="0" cellpadding="0" cellspacing="0">
                      					 	  <tbody>
                      					 	  		<tr>
                      					 	  			 <td colspan="3">
                      					 	  			 	   <table width="100%" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #cecece; width:99.5%;">
                      					 	  			 	   		 <tbody>
                      					 	  			 	   		 		<tr bgcolor="#f3f3f3">
                      					 	  			 	   		 			 <td width="17%" style="border-right:1px solid #cecece; text-align:center;">
                      					 	  			 	   		 			 	<span style="font-size:12px; font-family:Arial, Helvetica, sans-serif; font-weight:bold; color:#000000; line-height:38px; text-align:center;">
                      					 	  			 	   		 			 		Hình ảnh
                      					 	  			 	   		 			 	</span>
                      					 	  			 	   		 			 </td>
                      					 	  			 	   		 			 <td width="30%" style="border-right:1px solid #cecece;text-align:center;">
                      					 	  			 	   		 			   	<span style="font-size:12px; font-family:Arial, Helvetica, sans-serif; font-weight:bold; color:#000000; line-height:38px; text-align:center;">
                      					 	  			 	   		 			   		Tên sản phẩm
                      					 	  			 	   		 			   	</span>
                      					 	  			 	   		 			 </td>
                      					 	  			 	   		 			 <td width="12%" style="border-right:1px solid #cecece;text-align:center;">
                      					 	  			 	   		 			 	<span style="font-size:12px; font-family:Arial, Helvetica, sans-serif; font-weight:bold; color:#000000; line-height:38px; text-align:center;">
                      					 	  			 	   		 			 		Số lượng bán
                      					 	  			 	   		 			 	</span>
                      					 	  			 	   		 			 </td>
                      					 	  			 	   		 			 <td width="14%" style="border-right:1px solid #cecece;text-align:center;">
                      					 	  			 	   		 			 	<span style="font-size:12px; font-family:Arial, Helvetica, sans-serif; font-weight:bold; color:#000000; line-height:38px; text-align:center;">
                      					 	  			 	   		 			 		Giá sản phẩm
                      					 	  			 	   		 			 	</span>
                      					 	  			 	   		 			 </td>
                      					 	  			 	   		 			 <td width="14%" style="border-right:1px solid #cecece;text-align:center;">
                      					 	  			 	   		 			 	<span style="font-size:12px; font-family:Arial, Helvetica, sans-serif; font-weight:bold; color:#000000; line-height:38px; text-align:center;">
                      					 	  			 	   		 			 		Giảm giá
                      					 	  			 	   		 			 	</span>
                      					 	  			 	   		 			 </td>	
                      					 	  			 	   		 			 <td width="15%" style="text-align:center;">
                      					 	  			 	   		 			 	<span style="font-size:12px; font-family:Arial, Helvetica, sans-serif; font-weight:bold; color:#000000; line-height:38px; text-align:center;">
                      					 	  			 	   		 			 		Tổng tiền
                      					 	  			 	   		 			 	</span>
                      					 	  			 	   		 			 </td> 
                      					 	  			 	   		 		</tr>
                      					 	  			 	   		 		<%
                      														modelProduct mProduct = new modelProduct();
									                      					ArrayList<Product> alPro = mProduct.getLisProductInOrder(objOrder.getDateOrder());
									                      					for(Product objPro:alPro){
									                      						if(objPro.getSale_id() != 0){
									                      							int curentPrice = mProduct.getPriceOfSale(objPro.getId());
									                      							objPro.setPrice(curentPrice);
									                      							int discount = mProduct.getDiscount(objPro.getId());
									                      							objPro.setDiscount(discount);
									                      						}else{
									                      							int curentPrice = mProduct.getPrice(objPro.getId());
									                      							objPro.setPrice(curentPrice);
									                      							objPro.setDiscount(0);
									                      						}
                      														%>
                      														 <tr>
                      														 	 <td style="border-right:1px solid #cecece; text-align:center;border-top:1px solid #cecece;padding:5px;">
                      														 	 	<span style="font-size:13px; font-family:Arial, Helvetica, sans-serif; font-weight:normal; color:#000000; line-height:30px;  text-align:center;">
                      														 	 		<img src="<%=request.getContextPath() %>/files/<%=objPro.getImage() %>" alt="<%=objPro.getName() %>" width="70">
                      														 	 	</span>
                      														 	 </td>
                      														 	 <td style="border-right:1px solid #cecece;text-align:center;border-top:1px solid #cecece;">
                      														 	 	<span style="font-size:13px; font-family:Arial, Helvetica, sans-serif; font-weight:normal; color:#000000; line-height:30px;  text-align:center;text-transform: capitalize;">
                      														 	 		<%=objPro.getName() %>
                      														 	 	</span>
                      														 	 </td>
                      														 	  <td style="border-right:1px solid #cecece;text-align:center;border-top:1px solid #cecece;">
                      														 	  	<span style="font-size:13px; font-family:Arial, Helvetica, sans-serif; font-weight:normal; color:#000000; line-height:30px;  text-align:center;">
                      														 	  		<%=objPro.getNumOfProduct() %> bình
                      														 	  	</span>
                      														 	  </td>
                      														 	  <td style="border-right:1px solid #cecece;text-align:center;border-top:1px solid #cecece;">
                      														 	  	<span style="font-size:13px; font-family:Arial, Helvetica, sans-serif; font-weight:normal; color:#000000; line-height:30px;  text-align:center;">
                      														 	  		<%= String.format("%,d",objPro.getPrice())%> VNĐ
                      														 	  	</span>
                      														 	  </td>
                      														 	  <td style="border-right:1px solid #cecece;text-align:center;border-top:1px solid #cecece;">
                      														 	  	<span style="font-size:13px; font-family:Arial, Helvetica, sans-serif; font-weight:normal; color:#000000; line-height:30px;  text-align:center;">
                      														 	  		<%=objPro.getDiscount() %> %
                      														 	  	</span>
                      														 	  </td>
                      														 	  <td style="text-align:center;border-top:1px solid #cecece;">
                      														 	  	<span style="font-size:13px; font-family:Arial, Helvetica, sans-serif; font-weight:normal; color:#000000; line-height:30px;  text-align:center;">
                      														 	  		<%=String.format("%,d",objPro.getCurrentPrice()) %> VNĐ
                      														 	  	</span>
                      														 	  </td>
                      														 </tr>
           
                      														<%} %>
                      					 	  			 	   		 </tbody>
                      					 	  			 	   </table>
                      					 	  			 </td>
                      					 	  		</tr>
                      					 	  </tbody>
                      					 </table>
                      				</div>
                      			</div>
                      		</div>
                      </div>
                 </div>
				<%} %>
			</div>
			<!-- end main -->
		</div>
		
	</div>
</html>
<script type="text/javascript">
	function showOrder (evt) {
		$(evt).find('#collapseOne').toggleClass('collapsed');
		$(evt).next().slideToggle(400);
	}
</script>
