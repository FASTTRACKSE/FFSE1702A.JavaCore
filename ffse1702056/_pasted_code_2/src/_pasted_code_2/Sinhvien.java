package _pasted_code_2;

import java.util.Scanner;

public class Sinhvien {

		String id;
		String name;
		int age;
		String address;
		float gpa;
		public Sinhvien() {
			super();
			
		}
		public Sinhvien(String id, String name, int age, String address, float gpa) {
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
		public float getGpa() {
			return gpa;
		}
		public void setGpa(float gpa) {
			this.gpa = gpa;
		}
		public void display() {
			System.out.println(this.getId()+"|"+this.getName()+"|"+this.getAge()+"|"+this.getAddress()+"|"+this.getGpa());
			
			}

		
		public static void main(String[] args) {
		int control = 6;
		Sinhvien[] listSv = new Sinhvien[50];
		int soluong = 0;
		do {
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Cập nhật thông tin sinh viên theo ID ");
			System.out.println("3. Xóa sinh viên theo ID ");
			System.out.println("4. Sắp sếp sinh viên theo tên ");
			System.out.println("5. Hiển thị danh sách sinh viên");
			System.out.println("0. Kết thúc chương trình.");
			
			System.out.println("chon chuc nang so");
			Scanner scanner=new Scanner(System.in);
			
			control = Integer.parseInt(scanner.nextLine());
			
			if(control==1) {
				System.out.println("Ban muon nhap bao nhieu sinh vien");
				soluong = Integer.parseInt(scanner.nextLine());
				
				for (int i = 0;i < soluong;i++) {
					int dem = i+1;
					System.out.println("Nhap sinh vien" + dem);
					Sinhvien sv = new Sinhvien();
					
					System.out.println("nhap ID cho sinh vien ");
					String id = scanner.nextLine();
					sv.setId(id);
					
					System.out.println("nhap ten sinh vien");
					String name = scanner.nextLine();
					sv.setName(name);
					
					System.out.println("nhap tuoi sinh vien");
					int age = Integer.parseInt(scanner.nextLine());
					sv.setAge(age);
					
					System.out.println("nhap dia chi sinh vien");
					String address = scanner.nextLine();
					sv.setAddress(address);
					
					System.out.println("nhap diem trung binh sinh vien");
					int gpa = Integer.parseInt(scanner.nextLine());
					sv.setGpa(gpa);
					
					
					
				}
			}
			else if(control ==5) {
				for(int i=0;i<soluong;i++) {
					listSv[i].display();
					
				}
			}

		}
		while (control !=0);
		
	}
	}



