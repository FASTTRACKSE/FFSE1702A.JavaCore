package QLSV;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sinhvien {
	private int age;
	private String id, name, address;
	private float gpa;

	//	Khoi tao khong tham so
	public Sinhvien() {
		
	}
	
	// Khoi tao 1 doi tuong sinh vien
	public Sinhvien(String id, String name, String address, int age, float gpa) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.gpa = gpa;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public static void main(String[] args) {
		System.out.println("-----------menu------------");
        System.out.println("1. Them sinh vien");
		System.out.println("2. Cap nhat thong tin sinh vien theo ID");
		System.out.println("3. Xoa sinh vien");
		System.out.println("4. Sap xep sinh vien theo ten");
		System.out.println("5. Hien thi danh sach sinh vien");
		System.out.println("6. Ket thuc chuong trinh");
        System.out.println("---------------------------");
        System.out.println("Please choose: ");
	        

		ArrayList<Sinhvien> SV = new ArrayList<Sinhvien>();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		Sinhvien Student = new Sinhvien();
		while(n!=0) {
			Scanner scanner = new Scanner(System.in);
			if(n == 1) {
				
				System.out.println("Nhap ID sinh vien : ");
				String id = scanner.nextLine();
				Student.setId(id);
	
				System.out.println("Nhap Ten sinh vien : ");
				String name = scanner.nextLine();
				Student.setName(name);
				
				System.out.println("Nhap dia chi sinh vien : ");
				String address = scanner.nextLine();
				Student.setName(address);
				
				System.out.println("Nhap tuoi sinh vien : ");
				int age = Integer.parseInt(scanner.nextLine());
				Student.setAge(age);

				System.out.println("Nhap diem trung binh sinh vien : ");
				float gpa = scanner.nextFloat();
				Student.setGpa(gpa);
	
				Sinhvien sv = new Sinhvien(id, name, address, age, gpa);
				
				SV.add(sv);
				
			}else if(n==2) {
				
				System.out.println("ID sinh vien muon sua");
				String input_id = scanner.nextLine();
				
				int size = SV.size();
				for(int i=0; i < size; i++) {
					if(SV.get(i).id.equals(input_id)) {
						
						System.out.println("Nhap Ten sinh vien : ");
						String name = scanner.nextLine();
						Student.setName(name);
						SV.get(i).name = name;
						
						System.out.println("Nhap dia chi sinh vien : ");
						String address = scanner.nextLine();
						Student.setName(address);
						SV.get(i).address = address;
						
						System.out.println("Nhap tuoi sinh vien : ");
						int age = Integer.parseInt(scanner.nextLine());
						Student.setAge(age);
						SV.get(i).age = age;

						System.out.println("Nhap diem trung binh sinh vien : ");
						float gpa = scanner.nextFloat();
						Student.setGpa(gpa);
						SV.get(i).gpa = gpa;
					}
				}
				
			}else if(n==3) {
				
				System.out.println("Chon ID sinh vien muon xoa.");
				String input_id = scanner.nextLine();
				int size = SV.size();
				for(int i=0; i < size; i++) {
					if(SV.get(i).id.equals(input_id)) {
						SV.remove(i);
					}
				}
				
			}else if(n==4) {
				
				System.out.println("Sap xep sinh vien theo ten");
				// Sorting
				Collections.sort(SV, new Comparator<Sinhvien>() {
			        @Override
			        public int compare(Sinhvien fruit2, Sinhvien fruit1)
			        {
			            return  fruit1.name.compareTo(fruit2.name);
			        }
			    });
				
			}else if(n==5) {
				
				int size = SV.size();
				for(int i=0; i < size; i++) {
					System.out.printf("ID :%s",SV.get(i).id + "\n");
					System.out.printf("Ten :%s",SV.get(i).name + "\n");
					System.out.printf("Tuoi :%d \n", SV.get(i).age);
					System.out.printf("Dia chi :%s",SV.get(i).address + "\n");
					System.out.printf("DTB :%f \n",SV.get(i).gpa);
					System.out.println("-----------------------");
				}
				
			}else if(n==6) {
				
				System.out.println("Ket thuc chuong trinh");
				
			}
			
			
			System.out.println("-----------menu------------");
	        System.out.println("1. Them sinh vien");
			System.out.println("2. Cap nhat thong tin sinh vien theo ID");
			System.out.println("3. Xoa sinh vien");
			System.out.println("4. Sap xep sinh vien theo ten");
			System.out.println("5. Hien thi danh sach sinh vien");
			System.out.println("6. Ket thuc chuong trinh");
	        System.out.println("---------------------------");
	        System.out.println("Please choose: ");
			n = scn.nextInt();
		}
		
		//	Ket thuc chuong trinh
		System.out.println("Ket thuc chuong trinh");
	}
}
