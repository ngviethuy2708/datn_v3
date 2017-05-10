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

import library.TimeConvert;
import model.ModelHistory;
import model.ModelMember;
import model.ModelTraining;
import model.ModelUser;
import bean.DayOff;
import bean.Member;
import bean.SearchForDate;
import bean.Search;
import bean.Training;

/**
 * Servlet implementation class ControllerAdminSearchUsers
 */

public class ControllerAdminSearchRegister2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSearchRegister2() {
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
	/*	ModelRegister mRegis = new ModelRegister();
		TimeConvert cv = new TimeConvert();
		String type = "";
		String something = "";
		if(request.getParameter("submit") != null){
			type = request.getParameter("optradio");
			something = request.getParameter("something");
			System.out.println(something);
			System.out.println(cv.isDate(something));
			
		}
		if(cv.isDate(something) == false){
			String something2 = new String(something.getBytes("ISO-8859-1"), "UTF-8");
			Search item = new Search(type, something2);
			request.setAttribute("alRegis",mRegis.getListForSearch(item) );
		}else{
			Date dateUntil = cv.getDateTime(something);
			java.sql.Date dateSQl = cv.getSqlDate(dateUntil);
			SearchForDate item2 = new SearchForDate(type, dateSQl);
			request.setAttribute("alRegis", mRegis.getListForSearchDate(item2));	
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchRegister.jsp");
		rd.forward(request, response);*/
		ModelMember mMember = new ModelMember();
		ModelTraining mTraining = new ModelTraining();
		ModelHistory mHistory = new ModelHistory();
 		if(request.getParameter("submit") != null){
			String keyword  = request.getParameter("keyword");
			ArrayList<Member> alMember = mMember.getListKeyWord(keyword);
			for(Member objMember: alMember){
				int dayoff = mHistory.getDayOff(objMember.getCurentHistoryId());
				Calendar c = Calendar.getInstance();
				c.set(Calendar.DAY_OF_MONTH,objMember.getBeginDay().getDate());
				c.set(Calendar.MONTH, objMember.getBeginDay().getMonth());
				c.set(Calendar.YEAR, objMember.getBeginDay().getYear() + 1900);
				c.add(Calendar.DAY_OF_MONTH, objMember.getDayOfTraining()+dayoff);
				Date endDate = c.getTime();
				java.sql.Date endDateSql = TimeConvert.getSqlDate(endDate);
				objMember.setDayOff(dayoff);
				objMember.setEndDay(endDateSql);
			}
			ArrayList<Training> alTraining = mTraining.getListForMember();
			ArrayList<Training> alTrainings = new ArrayList<>();
			for (Training objTraining : alTraining) {
				if(objTraining.getSaleId() != 0){
					alTrainings.add(mTraining.getItemForMemberSale(objTraining.getId()));
				}else{
					alTrainings.add(mTraining.getItemForMemberNoSale(objTraining.getId()));
				}
			}
			request.setAttribute("alTraining", alTrainings);
			request.setAttribute("alMember", alMember);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/searchRegister.jsp");
			rd.forward(request, response);
		}
	}

}
