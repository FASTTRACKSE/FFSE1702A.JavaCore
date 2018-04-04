package assignment_9;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
<<<<<<< HEAD
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
=======
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing

public class Menu {
	static ArrayList<CanBo> arrCanBo = new ArrayList<>();
	private Scanner scanner;
	CanBo canBo;

	public Menu() {
		super();
	}

	public void dataWrite() throws IOException {
<<<<<<< HEAD
		/*
		 * // Luồng byte FileOutputStream fos = new FileOutputStream("CanBo.txt");
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * oos.writeObject(arrCanBo); oos.close();
		 */

		// Luồng charater
		FileWriter fw = new FileWriter("CanBo1.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String pre = "", json;
		for (CanBo cb : arrCanBo) {
			if (cb instanceof GiangVien)
				pre = "GiangVien|[";
			else if (cb instanceof NhanVien)
				pre = "NhanVien|[";
			json = pre + new Gson().toJson(cb) + "]\n";
			bw.write(json);
		}
		bw.flush();
		bw.close();

	}

	public void dataRead() throws IOException, ClassNotFoundException {
		/*
		 * // Luồng byte FileInputStream fis = null; ObjectInputStream ois = null; try {
		 * fis = new FileInputStream("CanBo.txt"); ois = new ObjectInputStream(fis);
		 * arrCanBo = (ArrayList<CanBo>) ois.readObject();
		 * 
		 * for (CanBo cb : arrCanBo) { System.out.print(cb); }
		 * 
		 * ois.close(); fis.close(); } catch (Exception e) {
		 * System.out.println("Có lỗi: " + e); }
		 */

		// Luồng charater
		FileReader frr = new FileReader("CanBo1.txt");
		BufferedReader br = new BufferedReader(frr);
		String text;
		Gson gson = new Gson();
		while ((text = br.readLine()) != null) {
			String[] arrOfStr = text.split("\\|", 2);
			if (arrOfStr[0].equals("NhanVien")) {
				TypeToken<ArrayList<NhanVien>> token = new TypeToken<ArrayList<NhanVien>>() {
				};
				ArrayList<CanBo> obj = gson.fromJson(arrOfStr[1], token.getType());
				arrCanBo.add(obj.get(0));
			} else if (arrOfStr[0].equals("GiangVien")) {
				TypeToken<ArrayList<GiangVien>> token = new TypeToken<ArrayList<GiangVien>>() {
				};
				ArrayList<CanBo> obj = gson.fromJson(arrOfStr[1], token.getType());
				arrCanBo.add(obj.get(0));
			}
		}
		br.close();
=======
		FileOutputStream fos = new FileOutputStream("CanBo.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(arrCanBo);
		oos.close();
	}

	public void dataRead() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("CanBo.txt");
			ois = new ObjectInputStream(fis);
			arrCanBo = (ArrayList<CanBo>) ois.readObject();
			// for (CanBo cb : arrCanBo) {
			// System.out.print(cb);
			// }
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.out.println("Có lỗi: " + e);
		}
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing
	}

	public void giaTriMacDinh() throws IOException {
		arrCanBo.add(new NhanVien("Nguyễn Văn A", "Phòng Đào tạo", "Trưởng phòng", 5, 3.3));
		arrCanBo.add(new NhanVien("Bành Thị B", "Phòng Đào tạo", "Phó phòng", 10, 2.2));
		arrCanBo.add(new NhanVien("Trương Văn C", "Phòng Đào tạo", "Nhân viên", 15, 1.1));
		arrCanBo.add(new GiangVien("Dương Thị D", "IT", "Cử nhân", 5, 1.1));
		arrCanBo.add(new GiangVien("Trần Văn E", "IT", "Thạc sĩ", 10, 2.2));
		arrCanBo.add(new GiangVien("Cao Văn F", "IT", "Tiến sĩ", 15, 3.3));
		arrCanBo.add(new GiangVien("Huỳnh Thị G", "IT", "Tiến sĩ", 15, 3.3));
		arrCanBo.add(new GiangVien("Phạm Văn H", "IT", "Tiến sĩ", 15, 3.3));
		// dataRead();
<<<<<<< HEAD
		dataWrite();
=======
		// dataWrite();
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing
	}

	public void themCanBo() {
		int soCanBo, choose;
		scanner = new Scanner(System.in);
		System.out.print("Nhập số cán bộ: ");
		soCanBo = Main.myFunction.loopCheckInt();
		for (int i = 0; i < soCanBo; i++) {
			System.out.println("Nhập thông tin cán bộ thứ " + (i + 1));
			System.out.print("Chọn loại cán bộ (1 - Giảng viên, 2 - Nhân viên): ");
			do {
				choose = Main.myFunction.loopCheckInt();
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
					System.err.print(" * Vui lòng nhập số từ 1-2!\n Nhập lại: ");
					break;
				}
			} while (choose > 2);
		}
		System.out.print("\nThêm thành công " + soCanBo + " cán bộ!\n");
	}

	public void xuatCanBo() {
		int i = 0;
		scanner = new Scanner(System.in);
		System.out.print("Nhập tên khoa hoặc phòng ban: ");
		String ten = scanner.nextLine();
		for (CanBo cb : arrCanBo) {
			if (cb instanceof GiangVien) {
				GiangVien gv = (GiangVien) cb;
				if (gv.getKhoa().equals(ten)) {
					i += 1;
					if (i == 1) {
						System.out.println("\nDanh sách giảng viên thuộc khoa " + ten);
						System.out.println(
								"+----------------------+----------------------------+-----------------------+------------------+------------------+---------------+-----------------+");
					}
					System.out.print(cb);
				}
			}
			if (cb instanceof NhanVien) {
				NhanVien nv = (NhanVien) cb;
				if (nv.getPhongBan().equals(ten)) {
					i += 1;
					if (i == 1) {
						System.out.println("\nDanh sách giảng viên thuộc " + ten);
						System.out.println(
								"+----------------------+----------------------------+-----------------------+------------------+------------------+---------------+-----------------+");
					}
					System.out.print(cb);
				}
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
