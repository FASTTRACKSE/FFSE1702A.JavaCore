package object;

public class BienLai implements Comparable<BienLai> {
	private String maCongTo,ngayNhap,chuKyNhap;
	private int chiSoCongTo;
	private int soDienTieuThu;
	private int month;
	private int year;
	private int chiSoCu;
	private static double tongTien;
	
	
	
	public BienLai(String maCongTo, String ngayNhap, String chuKyNhap, int chiSoCongTo, int month, int year,
			int chiSoCu) {
		super();
		this.maCongTo = maCongTo;
		this.ngayNhap = ngayNhap;
		this.chuKyNhap = chuKyNhap;
		this.chiSoCongTo = chiSoCongTo;
		this.month = month;
		this.year = year;
		this.chiSoCu = chiSoCu;
	}

	
	public int getChiSoCu() {
		return chiSoCu;
	}


	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}
	
	
	public String getMaCongTo() {
		return maCongTo;
	}


	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}


	public String getNgayNhap() {
		return ngayNhap;
	}


	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}


	public String getChuKyNhap() {
		return chuKyNhap;
	}


	public void setChuKyNhap(String chuKyNhap) {
		this.chuKyNhap = chuKyNhap;
	}


	public int getChiSoCongTo() {
		return chiSoCongTo;
	}


	public void setChiSoCongTo(int chiSoCongTo) {
		this.chiSoCongTo = chiSoCongTo;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public static double tinhTien(int soDienTieuThu) {
		if(soDienTieuThu==0) {
			tongTien=0;
		}

		else if (soDienTieuThu<=50 && soDienTieuThu >0) {
			tongTien=soDienTieuThu*1549;
		}
		else if (soDienTieuThu<=100 && soDienTieuThu >50) {
			tongTien=(soDienTieuThu-50)*1600+50*1549;
		}
		else if (soDienTieuThu<=200 && soDienTieuThu >100) {
			tongTien=(soDienTieuThu-100)*1858+50*1600+50*1549;
		}
		else if (soDienTieuThu<=300 && soDienTieuThu >200) {
			tongTien=(soDienTieuThu-200)*2340+100*1858+50*1600+50*1549;
		}
		else if (soDienTieuThu<=400 && soDienTieuThu >300) {
			tongTien=(soDienTieuThu-300)*2615+100*2340+100*1858+50*1600+50*1549;
		}
		else if (soDienTieuThu >400) {
			tongTien=(soDienTieuThu-400)*2701+100*2615+100*2340+100*1858+50*1600+50*1549;
		}
		return tongTien;
	}
	public int compareTo(BienLai bienlai) {
		
		if (year == bienlai.year) {
			if(month==bienlai.month) {
				return 0;
			}
			else if(month>bienlai.month) {
				return 1;
			}
			else {
				return 1;
			}
			
		}
			
		else if (year > bienlai.year)
			return 1;
		else
			return -1;
	}
	
	

}
