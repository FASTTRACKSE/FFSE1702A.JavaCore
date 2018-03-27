package assignment3;

import java.util.Comparator;
import java.util.Scanner;

public class Student {
	
	private String id, name, address;
	private int age;
	private double gpa;
	private Scanner input;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "|ID:  " + id + " |Name:  " + name + " |Age:  " + age
				+ " |Add: " + address + " |GPA: " + gpa + " |";
	}
	
	public void setStudent() {
		input = new Scanner(System.in);
		System.out.print("Nhập ID sinh viên: ");
		id = input.nextLine();
		System.out.print("Nhập tên sinh viên: ");
		name = input.nextLine();
		System.out.print("Nhập tuổi sinh viên: ");
		age = Integer.parseInt(input.nextLine());
		System.out.print("Nhập địa chỉ sinh viên: ");
		address = input.nextLine();
		System.out.print("Nhập điểm trung bình: ");
		gpa = Double.parseDouble(input.nextLine());
	}
	
	public static Comparator<Student> sortByName = new Comparator<Student>() {
		public int compare(Student st1, Student st2) {
			return st1.name.compareTo(st2.name);
		}
	};
}
