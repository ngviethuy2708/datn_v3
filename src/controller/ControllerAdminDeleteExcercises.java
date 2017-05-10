package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelFitnessExcercises;

/**
 * Servlet implementation class ControllerAdminDeleteExcercises
 */
public class ControllerAdminDeleteExcercises extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteExcercises() {
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
		if(request.getParameter("eid") != null){
			id = Integer.parseInt(request.getParameter("eid"));
		}
		ModelFitnessExcercises mEx = new ModelFitnessExcercises();
		int result = mEx.deleteExcercises(id);
		if(result > 0 ){
			response.sendRedirect(request.getContextPath()+"/admin/indexExcercises?delete=success");
		}
	}

}
