package bean;

public class Price {
	private int id;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Price(int id, int price) {
		super();
		this.id = id;
		this.price = price;
	}
	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}
}
