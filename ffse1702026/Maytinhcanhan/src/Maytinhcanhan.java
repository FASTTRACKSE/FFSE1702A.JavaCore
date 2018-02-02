import java.util.Scanner;

public class Maytinhcanhan {

	public static void thuchienphepcong(int a, int b) {
		int c;
		c = a + b;
		System.out.println("Kết quả là " + c);
	}

	public static void thuchienpheptru(int a, int b) {
		int c;
		c = a - b;
		System.out.println("Kết quả là " + c);

	}

	public static void main(String args[]) {
		String text = "yes";
		while (text == "yes") {
			int a, b, answer;
			System.out.println("MÁY TÍNH CÁ NHÂN");
			System.out.println("Chọn chức năng");
			System.out.println("1. Cộng");
			System.out.println("2. Trừ");
			System.out.println("3. Kết thúc");
			Scanner input3 = new Scanner(System.in);
			answer = input3.nextInt();
			try {
				if (answer != 1 && answer != 2 && answer != 3) {
					System.out.println("Vui lòng chọn đúng các số chức năng");
				} else if (answer == 3) {
					System.exit(0);
				} else {
					System.out.println("Nhập số a");
					Scanner input1 = new Scanner(System.in);
					a = input1.nextInt();
					System.out.println("Nhập số b");
					Scanner input2 = new Scanner(System.in);
					b = input2.nextInt();
					if (answer == 1) {
						thuchienphepcong(a, b);
					} else if (answer == 2) {
						thuchienpheptru(a, b);
					}
				}
			} catch (Exception ex) {
				System.out.println("vui lòng nhập số");
			}
			Scanner myInput4 = new Scanner(System.in);
			System.out.print("Bạn có muốn tiếp tục không  ");
			text = myInput4.nextLine();
			if (text.equalsIgnoreCase("N") || text.equalsIgnoreCase("No")) {
				text = "No";
			} else {
				text = "yes";
			}
		}
	}

}
