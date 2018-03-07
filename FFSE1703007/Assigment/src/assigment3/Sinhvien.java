package assigment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Sinhvien {
	private String id;
	private String name;
	private int age;
	private String address;
	private float gpa;

	public Sinhvien(String id, String name, int age, String address, float gpa) {
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

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public void display() {
		System.out.println(this.getId() + " | " + this.getName() + " | " + this.getAge() + " | " + this.getAddress()
				+ " | " + this.getGpa());
	}

	public static void main(String[] args) {
		ArrayList<Sinhvien> list = new ArrayList<Sinhvien>();
		Scanner scan = new Scanner(System.in);
		int n = 6;

		while (n != 0) {
			System.out.println("1. Thêm sinh viên. \r\n" + "2. Cập nhật thông tin sinh viên theo ID  .\r\n"
					+ "3. Xóa sinh viên theo ID .\r\n" + "4. Sắp sếp sinh viên theo tên .\r\n"
					+ "5. Hiển thị danh sách sinh viên .\r\n" + "0. Kết thúc chương trình.");
			n = Integer.parseInt(scan.nextLine());
			if (n == 1) {
				System.out.println("Nhập ID sinh viên");
				String id = scan.nextLine();

				System.out.println("Nhập tên sinh viên");
				String name = scan.nextLine();

				System.out.println("Nhập tuổi sinh viên");
				int age = Integer.parseInt(scan.nextLine());

				System.out.println("Nhập địa chỉ sinh viên");
				String address = scan.nextLine();

				System.out.println("Nhập điểm trung bình sinh viên");
				int gpa = Integer.parseInt(scan.nextLine());

				Sinhvien sv = new Sinhvien(id, name, age, address, gpa);
				list.add(sv);
			}

			else if (n == 2) {
				System.out.println("Nhập ID sinh viên");
				String id = scan.nextLine();

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).id.equals(id)) {
						System.out.println("Tên mới: ");
						String name = scan.nextLine();
						list.get(i).setName(name);

						System.out.println("Tuổi mới: ");
						int age = Integer.parseInt(scan.nextLine());
						list.get(i).setAge(age);

						System.out.println("�?ịa chỉ mới: ");
						String address = scan.nextLine();
						list.get(i).setAddress(address);

						System.out.println("�?iểm mới: ");
						float gpa = Float.parseFloat(scan.nextLine());
						list.get(i).setGpa(gpa);
					}
				}

			}

			else if (n == 3) {
				System.out.println("Nhập ID sinh viên");
				String id = scan.nextLine();

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).id.equals(id)) {
						list.remove(i);
						System.out.println("Đã xóa " + id);
					}
				}
			}

			else if (n == 4) {
				Collections.sort(list, new Comparator<Sinhvien>() {
					@Override
					public int compare(Sinhvien sv1, Sinhvien sv2) {
						return sv1.getName().compareTo(sv2.getName());
					}
				});
			}

			else if (n == 5) {
				for (int i = 0; i < list.size(); i++) {
					list.get(i).display();
				}
			}
		}
	}
}
