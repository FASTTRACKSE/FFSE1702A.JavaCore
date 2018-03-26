package quanlysinhvien;

import java.util.Scanner;
import java.io.*;

public class SinhVien {
	// Field
	private String id;
	private String name;
	private int age;
	private String address;
	private float avg;

	// Property
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public double getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	// Paramater
	public SinhVien() {
		this("", "", "", 0, 0);
	}

	public SinhVien(String id, String name, String address, int age, float avg) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.avg = avg;

	}

	// Method
	// Check Error
	// public static void printError(Exception ex)
	// {
	// System.out.println("Dữ liệu bạn nhập vào bị lỗi. Lỗi: " + ex.getMessage());
	// }

	// Input data
	public void inputSinhVien() throws Exception {
		

		BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
		
		

		try {
			do {
				System.out.print(
						"\nBạn nhập vào mã sinh viên (mã không được trùng, nhỏ hơn hoặc bằng 10 ký tự và không chứa các ký tự đặc biệt): ");
				setId(inputBuffer.readLine());
			} while (!ThaoTac.checkID(id));

			do {
				System.out.print("Bạn nhập vào họ và tên sinh viên (Lớn hơn hoặc bằng 5 ký tự): ");
				setName(inputBuffer.readLine());
			} while (!ThaoTac.checkFullName(name));

			do {
				System.out.print(
						"Bạn nhập vào địa chỉ cho sinh viên (không được để trống, Lớn hơn hoặc bằng 5 ký tự): ");
				setAddress(inputBuffer.readLine());
			} while (!ThaoTac.checkAddress(address));

			do {
				System.out.print("Bạn nhập vào điểm tuổi cho sinh viên (tuổi phải >= 17 và <= 100): ");
				Scanner input = new Scanner(System.in);
				setAge(input.nextInt());
			} while (!ThaoTac.checkAge(age));

			do {
				System.out.print("Bạn nhập vào điểm trung bình cho sinh viên (điểm trung bình phải >= 0 và <= 10): ");
				Scanner input1 = new Scanner(System.in);
				setAvg(input1.nextFloat());
			} while (!ThaoTac.checkPoint(avg));

			System.out.flush();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void displaySinhVien() throws Exception {
		try {
			System.out.printf(" %-10s | %-35s | %-9s | %-23s | %-24.2f| ", id, name,age, address, avg);
		} catch (Exception ex) {
			throw ex;
		}
	}
}