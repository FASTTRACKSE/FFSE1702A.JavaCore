package as5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Canbo> arrCanBo = new ArrayList<>();
		int soCanBo;
		double tongluong = 0, luong;
		Canbo canBo;
		Scanner scn = new Scanner(System.in);
		int menu;
		do {
			
			System.out.print("  số 1 : nhập thông tin cán bộ     \n");
			System.out.print("  số 2 : xem thông tin             \n");
			System.out.print("  số 3 : tổng tiền lương phải trả  \n");
			System.out.print("  số 4 : Sắp xếp cán bộ theo lương \n");
			
			System.out.print("\n chọn chức năng bạn: ");
			Scanner scn1 = new Scanner(System.in);
			menu = Integer.parseInt(scn1.nextLine());
			if (menu == 1) {
				System.out.print("Nhập số lượng cán bộ trong trường: ");
				soCanBo = scn1.nextInt();
				for (int i = 0; i < soCanBo; i++) {
					System.out.print("Nhập thong tin can bo thu " + (i + 1) + " \n");

					System.out.print("Nhập 1 chon giang vien, 2 chon nhan vien");
					int cb;
					cb = scn.nextInt();

					if (cb == 1) {
						
						canBo = new Giangvien();
						
						for(;;) {
						System.out.print("nhap ma can bo");
						String maCanBo=scn.next();
					    	try {
					    		CanboException.chkMaCanBo(maCanBo, arrCanBo);
					    		canBo.setMaCanBo(maCanBo);
					    		break;
					    	}catch(CanboException e) {
					    		System.out.print(e);
					    }
						
						}
						canBo.nhap();
						arrCanBo.add(canBo);

					} else if (cb == 2) {
						canBo = new Nhanvien();
						canBo.nhap();
						for(;;) {
						System.out.print("nhap ma can bo");
						String maCanBo=scn.next();
					    	try {
					    		CanboException.chkMaCanBo(maCanBo, arrCanBo);
					    		canBo.setMaCanBo(maCanBo);
					    		break;
					    	}catch(CanboException e) {
					    		System.out.print(e);
					    }
						arrCanBo.add(canBo);
						}

					}

				}
			} else if (menu == 2) {
				System.out.println("Xuất danh sách giảng viên khoa x(chọn 1), hoặc nhân viên phòng ban y(chọn 2): ");
				int i = Integer.parseInt(scn1.nextLine());
				if (i == 1) {
					System.out.println("nhap khoa:");
					String tenKhoa = scn.next();

					for (int j = 0; j < arrCanBo.size(); j++) {
						Canbo cb = arrCanBo.get(j);
						if (cb instanceof Giangvien) {
							Giangvien gv = (Giangvien) cb;
							if (gv.getKhoa().equals(tenKhoa)) {
								gv.xuat();
							}
						}
					}
				} else {
					System.out.println("nhap phong:");
					String tenPhong = scn.next();

					for (int j = 0; j < arrCanBo.size(); j++) {
						Canbo cb = arrCanBo.get(j);
						if (cb instanceof Nhanvien) {
							Nhanvien nv = (Nhanvien) cb;
							if (nv.getPhongBan().equals(tenPhong)) {
								nv.xuat();
							}
						}
					}
				}
			} else if (menu == 3) {
				for (Canbo cb : arrCanBo) {
					luong = cb.tinhLuong();
					tongluong += luong;
				}
				System.out.println("Tổng lương phải trả cho cán bộ trong trường = " + tongluong);
			} else if (menu == 4) {
				System.out.println("sap xep theo luong va ten");
				Collections.sort(arrCanBo, new Comparator<Canbo>() {
					@Override
					public int compare(Canbo cb1, Canbo cb2) {
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
				for (int i = 0; i < arrCanBo.size(); i++) {
					System.out.println("Tên: " + arrCanBo.get(i).getHoTen() + " Lương: " + arrCanBo.get(i).tinhLuong());
				}
			}
		} while (menu != 0);
	}

	
}