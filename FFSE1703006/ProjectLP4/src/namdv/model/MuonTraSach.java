package namdv.model;

public class MuonTraSach {
	private int idMuonTra, idBanDoc;
	private String maSachMuon, ngayMuon, ngayTra;

	public MuonTraSach() {
		super();
	}

	public MuonTraSach(int idMuonTra, int idBanDoc, String maSachMuon, String ngayMuon) {
		super();
		this.idMuonTra = idMuonTra;
		this.idBanDoc = idBanDoc;
		this.ngayMuon = ngayMuon;
		this.maSachMuon = maSachMuon;
	}

	public int getId() {
		return idMuonTra;
	}

	public void setId(int idMuonTra) {
		this.idMuonTra = idMuonTra;
	}

	public int getMaThanhVien() {
		return idBanDoc;
	}

	public void setMaThanhVien(int idBanDoc) {
		this.idBanDoc = idBanDoc;
	}

	public String getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(String ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public String getMaSachMuon() {
		return maSachMuon;
	}

	public void setMaSachMuon(String maSachMuon) {
		this.maSachMuon = maSachMuon;
	}

	public String getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}

}
