package object;

public class KhachHang {
	public KhachHang(String maKhackHang, String tenKhachHang, String quan, String phuong, String diaChi, String phone,
			String email, String maCongTo) {
		super();
		this.maKhackHang = maKhackHang;
		this.tenKhachHang = tenKhachHang;
		this.quan = quan;
		this.phuong = phuong;
		this.diaChi = diaChi;
		this.phone = phone;
		this.email = email;
		this.maCongTo = maCongTo;
	}
	public KhachHang() {}

	private String maKhackHang,tenKhachHang,quan,phuong,diaChi,phone,email,maCongTo;

	public String getMaKhackHang() {
		return maKhackHang;
	}

	public void setMaKhackHang(String maKhackHang) {
		this.maKhackHang = maKhackHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}
	
	

}
