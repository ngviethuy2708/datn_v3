package bean;

public class Post {
	private int id;
	private String name;
	private String image;
	private String preview;
	private String detail;
	private int categoryId;
	private String nameCategory;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public Post(int id, String name, String image, String preview,
			String detail, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.detail = detail;
		this.categoryId = categoryId;
	}
	
	public Post(int id, String name, String image, String preview,
			String detail, int categoryId, String nameCategory) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.detail = detail;
		this.categoryId = categoryId;
		this.nameCategory = nameCategory;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", image=" + image
				+ ", preview=" + preview + ", detail=" + detail
				+ ", categoryId=" + categoryId + ", nameCategory="
				+ nameCategory + "]";
	}
	
}
