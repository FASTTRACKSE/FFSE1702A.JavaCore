package assignment_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
	static ArrayList<CanBo> arrCanBo = new ArrayList<>();
	private Scanner scanner;
	CanBo canBo;

	public Menu() {
		super();
	}

	static boolean existHoTen(String n) {
		for (CanBo cb : arrCanBo) {
			if (cb.getHoTen().equals(n)) {
				return true;
			}
		}
		return false;
	}

	public void giaTriMacDinh() {
		arrCanBo.add(new NhanVien("Nguyễn Văn A", "Phòng Đào tạo", "Trưởng phòng", 5, 3.3));
		arrCanBo.add(new NhanVien("Bành Thị B", "Phòng Đào tạo", "Phó phòng", 10, 2.2));
		arrCanBo.add(new NhanVien("Trương Văn C", "Phòng Đào tạo", "Nhân viên", 15, 1.1));
		arrCanBo.add(new GiangVien("Dương Thị D", "IT", "Cử nhân", 5, 1.1));
		arrCanBo.add(new GiangVien("Trần Văn E", "IT", "Thạc sĩ", 10, 2.2));
		arrCanBo.add(new GiangVien("Cao Văn F", "IT", "Tiến sĩ", 15, 3.3));
		arrCanBo.add(new GiangVien("Huỳnh Thị G", "IT", "Tiến sĩ", 15, 3.3));
		arrCanBo.add(new GiangVien("Phạm Văn H", "IT", "Tiến sĩ", 15, 3.3));
	}

	public void themCanBo() {
		int n, choose;
		scanner = new Scanner(System.in);
		System.out.print("Nhập số cán bộ: ");
		n = CanBo.checkInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin cán bộ thứ " + (i + 1));
			do {
				System.out.print("Chọn loại cán bộ (1 - Giảng viên, 2 - Nhân viên): ");
				choose = CanBo.checkInt();
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
					System.out.println(" * Vui lòng nhập số từ 1-2!");
					break;
				}
			} while (choose < 1 || choose > 2);
		}
		System.out.print("\nThêm thành công " + n + " cán bộ!\n");
	}

	public void xuatCanBo() {
		int i = 0;
		scanner = new Scanner(System.in);
		System.out.print("Nhập tên khoa hoặc phòng ban: ");
		String ten = scanner.nextLine();
		for (CanBo cb : arrCanBo) {
			if (cb.getWhere().equals(ten)) {
				i += 1;
				if (i == 1) {
					System.out.println("\nDanh sách cán bộ");
					System.out.println(
							"+----------------------+----------------------------+-----------------------+------------------+------------------+---------------+-----------------+");
				}
				cb.xuat();
			}
		}
		if (i == 0) {
			System.out.println("Không tồn tại cán bộ!");
		} else {
			System.out.println(
					"+----------------------+----------------------------+-----------------------+------------------+------------------+---------------+-----------------+");
		}
	}

	public void tongLuong() {
		double tong = 0;
		for (CanBo cb : arrCanBo) {
			tong += cb.getLuong();
		}
		System.out.println("Tổng số lương trường trả cho cán bộ là: " + tong);
	}

	public void sortByLuong() {
		Collections.sort(arrCanBo, CanBo.sortByLuong);
		System.out.println("Sắp xếp thành công!\n");
	}
}
