package library;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

public class LibraryPerPuclic {
	public static boolean isLogin(HttpServletRequest request, HttpServletResponse response){
		HttpSession ss = request.getSession();
		User objUser = (User)ss.getAttribute("objUser");
		if(objUser == null ){
			try {
					response.sendRedirect(request.getContextPath()+"/index");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
}
