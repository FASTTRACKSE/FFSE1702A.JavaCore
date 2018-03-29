package Qlsv_ui;

import java.io.Serializable;

public class SinhVien implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String age;
	private String cls;

	public String getID() {
		return id;
	}

	public void setID(String id) {
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

	public void set(String age) {
		this.cls = cls;
	}

	public SinhVien(String id, String name, String age, String cls) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.cls = cls;
	}
}