<%@page import="bean.Post"%>
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
			<div class="col-md-10 main">
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
							<th>MÔ TẢ</th>
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
							<td><a href="<%=request.getContextPath()%>/admin/editPost?pid=<%=objP.getId()%>&type=load"><i class="fa fa-edit"></i></a></td>
							<td><a href="<%=request.getContextPath()%>/admin/deletePost?pid=<%=objP.getId()%>"><i class="fa fa-times"></i></a></td>
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
</html>
