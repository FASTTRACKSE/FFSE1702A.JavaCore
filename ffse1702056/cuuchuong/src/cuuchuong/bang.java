package cuuchuong;

import java.util.Scanner;
public class bang {

	public static void main(String[] args) {
		
		  
	        Scanner s = new Scanner(System.in); 
	        System.out.print("nhap  : "); 
	        int n = s.nextInt(); 
	        for (int j = 2; j < 11; j++) { 
	        for (int i = 1; i <=n; i++) { 
	            System.out.print(i + " x " + j + " = " + i*j +"	"); 
	        } 
	        System.out.println("	"); 

	        }
	        
	        		
	      
	}

}
