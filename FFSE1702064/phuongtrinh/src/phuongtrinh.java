import java.util.Scanner;

public class phuongtrinh {

	public static void main(String[] args) {
		Scanner sothu1 = new Scanner(System.in);
		for(;;) {
		System.out.println("Giải PT bậc 2 1 ẩn");
		System.out.println("PTB2 có dạng  ax2 + bx + c = 0");
		
		System.out.println("a=");
		int a = sothu1.nextInt();
		
		System.out.println("b=");
		int b = sothu1.nextInt();
		
		System.out.println("c=");
		int c = sothu1.nextInt();
        int x = b*b-4*a*c;
        if (a==0) { System.out.println("PT trở thành PT bậc nhất" ); }
        if (x<0&a!=0) {
        System.out.println("Phương trình vô nghiệm");
        }
        else {
        if (x==0&a!=0) {
        System.out.println("Phương trình có nghiệm x1=x2="+(-1*b/(2*a)));
        	
        }	
        
        if(x>0&a!=0){
            
            System.out.println("Phương trình có nghiệm x1="+((-1*b+Math.sqrt(x))/(2*a)));
            System.out.println("Phương trình có nghiệm x2="+((-1*b-Math.sqrt(x))/(2*a)));
            	
            }	
            }
        System.out.println("Nhấn N để kết thúc chương trình");
        System.out.println("Nhấn phím bất kỳ để tiếp tục");
        Scanner sothu2 = new Scanner(System.in);
        String nhap = sothu2.nextLine();
        String chu ="N";
        String chu1 ="n";
        if(nhap.equals(chu)||nhap.equals(chu1)) {
        	break;
        }
		}
	}
       
}
