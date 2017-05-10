package bean;

public class DanhGia {
	int idDanhGia;
	int idUsers;
	int idProducts;
	float danhgia;
	public int getIdDanhGia() {
		return idDanhGia;
	}
	public void setIdDanhGia(int idDanhGia) {
		this.idDanhGia = idDanhGia;
	}
	public int getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}
	public int getIdProducts() {
		return idProducts;
	}
	public void setIdProducts(int idProducts) {
		this.idProducts = idProducts;
	}
	
	
	public float getDanhgia() {
		return danhgia;
	}
	public void setDanhgia(float danhgia) {
		this.danhgia = danhgia;
	}
	public DanhGia(int idDanhGia, int idUsers, int idProducts, float danhgia) {
		super();
		this.idDanhGia = idDanhGia;
		this.idUsers = idUsers;
		this.idProducts = idProducts;
		this.danhgia = danhgia;
	}
	public DanhGia() {
		super();
	}
	@Override
	public String toString() {
		return "DanhGia [idDanhGia=" + idDanhGia + ", idUsers=" + idUsers
				+ ", idProducts=" + idProducts + ", danhgia=" + danhgia + "]";
	}
	
}
