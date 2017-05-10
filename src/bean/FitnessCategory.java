package bean;

public class FitnessCategory {
	private int id;
	private String name;
	private int finessCalendarId;
	private String image;
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
	public int getFinessCalendarId() {
		return finessCalendarId;
	}
	public void setFinessCalendarId(int finessCalendarId) {
		this.finessCalendarId = finessCalendarId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public FitnessCategory(int id, String name, int finessCalendarId,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.finessCalendarId = finessCalendarId;
		this.image = image;
	}
	public FitnessCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
