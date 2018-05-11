import java.util.Scanner;

public class dien {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		 System.out.print("nhap so dien : "); 
		int n = s.nextInt();
	if(n<=50) {
		System.out.println("So tien la : " +(n*1.549)); 
		System.out.println("Thue VAT (10%): " +(n*1.549*0.1)); 
		System.out.println("Tong tien: " +((n*1.549)+(n*1.549*0.1))); 
		
	}
	else if(n<=100) {
		System.out.println("So tien la : " +(n*1.549)); 
		System.out.println("so tien la : " +(50*1.600)); 
		System.out.println("Thue VAT (10%): " +((n-50)*1.600*0.1)); 
		System.out.println("Tong tien: " +(((n-50)*1.600)+((n-50)*1.600*0.1))); 
		
	}
	}

}