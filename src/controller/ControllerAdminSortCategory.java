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
 * Servlet implementation class ControllerAdminSortCategory
 */
public class ControllerAdminSortCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSortCategory() {
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
		if(request.getParameter("submit") != null ){
			int typeFitness = Integer.parseInt(request.getParameter("type"));
			int timeFitness = Integer.parseInt(request.getParameter("time"));
			int limitFitness = Integer.parseInt(request.getParameter("limit"));
			int idFitnessCalendar = mCategory.getIdFinessCalendar(typeFitness, timeFitness, limitFitness);
			ArrayList<FitnessCategory> alCategory = mCategory.getFinessCategoryForSort(idFitnessCalendar);
			request.setAttribute("alCategory", alCategory);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/sortCategory.jsp");
			rd.forward(request, response);
			
		}
	}

}
