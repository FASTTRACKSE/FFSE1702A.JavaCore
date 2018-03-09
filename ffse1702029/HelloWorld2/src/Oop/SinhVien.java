package Oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SinhVien {
	private String id;
	private String name;
	private int age;
	private String address;
	private float gpa;
	public SinhVien() {}
	public SinhVien(String id, String name, int age, String address, float gpa) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
	}

	public void setAge(int age) {
		if (age <= 120) {
			this.age = age;sq
		} else
			System.out.println("tuổi k đúng");

	}

	public int getAge() {
		return age;
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

	public static void main(String arg[]) {
		// menu
		Scanner scan = new Scanner(System.in);
		int n = 1;
		
		ArrayList<SinhVien> sinhvien = new ArrayList();
		while (n != 0) {
			System.out.println("*********************************");
			System.out.println("1.Thêm sinh viên");
			System.out.println("2.Cập nhật thông tin sinh viên theo ID");
			System.out.println("3.Xóa sinh viên theo ID");
			System.out.println("4.Sắp sếp sinh viên theo tên");
			System.out.println("5.Hiển thị danh sách sinh viên");
			System.out.println("0.Kết thúc chương trình");
			System.out.println("*********************************");
			System.out.print("Chọn chức năng số: ");

			n = scan.nextInt();

			// Khai bao mang sinh vien voi ten la sinhvien
			Scanner scanner = new Scanner(System.in);

			if (n == 1) {
				System.out.println("ban muon nhap bao nhieu sinh viên?");
				int number = Integer.parseInt(scanner.nextLine());
				
				for(int i=0; i<number; i++) {
					int dem =i+1;
				System.out.println("số sinh viên: "+ dem);
				SinhVien sv = new SinhVien();
				
				System.out.println("Nhập ID sinh viên");
				String id = scanner.nextLine();
				sv.setId(id);

				System.out.println("Nhập tên sinh viên");
				String name = scanner.nextLine();
				sv.setName(name);

				System.out.println("Nhập tuổi sinh viên");
				int age = Integer.parseInt(scanner.nextLine());
				sv.setAge(age);

				System.out.println("Nhập địa chỉ sinh viên");
				String address = scanner.nextLine();
				sv.setAddress(address);

				System.out.println("Nhập điểm trung bình sinh viên");
				float gpa = Float.parseFloat(scanner.nextLine());
				sv.setGpa(gpa);
				
				sinhvien.add(sv);
				
				
				}
			}
			if (n == 2) {
				System.out.print("Nhap ID can tim: ");
				String id = scanner.nextLine();
				
				for (int i = 0; i < sinhvien.size(); i++) {
					if(sinhvien.get(i).getId().equals(id)) {
						//nhap ten moi
						System.out.println("sua ten ");
						String name = scanner.nextLine();
						sinhvien.get(i).setName(name);
						
						System.out.println("sua tuoi");
						int age = Integer.parseInt(scanner.nextLine());
						sinhvien.get(i).setAge(age);
						
						System.out.println("sua dia chi");
						String address = scanner.nextLine();
						sinhvien.get(i).setAddress(address);
						
						System.out.println("sua diem trung binh");
						float gpa = Float.parseFloat(scanner.nextLine());
						sinhvien.get(i).setGpa(gpa);
						
					}else System.out.println("id k có");
				}
			}
			if (n == 3) {
					System.out.print("Nhap ID can xóa: ");
					String id = scanner.nextLine();
					
					for (int i = 0; i < sinhvien.size(); i++) {
						if(sinhvien.get(i).getId().equals(id)) {
							sinhvien.remove(i);
						}
					}
			}
			if (n == 4) {
				Collections.sort(sinhvien, new Comparator<SinhVien>() {
					public int compare(SinhVien sv1, SinhVien sv2) {
						return (sv1.name.compareTo(sv2.name));
						// return (sv2.hoTen.compareTo(sv1.hoTen));
					}
				});

				System.out.println("Danh sách sắp xếp theo tên trong bảng chữ cái a - b - c: ");
				for (int i = 0; i < sinhvien.size(); i++) {
					System.out.println("Tên: " + sinhvien.get(i).name +"|"+ "age: " + sinhvien.get(i).getAge() + "|"+" Điểm: "
							+ sinhvien.get(i).gpa);
				}
			}
			if (n == 5) {
				for (int i = 0; i < sinhvien.size(); i++) {
					System.out.println("id: " + sinhvien.get(i).getId() + "|" + "name: " + sinhvien.get(i).getName()
							+ "|" + "age: " + sinhvien.get(i).getAge() + "|" + "address: "
							+ sinhvien.get(i).getAddress() + "|" + "gpa: " + sinhvien.get(i).getGpa());
				}
			}
		}
	}
}
