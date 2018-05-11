package fasttrack.edu.vn.ui;


import java.io.Serializable;

public class Sinhvien implements Serializable {
	private String id;
	private String name;
	private String age;
	private String clas;
	
	public String getId() {
		return id;
	}
	public Sinhvien(String id, String name, String age, String clas) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.clas = clas;
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
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}

}