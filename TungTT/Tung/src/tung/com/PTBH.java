package tung.com;
import java.util.Scanner;
public class PTBH {
		public static void main(String[] args) {
			System.out.println("Giải PT bậc 2");
			
			System.out.println("PTB2 có dạng  ax2 + bx + c = 0");
			do {
			Scanner so1 = new Scanner(System.in);
			System.out.println("a=");
			int a = so1.nextInt();
			Scanner so2 = new Scanner(System.in);
			System.out.println("b=");
			int b = so2.nextInt();
			Scanner so3 = new Scanner(System.in);
			System.out.println("c=");
			int c = so3.nextInt();
	        int d = b*b-4*a*c;
	        if (d<0) {
	        System.out.println("Phương trình vô nghiệm");
	        }
	        else {
	        if (d==0) {
	        System.out.println("Phương trình có nghiệm x1=x2="+(-b/(2*a)));
	        	
	        }	
	        
	        else{
	            
	            System.out.println("Phương trình có nghiệm x1="+((-b+Math.sqrt(d))/(2*a)));
	            System.out.println("Phương trình có nghiệm x2="+((-b-Math.sqrt(d))/(2*a)));
	            	
	            }	
	            }
	        System.out.print("Bạn có muốn tiếp tục không? (y/n) ");
			String check = so1.nextLine();

			if ("n".equals(check)) {
				System.out.println("Bye Bye!");
				break;
			}
			System.out.println("");
	} while (true);
		}
}
