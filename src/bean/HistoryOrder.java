package bean;

import java.sql.Date;

public class HistoryOrder {
	private int id;
	private int product_id;
	private int current_price;
	private int numOfProduct;
	private Date dateOrder;
	private String nameProduct;
	private int totalPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(int current_price) {
		this.current_price = current_price;
	}
	public int getNumOfProduct() {
		return numOfProduct;
	}
	public void setNumOfProduct(int numOfProduct) {
		this.numOfProduct = numOfProduct;
	}
	public Date getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public HistoryOrder(int id, int product_id, int current_price,
			int numOfProduct, Date dateOrder) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.current_price = current_price;
		this.numOfProduct = numOfProduct;
		this.dateOrder = dateOrder;
	}
	
	public HistoryOrder(int id, int numOfProduct, Date dateOrder,
			String nameProduct, int totalPrice) {
		super();
		this.id = id;
		this.numOfProduct = numOfProduct;
		this.dateOrder = dateOrder;
		this.nameProduct = nameProduct;
		this.totalPrice = totalPrice;
	}
	
	public HistoryOrder(Date dateOrder) {
		super();
		this.dateOrder = dateOrder;
	}
	@Override
	public String toString() {
		return "HistoryOrder [id=" + id + ", product_id=" + product_id
				+ ", current_price=" + current_price + ", numOfProduct="
				+ numOfProduct + ", dateOrder=" + dateOrder + "]";
	}
	
	public HistoryOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}	
