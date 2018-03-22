package assigment4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<BienLai> list = new ArrayList<BienLai>();
		int control = 5;
		Scanner scan = new Scanner(System.in);
		while (control != 0) {
			System.out.println(
					"1. Nhập thông tin hộ sử dụng. \r\n" + "2. Hiển thị thông tin về các biên lai đã nhập  .\r\n"
							+ "3. Tính số tiền điện phải trả cho mỗi hộ dân .\r\n");

			control = Integer.parseInt(scan.nextLine());
			if (control == 1) {
				System.out.println("Nhập số lượng hộ gia đình cần nhập");
				int n = Integer.parseInt(scan.nextLine());
				for (int i = 1; i <= n; i++) {
					BienLai bl = new BienLai();
					bl.add();

					list.add(bl);
				}
			} else if (control == 2) {
				for (int i = 0; i < list.size(); i++) {
					System.out.println("Tên người dùng: " + list.get(i).getTen() + " | Số nhà: " + list.get(i).getSonha()
							+ " | Mã số: " + list.get(i).getMaso() + " | Chỉ số cũ: " + list.get(i).getChisocu() + " | Chỉ số mới: " + list.get(i).getChisomoi());
				}
			} else if (control == 3) {
				for (int i = 0; i < list.size(); i++) {
					System.out.println("Tên người dùng: " + list.get(i).getTen() + " | Số nhà: " + list.get(i).getSonha() + " | Mã số: "
							+ list.get(i).getMaso() + " | Số tiền: " + list.get(i).getSotien());
				}
			}
		}
	}
}
