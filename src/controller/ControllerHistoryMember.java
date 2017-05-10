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
import javax.servlet.http.HttpSession;

import library.TimeConvert;
import model.ModelHistory;
import model.ModelMember;
import model.modelProduct;
import bean.DayOff;
import bean.Member;
import bean.Product;
import bean.User;

/**
 * Servlet implementation class ControllerHistoryMember
 */

public class ControllerHistoryMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerHistoryMember() {
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
		HttpSession ss = request.getSession();
		ModelMember mMember = new ModelMember();
		ModelHistory mHistory = new ModelHistory();
		modelProduct mPro = new modelProduct();
		int id = 0;
		int currentHistoryId = 0;
		User objUser = (User)ss.getAttribute("objUser");
		if(objUser != null){
			id = objUser.getId();
		}
		int idMember = mMember.getIdMember(id);
		ArrayList<Member> alMember = mMember.getListForViewHistoryPublic(idMember);
		for(Member objMember:alMember){
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
			String currentDateStr = TimeConvert.getDateNow();
			Date currentDateUtil = TimeConvert.getDateTime(currentDateStr);
			java.sql.Date currenDate = TimeConvert.getSqlDate(currentDateUtil);
			if(TimeConvert.removeTime(objMember.getEndDay()).before(TimeConvert.removeTime(currenDate))){
				objMember.setIsExpired(false);
			}else{
				objMember.setIsExpired(true);
			}
		}
		ArrayList<Product> alPro = mPro.getListForPublic();
		for (Product objPro : alPro) {
			if(objPro.getSale_id() != 0){
				int curentPrice = mPro.getPriceOfSale(objPro.getId());
				objPro.setPrice(curentPrice);
				int discount = mPro.getDiscount(objPro.getId());
				objPro.setDiscount(discount);
			}else{
				int curentPrice = mPro.getPrice(objPro.getId());
				objPro.setPrice(curentPrice);
				objPro.setDiscount(0);
			}
		}
		currentHistoryId = mMember.getCurrentHistoryId(idMember);
		DayOff objDayoff = mMember.getDayOffForHistoryMember(currentHistoryId);
		ArrayList<DayOff> alDayOff = mMember.getAlDayOff(currentHistoryId);
		request.setAttribute("alProduct", alPro);
		request.setAttribute("alDayOff", alDayOff);
		request.setAttribute("objDayOff", objDayoff);
		request.setAttribute("alMember",alMember);
		RequestDispatcher rd = request.getRequestDispatcher("/public/historyMember.jsp");
		rd.forward(request, response);
	}

}
