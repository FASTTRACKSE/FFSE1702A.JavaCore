package text;
import java.util.Scanner;
public class text
{
	public static void main(String[] args)
	{
	Scanner myInput = new Scanner(System.in);
	System.out.print("Nhập vào 1 số :");
	int number = myInput.nextInt();
	for(int i=1; i<=10; i++) {
		for(int j=1; j<=number; j++) {
			System.out.printf("%5d x %2d = %2d", j , i , i*j);
		}
		System.out.println("");
	}
	}
}
