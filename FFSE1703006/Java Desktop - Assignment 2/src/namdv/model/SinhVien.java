package namdv.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private static final long serialVersionUID = 1L;
	private String lopSV, maSV, tenSV, tuoiSV;

	public SinhVien() {
		super();
	}

	public SinhVien(String lopSV, String maSV, String tenSV, String tuoiSV) {
		super();
		this.lopSV = lopSV;
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.tuoiSV = tuoiSV;
	}

	public String getLopSV() {
		return lopSV;
	}

	public void setLopSV(String lopSV) {
		this.lopSV = lopSV;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getTuoiSV() {
		return tuoiSV;
	}

	public void setTuoiSV(String tuoiSV) {
		this.tuoiSV = tuoiSV;
	}

}
