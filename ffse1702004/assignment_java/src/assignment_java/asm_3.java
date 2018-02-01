package assignment_java;
import java.util.Scanner;

public class asm_3 { 
		public static void main(String args[]){ 
			Scanner myInput	= new Scanner(System.in);
			System.out.print("Nhập vào một 2 so bat ky  : ");
			int n = myInput.nextInt();	
			int a = n/10;
			int b = n%10;
			switch (a) {
			case 0:System.out.print("");break;
			case 1:System.out.print("muoi ");break;
			case 2:System.out.print("hai muoi ");break;
			case 3:System.out.print("ba muoi ");break;
			case 4:System.out.print("bon muoi ");break;
			case 5:System.out.print("nam muoi ");break;
			case 6:System.out.print("sau muoi ");break;
			case 7:System.out.print("bay muoi ");break;
			case 8:System.out.print("tam muoi ");break;
			case 9:System.out.print("chin muoi ");break;
			}
			switch (b) {
			case 0:System.out.print("");break;
			case 1:System.out.print("mot");break;
			case 2:System.out.print("hai ");break;
			case 3:System.out.print("ba ");break;
			case 4:System.out.print("bon ");break;
			case 5:System.out.print("nam ");break;
			case 6:System.out.print("sau ");break;
			case 7:System.out.print("bay  ");break;
			case 8:System.out.print("tam ");break;
			case 9:System.out.print("chin ");break;
			}
	}
}