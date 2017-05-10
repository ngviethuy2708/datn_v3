package bean;

import java.sql.Date;

public class Product {
	private int id;
	private String name;
	private String image;
	private String preview;
	private String detail;
	private int quatity;
	private int price_id;
	private int sale_id;
	private int price;
	private int discount;
	private Date from;
	private Date to;
	private float tbc;
	private int currentPrice;
	private int numOfProduct;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	public int getPrice_id() {
		return price_id;
	}
	public void setPrice_id(int price_id) {
		this.price_id = price_id;
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public float getTbc() {
		return tbc;
	}
	public void setTbc(float tbc) {
		this.tbc = tbc;
	}
	
	public int getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getNumOfProduct() {
		return numOfProduct;
	}
	public void setNumOfProduct(int numOfProduct) {
		this.numOfProduct = numOfProduct;
	}
	public Product(int id, String name, String image, String preview,
			String detail, int quatity, int price_id, int sale_id) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.detail = detail;
		this.quatity = quatity;
		this.price_id = price_id;
		this.sale_id = sale_id;
	}
	
	public Product(int id, String name, String image, String preview,
			String detail, int quatity, int price) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.detail = detail;
		this.quatity = quatity;
		this.price = price;
	}
	
	public Product(int id, String name, String image, String preview,
			String detail, int quatity, int price, int discount, Date from,
			Date to) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.detail = detail;
		this.quatity = quatity;
		this.price = price;
		this.discount = discount;
		this.from = from;
		this.to = to;
	}
	
	public Product(int id, String name, String image, String preview,
			String detail, int quatity, int price_id, int sale_id, int price,
			int discount, Date from, Date to) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.detail = detail;
		this.quatity = quatity;
		this.price_id = price_id;
		this.sale_id = sale_id;
		this.price = price;
		this.discount = discount;
		this.from = from;
		this.to = to;
	}
	
	public Product(int id, String name, String image, String preview,
			String detail, int quatity, int price_id, int sale_id, int price) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.detail = detail;
		this.quatity = quatity;
		this.price_id = price_id;
		this.sale_id = sale_id;
		this.price = price;
	}
	public Product(int id, String name, String image, String preview,
			String detail, int quatity, int price_id, int sale_id,float tbc) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.detail = detail;
		this.quatity = quatity;
		this.price_id = price_id;
		this.sale_id = sale_id;
		this.tbc = tbc;
	}
	
	public Product(int id, String name, String image, String preview,
			String detail, int quatity, int price_id, int sale_id,
			int currentPrice, int numOfProduct) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.detail = detail;
		this.quatity = quatity;
		this.price_id = price_id;
		this.sale_id = sale_id;
		this.currentPrice = currentPrice;
		this.numOfProduct = numOfProduct;
	}
	
	public Product(int id) {
		super();
		this.id = id;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image
				+ ", preview=" + preview + ", detail=" + detail + ", quatity="
				+ quatity + ", price_id=" + price_id + ", sale_id=" + sale_id
				+ ", price=" + price + ", discount=" + discount + ", from="
				+ from + ", to=" + to + "]";
	}
	
}
