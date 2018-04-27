package ketnoidatabase;

public class Student {
	private int id;
	private String name;
	private int poin;
	public Student() {
		
	}
	public Student(int id, String name, int poin) {
		super();
		this.id = id;
		this.name = name;
		this.poin = poin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoin() {
		return poin;
	}
	public void setPoin(int poin) {
		this.poin = poin;
	}

}