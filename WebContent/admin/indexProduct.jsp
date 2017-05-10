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
							<a href="<%=request.getContextPath()%>/admin/addProduct?type=load" class="btn btn-success create-button" style="margin-left: -13px;">Tạo sản phẩm</a>
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
							<th style="width: 125px;">TÊN SẢN PHẨM</th>
							<th style="width: 120px;">HÌNH ẢNH</th>
							<th style="width: 300px;">MÔ TẢ</th>
							<th style="width: 96px;">SỐ LƯỢNG</th>
							<th style="width: 120px;">GÍA</th>
							<th>CHỨC NĂNG</th>
							<th>BÁN SẢN PHẨM</th>
							<th>NHẬP KHO</th>
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Product> alProduct = (ArrayList<Product>)request.getAttribute("alProduct");
					for(Product objProduct:alProduct){
						String price = String.format("%,d",objProduct.getPrice());
					%>
						<tr>
							<td><%=objProduct.getId() %></td>
							<td><%=objProduct.getName()%></td>
							<td><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objProduct.getImage()%>" width="100px" height ="80px"></td>
							<td style="width: 168px;"><%=objProduct.getPreview() %></td>
							<td style="text-align:center;"><%=objProduct.getQuatity()%></td> 
							<td>
							<%if(objProduct.getDiscount()!=0) {%>
							<%=price%> VNĐ (Đang giảm giá <%=objProduct.getDiscount()%>%)
							<%}else{ %>
							<%=price%> VNĐ
							<%} %>
							</td>
							<td style="text-align:center;"><a href="<%=request.getContextPath()%>/admin/editProduct?pid=<%=objProduct.getId()%>&type=load"><button id="edit">SỬA</button></a></td>
							<td style="text-align:center;"><a onclick="getProduct(<%=objProduct.getId()%>)"><button id="banhang">BÁN HÀNG</button></a></td>
							<td style="text-align:center;"><a  onclick="getProduct2(<%=objProduct.getId()%>)"><button id="add">THÊM</button></a></td>
						</tr>
					<%} %>

					</tbody>
				</table>
				</div>
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
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/indexProduct?page=<%=i%>"><%=i %></a></li>
  					<%} %>
					</ul>
				</div>
			</div>
			<!-- end main -->
			<!-- Modal -->
		<div class="modal fade" id="sale" tabindex="-1" role="dialog"
			aria-labelledby="loginLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #787878;">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="loginlLabel"
							style="font-weight: bold; text-align: center; color: white;">SẢN PHẨM</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="userID" value="">
						<form class="form-horizontal form_register" role="form"
							method="post" action="<%=request.getContextPath()%>/admin/addHisroryOrder">
								<div id= "imageProduct" style="margin-left: 39px;" >
								</div>
								<div style="float:right;">
									<ul style="position: absolute;margin-top: -105px;right: 88px;">
										<li style="display:block; margin-bottom:10px;"><strong>Tên sản phẩm: </strong><span id="nameProduct2"></span></li>
										<li style="display:block; margin-bottom:10px;"><strong>Số lượng hiện có: </strong><span id="quatity"></span></li>
										<li style="display:block; margin-bottom:10px;"><strong>Giá sản phẩm: </strong><span id="price"></span></li>
										<li style="display:block; margin-bottom:10px;"><strong>Số lượng bán: </strong><input type="number" id="numOfProduct" name="numOfProduct" min="1"/></li>
										<span id="saleError" style="color:red;"></span>
									</ul>
								</div>
								<input type="hidden" id="priceP" name="priceP">
								<input type="hidden" id="quatityP" name="quatityP">
								<input type="hidden" id="idP" name="idP">
								<input type="hidden" id="currentPrice" name="currentPrice">
							<div class="" style="text-align: right; margin-top:20px; margin-left: 30px;">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Đóng</button>
								<a href="#" id="addMember"><input
									class="button-add btn btn-success create-button" name="submit"
									type="submit" value="Xác nhận"  id="btn-submit" /></a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="add_product" tabindex="-1" role="dialog"
			aria-labelledby="loginLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #787878;">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="loginlLabel"
							style="font-weight: bold; text-align: center; color: white;">SẢN PHẨM</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="userID" value="">
						<form class="form-horizontal form_register" role="form"
							method="post" action="<%=request.getContextPath()%>/admin/addNumOfProduct">
								<div id= "imageProduct2" style="margin-left: 39px;" >
								</div>
								<div style="float:right;">
									<ul style="position: absolute;margin-top: -105px;right: 88px;">
										<li style="display:block; margin-bottom:10px;"><strong>Tên sản phẩm: </strong><span id="nameProduct22"></span></li>
										<li style="display:block; margin-bottom:10px;"><strong>Số lượng hiện có: </strong><span id="quatity2"></span></li>
										<li style="display:block; margin-bottom:10px;"><strong>Giá sản phẩm: </strong><span id="price2"></span></li>
										<li style="display:block; margin-bottom:10px;"><strong>Số lượng nhập: </strong><input type="number" id="numOfProduct2" name="numOfProduct" min="1"/></li>
									</ul>
								</div>
								<input type="hidden" id="priceP" name="priceP">
								<input type="hidden" id="quatityP2" name="quatityP">
								<input type="hidden" id="idP2" name="idP">
								<input type="hidden" id="currentPrice" name="currentPrice">
							<div class="" style="text-align: right; margin-top:20px; margin-left: 30px;">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Đóng</button>
								<a href="#" id="addMember"><input
									class="button-add btn btn-success create-button" name="submit"
									type="submit" value="Xác nhận"/></a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
		
	</div>
	<!-- end body -->
<%
	String msg = "";
	if(request.getParameter("sale") != null){
		msg = request.getParameter("sale");
		if(msg.equals("success")){
%>
<script>
	swal("", "Bán sản phẩm thành công!", "success")
</script>
		<%} %>
	<%} %>
<%
	String msg2 = "";
	if(request.getParameter("add") != null){
		msg = request.getParameter("add");
		if(msg.equals("success")){
%>
<script>
	swal("", "Thêm sản phẩm thành công!", "success")
</script>
		<%} %>
	<%} %>
</body>
<script>
	function getProduct(idProduct){
		$("#imageProduct img:last-child").remove();
		$.ajax({
			type: 'GET',
			async: false,
			url: '<%=request.getContextPath()%>/admin/getProduct',
			data: {'idProduct': idProduct },
			success: function(response) {
				$('#numOfProduct').val("");
				$('#saleError').html("");
				var value = response.split("|");
				var filepath = "<%=request.getContextPath()%>/files/";
				$('#imageProduct').prepend('<img class="img-rounded" style="width:154px; height:100px;" id="theImg" src="'+filepath+""+value[2]+'" />');
				$('#nameProduct').html(value[1]);
				$('#quatity').html(value[3]);
				$('#price').html(value[4]+" VNĐ");
				$('#priceP').val(parseFloat(value[4]));
				$('#quatityP').val(value[3]);
				$('#idP').val(value[0]);
				$('#sale').modal('show');
			}
		});
	}
	$('#numOfProduct').on('input',function(e){
		 var price = $('#priceP').val();
		 var quatity = $('#quatityP').val();
		 var newQuatity = $('#numOfProduct').val();
		 var quatity2 = quatity - newQuatity;
		 var quatityOld =  $('#quatityP').val();
		 if(parseInt(quatityOld) >= parseInt(newQuatity)){
			 $("#saleError").html("");
			 $("#btn-submit").removeAttr("disabled");
			 $('#quatity').html(quatity2);
			 var price_now = parseFloat(price) * newQuatity;
			 $('#price').html(price_now+" VNĐ"); 
			 $('#currentPrice').val(price_now); 
		 }else if(parseInt(quatityOld) < parseInt(newQuatity)){
			 $('#price').html(price);
			 $('#quatity').html(quatityOld);
			 $("#btn-submit").attr("disabled", true);
			 $("#saleError").html("invalid number");
		 }
		 
	});
	function getProduct2(idProduct){
		$("#imageProduct2 img:last-child").remove();
		$.ajax({
			type: 'GET',
			async: false,
			url: '<%=request.getContextPath()%>/admin/getProduct',
			data: {'idProduct': idProduct },
			success: function(response) {
				console.log(response);
				var value = response.split("|");
				var filepath = "<%=request.getContextPath()%>/files/";
				$('#imageProduct2').prepend('<img class="img-rounded" style="width:154px; height:100px;" id="theImg2" src="'+filepath+""+value[2]+'" />');
				$('#nameProduct22').html(value[1]);
				$('#quatity2').html(value[3]);
				$('#quatityP2').val(value[3]);
				$('#price2').html(value[4]+" VNĐ");
				$('#idP2').val(value[0]);
				$('#add_product').modal('show');
			}
		});
	}
</script>
</html>
