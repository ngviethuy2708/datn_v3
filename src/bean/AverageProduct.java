package bean;

public class AverageProduct {
	private int id;
	private int productId;
	private float average;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public AverageProduct(int id, int productId, float average) {
		super();
		this.id = id;
		this.productId = productId;
		this.average = average;
	}
	@Override
	public String toString() {
		return "AverageProduct [id=" + id + ", productId=" + productId
				+ ", average=" + average + "]";
	}
	
	
}
