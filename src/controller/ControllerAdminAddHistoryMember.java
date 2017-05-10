package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.rdf.model.Model;

import bean.History;
import bean.Member;
import library.TimeConvert;
import model.ModelHistory;
import model.ModelMember;
import model.ModelTraining;
import model.ModelUser;

/**
 * Servlet implementation class ControllerAdminAjaxRegister
 */

public class ControllerAdminAddHistoryMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddHistoryMember() {
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
	/*	ModelUser mUser = new ModelUser();
		ModelMember mMember = new ModelMember();
		PrintWriter out = response.getWriter();
		int id = Integer.valueOf(request.getParameter("aid"));
		int active = Integer.valueOf(request.getParameter("aactive"));
		String imgActive = "";
		String result = "";
		if(mUser.setActive(id,active) > 0){
			int curentHistoryId = 0;
			Member objMember = new Member(0, id, curentHistoryId);
			int addMember = mMember.addItem(objMember);
			imgActive = request.getContextPath() + "/templates/admin/images/icon-success.png";
			active = 1;
			result += "<a href='avascript:void(0)' onclick='return setActive("+id +","+ active +")' title=''><img style='width:30px; height:30px;'' src='" + imgActive + "'></a>";
			out.print(result);
		}*/
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		System.out.println(memberId);
		int trainingId = Integer.parseInt(request.getParameter("trainingId"));
		int priceId = Integer.parseInt(request.getParameter("priceId"));
		int saleId = Integer.parseInt(request.getParameter("saleId"));
		ModelUser mUser = new ModelUser();
		ModelMember mMember = new ModelMember();
		ModelTraining mTraining = new ModelTraining();
		ModelHistory mHistory = new ModelHistory();
		Member objMember = null;
		//int result = mUser.setActive(userId);
		int curentHistoryId = 0;
		int curentPrice = 0;
		String curentDateStr = TimeConvert.getDateNow();
		Date curentDateUntil = TimeConvert.getDateTime(curentDateStr);
		java.sql.Date curentDateSql = TimeConvert.getSqlDate(curentDateUntil);
		if(saleId != 0){
			curentPrice = mTraining.getPriceOfSale(trainingId);
		}else{
			curentPrice = mTraining.getPrice(trainingId);
		}
		History objHistory = new History(0, memberId, trainingId, priceId, saleId, curentDateSql,curentPrice);
		int resultHistory = mHistory.addItem(objHistory);
		if(resultHistory > 0){
			curentHistoryId = mHistory.getIdMax();
			objMember = new Member(memberId, curentHistoryId);
			System.out.println(objMember);
			int resultUpdateMember = mMember.editItem(objMember);
			System.out.println(resultUpdateMember);
			if(resultUpdateMember > 0){
				int resultUpdateExpired = mMember.setExpriredForAddHistory(memberId);
				if(resultUpdateExpired > 0){
					PrintWriter out = response.getWriter();
					String result = "sucess";
					out.print(result);
				}
			}
		}
		/*if(result > 0){
			objMember = new Member(0, userId, 0);
			int resultMember = mMember.addItem(objMember);
			System.out.println(resultMember);
			if(result > 0){
				int curentPrice = 0;
				idMember = mMember.getIdMax();
				System.out.println("idMember "+idMember);
				String curentDateStr = TimeConvert.getDateNow();
				Date curentDateUntil = TimeConvert.getDateTime(curentDateStr);
				java.sql.Date curentDateSql = TimeConvert.getSqlDate(curentDateUntil);
				if(saleId != 0){
					curentPrice = mTraining.getPriceOfSale(trainingId);
				}else{
					curentPrice = mTraining.getPrice(trainingId);
				}
				History objHistory = new History(0, idMember, trainingId, priceId, saleId, curentDateSql,curentPrice);
				System.out.println(objHistory);
				int resultHistory = mHistory.addItem(objHistory);
				System.out.println("resultHistory "+resultHistory);
				if(resultHistory > 0){
					curentHistoryId = mHistory.getIdMax();
					objMember = new Member(idMember, userId, curentHistoryId);
					int resultUpdateMember = mMember.editItem(objMember);
					if(resultUpdateMember > 0){
						System.out.println("thanh cong");
					}
				}
			}
		}*/
	}

}
