import java.util.Scanner;

public class phuongtrinh {

	public static void main(String[] args) {
		System.out.println("Giải PT bậc 2 1 ẩn");
		System.out.println("PTB2 có dạng  ax2 + bx + c = 0");
		Scanner sothu1 = new Scanner(System.in);
		System.out.println("a=");
		int a = sothu1.nextInt();
		Scanner sothu2 = new Scanner(System.in);
		System.out.println("b=");
		int b = sothu2.nextInt();
		Scanner sothu3 = new Scanner(System.in);
		System.out.println("c=");
		int c = sothu3.nextInt();
        int x = b*b-4*a*c;
        if (x<0) {
        System.out.println("Phương trình vô nghiệm");
        }
        else {
        if (x==0) {
        System.out.println("Phương trình có nghiệm x1=x2="+(-1*b/(2*a)));
        	
        }	
        
        else{
            
            System.out.println("Phương trình có nghiệm x1="+((-1*b+Math.sqrt(x))/(2*a)));
            System.out.println("Phương trình có nghiệm x2="+((-1*b-Math.sqrt(x))/(2*a)));
            	
            }	
            }
	}
       
}
