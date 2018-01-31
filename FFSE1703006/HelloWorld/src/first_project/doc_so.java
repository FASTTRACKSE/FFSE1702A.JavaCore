package first_project;

import java.util.*;

public class doc_so {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanIn = new Scanner(System.in);
		int num, num1, num2;
		System.out.print("Input num: ");
		num = scanIn.nextInt();
		num1 = num / 10;
		num2 = num % 10;
		String read[] = { "mươi", "mốt", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };
		if (num == 10) {
			System.out.println(num + " => " + "mười ");
		} else if (num1 == 1) {
			read[1] = "một";
			System.out.println(num + " => " + "mười " + read[num2]);
		} else if (num2 == 0) {
			System.out.println(num + " => " + read[num1] + " " + read[num2]);
		} else {
			System.out.println(num + " => " + read[num1] + " mươi " + read[num2]);
		}
	}
}
