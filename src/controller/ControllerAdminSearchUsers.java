package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.TimeConvert;
import model.ModelTraining;
import model.ModelUser;
import bean.SearchForDate;
import bean.Search;
import bean.Training;

/**
 * Servlet implementation class ControllerAdminSearchUsers
 */

public class ControllerAdminSearchUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSearchUsers() {
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
		ModelUser mUser = new ModelUser();
		ModelTraining mTraining = new ModelTraining();
		TimeConvert cv = new TimeConvert();
		String type = "";
		String something = "";
		if(request.getParameter("submit") != null){
			type = request.getParameter("optradio");
			something = request.getParameter("something");
		}
		if(cv.isDate(something) == false){
			String something2 = new String(something.getBytes("ISO-8859-1"), "UTF-8");
			Search item = new Search(type, something2);
			request.setAttribute("alUser",mUser.getListForSearch(item) );
		}else{
			Date dateUntil = cv.getDateTime(something);
			java.sql.Date dateSQl = cv.getSqlDate(dateUntil);
			SearchForDate item2 = new SearchForDate(type, dateSQl);
			request.setAttribute("alUser", mUser.getListForSearchDate(item2));	
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
		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchUsers.jsp");
		rd.forward(request, response);
		
	}

}
