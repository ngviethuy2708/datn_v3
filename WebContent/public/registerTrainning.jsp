<%@page import="bean.Training"%>
<%@page import="library.TimeConvert"%>
<%@page import="bean.Register"%>
<%@page import="bean.News"%>
<%@page import="bean.Introduce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp" %>
	<!-- body -->
	<div class="main-content">
			<div class="container">
				<div class="row main-section">
					<div class="col-md-8">
					<!-- section1 -->
						<div class="section">
						 	<div class="title-section">
						 		<div class="col-md-12">	
						 			<nav class="navbar navbar-inverse">
  										<p><span class="animated flash animation-delay-11">ĐĂNG KÝ TẬP</span></p>
									</nav>
							
								</div>
							</div>
							<div class="row main-section">
							
								<div class="col-md-12">
									<div class="row detail-section-index">
										<%int checkUser = (Integer)request.getAttribute("checkUser"); 
										ArrayList<Training> alTrainning = (ArrayList<Training>)request.getAttribute("alTrainning");										
										%>
										<%if(checkUser == 1) {
											Register objRegis = (Register)request.getAttribute("objRegis");										
										%>
										<div class="col-md-12">
											<h3 style="color: black; font-weight: bold; text-align: center;">THÔNG TIN ĐĂNG KÝ CỦA BẠN</h3>
										</div>
										<label style="font-weight:bold; margin-left:20px;">Họ và tên : </label> <%=objRegis.getFullName() %></br>
										<label style="font-weight:bold; margin-left:20px;">Ngày Sinh : </label><%=TimeConvert.getStringDatetime(objRegis.getBirthDay()) %></br>
										<label style="font-weight:bold; margin-left:20px;">Số điện thoại : </label><%=objRegis.getPhoneNumber() %> </br>
										<label style="font-weight:bold; margin-left:20px;">Lịch tập : </label> <%=objRegis.getTrainingName() %></br>
										<label style="font-weight:bold; margin-left:20px;">Số ngày tập : </label> <%=objRegis.getTrainingDay() %></br>
										<label style="font-weight:bold; margin-left:20px;">Ngày bắt đầu : </label> <%=TimeConvert.getStringDatetime(objRegis.getBeginDate()) %></br>
										<label style="font-weight:bold; margin-left:20px;">Ngày kết thúc : </label> <%=TimeConvert.getStringDatetime(objRegis.getEndDate())%></br>
										<label style="font-weight:bold; margin-left:20px;">Học phí : </label> <%=objRegis.getTrainingPrice() %></br>
										<label style="font-weight:bold; margin-left:20px;">Tình trạng nộp học phí : </label>
											<%if(objRegis.isType()==true){%>
												Đã nộp
											<%}else{%>
												Chưa nộp
											<%} %>
											</br>
										<label style="font-weight:bold; margin-left:20px;">Cảm ơn bạn đã đến với trung tâm của chúng tôi! </label>
										<%}else if(objUsers.isRegister()==false){ %>
											<div class="col-md-12">
											<h3 style="color: black; font-weight: bold; text-align:center;">CHÀO MỪNG BẠN ĐẾN VỚI TRUNG TÂM CHÚNG TÔI</h3>
										</div>
										<div class="col=md-12" style ="margin-left: 71px;"">
											<form class="form-horizontal form_RegisterTrainning" role="form" method="post" action="<%=request.getContextPath()%>/registerTrainning" >
												<div class="form-group">
    												<label  style="margin-left:-170px;" class="col-sm-5 control-label">Chọn lịch tập: </label>
   													<div class="col-sm-5">
      													<select name="training" class="selectpicker" style="margin-top: 9px;  margin-left:41px;"  >
      													<%
      													for(Training objTranning:alTrainning){
      													%>
      							
 															<option value="<%=objTranning.getIdTraining()%>"><%=objTranning.getNameTraining() %> (<%=objTranning.getPriceTraining() %>)</option>
 														<%} %>
														</select>
    												</div>
 												</div>
 												<div class="form-group" >
    												<label  style="margin-left:-132px; for="inputEmail3" class="col-sm-5 control-label">Chọn ngày bắt đầu: </label>
   													<div class="col-sm-5">
      													<input type="text" name="beginDate" class="form-control required" id="username" placeholder="dd/MM/yyyy" style="width:200px;">
    												</div>
 												</div>
 												<div class="form-group">
 													<div class="col-sm-offset-2 col-sm-10">
     													<p >
															<input class="button-add btn btn-success create-button" name="submit" type="submit" value="Đăng ký" style="margin-left:-128px;" /> 
		        										</p>
    												</div>
 												</div>
											</form>	
										</div>
										<%} %>
									</div>
								</div>
								
							
							</div>
						</div>
						<!-- end section 1 -->
						
					</div>
					<%@include file="/templates/public/inc/rightbar.jsp" %>
		<%@include file="/templates/public/inc/footer.jsp" %>