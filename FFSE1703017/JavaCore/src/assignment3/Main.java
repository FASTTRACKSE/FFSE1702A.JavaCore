package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Student> arrStudent = new ArrayList<>();
	private static Scanner input;
	
	public static void printMenu() {
		System.out.println("/***********************************************/");
		System.out.println("1. Thêm sinh viên");
		System.out.println("2. Cập nhật thông tin sinh viên theo ID");
		System.out.println("3. Xóa sinh viên theo ID");
		System.out.println("4. Sắp xếp sinh viên theo tên");
		System.out.println("5. Hiển thị danh sách sinh viên");
		System.out.println("0. Kết thúc chương trình");
		System.out.println("/***********************************************/");
	}
	
	public static void addStudent() {
		input = new Scanner(System.in);
		
		System.out.print("Nhập số lượng sinh viên: ");
		int n = Integer.parseInt(input.nextLine());
		
		for(int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin sinh viên " + (i + 1));
			Student st = new Student();
			st.setStudent();
			arrStudent.add(st);
		}
		System.out.println("Thêm thành công " + n + " sinh viên");
		System.out.println("/***********************************************/");
	}
	
	public static void updateByID() {
		input = new Scanner(System.in);
		System.out.print("Nhập ID sinh viên muốn sửa: ");
		String id = input.nextLine();
		
		boolean isWrongID = true;
		for(Student st : arrStudent) {
			if(st.getId().equals(id)) {
				Student temp = new Student();
				temp.setStudent();
				int i = arrStudent.indexOf(st);
				arrStudent.set(i, temp);
				System.out.println("Sửa thành công sinh viên có ID là " + id);
				isWrongID = false;
				break;
			}
		}
		
		if(isWrongID) {
			System.out.println("Không tìm sinh viên có ID phù hợp!");
		}
		System.out.println("/***********************************************/");
	}
	
	public static void deleteByID() {
		input = new Scanner(System.in);
		System.out.print("Nhập ID sinh viên muốn xóa: ");
		String id = input.nextLine();
		
		boolean isWrongID = true;
		for(Student st : arrStudent) {
			if(st.getId().equals(id)) {
				arrStudent.remove(st);
				System.out.println("Xóa thành công sinh viên có ID là " + id);
				isWrongID = false;
				break;
			}
		}
		
		if(isWrongID) {
			System.out.println("Không tìm sinh viên có ID phù hợp!");
		}
		System.out.println("/***********************************************/");
	}
	
	public static void sortStudent() {
		Collections.sort(arrStudent, Student.sortByName);
		System.out.println("Sắp xếp thành công!");
		System.out.println("/***********************************************/");
	}
	
	public static void showStudent() {
		System.out.println("Danh sách sinh viên: ");
		for(Student st : arrStudent) {
			System.out.println(st);
		}
		System.out.println("/***********************************************/");
	}

	public static void main(String[] args) {
		printMenu();
		
		do {
			input = new Scanner(System.in);
			System.out.println("Nhập 0-5 để chọn chức năng, 6 để hiển thị menu: ");
			int control = Integer.parseInt(input.nextLine());
			switch (control) {
			case 1:
				addStudent();
				break;
			case 2:
				updateByID();
				break;
			case 3:
				deleteByID();
				break;
			case 4:
				sortStudent();
				break;
			case 5:
				showStudent();
				break;
			case 6:
				printMenu();
				break;
			case 0:
				System.out.println("Kết thúc chương trình");
				System.exit(0);
			default:
				System.out.print("Phải nhập số từ 0 đến 5, hãy nhập lại: ");
				break;
			}
			
		}
		while(true);

	}

}
