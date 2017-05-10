package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import library.TimeConvert;
import model.ModelFitnessExcercises;
import model.ModelPost;
import model.ModelPrice;
import model.ModelSale;
import model.ModelTraining;
import model.ModelUser;
import bean.FitnessExcercises;
import bean.Post;
import bean.Price;
import bean.Sale;
import bean.Training;
import bean.User;

/**
 * Servlet implementation class ControllerAdminAddUsers
 */

public class ControllerAdminEditPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditPost() {
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
		ModelPost mPost = new ModelPost();
		int pid = 0;
		if("load".equals(request.getParameter("type"))){
			if(request.getParameter("pid") != null){
				pid = Integer.parseInt(request.getParameter("pid"));
			}
			System.out.println(pid);
			request.setAttribute("objPost", mPost.getItem(pid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editPost.jsp");
			rd.forward(request, response);
		}else{
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);
			List<FileItem> fileItems = null;
			try {
				fileItems = sfu.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = "";
			String preview = "";
			String detail = "";
			int cid = 0;
			int id = 0;
			String picture = "";
			String pictureNew = "";
			String pictureOld = "";
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					String fileName = fileItem.getFieldName();
					String fileValue = new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8");
					switch (fileName) {
					case "name":
						name = fileValue;
						break;
					case "preview":
						preview = fileValue;
						break;
					case "detail":
						detail = fileValue;
						break;
					case "typePost":
						cid  = Integer.parseInt(fileValue);
						break;
					case "pictureOld":
						pictureOld  = fileValue;
						break;
					case "pid":
						id = Integer.parseInt(fileValue);
						break;
					default:
						break;
					}
				}else{ // nếu là file
					picture = fileItem.getName();
					if(!picture.isEmpty()){ // có upload
						// đổi tên ảnh
						pictureNew = FilenameUtils.getBaseName(picture) + System.nanoTime() + "." + FilenameUtils.getExtension(picture);
						String filePath = request.getServletContext().getRealPath("")+ File.separator + "files" + File.separator + pictureNew;
						File file = new File(filePath);
						try {
							fileItem.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(request.getServletContext().getRealPath(""));
					}else{
						pictureNew = pictureOld;
					}
			
				}
			}
			Post objPost = new Post(id, name, pictureNew, preview, detail, cid);
			int value = mPost.editPost(objPost);
			if(value > 0){
				response.sendRedirect(request.getContextPath() + "/admin/indexPost?edit=success");
				return ;
			}
		}
	}
}
