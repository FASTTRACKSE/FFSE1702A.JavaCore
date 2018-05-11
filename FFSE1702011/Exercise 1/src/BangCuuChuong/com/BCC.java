package BangCuuChuong.com;
import java.util.Scanner;
public class BCC {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		int check = 1;
		while(check == 1) {
			System.out.print("Nhap vao 1 so: ");
			int number = myInput.nextInt();
			for(int i = 1; i <= 10; i++) {
				for(int j = 1; j <= number; j++) {
					System.out.printf("%d x %d = %d", j, i, j*i);
					System.out.print("	");
				}
				System.out.println();
			}
			System.out.println();
			System.out.print("Bạn có muốn tiếp tục - Ghi 1 để tiếp tục - Ghi 0 để dừng lại: ");
			check = myInput.nextInt();
		}
		System.out.println("Tạm biệt! Hẹn gặp lại!!");
	}
}
