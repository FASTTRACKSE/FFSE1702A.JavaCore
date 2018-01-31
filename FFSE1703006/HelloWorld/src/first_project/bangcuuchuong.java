package first_project;
import java.util.Scanner;
import java.util.Arrays;
public class bangcuuchuong {

	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		int num;
		System.out.print("Input number: ");
		num = scanIn.nextInt();
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= num; j++) {
				System.out.print(j + " x " + i + " = " + i * j + "\t");
			}
			System.out.println();
		}
	}
	
}
