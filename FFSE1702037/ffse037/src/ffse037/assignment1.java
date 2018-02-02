package ffse037;
import java.util.Scanner;
public class assignment1 {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		for(;;) {
		System.out.print("nhập vào 1 số : ");
		int so1 = myInput.nextInt();
		
		  for (int i = 1; i < 11; i++ ) {
			  for (int j = 1; j <= so1; j++ ) {
				  int kq=j * i;
				  System.out.printf("%5d x %2d = %2d",j, i,kq );  
		      }
			  System.out.println();	 
			 
	      }
		  System.out.println("nhập N để dừng chương trình");
		  System.out.println("nhập phím bất kỳ để tiếp tục chương trình");
		  Scanner myInput1 = new Scanner(System.in);
		  String nhapchu = myInput1.nextLine();
		  String chu = "N";
		  
		  if(nhapchu.equals(chu)) {
			 break;
			  }
		}
		}
}
