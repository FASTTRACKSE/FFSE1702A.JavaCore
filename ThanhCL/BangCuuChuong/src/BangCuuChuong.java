import java.util.Scanner;

public class BangCuuChuong {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập vào 1 số : ");
		int so1 = myInput.nextInt();
		
		for (int i = 1; i< 11; i++) {
			System.out.printf("%d x %2d  = %2d", so1, 1, so1*i);
			System.out.printf("%20d x %2d  = %2d", so1+1, 1, (so1+1)*i);
			System.out.printf("%20d x %2d  = %2d\n", so1+2, 1, (so1+2)*i);
		}
	}

}
