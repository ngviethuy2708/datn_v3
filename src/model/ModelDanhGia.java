package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.AverageProduct;
import bean.DanhGia;
import bean.Product;

public class ModelDanhGia {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<DanhGia> getList(){
		ArrayList<DanhGia> alDanhGia = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="select * from product_rate";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idDanhGia = rs.getInt("id");
				int idUsers = rs.getInt("user_id");
				int idProducts = rs.getInt("product_id");
				int danhGia = rs.getInt("rate");
				DanhGia objDanhGia = new DanhGia(idDanhGia, idUsers, idProducts, danhGia);
				alDanhGia.add(objDanhGia);
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
		return alDanhGia;
	}
	public int getIdProductMax(){
		int id = 0;
		String sql = "SELECT id FROM product WHERE id=(SELECT max(id) FROM product)";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				id = rs.getInt("id");
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
		return id;
	}
	public int getIdUserMax(){
		int id = 0;
		String sql = "SELECT id FROM user WHERE id=(SELECT max(id) FROM user)";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				id = rs.getInt("id");
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
		return id;
	}
	public int countRate(int userId , int productId ){
		int sodanhgia = 0;
		String sql ="SELECT COUNT(id) AS sodanhgia FROM product_rate where user_id = ? and product_id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, productId);
			rs = pst.executeQuery();
			if(rs.next()){
				sodanhgia = rs.getInt("sodanhgia");
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
		return sodanhgia;
	}
	public int addItem(DanhGia objDanhGia){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO product_rate(user_id,product_id,rate) VALUES (?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objDanhGia.getIdUsers());
			pst.setInt(2, objDanhGia.getIdProducts());
			pst.setFloat(3, objDanhGia.getDanhgia());
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
	public int deleteItem(){
		int result = 0;
		String sql = "DELETE FROM average_product";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
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
	public int addAverage(AverageProduct objDanhGia){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO average_product(product_id,average) VALUES (?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objDanhGia.getProductId());
			pst.setFloat(2, objDanhGia.getAverage());
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
	public int editItem(DanhGia objDanhGia){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="UPDATE product_rate SET rate = ? where user_id = ? and product_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setFloat(1, objDanhGia.getDanhgia());
			pst.setInt(2, objDanhGia.getIdUsers());
			pst.setInt(3,objDanhGia.getIdProducts());
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
}
