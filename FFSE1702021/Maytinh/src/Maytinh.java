
import java.util.Scanner;
public class Maytinh {
	public static void main(String[] args) {
       System.out.print(">> MÁY TÍNH CÁ NHÂN <<\n");
       System.out.print(" +-----------------+\n");
       System.out.print(" |1. Cộng          |\n");
       System.out.print(" |2. Trừ           |\n");
       System.out.print(" |3. Kết thúc      |\n");
       System.out.print(" +-----------------+\n");
       System.out.print(">> Chọn chức năng <<");
       
      
       Scanner scanner = new Scanner(System.in);
       int answer = scanner.nextInt();
      
    	   
           
       
     
       if( answer == 1) {
    	   System.out.print("Chi nhap 2 so:\n");
    	   System.out.print("Nhap so 1:\n");
    	   Scanner myInput=new Scanner(System.in);
    	   int a =  myInput.nextInt();
    	   System.out.print("Nhap so 2:\n");
    	   Scanner myInput2=new Scanner(System.in);
    	   int b =  myInput2.nextInt();
    	   System.out.print(a +" + " +b +" = "+(a+b));
    	   
    	   
       }
       else if( answer == 2 ) {
    	   System.out.print("Chi nhap 2 so:\n");
    	   System.out.print("Nhap so 1:\n");
    	   Scanner myInput3=new Scanner(System.in);
    	   int a =  myInput3.nextInt();
    	   System.out.print("Nhap so 2:\n");
    	   Scanner myInput4=new Scanner(System.in);
    	   int b =  myInput4.nextInt();
    	   System.out.print(a +" - " +b +" = "+(a-b));
       }
       else if( answer == 3 ) {
    	   System.out.print("Bye");
    	   
       }
     
 
} 
}
