<%@page import="bean.Post"%>
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
	<div class="container">
		<div class="row">
			<!-- main -->
			<div class="col-md-12 main">
				<div class="search-form">
					<div class="col-md-2">
						<p>
							<a href="<%=request.getContextPath()%>/admin/addPost?type=load" class="btn btn-success create-button" style="margin-left: -13px;">Tạo bài đăng</a>
		        		</p>
		    		</div>
		    		<!--search form  -->
		    		<div class="col-md-10">
					<form class="form-inline" role="form"
						action="<%=request.getContextPath()%>/admin/sortPost"
						method="post">
						<div class="form-group">
							<select name="sortPost" class="form-control" style="margin-left: 86px; width: 350px;">
  								<option value="1">--------------------TIN TỨC--------------------------</option>
 								<option value="2">-----------------QUẢNG CÁO--------------</option>
							</select>
						</div>
						<input class="button-add btn btn-primary create-button"
							name="submit" type="submit" value="Sắp xếp" />
					</form>
				</div>
		    	</div>
		    	
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>TÊN BÀI ĐĂNG</th>
							<th>HÌNH ẢNH</th>
							<th style="width:367px;">MÔ TẢ</th>
							<th>LOẠI BÀI ĐĂNG</th>
							<th>SỬA</th>
							<th>XÓA</th>
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Post> alPost = (ArrayList<Post>)request.getAttribute("alPost");
					for(Post objP:alPost){
					%>
						<tr>
							<td><%=objP.getId()%></td>
							<td><%=objP.getName()%></td>
							<td><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objP.getImage()%>" width="100px" height ="80px"></td>
							<td><%=objP.getPreview()%></td>
							<td><%=objP.getNameCategory() %></td>
							<td><a href="<%=request.getContextPath()%>/admin/editPost?pid=<%=objP.getId()%>&type=load"><button id="edit">SỬA</button></a></td>
							<td><a href="<%=request.getContextPath()%>/admin/deletePost?pid=<%=objP.getId()%>"><button id="banhang">Xóa</button></a></td>
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
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/indexPost?page=<%=i%>"><%=i %></a></li>
  					<%} %>
					</ul>
				</div>
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
	swal("", "Tạo bài đăng thành công!", "success");
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
	swal("", "Sửa bài đăng thành công!", "success");
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
	swal("", "Xóa bài đăng thành công!", "success");
</script>
		<%} %>
	<%} %>
	

	
</body>
</html>
