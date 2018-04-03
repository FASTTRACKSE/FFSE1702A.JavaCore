package assignment2.model;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String code, course, name, age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
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
	
	public Student(String code, String name, String age) {
		this.code = code;
		this.name = name;
		this.age = age;
	}
	
	public Student(String code, String course, String name, String age) {
		this.code = code;
		this.course = course;
		this.name = name;
		this.age = age;
	}
	
}
