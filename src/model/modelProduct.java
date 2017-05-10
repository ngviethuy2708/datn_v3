package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.LibraryString;
import library.TimeConvert;
import bean.HistoryOrder;
import bean.Product;
import bean.Training;

public class modelProduct {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;

	public ArrayList<Product> getList() {
		ArrayList<Product> alPro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM product";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int quatity = rs.getInt("quatity");
				int price_id = rs.getInt("price_id");
				int sale_id = rs.getInt("sale_id");
				Product objPro = new Product(id, name, image, preview, detail,
						quatity, price_id, sale_id);
				alPro.add(objPro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPro;
	}

	public ArrayList<Product> getListForPublic() {
		ArrayList<Product> alPro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT product.*,average_product.average FROM product JOIN average_product ON product.id = average_product.product_id ORDER BY average_product.average DESC LIMIT 4";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int quatity = rs.getInt("quatity");
				int price_id = rs.getInt("price_id");
				int sale_id = rs.getInt("sale_id");
				float average = rs.getFloat("average");
				Product objPro = new Product(id, name, image, preview, detail,
						quatity, price_id, sale_id, average);
				alPro.add(objPro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPro;
	}

	public ArrayList<Product> getListForPaginator(int offset, int rowCount) {
		ArrayList<Product> alPro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM product  LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int quatity = rs.getInt("quatity");
				int price_id = rs.getInt("price_id");
				int sale_id = rs.getInt("sale_id");
				Product objPro = new Product(id, name, image, preview, detail,
						quatity, price_id, sale_id);
				alPro.add(objPro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPro;
	}

	public int getSum() {
		int sodong = 0;
		String sql = "SELECT COUNT(id) AS sodong FROM product ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				sodong = rs.getInt("sodong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public int addItem(Product objProduct) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql = "INSERT INTO product(name,image,preview,detail,quatity,price_id,sale_id) VALUES (?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objProduct.getName());
			pst.setString(2, objProduct.getImage());
			pst.setString(3, objProduct.getPreview());
			pst.setString(4, objProduct.getDetail());
			pst.setInt(5, objProduct.getQuatity());
			pst.setInt(6, objProduct.getPrice_id());
			pst.setInt(7, objProduct.getSale_id());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		} finally {
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

	public int getPriceOfSale(int id) {
		int curent_price = 0;
		int price = 0;
		int discount = 0;
		String from = "";
		String to = "";
		String sql = "SELECT price.price AS price,sale.discount AS discount ,sale.from_date AS from_date, sale.to_date AS to_date FROM product JOIN price ON price.id = product.price_id JOIN sale ON sale.id = product.sale_id WHERE product.id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				price = rs.getInt("price");
				discount = rs.getInt("discount");
				Date fromSql = rs.getDate("from_date");
				java.util.Date fromUtil = TimeConvert.getNormalDate(fromSql);
				from = TimeConvert.getStringDatetime(fromUtil);
				Date toSql = rs.getDate("to_date");
				java.util.Date toUtil = TimeConvert.getNormalDate(toSql);
				to = TimeConvert.getStringDatetime(toUtil);
			}
			if (discount != 0) {
				if (TimeConvert.checkSale(from, to) == true) {
					curent_price = price - ((price * discount) / 100);
				} else {
					curent_price = price;
				}
			} else {
				curent_price = price;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return curent_price;
	}

	public int getDiscount(int id) {
		int discount = 0;
		String from = "";
		String to = "";
		String sql = "SELECT sale.discount AS discount ,sale.from_date AS from_date, sale.to_date AS to_date FROM product JOIN sale ON sale.id = product.sale_id WHERE product.id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				discount = rs.getInt("discount");
				Date fromSql = rs.getDate("from_date");
				java.util.Date fromUtil = TimeConvert.getNormalDate(fromSql);
				from = TimeConvert.getStringDatetime(fromUtil);
				Date toSql = rs.getDate("to_date");
				java.util.Date toUtil = TimeConvert.getNormalDate(toSql);
				to = TimeConvert.getStringDatetime(toUtil);
			}
			if (discount != 0) {
				if (TimeConvert.checkSale(from, to) == true) {
					discount = discount;
				} else {
					discount = 0;
				}
			} else {
				discount = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return discount;
	}

	public int getPrice(int id) {
		int price = 0;
		String sql = "SELECT price.price AS price from product JOIN price ON price.id = product.price_id where product.id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				price = rs.getInt("price");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return price;
	}

	public Product getItem(int id) {
		Product objPro = null;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM product where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int quatity = rs.getInt("quatity");
				int price_id = rs.getInt("price_id");
				int sale_id = rs.getInt("sale_id");
				objPro = new Product(id, name, image, preview, detail, quatity,
						price_id, sale_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objPro;
	}

	public Product getItemNoSale(int id) {
		Product objPro = null;
		conn = mConnect.getConnectSQL();
		String sql = "select product.name,product.image,product.preview,product.detail,product.quatity,product.price_id,product.sale_id,price.price from product join price on product.price_id = price.id  where product.id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int quatity = rs.getInt("quatity");
				int price = rs.getInt("price");
				int price_id = rs.getInt("price_id");
				int sale_id = rs.getInt("sale_id");
				objPro = new Product(id, name, image, preview, detail, quatity,
						price_id, sale_id, price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objPro;
	}

	public Product getItemSale(int id) {
		Product objPro = null;
		conn = mConnect.getConnectSQL();
		String sql = "select product.name,product.image,product.preview,product.detail,product.quatity,product.price_id,product.sale_id,price.price,sale.discount,sale.from_date,sale.to_date from product join price on product.price_id = price.id join sale on product.sale_id = sale.id where product.id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int quatity = rs.getInt("quatity");
				int price_id = rs.getInt("price_id");
				int sale_id = rs.getInt("sale_id");
				int price = rs.getInt("price");
				int discount = rs.getInt("discount");
				Date fromDate = rs.getDate("from_date");
				Date toDate = rs.getDate("to_date");
				objPro = new Product(id, name, image, preview, detail, quatity,
						price_id, sale_id, price, discount, fromDate, toDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objPro;
	}

	public int editItem(Product objProduct) {
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql = "UPDATE product SET name = ?,image = ? ,preview = ?,detail=?, price_id = ? ,sale_id = ? WHERE id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objProduct.getName());
			pst.setString(2, objProduct.getImage());
			pst.setString(3, objProduct.getPreview());
			pst.setString(4, objProduct.getDetail());
			pst.setInt(5, objProduct.getPrice_id());
			pst.setInt(6, objProduct.getSale_id());
			pst.setInt(7, objProduct.getId());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		} finally {
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

	public int addHistoryOrder(HistoryOrder objH) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql = "INSERT INTO history_order(product_id,current_price,number_of_product,date_order) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objH.getProduct_id());
			pst.setInt(2, objH.getCurrent_price());
			pst.setInt(3, objH.getNumOfProduct());
			pst.setDate(4, objH.getDateOrder());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		} finally {
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

	public int editItem(int id, int quatity) {
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql = "UPDATE product SET quatity = ? WHERE id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, quatity);
			pst.setInt(2, id);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		} finally {
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

	public ArrayList<HistoryOrder> getListHistoryForPaginator() {
		ArrayList<HistoryOrder> alH = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT *,sum(history_order.current_price) as price ,sum(history_order.number_of_product) as numOfProduct,product.name as nameProduct FROM `history_order`JOIN product ON history_order.product_id = product.id GROUP BY history_order.product_id,history_order.date_order ORDER BY history_order.date_order DESC ";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int numOfProduct = rs.getInt("numOfProduct");
				Date dateOrder = rs.getDate("date_order");
				String nameProduct = rs.getString("nameProduct");
				int totalPrice = rs.getInt("price");
				HistoryOrder objH = new HistoryOrder(id, numOfProduct,
						dateOrder, nameProduct, totalPrice);
				alH.add(objH);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alH;
	}

	public ArrayList<HistoryOrder> getHistoryOrder() {
		ArrayList<HistoryOrder> alOrder = new ArrayList<>();
		String sql = "SELECT date_order FROM `history_order` GROUP by date_order ORDER BY date_order DESC ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Date dateOrder = rs.getDate("date_order");
				HistoryOrder objOrder = new HistoryOrder(dateOrder);
				alOrder.add(objOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alOrder;
	}

	public ArrayList<HistoryOrder> getHistoryOrderPaginator(int offset,
			int rowCount) {
		ArrayList<HistoryOrder> alOrder = new ArrayList<>();
		String sql = "SELECT date_order FROM `history_order` GROUP by date_order ORDER BY date_order DESC LIMIT ?,?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while (rs.next()) {
				Date dateOrder = rs.getDate("date_order");
				HistoryOrder objOrder = new HistoryOrder(dateOrder);
				alOrder.add(objOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alOrder;
	}

	public ArrayList<Product> getLisProductInOrder(Date dateOrder) {
		ArrayList<Product> alPro = new ArrayList<>();
		String sql = "SELECT p.*,o.* FROM product as p JOIN history_order as o ON p.id = o.product_id WHERE o.date_order = ? GROUP BY o.product_id";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setDate(1, dateOrder);
			;
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				int quatity = rs.getInt("quatity");
				int price_id = rs.getInt("price_id");
				int sale_id = rs.getInt("sale_id");
				int currentPrice = rs.getInt("current_price");
				int numOfProduct = rs.getInt("number_of_product");
				Product objPro = new Product(id, name, image, preview, detail,
						quatity, price_id, sale_id, currentPrice, numOfProduct);
				alPro.add(objPro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPro;
	}

	public ArrayList<Product> getId(String nameProduct) {
		ArrayList<Product> alPro = new ArrayList<>();
		String sql = "Select id from product where name like '%" + nameProduct
				+ "%' ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				Product objPro = new Product(id);
				alPro.add(objPro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alPro;
	}

	public ArrayList<HistoryOrder> getHistoryOrderSearch(
			ArrayList<Product> alPro) {
		ArrayList<HistoryOrder> alOrder = new ArrayList<>();
		for (Product objPro : alPro) {
			String sql = "SELECT date_order FROM `history_order` where product_id = ? GROUP by date_order ORDER BY date_order DESC";
			conn = mConnect.getConnectSQL();
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, objPro.getId());
				rs = pst.executeQuery();
				while (rs.next()) {
					Date dateOrder = rs.getDate("date_order");
					HistoryOrder objOrder = new HistoryOrder(dateOrder);
					if (alOrder.size() == 0) {
						alOrder.add(objOrder);
					} else {
						boolean temp = true;
						for (HistoryOrder objOrder2 : alOrder) {
							if (TimeConvert
									.removeTime(objOrder.getDateOrder())
									.equals(TimeConvert.removeTime(objOrder2
											.getDateOrder()))) {
								temp = false;
								break;
							}
						}
						if (temp) {
							alOrder.add(objOrder);
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return alOrder;
	}
}
