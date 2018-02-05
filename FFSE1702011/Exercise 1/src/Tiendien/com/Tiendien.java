package Tiendien.com;
import java.util.*;
public class Tiendien {
	public static void main(String[] args) {
		int n,t;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập số điện sử dụng: ");
		n = myInput.nextInt();
		System.out.print("Tiền điện tính được là: ");
		if(n > 0 && n <= 50) {
			t = n * 1549;
			System.out.print(t + " VNĐ");
		}
		else if(n > 50 && n <= 100) {
			t = n * 1600;
			System.out.print(t + " VNĐ");
		}
		else if(n > 100 && n <= 200) {
			t = n * 1858;
			System.out.print(t + " VNĐ");
		}
		else if(n > 200 && n <= 300) {
			t = n * 2340;
			System.out.print(t + " VNĐ");
		}
		else if(n > 300 && n <= 400) {
			t = n * 2615;
			System.out.print(t + " VNĐ");
		}
		else {
			t = n * 2701;
			System.out.print(t + " VNĐ");
		}
	}
}
