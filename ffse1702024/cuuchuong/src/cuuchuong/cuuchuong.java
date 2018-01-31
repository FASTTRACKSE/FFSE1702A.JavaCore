package cuuchuong;
import java.util.Scanner; 
public class cuuchuong {
	
	

	    public void bang() { 
	        int n; 
	        Scanner s = new Scanner(System.in); 
	        System.out.print("nhap so : "); 
	        n = s.nextInt(); 
	        System.out.println("bang cuu chuong cua " + n +  " la"); 
	        for (int j = 0; j < 10; j++) { 
	            System.out.println(n + "x" + j + " = " + (j * n)); 
	        } 
	        System.out.println(""); 

	    } 

	    public static void main(String args[]) { 
	    	cuuchuong n = new cuuchuong(); 
	        n.bang(); 

	    } 
	} 