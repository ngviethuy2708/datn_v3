package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelFitnessExcercises;

/**
 * Servlet implementation class ControllerAdminDeleteFitnessCategory
 */

public class ControllerAdminDeleteFitnessCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteFitnessCategory() {
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
		int id = 0;
		ModelFitnessExcercises mCategory = new ModelFitnessExcercises();
		if(request.getParameter("id") != null){
			id = Integer.parseInt(request.getParameter("id"));
			int result = mCategory.deleteCategory(id);
			if(result > 0){
				int resultExcercises = mCategory.deleteExcercisesInCategory(id);
				if(resultExcercises > 0){
					response.sendRedirect(request.getContextPath()+"/admin/fitnessCategory?delete=success");
				}
			}
		}
	}

}
