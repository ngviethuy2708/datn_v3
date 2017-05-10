package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DayOff;
import library.TimeConvert;
import model.ModelMember;

/**
 * Servlet implementation class ControllerSetDayOffMember
 */
public class ControllerSetDayOffMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSetDayOffMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelMember mMember = new ModelMember();
		int historyId = 0;
		if(request.getParameter("submit") != null){
			historyId = Integer.parseInt(request.getParameter("historyId"));
			String dayFrom = request.getParameter("dayFrom");
			java.util.Date dayFromUtil = TimeConvert.getDateTime(dayFrom);
			Date dayFromSQl = TimeConvert.getSqlDate(dayFromUtil);
			String dayTo = request.getParameter("dayTo");
			java.util.Date dayToUtil = TimeConvert.getDateTime(dayTo);
			Date dayToSQl = TimeConvert.getSqlDate(dayToUtil);
			DayOff objDayOff = new DayOff(0, historyId, dayFromSQl, dayToSQl);
			int result =  mMember.addDayOff(objDayOff);
			if(result > 0){
				response.sendRedirect(request.getContextPath() + "/historyMember?addDayOff=success");
			}
		}
	}

}
