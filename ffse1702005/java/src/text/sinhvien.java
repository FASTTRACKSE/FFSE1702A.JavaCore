package text;

import java.util.ArrayList;
import java.util.Scanner;

public class sinhvien {
 private String id;
 private String name;
 private int age;
 private String address;
 private float gpa;
 
	
	public sinhvien()	{}
	public sinhvien(String id,String name,int age,String address,float gpa) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.address=address;
		this.gpa = gpa;
		
	}
	
	public void setAge(int age) {
		if(age<150) {
			this.age=age;
		}
		else {
			System.out.println("Tuổi không đúng");
		}
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
	public int getAge() {
		return age;
	}
	public void display() {
		System.out.println(id+" | "+name+" | "+address+" | "+gpa+"  |  "+age);
	}
	public static void main(String[] args) {
		sinhvien[] dsSV = new sinhvien[50];
		int index = 0;
		Scanner scn = new Scanner(System.in);
		System.out.print("So sv muon nhap: ");
		int m = scn.nextInt(); 
		for(int i = 0; i < m; i++) {
			sinhvien sv = new sinhvien();
			
			System.out.print("Nhap ID sinh vien: ");
			Scanner sc = new Scanner(System.in);
			String id = sc.nextLine();
			sv.setId(id);
			System.out.print("Nhập tên:");
			Scanner na = new Scanner(System.in);
			String name= na.nextLine();
			sv.setName(name);
			System.out.print("Nhập địa chỉ:");
			Scanner ad = new Scanner(System.in);
			String address= ad.nextLine();
			sv.setAddress(address);
			System.out.print("Nhập điểm:");
			Scanner gp = new Scanner(System.in);
			float gpa = gp.nextFloat();
			sv.setGpa(gpa);
			System.out.print("Nhập tuổi:");
			Scanner ag = new Scanner(System.in);
			String age= ag.nextLine();
			sv.setAddress(address);
			//nhap tiep thong tin con lai
			
			dsSV[index] = sv;
			index ++;
		}
		int n;
		do {
		System.out.println("1.Thêm sinh viên");
		System.out.println("2.Cập nhật thông tin");
		System.out.println("3.Xóa sinh viên theo ID");
		System.out.println("4.Sắp xếp sinh viên theo tên");
		System.out.println("5.Hiển thị danh sách sinh viên");
		System.out.println("0.Kết thúc chương trình");
		
		//Hien thi menu
		//tu lam
		
		
		System.out.print("Chon menu: ");
		n = scn.nextInt();
		
		
		if (n == 1) {
			
			System.out.print("So sv muon nhap them: ");
			int a = scn.nextInt(); 
			for(int i = m; i < m+a; i++) {
				sinhvien sv = new sinhvien();
				
				System.out.print("Nhap ID sinh vien: ");
				Scanner sc = new Scanner(System.in);
				String id = sc.nextLine();
				sv.setId(id);
				System.out.print("Nhập tên:");
				Scanner na = new Scanner(System.in);
				String name= na.nextLine();
				sv.setName(name);
				System.out.print("Nhập địa chỉ:");
				Scanner ad = new Scanner(System.in);
				String address= ad.nextLine();
				sv.setAddress(address);
				System.out.print("Nhập điểm:");
				Scanner gp = new Scanner(System.in);
				float gpa = gp.nextFloat();
				sv.setGpa(gpa);
				System.out.print("Nhập tuổi:");
				Scanner ag = new Scanner(System.in);
				String age= ag.nextLine();
				sv.setAddress(address);
				//nhap tiep thong tin con lai
				
				dsSV[index] = sv;
				index ++;
				
			
			}

			}
		if(n == 5) {
			for(int i = 0; i < m; i++) {
			dsSV[i].display();
		}
		}
		}while(n!=0);
		}
	}
