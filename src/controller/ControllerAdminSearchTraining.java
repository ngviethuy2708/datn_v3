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

import library.LibraryConstant;
import library.TimeConvert;
import model.ModelTraining;
import model.ModelUser;
import bean.SearchForDate;
import bean.Search;
import bean.Training;

/**
 * Servlet implementation class ControllerAdminSearchUsers
 */

public class ControllerAdminSearchTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSearchTraining() {
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
			ArrayList<Training> alTraining = mTraining.getListForSearch(item);
			for (Training objTraining : alTraining) {
				int curentPrice = mTraining.getPrice(objTraining.getId());
				objTraining.setPrice(curentPrice);
				int discount = mTraining.getDiscount(objTraining.getId());
				objTraining.setDiscount(discount);
			}
			request.setAttribute("alTraining",alTraining);
		}else{
			Date dateUntil = cv.getDateTime(something);
			java.sql.Date dateSQl = cv.getSqlDate(dateUntil);
			SearchForDate item2 = new SearchForDate(type, dateSQl);
			ArrayList<Training> alTraining =  mTraining.getListForSearchDate(item2);
			for (Training objTraining : alTraining) {
				int curentPrice = mTraining.getPrice(objTraining.getId());
				objTraining.setPrice(curentPrice);
				int discount = mTraining.getDiscount(objTraining.getId());
				objTraining.setDiscount(discount);
			}
			request.setAttribute("alTraining", alTraining);	
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchTraining.jsp");
		rd.forward(request, response);
		
	}

}
