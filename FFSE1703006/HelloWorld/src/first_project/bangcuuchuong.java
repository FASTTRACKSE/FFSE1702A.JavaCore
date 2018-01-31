package first_project;
import java.util.Scanner;
public class bangcuuchuong {

	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		int num;
		System.out.print("Input number: ");
		num = scanIn.nextInt();
        for ( int i = 1; i<= 10 ; i ++) {
            System.out.println(num  + " x " + i + " = " + i * num);
        }
	}
}
