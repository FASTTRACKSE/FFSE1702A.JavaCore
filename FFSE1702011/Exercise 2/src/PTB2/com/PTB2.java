package PTB2.com;
import java.util.Scanner;
public class PTB2 {
	public static void main(String[] args) {
		float a,b,c;
		Scanner myInput = new Scanner(System.in);
		String check = "Y";
		
		while(check.equals("Y")) {
			System.out.print("Nhập vào số a: ");
			a = myInput.nextFloat();
			System.out.print("Nhập vào số b: ");
			b = myInput.nextFloat();
			System.out.print("Nhập vào số c: ");
			c = myInput.nextFloat();
			
			if(a == 0) {
				System.out.println("x = " + (-c/b));
			} else {
				float dt = b*b - 4*a*c;
				if(dt < 0) {
					System.out.println("Phương trình vô nghiệm");
				} else if (dt == 0) {
					System.out.println("Phương trình có nghiệm kép: x1 = x2 = " + (-b/(2*a)));
				} else {
					System.out.println("Phương trình có 2 nghiệm: ");
					System.out.println("x1 =" + ((-b + Math.sqrt(dt))/2*a));
					System.out.println("x2 =" + ((-b - Math.sqrt(dt))/2*a));
				}
			}
			Scanner myCheck = new Scanner(System.in);
			System.out.print("Bạn có muốn tiếp tục - Nhập Y để tiếp tục - Nhập bất kì để kết thúc: ");
			check = myCheck.nextLine();
		}
	}
}
