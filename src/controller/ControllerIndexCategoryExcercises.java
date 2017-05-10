package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.FitnessCategory;
import model.ModelFitnessExcercises;

/**
 * Servlet implementation class ControllerIndexCategoryExcercises
 */
public class ControllerIndexCategoryExcercises extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndexCategoryExcercises() {
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
		ModelFitnessExcercises mCategory = new ModelFitnessExcercises();
		int limitId = Integer.parseInt(request.getParameter("gioitinh"));
		int timeId = Integer.parseInt(request.getParameter("thoigian"));
		int typeId = Integer.parseInt(request.getParameter("chucnang"));
		int idFitnessCalendar = mCategory.getIdFinessCalendar(typeId, timeId, limitId);
		ArrayList<FitnessCategory> alCategory = mCategory.getFinessCategoryForSort(idFitnessCalendar);
		request.setAttribute("alCategory", alCategory);
		RequestDispatcher rd = request.getRequestDispatcher("/public/indexCategory.jsp");
		rd.forward(request, response);
	}

}
