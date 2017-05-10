package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;










import library.LibraryString;
import bean.SearchForDate;
import bean.Search;
import bean.User;


public class ModelUser {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<User> getList(){
		ArrayList<User> alUsers = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM user";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				Date birthDay = rs.getDate("Birth_day");
				String addDress = rs.getString("address");
				String phoneNumber = rs.getString("phone");
				boolean isMember = rs.getBoolean("is_member");
				User objUser = new User(id, userName, passWord, fullName, birthDay, addDress, phoneNumber, isMember);
				alUsers.add(objUser);
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
		return alUsers;
	}
	public int addItem(User objUsers){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO user(user_name,pass_word,full_name,Birth_day,address,phone,is_member) VALUES (?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUsers.getUserName());
			pst.setString(2,lib.md5(objUsers.getPassWord()));
			pst.setString(3, objUsers.getFullName());
			pst.setDate(4, objUsers.getBirthDay());
			pst.setString(5, objUsers.getAddDress());
			pst.setString(6, objUsers.getPhoneNumber());
			pst.setBoolean(7, false);
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
	
	public int delItem(int uid){
		int result = 0;
		String sql = "DELETE FROM user WHERE id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
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
	
	public User getItem(int uid){
		User objUser = null;
		String sql = "SELECT * FROM user WHERE id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs = pst.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				Date birthDay = rs.getDate("birth_day");
				String addDress = rs.getString("address");
				String phoneNumber = rs.getString("phone");
				boolean isMember = rs.getBoolean("is_member");
				objUser = new User(id, userName, passWord, fullName, birthDay, addDress, phoneNumber, isMember);
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
		return objUser;
	}
	
	public int editItem(User objUsers){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE user SET user_name = ?,pass_word = ?, full_name = ?, birth_day = ?,address = ?,phone = ? WHERE id = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUsers.getUserName());
			pst.setString(2,objUsers.getPassWord());
			pst.setString(3, objUsers.getFullName());
			pst.setDate(4, objUsers.getBirthDay());
			pst.setString(5, objUsers.getAddDress());
			pst.setString(6, objUsers.getPhoneNumber());
			pst.setInt(7, objUsers.getId());
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
	/*public int editItemForRegister(int IdUsers){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE users SET Isregister = 1 WHERE Idusers = ? ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, IdUsers);
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
	}*/
	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(id) AS sodong FROM user ";
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
	public ArrayList<User> getListForPaginator(int offset, int rowCount){
		ArrayList<User> alUser = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM user  LIMIT ?,? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				Date birthDay = rs.getDate("Birth_day");
				String addDress = rs.getString("address");
				String phoneNumber = rs.getString("phone");
				boolean isMember = rs.getBoolean("is_member");
				User objUser = new User(id, userName, passWord, fullName, birthDay, addDress, phoneNumber, isMember);
				alUser.add(objUser);
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
		return alUser;
	}
	public ArrayList<User> getListForSearch(Search item){
		ArrayList<User> alUser = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "select * from user where (is_member = '"+item.getType()+"' and  user_name like '%"+item.getSomething()+"%') or (is_member = '"+item.getType()+"' and  full_name like '%"+item.getSomething()+"%')";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				Date birthDay = rs.getDate("Birth_day");
				String addDress = rs.getString("address");
				String phoneNumber = rs.getString("phone");
				boolean isMember = rs.getBoolean("is_member");
				User objUser = new User(id, userName, passWord, fullName, birthDay, addDress, phoneNumber, isMember);
				alUser.add(objUser);
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
		return alUser;
	}
	public ArrayList<User> getListForSearchDate(SearchForDate item){
		ArrayList<User> alUser = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "select * from user where (is_member = '"+item.getType()+"' and  birth_day = '"+item.getDate()+"') ";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String fullName = rs.getString("full_name");
				Date birthDay = rs.getDate("birth_day");
				String addDress = rs.getString("address");
				String phoneNumber = rs.getString("phone");
				boolean isMember = rs.getBoolean("is_member");
				User objUser = new User(id, userName, passWord, fullName, birthDay, addDress, phoneNumber, isMember);
				alUser.add(objUser);
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
		return alUser;
	}
	public int setActive(int id) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			String sql = "UPDATE user SET is_member = 1 WHERE id =?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
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
	/*public int editItemForEnddate(int IdUsers){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE users SET Isregister = 0 WHERE Idusers = ? ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, IdUsers);
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
	}*/
	public User getUserByUserPass(String username, String password) {
		User objUsers = null;
		String sql = "SELECT * FROM user WHERE user_name = ? && pass_word = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, LibraryString.md5(password));
			rs = pst.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String fullName = rs.getString("full_name");
				String  userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				Date birthDay = rs.getDate("birth_day");
				String addDress = rs.getString("address");
				String phoneNumber = rs.getString("phone");
				boolean isMember = rs.getBoolean("is_member");
				objUsers = new User(id, userName, passWord, fullName, birthDay, addDress, phoneNumber, isMember);
			}else{
				System.out.println("abc");
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
		return objUsers;
		
	}
}
