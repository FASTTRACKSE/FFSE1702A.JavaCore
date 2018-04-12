package namdv.model;

public class Sach {
	private int id, nhaXuatBan, theLoaiSach, namXuanBan, soLuongTong, soLuongKho;
	private String ten, tacGia;

	public Sach() {
		super();
	}

	public Sach(int id, int nhaXuatBan, int theLoaiSach, int namXuanBan, int soLuongTong, int soLuongKho, String ten,
			String tacGia) {
		super();
		this.id = id;
		this.nhaXuatBan = nhaXuatBan;
		this.theLoaiSach = theLoaiSach;
		this.namXuanBan = namXuanBan;
		this.soLuongTong = soLuongTong;
		this.soLuongKho = soLuongKho;
		this.ten = ten;
		this.tacGia = tacGia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(int nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getTheLoaiSach() {
		return theLoaiSach;
	}

	public void setTheLoaiSach(int theLoaiSach) {
		this.theLoaiSach = theLoaiSach;
	}

	public int getNamXuanBan() {
		return namXuanBan;
	}

	public void setNamXuanBan(int namXuanBan) {
		this.namXuanBan = namXuanBan;
	}

	public int getSoLuongTong() {
		return soLuongTong;
	}

	public void setSoLuongTong(int soLuongTong) {
		this.soLuongTong = soLuongTong;
	}

	public int getSoLuongKho() {
		return soLuongKho;
	}

	public void setSoLuongKho(int soLuongKho) {
		this.soLuongKho = soLuongKho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

}
