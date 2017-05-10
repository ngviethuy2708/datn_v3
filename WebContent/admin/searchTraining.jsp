<%@page import="bean.Training"%>
<%@page import="bean.User"%>
<%@page import="library.TimeConvert"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<style>
th {
	text-align:center;
}
td {
	text-align:center;
}
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
button {
    background-color: white; 
    color: black; 
    border: 2px solid #008CBA;
}

button:hover {
    background-color: #008CBA;
    color: white;
}
</style>
	<!-- body -->
	<div class="container">
		<div class="row">
			<!-- main -->
			<div class="col-md-12 main">
				<div class="col-md-2">
					<p>
						<a href="<%=request.getContextPath()%>/admin/indexTraining" class="btn btn-success create-button" style="margin-left: -16px; margin-top: 41px;">Quay lại</a>
		        	</p>
		    	</div>	
				<!-- end search form -->
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>HÌNH ẢNH</th>
							<th style="width: 114px;">TÊN GÓI TẬP</th>
							<th style="width:131px;">NGÀY KHỞI TẠO </th>
							<th style="width:299px;">MÔ TẢ</th>
							<th style="width: 120px;">SỐ NGÀY TẬP</th>
							<th style="width: 112px;">GÍA</th>
							<th>KÍCH HOẠT</th>
							<th>CHỨC NĂNG</th>
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Training> alTraining = (ArrayList<Training>)request.getAttribute("alTraining");
					for(Training objTraining:alTraining){
						String imgActive = "";
						String isActive = "";
						int type;
						if(objTraining.isActive() == true){
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
							<td><%=objTraining.getId() %></td>
							<td><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objTraining.getPicture()%>" width="100px" height ="80px"></td>
							<td><%=objTraining.getName()%></td>
							<td><%=objTraining.getDateCreate()%></td>
							<td><%=objTraining.getPreview() %></td>
							<td><%=objTraining.getDayOfTraining() %> ngày</td>
							<td>
							<%if(objTraining.getDiscount()!=0) {%>
							<%=objTraining.getPrice()%> (Đang giảm giá <%=objTraining.getDiscount()%>%)
							<%}else{ %>
							<%=objTraining.getPrice()%>
							<%} %>
							</td>
							<td class="align-center" id="setactive-<%=objTraining.getId() %>">
								<a href="javascript:void(0)" onclick="return setActive(<%=objTraining.getId() %>, <%=type %>)" title="<%=isActive %>"><img style="width:30px; height:30px;" src="<%=imgActive %>" alt=""></a>
							</td>
							<td><a href="<%=request.getContextPath()%>/admin/editTraining?tid=<%=objTraining.getId()%>&type=load"><button>SỬA</button></a></td>
						</tr>
					<%} %>

					</tbody>
				</table>
				</div>
			</div>
			<!-- end main -->
		</div>
		
	</div>
	<!-- end body -->
</body>
<script type="text/javascript">
	function setActive(id, active){
		$.ajax({
			url: '<%=request.getContextPath() %>/admin/activeTraining',
			type: 'POST',
			cache: false,
			data: {
				aid: id,
				aactive: active,
				},
			success: function(data){
				$('#setactive-' + id).html(data);
			},
			error: function (){
				alert('Có lỗi xảy ra');
			}
		});
		return false;
	}
	</script>
</html>
