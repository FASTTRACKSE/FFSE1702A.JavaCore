package assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import assignment4.BienLai;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int n = 5;
		int num = 0;
		ArrayList<Canbo> listCB = new ArrayList<Canbo>(5);

		do {
			System.out.println("-----------Menu------------");
			System.out.println("1. Nhap danh sach can bo trong truong");
			System.out.println("2. Xuat danh sach giang vien khoa x, hoac phong ban y:");
			System.out.println("3. Tong luong truong phai tra:");
			System.out.println("4. Sap xep theo luong:");
			System.out.println("0. Thoat");
			System.out.println("---------------------------");
			System.out.println("Chon chuc nang: ");

			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());

			if (n == 1) {
				System.out.println("Nhap so luong can bo muon nhap");
				int soLuong = Integer.parseInt(sc.nextLine());

				for (int i = 0; i < soLuong; i++) {
					for (;;) {
						System.out.println("1. Nhap giang vien");
						System.out.println("2. Nhap nhan vien");
						num = Integer.parseInt(sc.nextLine());
						if (num == 1 || num == 2)
							break;
					}

					if (num == 1) {
						GiangVien gv = new GiangVien();
						gv.nhap(sc);
						listCB.add(gv);
						System.out.println(Arrays.toString(listCB.toArray()));
					}

					if (num == 2) {
						NhanVien nv = new NhanVien();
						nv.nhap(sc);
						listCB.add(nv);
					}
				}
			} else if (n == 2) {
				for (;;) {
					System.out.println("1. Danh sach giang vien theo khoa");
					System.out.println("2. Danh sach nhan vien phong ban");
					num = Integer.parseInt(sc.nextLine());
					if (num == 1 || num == 2)
						break;
				}

				if (num == 1) {
					System.out.println(Arrays.toString(listCB.toArray()));
					// GiangVien gv = new GiangVien();
					// System.out.println("Chon khoa muon hien thi:");
					// String khoa = sc.nextLine();
					// for(int i = 0; i < listCB.size(); i++) {
					// listCB.get(i).xuat();
					// }
				}

				if (num == 2) {
					NhanVien nv = new NhanVien();
					nv.nhap(sc);
					listCB.add(nv);
				}
			}
		} while (n != 0);
	}
}
