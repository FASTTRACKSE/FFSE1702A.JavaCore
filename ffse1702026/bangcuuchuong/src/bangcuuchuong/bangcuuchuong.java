package bangcuuchuong;
import java.util.Scanner; 
public class bangcuuchuong {

	public static void main(String args[]) { 
			String text= "yes";
			while(text=="yes") {
	        int t=1; 
	        int n;
	        Scanner myInput = new Scanner(System.in); 
	        System.out.print("nhap n : "); 
	        n = myInput.nextInt(); 
	        System.out.println("Bảng cửu chương từ " + t + " đến  "+ n
	        		+ " la"); 
	        
	        for (int i = 1; i <= 10; i++) { 
	        	for (int j=1;j<=n;j++) {
	        		if(j==1) {
	        			System.out.printf("%2d x %2d = %2d",j,i,i*j); 
	        		}
	        		else {
	        			System.out.printf("%12d x %2d = %2d",j,i,i*j);
	        		}
	        	 }
	        	System.out.println(""); 
	        }
	        Scanner myInput2 = new Scanner(System.in);
	        System.out.print("Bạn có muốn tiếp tục không  "); 
	        text = myInput2.nextLine();
	        if(text.equalsIgnoreCase("N")||text.equalsIgnoreCase("No")) {
	        	text="No";
	        }
	        else {
	        	text="yes";
	        }
	    } 

	}
	    
	

}
