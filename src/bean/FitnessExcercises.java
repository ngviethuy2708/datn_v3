package bean;

public class FitnessExcercises {
	private int id;
	private String name;
	private String image;
	private String preview;
	private String deatail;
	private String video;
	private String result;
	private int fitnessCategoryId;
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
	public String getDeatail() {
		return deatail;
	}
	public void setDeatail(String deatail) {
		this.deatail = deatail;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getFitnessCategoryId() {
		return fitnessCategoryId;
	}
	public void setFitnessCategoryId(int fitnessCategoryId) {
		this.fitnessCategoryId = fitnessCategoryId;
	}
	public FitnessExcercises(int id, String name, String image, String preview,
			String deatail, String video, String result, int fitnessCategoryId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.preview = preview;
		this.deatail = deatail;
		this.video = video;
		this.result = result;
		this.fitnessCategoryId = fitnessCategoryId;
	}
	public FitnessExcercises() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FitnessExcercises [id=" + id + ", name=" + name + ", image="
				+ image + ", preview=" + preview + ", deatail=" + deatail
				+ ", video=" + video + ", result=" + result
				+ ", fitnessCategoryId=" + fitnessCategoryId + "]";
	}
	
}
