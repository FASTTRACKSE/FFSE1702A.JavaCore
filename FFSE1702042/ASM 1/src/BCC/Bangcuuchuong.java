package BCC;
import java.util.Scanner;

public class Bangcuuchuong {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		do {
			System.out.print("Bạn chưa thuộc Bảng cửu chương nào");
			System.out.print(" nhập vào 1 số:");
			int i = myInput.nextInt();
			myInput.nextLine();
			for (int num = 1; num <= 10; num++) {
				for (int j = 1; j <= i; j++) {
					System.out.print(j + " x " + num + " = " + (num * j));
					System.out.print("		");
				}
				System.out.println();
			}
			System.out.print("Bạn có muốn tiếp tục không? (y/n) ");
			String check = myInput.nextLine();

			if ("n".equals(check)) {
				System.out.println("Bye Bye!");
				break;
			}
			System.out.println("");
		} while (true);

	}
}
