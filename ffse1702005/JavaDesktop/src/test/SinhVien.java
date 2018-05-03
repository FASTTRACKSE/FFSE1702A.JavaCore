package test;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private String id;
	private String name;
	private String age;
	private String lop;
	
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public SinhVien(String id, String name, String age, String lop) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.lop = lop;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
