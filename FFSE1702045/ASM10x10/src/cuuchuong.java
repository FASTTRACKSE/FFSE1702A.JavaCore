import java.util.Scanner;
public class cuuchuong {
	
	public static void main(String[] args) {
		 Scanner bien = new Scanner(System.in);
		 System.out.println("Nhap vao 1 so : ");
	       int n = bien.nextInt();
	       
	       for ( int j = 2; j<= 9 ; j ++) {
	            for ( int i = 1; i<= n ; i ++) {
	                System.out.print(i  + " x " + j + " = " + i * j + "\t");
	            }
	            System.out.println("			"); 
	       }
	}
}