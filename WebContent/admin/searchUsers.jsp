<%@page import="bean.Training"%>
<%@page import="bean.User"%>
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
    padding: 1px 8px;
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
th {
	text-align:center;
}
td {
	text-align:center;
}
</style>
	<!-- body -->
	<div class="container">
		<div class="row">
			<!-- main -->
			<div class="col-md-10 main">
				<div class="col-md-2">
					<p>
						<a href="<%=request.getContextPath()%>/admin/indexUsers" class="btn btn-success create-button" style="margin-left: -16px; margin-top: 41px;">Quay lại</a>
		        	</p>
		    	</div>	
				<!-- end search form -->
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th style="width:100px;">USERNAME</th>
							<th style="width: 121px;">HỌ TÊN</th>
							<th style="width:121px;">NGÀY SINH</th>
							<th style="width:250px;">ĐỊA CHỈ</th>
							<th style="width: 123px;">SỐ ĐIỆN THOẠI</th>
							<th>HỘI VIÊN</th>
							<th>CHỨC NĂNG</th>
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<User> alUser = (ArrayList<User>)request.getAttribute("alUser");
					for(User objUser:alUser){
						String imgActive = "";
						String isActive = "";
						int type;
						if(objUser.isMember()==true){
							isActive = "Kích hoạt";
							imgActive = request.getContextPath() + "/templates/admin/images/icon-success.png";
							type = 1;
						}else{
							isActive = "Ngừng kích hoạt";
							imgActive = request.getContextPath() + "/templates/admin/images/icon-fail.png";
							type = 0;
						}
					%>
						<tr>
							<td><%=objUser.getId() %></td>
							<td><%=objUser.getUserName() %></td>
							<td><%=objUser.getFullName() %></td>
							<td><%=TimeConvert.getStringDatetime(objUser.getBirthDay()) %></td>
							<td><%=objUser.getAddDress() %></td>
							<td><%=objUser.getPhoneNumber() %></td>
							<%if(objUser.isMember() == false){ %>
								<td><a href="" id="userId" data-id="<%=objUser.getId() %>"  data-toggle="modal" data-target="#Member"><img style="width:30px; height:30px;" src="<%=request.getContextPath() %>/templates/admin/images/icon-fail.png" alt=""></a></td>
							<%}else{ %>
								<td><img style="width:30px; height:30px;" src="<%=request.getContextPath() %>/templates/admin/images/icon-success.png" alt=""></td>
							<%} %>
							<td><a href="<%=request.getContextPath()%>/admin/editUsers?uid=<%=objUser.getId()%>"><button id="edit">Sửa</button></a></td>
						</tr>
					<%} %>

					</tbody>
				</table>
				</div>
			</div>
			<!-- end main -->
			<%@include file="/templates/admin/inc/rightbar.jsp" %>
		</div>
		
	</div>
	<!-- end body -->
</body>
<!-- Modal -->
<div class="modal fade" id="Member" tabindex="-1" role="dialog" aria-labelledby="loginLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header" style="background-color: #787878;">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginlLabel" style = "font-weight:bold; text-align:center; color:white;">LỊCH TẬP</h4>
      </div>
      <div class="modal-body">
       	<form class="form-horizontal form_register" action ="<%=request.getContextPath() %>/admin/activeMember" role="form" method="post">
         	<div class="form-group">
    			<label for="inputEmail3" class="col-sm-3 control-label">Chọn lịch tập:</label>
   				<div class="col-sm-9">
      				<select id="training" style="width: 373px; height: 30px;">
      					<%
      					ArrayList<Training> alTraining = (ArrayList<Training>)request.getAttribute("alTraining");
      					for(Training objTraining:alTraining){
      					%>
      					<option id="<%=objTraining.getId() %>" discount="<%=objTraining.getDiscount()%>" price="<%=objTraining.getPrice()%>" idPrice="<%=objTraining.getPriceId()%>" idSale="<%=objTraining.getSaleId()%>" dateFrom="<%=objTraining.getFromDate()%>" dateTo="<%=objTraining.getToDate()%>" day_of_training="<%=objTraining.getDayOfTraining()%>"><%=objTraining.getName()%></option>
      					<%} %>
      				</select>
    			</div>
    			<div class="form-group" >
    				<label for="inputEmail3" class="col-sm-3 control-label" style="margin-left: -32px;">Giá gốc:</label>
   					<div class="col-sm-9" style="margin-top:8px;">
      					<span id="price" style="margin-left: 39px;"></span>
    				</div>
 				</div>
 				<div class="form-group">
    				<label for="inputEmail3" class="col-sm-3 control-label" style="margin-left: -25px;     margin-top: -13px;" >Giảm giá:</label>
   					<div class="col-sm-9" style="margin-top: -5px;">
      					<span id="discount" style="margin-left: 33px;"></span>
    				</div>
 				</div>
 				<div class="form-group">
    				<label for="inputEmail3" class="col-sm-3 control-label" style="margin-left: 29px; float: left; margin-top: -12px;">Giá sau khi giảm:</label>
   					<div class="col-sm-9" style="left: -196px; margin-top: -20px;">
      					<span id="curent_price" style="float:right;"></span>
    				</div>
 				</div>
 				<div class="form-group">
    				<label for="inputEmail3" class="col-sm-3 control-label" style="margin-left: -4px; float: left; margin-top: -12px;">Số ngày tập:</label>
   					<div class="col-sm-9" style="left: -376px; margin-top: -5px;">
      					<span id="day_of_training" style="float:right;"></span>
    				</div>
 				</div>
 			</div>
 			<div class="" style="text-align: right;">
        		<button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
       			<a id="addMember"><input class="button-add btn btn-success create-button" name="submit" type="submit" value="Xác nhận" /></a> 
     		</div>
     		<input type="hidden" id="user_id" name="userId" value="">
     		<input type="hidden" id="training_id" name="trainingId" value="">
     		<input type="hidden" id="price_id" name="priceId" value="">
     		<input type="hidden" id="sale_iD" name="saleId" value="">
        </form>
      </div>
    </div>
  </div>
</div>
<script>
function parseDate(dateStr) {
    var parts = dateStr.split("-");
    return new Date(parts[2], parts[1] - 1, parts[0]);
}
select_training();
$('#training').change(function(){
	select_training();
});
function select_training(){
	var user_id =  $("#userId").attr("data-id");
	$('#user_id').val(user_id);
	var training = $('#training option:selected');
	if (training) {
		var idTraining = training.attr('id');
		$('#training_id').val(idTraining);
		var price = training.attr('price');
		var discount = training.attr('discount');
		var priceId = training.attr('idPrice');
		$('#price_id').val(priceId);
		var saleID = training.attr('idSale');
		$('#sale_iD').val(saleID);
		
		var dateFrom = new Date(training.attr('dateFrom')).getTime();
		var dateTo = new Date(training.attr('dateTo')).getTime();
		
		var day_of_training = training.attr('day_of_training');
		
		var current_date = new Date().getTime();
		/* current_date.setHours(0, 0, 0, 0); */
		if(saleID != 0){
			if((dateFrom <= current_date ) && (current_date <= dateTo  )){
				var curent_price = price - ((price*discount)/100);
				$('#price').html(price+" VNĐ");
				$('#discount').html(discount+" %");
				$('#curent_price').html(curent_price+" VNĐ");
				$('#day_of_training').html(day_of_training+" ngày");
			}else{
				$('#price').html(price+" VNĐ");
				$('#discount').html("0 %");
				$('#curent_price').html(price+" VNĐ");
				$('#day_of_training').html(day_of_training+" ngày");
			}
		}else{
			$('#price').html(price+" VNĐ");
			$('#discount').html("0 %");
			$('#curent_price').html(price+" VNĐ");
			$('#day_of_training').html(day_of_training+" ngày");
		}	
	}
}
</script>
</html>
