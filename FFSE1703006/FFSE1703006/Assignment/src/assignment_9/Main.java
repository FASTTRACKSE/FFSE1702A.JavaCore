package assignment_9;

public class Main {

	static MyFunction myFunction = new MyFunction();

	public static void showMenu() {
		System.out.print("+--------------------------------------------------------------------+\n");
		System.out.print("|                                MENU                                |");
		System.out.printf("\n| %-66s |", "1. Nhập thông tin cán bộ trong trường.");
		System.out.printf("\n| %-66s |", "2. Xuất danh sách giảng viên theo khoa / nhân viên theo phòng ban.");
		System.out.printf("\n| %-66s |", "3. Tổng số lương trường phải trả cho cán bộ.");
		System.out.printf("\n| %-66s |", "4. Sắp xếp cán bộ theo lương.");
		System.out.printf("\n| %-66s |", "5. Hiển thị lại menu.");
		System.out.printf("\n| %-66s |\n", "6. Kết thúc chương trình.", "|");
		System.out.println("+--------------------------------------------------------------------+");
	}

	public static void showChoose() {
		System.out.println("--------------------------------------------");
		System.out.print("\nChọn chức năng (nhấn 5 để hiện lại menu): ");
	}

	public static void main(String[] args) throws Exception {
		int choose;
		Menu menu = new Menu();
		// menu.giaTriMacDinh();
		menu.dataRead();
		showMenu();
		System.out.print("\nChọn chức năng (nhấn 5 để hiện lại menu): ");
		do {
			choose = Main.myFunction.loopCheckInt();
			switch (choose) {
			case 1:
				menu.themCanBo();
				showChoose();
				break;
			case 2:
				menu.xuatCanBo();
				showChoose();
				break;
			case 3:
				menu.tongLuong();
				showChoose();
				break;
			case 4:
				menu.sortByLuong();
				showChoose();
				break;
			case 5:
				showMenu();
				showChoose();
				break;
			case 6:
				menu.dataWrite();
				System.out.println("Kết thúc chương trình");
				System.exit(0);
				break;
			default:
				System.err.print(" * Vui lòng nhập số từ 1-6!\n Nhập lại: ");
				break;
			}
		} while (true);
	}

}
