package assignment_7;

import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	public static void showMenu() {
		System.out.print("+------------------------------------------+\n");
		System.out.print("|                   MENU                   |");
		System.out.printf("\n| %-40s |", "1. Thêm sinh viên.");
		System.out.printf("\n| %-40s |", "2. Cập nhật thông tin sinh viên theo ID.");
		System.out.printf("\n| %-40s |", "3. Xóa sinh viên theo ID");
		System.out.printf("\n| %-40s |", "4. Sắp xếp sinh viên theo tên.");
		System.out.printf("\n| %-40s |", "5. Sắp xếp sinh viên theo GPA.");
		System.out.printf("\n| %-40s |", "6. Hiển thị danh sách sinh viên.");
		System.out.printf("\n| %-40s |", "7. Hiển thị lại menu.");
		System.out.printf("\n| %-40s |\n", "0. Kết thúc chương trình.", "|");
		System.out.println("+------------------------------------------+");
	}

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		Menu menu = new Menu();
		menu.giaTriMacDinh();
		showMenu();
		do {
			System.out.print("Chọn chức năng (nhấn 7 để hiện lại menu): ");
			int choose = scanner.nextInt();
			System.out.println("--------------------------------------------");
			switch (choose) {
			case 1:
				SinhVien sv = new SinhVien();
				menu.themSinhVien(sv);
				break;
			case 2:
				menu.updateByID();
				break;
			case 3:
				menu.deleteByID();
				break;
			case 4:
				menu.sortByName();
				break;
			case 5:
				menu.sortByGPA();
				break;
			case 6:
				menu.hienThiSV();
				break;
			case 7:
				showMenu();
				break;
			case 0:
				System.out.println("Kết thúc chương trình");
				System.exit(0);
				break;
			default:
				System.out.println("Vui lòng nhập số từ 0-7\n");
				break;
			}
		} while (true);
	}

}
