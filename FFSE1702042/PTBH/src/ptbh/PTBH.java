package ptbh;
import java.util.Scanner;
public class PTBH {
	
	public static void main(String[] args) {
		String kt = "yes";
		while( kt == "yes") {
		System.out.print("Giải phương trình bậc 2\n");
		System.out.print("nhập a\n");
		Scanner Soa=new Scanner(System.in);
		int a = Soa.nextInt();
		System.out.print("nhập b\n");
		Scanner Sob=new Scanner(System.in);
		int b = Sob.nextInt();
		System.out.print("nhập c\n");
		Scanner Soc=new Scanner(System.in);
		int c = Soc.nextInt();
		int denta = b*b - 4*a*c;
		if( a==0) { 
			System.out.print("Sai đề: a khác 0\n");
			kt = "yes";
			
		}else {
		if( denta <0 ) {
			System.out.print("Vô nghiệm");
		}
		if( denta == 0) {
			System.out.print("X1 = X2 ="+ (-b)/(2*a));
		}
		if( denta > 0) {
			System.out.print("X1 = "+ (-b + Math.sqrt(denta))/(2*a) +"\n");
			System.out.print("X2 = "+ (-b - Math.sqrt(denta))/(2*a));
		}
		Scanner myInput2 = new Scanner(System.in);
		System.out.println("\n Nhấn phím bất kì để tiếp tục, nhấn N để kết thúc  ");
		kt = myInput2.nextLine();
		if (kt.equalsIgnoreCase("N") || kt.equalsIgnoreCase("No")) {
			break;
		} else {
			kt = "yes";
		}
		}
	  }
	}
}


