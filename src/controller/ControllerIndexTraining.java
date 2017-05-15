package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Training;
import model.ModelTraining;

/**
 * Servlet implementation class ControllerIndexTraining
 */

public class ControllerIndexTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndexTraining() {
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
		ArrayList<Training> alTraining = mTraining.getListForIndexTraining();
		for (Training objTraining : alTraining) {
			if(objTraining.getSaleId() != 0){
				int curentPrice = mTraining.getPriceOfSale(objTraining.getId());
				objTraining.setPrice(curentPrice);
				int discount = mTraining.getDiscount(objTraining.getId());
				objTraining.setDiscount(discount);
			}else{
				int curentPrice = mTraining.getPrice(objTraining.getId());
				objTraining.setPrice(curentPrice);
				objTraining.setDiscount(0);
			}
		}
		request.setAttribute("alTraining", alTraining);
		RequestDispatcher rd = request.getRequestDispatcher("/public/indexTraining.jsp");
		rd.forward(request, response);
	}

}
