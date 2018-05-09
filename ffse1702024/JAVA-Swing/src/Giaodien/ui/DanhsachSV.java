package Giaodien.ui;

import java.util.ArrayList;

public class DanhsachSV {
	private ArrayList<SinhVien> ds ;

	public DanhsachSV() {
		super();
		ds = new ArrayList<SinhVien>();
		
	} 
	public boolean themSV(SinhVien sv) {
		if (!ds.contains(sv))
			return  ds.add(sv);
		return false;
	}
	public ArrayList<SinhVien> getDs() {
		return ds;
	}
	public int SoSV() {
		return ds.size();
	}
	public boolean XoaSV(int index) {
		if(index>0 && index<ds.size()-1) {
			ds.remove(index);
			return true;
		}
		else {
		return false;
		}
	}
	public boolean SuaSV(long mssv,String hoten,int tuoi){
		SinhVien sv = new SinhVien(mssv,hoten,tuoi);
		if(ds.contains(sv)) {
			sv.setMssv(mssv);
			sv.setHoten(hoten);
			sv.setTuoi(tuoi);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean KiemTra(long mssv,String hoten,int tuoi) {
		SinhVien sv = new SinhVien(mssv,hoten,tuoi);
		if(ds.contains(sv))
			return true;
		return false;
		
		
	}
}
