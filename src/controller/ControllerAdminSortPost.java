package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelPost;
import bean.Post;

/**
 * Servlet implementation class ControllerAdminSortPost
 */

public class ControllerAdminSortPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSortPost() {
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
		if(request.getParameter("submit") != null){
			int cid = 0;
			ArrayList<Post> alPost = new ArrayList<>();
			ModelPost mPost = new ModelPost();
			if(request.getParameter("sortPost") != null){
				cid = Integer.parseInt(request.getParameter("sortPost"));
				alPost = mPost.getListForSort(cid);
				request.setAttribute("alPost", alPost);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/sortPost.jsp");
				rd.forward(request, response);
				}
			}
		}
	}


