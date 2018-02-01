package text;
import java.util.Scanner;
public class Maytinhcanhan {
	public static void main(String[] args)
	{
	for(int i=1; i>=i++; i++) {
		System.out.println(">> MÁY TÍNH CÁ NHÂN <<");
		System.out.println("+--------------------+");
		System.out.println("+|    1. Cộng       |+");
		System.out.println("+|    2. Trừ        |+");
		System.out.println("+|    3. Kết thúc   |+");
		System.out.println("+--------------------+");
		System.out.println("");
		System.out.println("+>> Chọn chức năng <<+");
	
	Scanner myInput = new Scanner(System.in);
	int answer = myInput.nextInt();
	try {
	if(answer == 1) {
		int c;
		System.out.print("Nhập a =");
		int a = myInput.nextInt();
		System.out.print("Nhập b =");
		int b = myInput.nextInt();
		c = a + b;
		System.out.println(">> Kết quả phép cộng: " + a + " + " + b + " = " + c + " <<");
	}
	
	else if(answer == 2) {
		int c;
		System.out.print("Nhập a =");
		int a = myInput.nextInt();
		System.out.print("Nhập b =");
		int b = myInput.nextInt();
		c = a - b;
		System.out.println(">> Kết quả phép trừ: " + a + " - " + b + " = " + c + " <<");
	}
	
	else if(answer == 3) {
		System.exit(0);
	}
	
	else {
		System.out.println("+>> Nhập sai chức năng vui lòng nhập lại <<+");
	}
	}
	catch (Exception e) {
        System.out.println("+>> Error! Vui lòng nhập lại <<+");
    }
	}
	}
}
