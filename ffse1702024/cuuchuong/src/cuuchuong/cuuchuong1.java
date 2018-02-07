package cuuchuong;
import java.util.Scanner; 
public class cuuchuong1 {
	
	

    public static void main(String args[]) { 
        Scanner s = new Scanner(System.in); 
        System.out.print("nhap 1 so : "); 
        int n = s.nextInt();  
        System.out.println("Bang cuu chuong " + n +  " la"); 
        for(int i = 1;i <= 10; i++) {
        	for (int j = 1; j <= n; j++) { 
        		System.out.print(j + " x " + i + " = " + (j * i));
        		System.out.print("		");
           
        	}
	        System.out.println(); 
	        
        } 
    }
}