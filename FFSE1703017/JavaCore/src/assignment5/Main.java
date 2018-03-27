package assignment5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<CanBo> arrCanBo = new ArrayList<>();
	static Scanner input;
	
	public static void inMenu() {
		System.out.println("/***********************************************/");
		System.out.println("1. Nhập thông tin cán bộ trong trường");
		System.out.println("2. Xuất danh sách cán bộ theo khoa hoặc phòng ban");
		System.out.println("3.Tổng số lương trường phải trả cho cán bộ");
		System.out.println("4.Sắp xếp cán bộ theo lương và tên");
		System.out.println("0. Kết thúc chương trình");
		System.out.println("/***********************************************/");
	}
	
	public static void themCanBo() {
		int chon;
		input = new Scanner(System.in);
		System.out.print("Số lượng cán bộ sẽ nhập: ");
		int n = checkInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin cán bộ thứ " + (i + 1) + " :");
			do {
				System.out.print("Chọn loại cán bộ (1 - Giảng viên, 2 - Nhân viên): ");
				chon = checkInt();
			} while (chon > 2 || chon == 0);
			CanBo cb = (chon == 1) ? new GiangVien() : new NhanVien();
			cb.nhap();
			arrCanBo.add(cb);
		}
		System.out.println("Thêm thành công " + n + " cán bộ");
		System.out.println("/***********************************************/");
	}
	
	public static void xuatCanBo() {
		if(arrCanBo.size() > 0) {
			input = new Scanner(System.in);
			boolean saiTen = true;
			System.out.print("Nhập tên khoa hoặc phòng ban: ");
			String ten = input.nextLine();
			System.out.println("Danh sách cán bộ thuộc khoa / phòng ban " + ten + " :");
			for(CanBo cb : arrCanBo) {
				if (cb instanceof GiangVien) {
					GiangVien gv = (GiangVien) cb;
					if(gv.getKhoa().equals(ten)) {
						System.out.println(gv);
						saiTen = false;
					}
				} else {
					NhanVien nv = (NhanVien) cb;
					if(nv.getPhongBan().equals(ten)) {
						System.out.println(nv);
						saiTen = false;
					}
				}
			}
			if(saiTen) System.out.println("Không có cán bộ phù hợp");
		} else {
			System.out.println("Chưa có danh sách cán bộ");
		}
		System.out.println("/***********************************************/");
	}
	
	public static void tongLuong() {
		double tong = 0;
		for (CanBo cb : arrCanBo) {
			tong += cb.getLuong();
		}
		System.out.println("Tổng số lương trường trả: " + tong);
		System.out.println("/***********************************************/");
	}
	
	public static void sapXep() {
		if(arrCanBo.size() > 0) {
			Collections.sort(arrCanBo, CanBo.sapXep);
			System.out.println("Sắp xếp thành công");
		} else {
			System.out.println("Chưa có danh sách cán bộ");
		}
		System.out.println("/***********************************************/");
	}
	
	public static String checkHoTen() {
		do {
			try {
				String s = input.nextLine();
				MyException.chkHoTen(s, arrCanBo);
				return s;
			} catch (MyException e) {
				System.out.print(e);
			}
		} while(true);
	}
	
	public static double checkHeSoLuong() {
		do {
			try {
				String s = input.nextLine();
				MyException.chkDouble(s);
				return Double.parseDouble(s);
			} catch (MyException e) {
				System.out.print(e);
			}
		} while (true);
	}
	
	public static int checkInt() {
		do {
			try {
				String s = input.nextLine();
				MyException.chkDouble(s);
				return Integer.parseInt(s);
			} catch (MyException e) {
				System.out.print(e);
			}
		} while (true);
	}
	
	public static void ghiDuLieu() throws IOException, ClassNotFoundException {
		try {
			FileOutputStream fos = new FileOutputStream("Dulieu.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(arrCanBo);
			oos.close();fos.close();
		} catch (IOException e) {
			System.out.println("File chưa được ghi");
			System.out.println(e);
		}
	}
//	public static void ghiDuLieu() throws IOException {
//		FileWriter fw = new FileWriter("Dulieu.txt");
//		BufferedWriter bw = new BufferedWriter(fw);
//		for (CanBo cb : arrCanBo) {
//			bw.write(cb.toString());
//		}
//		bw.flush();bw.close();
//	}
	
	@SuppressWarnings("unchecked")
	public static void docDuLieu() {
		try {
			FileInputStream fis = new FileInputStream("Dulieu.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			arrCanBo = (ArrayList<CanBo>) ois.readObject();
			for (CanBo cb : arrCanBo) {
				System.out.println(cb);
			}
			fis.close();ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//	public static void docDuLieu() throws IOException {
//		FileReader fr = new FileReader("Dulieu.txt");
//		BufferedReader br = new BufferedReader(fr);
//		String text;
//		while((text = br.readLine()) != null){
//			System.out.println(text);
//		}
//		br.close();
//	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		System.out.println("In file:");
		docDuLieu();
		inMenu();
		do {
			System.out.print("Nhập 0-4 để chọn chức năng, 5 để hiển thị menu: ");
			input = new Scanner(System.in);
			int chon = checkInt();
			switch (chon) {
			case 1:
				themCanBo();
				break;
			case 2:
				xuatCanBo();
				break;
			case 3:
				tongLuong();
				break;
			case 4:
				sapXep();
				break;
			case 5:
				inMenu();
				break;
			case 0:
				ghiDuLieu();
				System.out.println("Kết thúc chương trình");
				System.exit(0);
			default:
				System.out.print("Nhập 0-4 để chọn chức năng, 5 để hiển thị menu: ");
				break;
			}
		} while(true);

	}

}
