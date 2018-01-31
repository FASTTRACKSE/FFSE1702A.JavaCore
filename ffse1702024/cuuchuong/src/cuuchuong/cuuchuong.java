package cuuchuong;
import java.util.Scanner; 
public class cuuchuong {
	
	

	    public static void main(String args[]) { 
	        int n; 
	        Scanner s = new Scanner(System.in); 
	        System.out.print("nhap 1 so : "); 
	        n = s.nextInt(); 
	        System.out.println("Bang cuu chuong " + n +  " la"); 
	        for (int j = 0; j < 10; j++) { 
	            System.out.println(n + " x " + j + " = " + (j * n)); 
	        } 
	        System.out.println("");
	    } 
	} 