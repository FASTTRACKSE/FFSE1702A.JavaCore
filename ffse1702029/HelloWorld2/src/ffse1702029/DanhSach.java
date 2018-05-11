package ffse1702029;

import java.util.ArrayList;

public class DanhSach {
	private ArrayList<SinhVien> ds;
	
	public DanhSach() {
		super();
		ds = new ArrayList<SinhVien>();
	}
	public boolean them(SinhVien sv) {
		if(!ds.contains(sv))
			return ds.add(sv);
		return false;
	}
	public ArrayList<SinhVien> getDs(){
		return ds;
	}
	public int soSV() {
		return ds.size();
	}
	public boolean xoaSV(int index) {
		if(index>0 && index<ds.size()-1) {
			ds.remove(index);
			return true;
		}else {
		return false;
		}
	}
	public boolean suaSV(String ms, String ht, int tuoi, String email) {
		SinhVien sv = new SinhVien(ms, ht, tuoi, email);
		if(ds.contains(sv)) {
			sv.setMs(ms);
			sv.setHt(ht);
			sv.setTuoi(tuoi);
			sv.setEmail(email);
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		
		
	}
}
