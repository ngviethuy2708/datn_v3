<%@page import="bean.Training"%>
<%@page import="bean.Member"%>
<%@page import="java.util.Date"%>
<%@page import="library.TimeConvert"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
</style>
<%@include file="/templates/admin/inc/header.jsp"%>
<!-- body -->
<div class="container">
	<div class="row">
		<!-- main -->
		<div class="col-md-10 main">
			<div class="search-form">
				<div class="col-md-2">
					<p>
						<a href="<%=request.getContextPath()%>/admin/indexRegister" class="btn btn-success create-button" style="margin-left: -16px; margin-top: 41px;">Quay lại</a>
		        	</p>
		    	</div>	
				<!--search form  -->
			</div>
			<!-- end search form -->
			<span id="addHistoryErr" style="color: red;"></span>
			<div class="table-main">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th><span style="font-size: 13px;">LỊCH TẬP</span></th>
							<th><span style="font-size: 13px;">SỐ NGÀY TẬP</span></th>
							<th><span style="font-size: 13px;">SỐ NGÀY NGHỈ</span></th>
							<th style="width: 107px; text-align: center;"><span
								style="font-size: 13px;">NGÀY BẮT ĐẦU</span></th>
							<th style="width: 113px; text-align: center;"><span
								style="font-size: 13px;">NGÀY KẾT THÚC</span></th>
							<th style="width: 113px; text-align: center;"><span
								style="font-size: 13px;">THÀNH TIỀN</span></th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<Member> alMember = (ArrayList<Member>)request.getAttribute("alHistory"); 
												
													for(Member objMember:alMember){
													
						%>
						<tr>
							<td style="white-space: nowrap;"><%=objMember.getTrainingName()%></td>
							<td style="white-space: nowrap;"><%=objMember.getDayOfTraining()%> ngày</td>
							<td id="trainingName_<%=objMember.getId() %>"><%=objMember.getDayOff()%> ngày</td>
							<td id="dayOfTraining_<%=objMember.getId()%>"><%=TimeConvert.getStringDatetime(objMember.getBeginDay())%></td>
							<td id="dayOff_<%=objMember.getId()%>"><%=TimeConvert.getStringDatetime(objMember.getEndDay())%></td>
							<td><%=objMember.getCurrent_price()%> VNĐ</td>
							<%-- 	<td><%=objRegis.getTrainingPrice() %></td>
							<td><%=cv.getStringDatetime(objRegis.getBeginDate()) %></td>
							<% if(objDate.before(dateNow)) {%>
							<td><p style="color:red;"><%=cv.getStringDatetime(objRegis.getEndDate()) %></p></td>
							<%} else{ %>
							<td><%=cv.getStringDatetime(objRegis.getEndDate()) %></td>
							<%} %>
							<td class="align-center" id="setactive-<%=objRegis.getIdRegister() %>">
							<a href="javascript:void(0)" onclick="return setActive(<%=objRegis.getIdRegister() %>, <%=type %>)" title="<%=isActive %>"><img style="width:30px; height:30px;" src="<%=imgActive %>" alt=""></a>
							</td>
							<td><a href="<%=request.getContextPath()%>/admin/editRegister?rid=<%=objRegis.getIdRegister()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteRegister?rid=<%=objRegis.getIdRegister()%>"><i class="fa fa-times"></i></a></td> --%>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>
		<!-- end main -->
		<!-- Modal -->
		<%@include file="/templates/admin/inc/rightbar.jsp"%>
	</div>

</div>
<!-- end body -->
</body>
</html>
