package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.LibraryString;
import bean.FitnessCategory;
import bean.FitnessExcercises;
import bean.Post;
import bean.User;

public class ModelPost {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(id) AS sodong FROM post ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				sodong = rs.getInt("sodong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sodong;
	}
	public ArrayList<Post> getListForPaginator(int offset, int rowCount){
		ArrayList<Post> alPost = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT post.*,category_post.name as name_category FROM post join category_post ON post.category_post_id = category_post.id LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int categoryId = rs.getInt("category_post_id");
				String nameCategory = rs.getString("name_category");
				Post objP = new Post(id, name, image, preview, detail, categoryId, nameCategory);
				alPost.add(objP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPost;
	}
	public int addPost(Post objP){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO post(name,image,preview,detail,category_post_id) VALUES (?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objP.getName());
			pst.setString(2, objP.getImage());
			pst.setString(3, objP.getPreview());
			pst.setString(4, objP.getDetail());
			pst.setInt(5, objP.getCategoryId());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public Post getItem(int pid){
		String sql = "SELECT * FROM `post` WHERE id = ? limit 1";
		Post objP = null;
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			rs = pst.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int categoryId = rs.getInt("category_post_id");
				objP = new Post(id, name, image, preview, detail, categoryId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return objP;
	}
	public int editPost(Post objP){
		int result = 0;
		String sql ="UPDATE post SET name = ? , image = ? , preview = ?, detail = ?,category_post_id = ? WHERE id = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objP.getName());
			pst.setString(2, objP.getImage());
			pst.setString(3, objP.getPreview());
			pst.setString(4, objP.getDetail());
			pst.setInt(5, objP.getCategoryId());
			pst.setInt(6,objP.getId());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				result = 0;
				e.printStackTrace();
			}
		}
		return result;
	}
	public int deletePost(int id){
		int result = 0;
		String sql ="DELETE FROM `post` WHERE id = ? ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<Post> getListForSort(int cid){
		ArrayList<Post> alPost = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT post.*,category_post.name as name_category FROM post join category_post ON post.category_post_id = category_post.id WHERE category_post_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int categoryId = rs.getInt("category_post_id");
				String nameCategory = rs.getString("name_category");
				Post objP = new Post(id, name, image, preview, detail, categoryId, nameCategory);
				alPost.add(objP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPost;
	}
	public ArrayList<Post> getNewsForPublic(){
		ArrayList<Post> alPost = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT post.*,category_post.name as name_category FROM post join category_post ON post.category_post_id = category_post.id WHERE category_post.id = 1 ORDER BY post.id DESC LIMIT 4";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int categoryId = rs.getInt("category_post_id");
				String nameCategory = rs.getString("name_category");
				Post objP = new Post(id, name, image, preview, detail, categoryId, nameCategory);
				alPost.add(objP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPost;
	}
	public ArrayList<Post> getIntroDuceForPuclin(){
		ArrayList<Post> alPost = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT post.*,category_post.name as name_category FROM post join category_post ON post.category_post_id = category_post.id WHERE category_post.id = 2 ORDER BY post.id DESC LIMIT 4";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int categoryId = rs.getInt("category_post_id");
				String nameCategory = rs.getString("name_category");
				Post objP = new Post(id, name, image, preview, detail, categoryId, nameCategory);
				alPost.add(objP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPost;
	}
	public ArrayList<Post> getIntroDuceForDetail(){
		ArrayList<Post> alPost = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT post.*,category_post.name as name_category FROM post join category_post ON post.category_post_id = category_post.id WHERE category_post.id = 2 ORDER BY post.id DESC LIMIT 8";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int categoryId = rs.getInt("category_post_id");
				String nameCategory = rs.getString("name_category");
				Post objP = new Post(id, name, image, preview, detail, categoryId, nameCategory);
				alPost.add(objP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPost;
	}
}
