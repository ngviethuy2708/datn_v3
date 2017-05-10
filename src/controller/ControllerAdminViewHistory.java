package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import bean.Member;
import bean.Training;
import library.LibraryConstant;
import library.LibraryPer;
import library.TimeConvert;
import model.ModelHistory;
import model.ModelMember;
import model.ModelTraining;
import model.ModelUser;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerAdminViewHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminViewHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	TimeConvert cv = new TimeConvert();
		String dateStr = cv.getDateNow();
		Date dateUtil = cv.getDateTime(dateStr);
		ModelRegister mRegis = new ModelRegister();
		ArrayList<Register> alRegis = mRegis.getList();
		for (Register objRegis : alRegis) {
			java.sql.Date dateSql = objRegis.getEndDate();
			Date objDate = cv.getNormalDate(dateSql);
			if(objDate.before(dateUtil)){
				mRegis.editRegisterForEnddate(objRegis.getIdRegister());	
			}
		}
		int tongSoDong = mRegis.getSum();
		int soTrang = (int)Math.ceil((float)tongSoDong/LibraryConstant.ROW_COUNT);
		int currentPage = 1;
		if(request.getParameter("page") != null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", currentPage);
		request.setAttribute("soTrang", soTrang);
		int offset = (currentPage-1) * LibraryConstant.ROW_COUNT;
		request.setAttribute("alRegis", mRegis.getListForPaginator(offset,LibraryConstant.ROW_COUNT));
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexRegister.jsp");
		rd.forward(request, response);*/
		int id = 0 ;
		if(request.getParameter("mid") != null){
			id = Integer.parseInt(request.getParameter("mid"));
		}
		ModelMember mMember = new ModelMember();
		ModelHistory mHistory = new ModelHistory();
		ArrayList<Member> alMember = mMember.getListForViewHistory(id);
		for(Member objMember: alMember){
			int dayoff = mHistory.getDayOff(objMember.getHistoryId());
			objMember.setDayOff(dayoff);
			Calendar c = Calendar.getInstance();
			c.set(objMember.getBeginDay().getDay(), objMember.getBeginDay().getMonth(), objMember.getBeginDay().getYear());
			c.set(Calendar.DAY_OF_MONTH,objMember.getBeginDay().getDate());
			c.set(Calendar.MONTH, objMember.getBeginDay().getMonth());
			c.set(Calendar.YEAR, objMember.getBeginDay().getYear() + 1900);
			c.add(Calendar.DAY_OF_MONTH, objMember.getDayOfTraining()+objMember.getDayOff());
			Date endDate = c.getTime();
			java.sql.Date endDateSQL = TimeConvert.getSqlDate(endDate);
			objMember.setEndDay(endDateSQL);
		}
		request.setAttribute("alHistory",alMember);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/viewHistory.jsp");
		rd.forward(request, response);
		/*ModelMember mMember = new ModelMember();
		ModelHistory mHistory = new ModelHistory();
		ModelTraining mTraining = new ModelTraining();
		ArrayList<Member> alMembers = mMember.getList();
		for (Member member : alMembers) {
			int dayoff = mHistory.getDayOff(member.getCurentHistoryId());
			member.setDayOff(dayoff);
			Calendar c = Calendar.getInstance();
			c.set(objMember.getBeginDay().getDay(), objMember.getBeginDay().getMonth(), objMember.getBeginDay().getYear());
			c.set(Calendar.DAY_OF_MONTH,member.getBeginDay().getDate());
			c.set(Calendar.MONTH, member.getBeginDay().getMonth());
			c.set(Calendar.YEAR, member.getBeginDay().getYear() + 1900);
			c.add(Calendar.DAY_OF_MONTH, member.getDayOfTraining()+member.getDayOff());
			Date endDate = c.getTime();
			java.sql.Date endDateSQL = TimeConvert.getSqlDate(endDate);
			member.setEndDay(endDateSQL);
			String currentDateStr = TimeConvert.getDateNow();
			Date currentDateUtil = TimeConvert.getDateTime(currentDateStr);
			java.sql.Date currenDate = TimeConvert.getSqlDate(currentDateUtil);
			if(member.getEndDay().before(currenDate)){
				int result = mMember.setExprired(member.getId());
				if(result > 0){
					System.out.println(member.getFullName()+" het han");
				}
			}
		}*/
	/*	int tongSoDong = mMember.getSum();
		int soTrang = (int)Math.ceil((float)tongSoDong/LibraryConstant.ROW_COUNT);
		int currentPage = 1;
		if(request.getParameter("page") != null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", currentPage);
		request.setAttribute("soTrang", soTrang);
		int offset = (currentPage-1) * LibraryConstant.ROW_COUNT;
		ArrayList<Member> alMember = mMember.getListForPaginator(offset, LibraryConstant.ROW_COUNT);
		for(Member objMember:alMember){	
			int dayoff = mHistory.getDayOff(objMember.getCurentHistoryId());
			objMember.setDayOff(dayoff);
			Calendar c = Calendar.getInstance();
			c.set(objMember.getBeginDay().getDay(), objMember.getBeginDay().getMonth(), objMember.getBeginDay().getYear());
			c.set(Calendar.DAY_OF_MONTH,objMember.getBeginDay().getDate());
			c.set(Calendar.MONTH, objMember.getBeginDay().getMonth());
			c.set(Calendar.YEAR, objMember.getBeginDay().getYear() + 1900);
			c.add(Calendar.DAY_OF_MONTH, objMember.getDayOfTraining()+objMember.getDayOff());
			Date endDate = c.getTime();
			java.sql.Date endDateSQL = TimeConvert.getSqlDate(endDate);
			objMember.setEndDay(endDateSQL);
		}
		request.setAttribute("alMember", alMember);
		ArrayList<Training> alTraining = mTraining.getListForMember();
		ArrayList<Training> alTrainings = new ArrayList<>();
		for (Training objTraining : alTraining) {
			if(objTraining.getSaleId() != 0){
				alTrainings.add(mTraining.getItemForMemberSale(objTraining.getId()));
			}else{
				alTrainings.add(mTraining.getItemForMemberNoSale(objTraining.getId()));
			}
		}*/
		/*request.setAttribute("alTraining", alTrainings);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexRegister.jsp");
		rd.forward(request, response);*/
		
	}

}
