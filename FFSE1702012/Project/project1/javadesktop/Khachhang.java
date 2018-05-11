package project1.javadesktop;
	
public class Khachhang {
	private String makh;
	private String hoten;
	private String diachi;
	private String phuong;
	private String quan;
	private String sdt;
	private String email;
	private String mact;
	
	public Khachhang() {
		super();
		// TODO Auto-generated constructor stub
	}
	//ham dung truyen tham so:
	public Khachhang(String makh, String hoten, String diachi, String phuong, String quan, String sdt, String email,
			String mact) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.phuong = phuong;
		this.quan = quan;
		this.sdt = sdt;
		this.email = email;
		this.mact = mact;
	}
	//ham getter va setter:
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getPhuong() {
		return phuong;
	}
	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMact() {
		return mact;
	}
	public void setMact(String mact) {
		this.mact = mact;
	}
	
	
}
