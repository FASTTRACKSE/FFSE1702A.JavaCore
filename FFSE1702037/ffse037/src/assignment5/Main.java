package assignment5;

import java.util.ArrayList;
import java.util.Scanner;

import lab3.Khachhang;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static Scanner myinput = new Scanner(System.in);

	public static void showMenu() {
		System.out.print(" ---------------------------------------------------------------- \n");
		System.out.print("|                              MENU                          |");
		System.out.printf("\n| %-47s |", "1. Nhập thông tin hộ cán bộ.");
		System.out.printf("\n| %-46s |",
				"2. Hiển thị danh sách giảng viên khoa X hoặc Hiển thị danh sách nhân viên phòng Y");
		System.out.printf("\n| %-47s |", "3. Tổng số lương phải trả cho cán bộ");
		System.out.printf("\n| %-47s |", "4. Sắp xếp cán bộ theo lương");
		System.out.printf("\n| %-52s |\n", "0. Kết thúc chương trình.", "|");
		System.out.println(" ---------------------------------------------------------------- ");
	}

	public static void main(String args[]) {

		CanBo canBo;

		ArrayList<CanBo> list = new ArrayList();
		for (;;) {
			showMenu();
			System.out.println("mời bạn chọn danh mục:");
			int a = Integer.parseInt(myinput.nextLine());
			if (a == 1) {
				System.out.println("nhấn 1 để nhập nhân viên , nhấn 2 để nhập giảng viên:");
				int b = Integer.parseInt(myinput.nextLine());
				if (b == 1) {
					NhanVien nv = new NhanVien();
					nv.nhap();
					list.add(nv);
				}
				if (b == 2) {
					GiangVien gv = new GiangVien();
					gv.nhap();
					list.add(gv);
				}
			}
			if (a == 2) {
				System.out.println("nhấn 1 để hiển thị nhân viên , nhấn 2 để hiển thị giảng viên:");
				int b = Integer.parseInt(myinput.nextLine());
				if (b == 1) {
					System.out.println("nhap phong:");
					String tenPhong = myinput.nextLine();

					for (int j = 0; j < list.size(); j++) {
						CanBo cb = list.get(j);
						if (cb instanceof NhanVien) {
							NhanVien nv = (NhanVien) cb;
							if (nv.getPhongban().equals(tenPhong)) {
								nv.xuat();

							}
						}
					}
				} else {
					System.out.println("nhap khoa:");
					String tenKhoa = myinput.nextLine();
					for (int j = 0; j < list.size(); j++) {
						CanBo cb = list.get(j);
						if (cb instanceof GiangVien) {
							GiangVien gv = (GiangVien) cb;
							if (gv.getKhoa().equals(tenKhoa)) {
								gv.xuat();
							}
						}
					}
				}

			}
			if (a == 3) {
				double tongluong = 0;
				double luong;
				for (CanBo cb : list) {

					luong = cb.tinhluong();
					tongluong += luong;
				}
				System.out.println("tổng lương phải trả cho cán bộ : " + tongluong);
			}
			if (a == 4) {

				System.out.println("sap xep theo luong va ten");
				Collections.sort(list, new Comparator<CanBo>() {

					public int compare(CanBo cb1, CanBo cb2) {
						if (cb1.getLuong() > cb2.getLuong()) {
							return 1;
						} else {
							if (cb1.getLuong() == cb2.getLuong()) {
								return cb1.getHoTen().compareTo(cb2.getHoTen());
							} else {
								return -1;
							}
						}
					}
				});
				System.out.println("Danh sách sắp xếp theo tên trong bảng chữ cái a - b - c: ");
				for (int i = 0; i < list.size(); i++) {
					System.out.println("Tên: " + list.get(i).getHoTen() + " Lương: " + list.get(i).tinhluong());
				}
			}
			if (a == 0) {
			}
		}
	}

}
