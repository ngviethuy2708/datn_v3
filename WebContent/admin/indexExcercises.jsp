<%@page import="bean.FitnessExcercises"%>
<%@page import="java.util.Date"%>
<%@page import="bean.Training"%>
<%@page import="library.TimeConvert"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	<!-- body -->
	<div class="container">
		<div class="row">
			<!-- main -->
			<div class="col-md-12 main">
				<div class="search-form">
					<div class="col-md-2">
						<p>
							<a href="<%=request.getContextPath()%>/admin/addExcercises?type=load" class="btn btn-success create-button" style="margin-left: -13px;">Tạo bài tập</a>
		        		</p>
		    		</div>
		    		<!--search form  -->
		    	</div>
		    	
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>TÊN BÀI TẬP</th>
							<th>HÌNH ẢNH</th>
							<th>MÔ TẢ</th>
							<th>YÊU CẦU </th>
							<th>SỬA</th>
							<th>XÓA</th>
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<FitnessExcercises> alEx = (ArrayList<FitnessExcercises>)request.getAttribute("alEx");
					for(FitnessExcercises objEx:alEx){
					%>
						<tr>
							<td><%=objEx.getId() %></td>
							<td style="width:235px;"><%=objEx.getName() %></td>
							<td><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objEx.getImage()%>" width="100px" height ="80px"></td>
							<td style="width: 493px;"><%=objEx.getPreview() %></td>
							<td><%=objEx.getResult() %></td> 
							<td><a href="<%=request.getContextPath()%>/admin/editExcercises?eid=<%=objEx.getId()%>&type=load"><i class="fa fa-edit"></i></a></td>
							<td><a href="<%=request.getContextPath()%>/admin/deleteExcercises?eid=<%=objEx.getId()%>"><i class="fa fa-times"></i></a></td>
						</tr>
					<%} %>

					</tbody>
				</table>
			</div>
			<!-- end main -->
		</div>
		
	</div>
	<!-- end body -->
<%
	String msg = "";
	if(request.getParameter("add") != null){
		msg = request.getParameter("add");
		if(msg.equals("success")){
%>
<script>
	swal("", "Tạo bài tập thành công!", "success");
</script>
		<%} %>
	<%} %>
	
<%
	String msg2 = "";
	if(request.getParameter("edit") != null){
		msg = request.getParameter("edit");
		if(msg.equals("success")){
%>
<script>
	swal("", "Sửa bài tập thành công!", "success");
</script>
		<%} %>
	<%} %>
<%
	String msg3 = "";
	if(request.getParameter("delete") != null){
		msg = request.getParameter("delete");
		if(msg.equals("success")){
%>
<script>
	swal("", "Xóa bài tập thành công!", "success");
</script>
		<%} %>
	<%} %>
	
</body>

