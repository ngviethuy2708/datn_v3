package controller;

import java.io.IOException;
import java.util.Date;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import library.LibraryString;
import library.TimeConvert;
import model.ModelUser;

/**
 * Servlet implementation class ControllerEditUsers
 */

public class ControllerEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEditUser() {
        super();
        
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
		TimeConvert cv = new TimeConvert();
		int uid = 0;
		if(request.getParameter("uid") != null){
			uid = Integer.parseInt( request.getParameter("uid"));
		}
		if(request.getParameter("submit") != null){
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			String fullName = request.getParameter("fullName");
			fullName = new String(fullName.getBytes("ISO-8859-1"), "UTF-8");
			String date = request.getParameter("birthDay");
			java.util.Date date_until = TimeConvert.getDateTime(date);
			java.sql.Date birthDay = TimeConvert.getSqlDate(date_until);
			String addDress = request.getParameter("address");
			addDress = new String(addDress.getBytes("ISO-8859-1"), "UTF-8");
			String phoneNumber = request.getParameter("phoneNumber");
			User objUser = new User(uid, userName, passWord, fullName, birthDay, addDress,phoneNumber);
			if(mUser.editItem(objUser)>0){
				HttpSession ss = request.getSession();
				User objUserss = (User)ss.getAttribute("objUser");
				boolean isMember = objUserss.isMember();
				ss.removeAttribute("objUser");
				objUser.setMember(isMember);
				ss.setAttribute("objUser", objUser);
				response.sendRedirect(request.getContextPath()+"/index?edit=success");
			}else{
				response.sendRedirect(request.getContextPath()+"/index");
			}
		}
	}

}
