package bean;

public class Search {
	private String type;
	private String something;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSomething() {
		return something;
	}
	public void setSomething(String something) {
		this.something = something;
	}
	public Search(String type, String something) {
		super();
		this.type = type;
		this.something = something;
	}
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
