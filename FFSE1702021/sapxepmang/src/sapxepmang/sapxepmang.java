package sapxepmang;

import java.util.Scanner;

public class sapxepmang {
	public static void giamdan(int mang[], int n) {
		int t;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (mang[i] < mang[j]) {
					t = mang[i];
					mang[i] = mang[j];
					mang[j] = t;
				}
		System.out.print("Mảng sắp xếp giảm dần ");
		for (int i = 0; i < mang.length; i++) {
			System.out.print(mang[i] + " ,");
		}
		System.out.println("");

	}

	public static void tangdan(int mang[], int n) {
		int t;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (mang[i] > mang[j]) {
					t = mang[i];
					mang[i] = mang[j];
					mang[j] = t;
				}
		System.out.print("Mảng sắp xếp tăng dần ");
		for (int i = 0; i < mang.length; i++) {
			System.out.print(mang[i] + " ,");
		}
		System.out.println("");

	}

	public static void main(String[] args) {
		String text = "yes";
		while (text == "yes") {
			int n, a;
			int answer;
			try {
			System.out.print("Nhập số phần tử trong mảng số nguyên: ");
			Scanner input = new Scanner(System.in);
			n = input.nextInt();
			int mang[] = new int[n];

			for (int i = 0; i < n; i++) {
				System.out.print("Nhập phần tử thứ " + (i + 1) + " của mảng : ");
				Scanner input2 = new Scanner(System.in);
				a = input2.nextInt();
				mang[i] = a;
			}
			System.out.println("lựa chọn phương án in:");
			System.out.println("1.Sắp xếp mảng từ cao đến thấp");
			System.out.println("2.Sắp xếp mảng từ thấp đến cao");
			System.out.println("3.Nhập lại mảng");
			System.out.println("4.Thoát khỏi chương trình");
			Scanner input3 = new Scanner(System.in);
			answer = input3.nextInt();
			if (answer == 1) {
				giamdan(mang, n);
			}
			if (answer == 2) {
				tangdan(mang, n);
			}
			if (answer == 3) {
				continue;
			}
			if (answer == 4) {
				System.exit(0);
			}
			}
			catch(Exception ex) {
				System.out.println("Vui lòng nhập số nguyên ");
			}
			Scanner myInputa = new Scanner(System.in);
			System.out.println("Bạn có muốn tiếp tục không  ");
			text = myInputa.nextLine();
			if (text.equalsIgnoreCase("N") || text.equalsIgnoreCase("No")) {
				text = "No";
			} else {
				text = "yes";
			}
		}
	}
}