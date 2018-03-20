package text;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<CanBo> arrCanBo = new ArrayList<>();
		int choose, soCanBo;
		long tongLuong = 0, luong;
		CanBo canBo = null;

		for (;;) {
			try {
				System.out.println("+>>       Menu       <<+");
				System.out.println("+|  1. Nhập cán bộ    |+");
				System.out.println("+|  2. List cán bộ    |+");
				System.out.println("+|  3. Lương phải trả |+");
				System.out.println("+|  4. Kết thúc       |+");
				System.out.println("+>>  Chọn chức năng  <<+");
				Scanner myInput = new Scanner(System.in);
				int answer = myInput.nextInt();
				if (answer == 1) {

					Scanner scanner = new Scanner(System.in);
					System.out.print("Nhập số lượng cán bộ trong trường: ");
					soCanBo = scanner.nextInt();
					for (int i = 0; i < soCanBo; i++) {
						System.out.println("Nhập thông tin cán bộ thứ " + (i + 1) + ":");
						do {
							System.out.print("Chọn loại cán bộ (1 - giảng viên, 2 - nhân viên): ");
							choose = scanner.nextInt();
							switch (choose) {
							case 1:
								canBo = new GiangVien();
								canBo.nhap();
								arrCanBo.add(canBo);
								break;
							case 2:
								canBo = new NhanVien();
								canBo.nhap();
								arrCanBo.add(canBo);
								break;
							default:
								System.out.println("Chọn không hợp lệ.");
								break;
							}
						} while (choose < 1 || choose > 3);
					}

				} else if (answer == 2) {
					System.out.println("Hiển thị danh sách cán cán bộ trong trường: ");
					for (CanBo cb : arrCanBo) {
						System.out.println(cb.toString());
					}
				} else if (answer == 3) {
					for (CanBo cb : arrCanBo) {
						luong = cb.tinhLuong();
						tongLuong += luong;
					}
					System.out.println("Tổng lương phải trả cho cán bộ trong trường = " + tongLuong);
				} else if (answer == 4) {
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("+>> Error! Vui lòng nhập lại <<+");
			}
		}
	}
}