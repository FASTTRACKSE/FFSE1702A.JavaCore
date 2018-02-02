package ffse037;
import java.util.Scanner;
public class assignment6 {
	 public static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	    	for(;;) {
	    		System.out.println();
	        System.out.print("Nhập số chữ điện hộ gia đình: ");
	        int n = scanner.nextInt();
	    	try {
	    		int a=50*1549;
	    		int b=50*1600;
	    		int c=50*1858;
	    		int d=50*2340;
	    		int e=50*2615;
	    		
	    		if(n<=50) {			
	    			int dntt= n*1549;
	    			int tiendien=dntt+(dntt*10/100);
	    			  System.out.println("tiền điện :"+tiendien);
	    			  
	    		}
	    		else if(n<=100) {			
	    			int dntt= a+((n-50)*1600);
	    			int tiendien=dntt+(dntt*10/100);
	    			  System.out.println("tiền điện :"+tiendien);
	    		}else if(n<=200) {
	    			int dntt= a+ b+((n-100)*1858);
	    			int tiendien=dntt+(dntt*10/100);
	    			  System.out.println("tiền điện :"+tiendien);
	    		}		
	    		else if(n<=300) {
	    			int dntt= a+b+c+((n-200)*2340);
	    			int tiendien=dntt+(dntt*10/100);
	    			  System.out.println("tiền điện :"+tiendien);
	    		}		
	    		else if(n<=400) {
	    			int dntt= a+b+c+d+((n-300)*2615);
	    			int tiendien=dntt+(dntt*10/100);
	    			  System.out.println("tiền điện :"+tiendien);
	    		}
	    		else if(n>400) {
	    			int dntt= a+b+c+d+e+((n-400)*2701);
	    			int tiendien=dntt+(dntt*10/100);
	    			  System.out.println("tiền điện :"+tiendien);
	    		}
	    	}catch(Exception ex) {
	    		System.out.println("vui lòng nhập số ");
	    	}
	        
	    }
	}
}
