package as1;
import java.util.Scanner; 
public class bcc {
	 public static void main(String[] args) { 
	         
	        Scanner s = new Scanner(System.in); 
	        System.out.print("Nhập vào 1 số: "); 
	        int n = s.nextInt();
	        System.out.println("Bảng cửu chương của " + n + " là:");
	        for (int j = 0; j < 10; j++) { 
	            System.out.println(n + " x " + j + " = " + (j * n)); 
	        } 
	        System.out.println(""); 
}

   
} 