package as1;
import java.util.Scanner;
public class Sinhvien {
	private String id;
	private String name;
	private int age;
	private String address;
	private float gpa;
	public Sinhvien() {
		
	}
	public Sinhvien(String id, String name, int age, String address, float gpa) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.address=address;
		this.gpa=gpa;
		
	}
	public void setAge(int age) {
		if(age<=100) {
			this.age=age;
		}
	}
}