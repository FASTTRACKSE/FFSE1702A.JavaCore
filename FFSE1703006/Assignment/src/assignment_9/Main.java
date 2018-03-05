package assignment_9;

import java.util.Scanner;

public class Main {
	private static Scanner scanner;

	public static void showMenu() {
		System.out.print("+--------------------------------------------------------------------+\n");
		System.out.print("|                                MENU                                |");
		System.out.printf("\n| %-66s |", "1. Nhập thông tin cán bộ trong trường.");
		System.out.printf("\n| %-66s |", "2. Xuất danh sách giảng viên theo khoa / nhân viên theo phòng ban.");
		System.out.printf("\n| %-66s |", "3. Tổng số lương trường phải trả cho cán bộ.");
		System.out.printf("\n| %-66s |", "4. Sắp xếp cán bộ theo lương.");
		System.out.printf("\n| %-66s |", "5. Hiển thị lại menu.");
		System.out.printf("\n| %-66s |\n", "0. Kết thúc chương trình.", "|");
		System.out.println("+--------------------------------------------------------------------+");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		Menu menu = new Menu();
		menu.giaTriMacDinh();
		showMenu();
		do {
			System.out.print("\nChọn chức năng (nhấn 5 để hiện lại menu): ");
			int choose = scanner.nextInt();
			System.out.println("--------------------------------------------");
			switch (choose) {
			case 1:
				menu.themCanBo();
				break;
			case 2:
				menu.xuatCanBo();
				break;
			case 3:
				menu.tongLuong();
				break;
			case 4:
				menu.sortByLuong();
				break;
			case 5:
				showMenu();
				break;
			case 0:
				System.out.println("Kết thúc chương trình");
				System.exit(0);
				break;
			default:
				System.out.println("Vui lòng nhập số từ 0-5\n");
				break;
			}
		} while (true);
	}

}
