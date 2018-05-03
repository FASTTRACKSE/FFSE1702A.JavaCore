package Qlsv_UI;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private String id;
	private String name;
	private String age;
	private String cls;
	
	public String getId() {
		return id;
	}
	public SinhVien(String id, String name, String age, String cls) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.cls = cls;
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
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}

}