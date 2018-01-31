package bangcuuchuong;
import java.util.Scanner; 
public class bangcuuchuong {

	public static void main(String args[]) {  
	        int t=1; 
	        int n;
	        Scanner myInput = new Scanner(System.in); 
	        System.out.print("nhap n : "); 
	        n = myInput.nextInt(); 
	        System.out.println("bang cuu chuong tu " + t + " den  "+ n
	        		+ " la"); 
	        
	        for (int i = 1; i <= 10; i++) { 
	        	for (int j=1;j<=n;j++) {
	            System.out.print(j + " x " + i + " = " + (i * j)+ "    "); 
	        	 }
	        	System.out.println(""); 
	        } 
	        
	       
	        

	    } 

	    
	    
	

}
