package assignment_7;

import java.util.Scanner;
import java.util.Comparator;

public class SinhVien {
	private String id;
	private String name;
	private int age;
	private String address;
	private double gpa;
	private Scanner scanner;

	public SinhVien() {
		super();
	}

	public SinhVien(String id, String name, int age, String address, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
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

	public static Comparator<SinhVien> sortByName = new Comparator<SinhVien>() {
		public int compare(SinhVien sv1, SinhVien sv2) {
			return sv1.name.compareTo(sv2.name);
		}
	};

	public static Comparator<SinhVien> sortByGPA = new Comparator<SinhVien>() {
		public int compare(SinhVien sv1, SinhVien sv2) {
			return Double.compare(sv2.gpa, sv1.gpa);
		}
	};

	public void nhap() {
		scanner = new Scanner(System.in);
		System.out.print("Nhập id sinh viên\t: ");
		id = scanner.nextLine();
		System.out.print("Nhập tên sinh viên\t: ");
		name = scanner.nextLine();
		System.out.print("Nhập tuổi sinh viên\t: ");
		age = Integer.parseInt(scanner.nextLine());
		System.out.print("Nhập địa chỉ sinh viên\t: ");
		address = scanner.nextLine();
		System.out.print("Nhập điểm trung bình\t: ");
		gpa = scanner.nextDouble();
		System.out.println("--------------------------------------------");
	}

	public void xuat() {
		System.out.printf("| %-6s | %-20s | %-3s | %-20s | %4s |\n", id, name, age, address, gpa);
	}
}
