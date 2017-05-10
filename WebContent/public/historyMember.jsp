<%@page import="java.util.Date"%>
<%@page import="bean.DayOff"%>
<%@page import="bean.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
    <div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="page-caption">
                        <h2 class="page-title">THÔNG TIN THẺ THÀNH VIÊN</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="page-breadcrumb">
        <div class="container">
            <div class="col-lg-12">
                <ol class="breadcrumb">
                    <li><a href="<%=request.getContextPath()%>/index">Trang chủ</a></li>
                    <li class="active">Thẻ thành viên</li>
                </ol>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                    <div class="row">
                    	<%
                    	ArrayList<Member> alMember = (ArrayList<Member>)request.getAttribute("alMember"); 
                    	for(Member objMember:alMember){
                    	%>
                        <div class="col-lg-12 col-sm-12 col-md-12 col-sm-12">
                            <div class="post-holder">
                                <!-- post holder -->
                                <div class="post-img">
                                    <!-- post img -->
                                    <a href="#"><img style="width:100%; height:150px;"src="<%=request.getContextPath()%>/templates/public/images/banner.jpg" alt="" class="img-responsive"></a>
                                </div>
                                <!-- /.post img -->
                                <div class="post-content">
                                    <!-- post content -->
                                    <div class="post-header">
                                        <!-- post header -->
                                        <h1 class="post-title"><a href="blog-single.html" class="title">Câu lạc bộ Gym Tài Nguyên Đà Nẵng</a></h1>
                                        <div class="meta">
                                            <!-- post meta -->
                                            <%ArrayList<DayOff> alDayOff = (ArrayList<DayOff>)request.getAttribute("alDayOff"); %>
                                           	<ul class="list-group list-group-flush">
    											<li class="list-group-item"><span style="font-weight:bold">Tên gói tập: </span><%=objMember.getTrainingName() %></li>
    											<li class="list-group-item"><span style="font-weight:bold">Số ngày tập: </span><%=objMember.getDayOfTraining() %> ngày</li>
    											<li class="list-group-item"><span style="font-weight:bold">Số ngày nghỉ: </span><%=objMember.getDayOff() %> ngày</li>
    											<%if(alDayOff != null && objMember.getIsExpired() == true){ int i =1;%>
    												
    												<%for(DayOff objDayOff:alDayOff){%>
    													<li class="list-group-item"><span style="font-weight:bold;">Lần nghỉ <%=i%></span>: <%=TimeConvert.getStringDatetime(objDayOff.getStart_day()) %> -> <%=TimeConvert.getStringDatetime(objDayOff.getEnd_day()) %></li>
    												<%i++;}%>
    										
    											<% } %>
    											<li class="list-group-item"><span style="font-weight:bold">Học phí: </span><%=objMember.getCurrent_price() %> VNĐ</li>
    											<li class="list-group-item"><span style="font-weight:bold">Ngày bắt đầu: </span><%=TimeConvert.getStringDatetime(objMember.getBeginDay()) %></li>
    											<li class="list-group-item"><span style="font-weight:bold">Ngày kết thúc: </span><%=TimeConvert.getStringDatetime(objMember.getEndDay()) %></li>
    											<%if(objMember.getIsExpired() == true){ %>
    											<li class="list-group-item"><span style="font-weight:bold">Trạng thái: </span>Khả dụng</li>
    											<%}else{ %>
    											<li style="color:red;" class="list-group-item"><span style="font-weight:bold">Trạng thái: </span>Đã hết hạn</li>
    											<%} %>
  											</ul>
  											<%DayOff objDayOff = (DayOff)request.getAttribute("objDayOff"); %>
  											<%if(objMember.getIsExpired() == true && objMember.getDayOfTraining() >= 60){ %>
  											<input type="hidden" value="<%=TimeConvert.getStringDatetime(objMember.getEndDay())%>" id="endDate">
  											
  											<div class="card-block">
   												<a href="javascript:;" onclick="divDateOff();" class="card-link">Chọn thời giạn tạm vắng</a>
  											</div>
  											<form id="form-dayoff" action="<%=request.getContextPath()%>/setDayOffMember" method="post">
  											<div class="row form-group" id="divDateOff" style="display:none">
                								<div class="col-lg-6 col-md-6 form-group">
                									<label for="inputAddress">Ngày bắt đầu vắng(*)</label>                  
                     								<div class="input-group date" id="date_off">
                   	 									<input id="date_off_from" type="text" class="form-control" name="dayFrom" value="" placeholder="dd-MM-yyyy"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                   	 								</div>
                   	 								<span style="color:red;" id="date_off_from_err"></span>                  
               	 								</div>
                								<div class="col-lg-6 col-md-6 form-group">                  
                    								<label for="inputAddress">Ngày đi tập trở lại(*)</label>
                    								<div class="input-group date" id="date_off">
                   	 									<input id="date_off_to" type="text" class="form-control" name="dayTo" value="" placeholder="dd-MM-yyyy"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>	
                   	 								</div>
                   	 								<span style="color:red;" id="date_off_to_err"></span>                     
                								</div>
                								<input type="hidden" name="historyId" value="<%=objMember.getHistoryId()%>">
                								<%if(objDayOff == null){ %>
                									<script>
                									var endDate = $('#endDate').val();
                									var arr = endDate.split("/");
                									var date = new Date(arr[2]+"-"+arr[1]+"-"+arr[0]);
                								    var d = date.getDate();
                								    var m = date.getMonth();
                								    var y = date.getFullYear();
                								    var maxDate = new Date(y, m, d);
                									var minDate = new Date();
                									$(".input-group#date_off").datepicker({
                										changeYear: true,
                										changeMonth: true,
                										autoclose: true,
                										format: 'dd/mm/yyyy',
                										startDate: minDate,
                										endDate: maxDate
                									});
                									</script>
                								<%}else{ %>
                									<input type="hidden" value="<%=TimeConvert.getStringDatetime(objDayOff.getEnd_day())%>" id="endDateObjDayOff">
                									<script>
                									var endDate = $('#endDate').val();
                									var arr = endDate.split("/");
                									var date = new Date(arr[2]+"-"+arr[1]+"-"+arr[0]);
                								    var d = date.getDate();
                								    var m = date.getMonth();
                								    var y = date.getFullYear();
                								    var maxDate = new Date(y, m, d);
                								    var startDate = $('#endDateObjDayOff').val();
                								    var arr2 = startDate.split("/");
                								    var date2 = new Date(arr2[2]+"-"+arr2[1]+"-"+arr2[0]);
                								    var d2 = date2.getDate();
                								    var m2 = date2.getMonth();
                								    var y2 = date2.getFullYear();
                									var minDate = new Date(y2, m2, d2+1);
                									$(".input-group#date_off").datepicker({
                										changeYear: true,
                										changeMonth: true,
                										autoclose: true,
                										format: 'dd/mm/yyyy',
                										startDate: minDate,
                										endDate: maxDate
                									});
                									</script>
                								<%} %>
                								<input  class="btn btn-default" style="margin-left:297px; margin-top:20px;" type="submit" name="submit" value="Xác nhận" >
             								</div>
             								</form>
  											<%} %>
                                      </div>
                                        <!-- /.post meta -->
                                    </div>
                                </div>
                                <!-- /.post content -->
                            </div>
                            <!-- /.post holder -->
                        </div>
                        <%} %>
                        <div class="col-md-10 col-sm-10 text-center">
                                <div class="st-pagination">
                                    <!--st-pagination-->
                                    <ul class="pagination">
                                        <li> <a href="#" aria-label="previous"><span aria-hidden="true">previous</span></a></li>
                                        <li class="active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li> <a href="#" aria-label="Next"><span aria-hidden="true">next</span></a></li>
                                    </ul>
                                </div>
                                <!--/.st-pagination-->
                            </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                         <!-- widget start -->
                                         <div class="widget widget-recent-post"><!-- widget recent post -->
                                             <h2 class="widget-title">Sản phẩm đánh giá cao nhất</h2>
                                             <ul class="listnone widget-recent-post">
                                              	<%
                               					ArrayList<Product> alPro = (ArrayList<Product>)request.getAttribute("alProduct"); 
                                				for(Product objProduct:alPro){
                                					String price = String.format("%,d",objProduct.getPrice());
                                				%>
                                                 <li>
                                                     <div class="row">
                                                         <div class="col-md-4">
                                                         	<%if(objProduct.getDiscount() != 0){ %>
                       										<div class="offer-tag" >
                                								<p class="off-price"><%=objProduct.getDiscount()%>% 0ff</p>
                            								</div>
                       										<%} %>
                                                             <div class="recent-post-img">
                                                                 <a href="#"><img style="width:100%; height:100px;" src="<%=request.getContextPath() %>/files/<%=objProduct.getImage()%>" alt=""></a>
                                                                 <div class="team-meta"><span class="team-designation" style="font-size:12px;"><%=price %> VNĐ</span></div>
                                                             </div>
                                                         </div>
                                                         <div class="col-md-8">
                                                             <div class="recent-post-content">
                                                                 <h4><a href="#" class="title"><%=objProduct.getName() %></a></h4>
                                                                 <div class="meta"><span class="meta-date"><%=objProduct.getPreview() %></span>
                                                                 </div>
                                                             </div>
                                                         </div>
                                                     </div>
                                                 </li>
                                                 <%} %>
                                             </ul>
                                         </div><!-- /.widget recent post -->
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="container ">
            <p>Copyright © 2016 - 2017 Thể hình - Tập thể hình - Thể hình đẹp - Phương pháp tập thể hình nam, nữ - Thể lực</p>
            <p>CODE BY: Nguyễn Viết Huy</p>
        </div>
    </div>
</body>
<%
	String ms = "";
	if(request.getParameter("addDayOff") != null){
		ms = request.getParameter("addDayOff");
		if(ms.equals("success")){
%>
<script>
	swal("", "Cập nhập lịch nghỉ hội viên thành công!", "success")
</script>
		<%} %>
	<%} %>
<script>
function divDateOff(){
	$("#divDateOff").css({display: "block"});
}
$("#form-dayoff").submit(function(e){
	var check = 1;
	var dayFrom = $('#date_off_from').val();
	var dayTo =  $('#date_off_to').val();
	if(dayFrom == ""){
		check = 0;
		$('#date_off_from_err').html('This field is required');
	}else{
		$('#date_off_from_err').html('');
	}
	if(dayTo == ""){
		check = 0;
		$('#date_off_to_err').html('This field is required');
	}else{
		$('#date_off_to_err').html('');
	}
	if(check == 0){
		e.preventDefault();
	}else if(!confirm('Bạn có chắc chắn với lựa chọn của mình ?')){
		e.preventDefault();
	}
	
});
</script>
</html>
