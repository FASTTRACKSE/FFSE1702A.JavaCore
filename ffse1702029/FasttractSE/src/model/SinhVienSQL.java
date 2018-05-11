package model;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

public class SinhVienSQL {
	Connection conn= getConnect("localhost", "ffse1702029", "ffse1702029","12345");
	PreparedStatement ptmt = null;

	String masv, name, lop, ngaysinh, address, phone, email, pass, nam_hoc, xep_loai;
	int diem_cn, diem_ta;

public SinhVienSQL(String masv, String name, String lop, String ngaysinh, String address, String phone, String email,
		String pass, String nam_hoc, String xep_loai, int diem_cn, int diem_ta) {
	super();
	this.masv = masv;
	this.name = name;
	this.lop = lop;
	this.ngaysinh = ngaysinh;
	this.address = address;
	this.phone = phone;
	this.email = email;
	this.pass = pass;
	this.nam_hoc = nam_hoc;
	this.xep_loai = xep_loai;
	this.diem_cn = diem_cn;
	this.diem_ta = diem_ta;
}

private Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd) {
	// TODO Auto-generated method stub
	return null;
}

public String getMasv() {
	return masv;
}

public void setMasv(String masv) {
	this.masv = masv;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLop() {
	return lop;
}

public void setLop(String lop) {
	this.lop = lop;
}

public String getNgaysinh() {
	return ngaysinh;
}

public void setNgaysinh(String ngaysinh) {
	this.ngaysinh = ngaysinh;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
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

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getNam_hoc() {
	return nam_hoc;
}

public void setNam_hoc(String nam_hoc) {
	this.nam_hoc = nam_hoc;
}

public String getXep_loai() {
	return xep_loai;
}

public void setXep_loai(String xep_loai) {
	this.xep_loai = xep_loai;
}

public int getDiem_cn() {
	return diem_cn;
}

public void setDiem_cn(int diem_cn) {
	this.diem_cn = diem_cn;
}

public int getDiem_ta() {
	return diem_ta;
}

public void setDiem_ta(int diem_ta) {
	this.diem_ta = diem_ta;
}
}