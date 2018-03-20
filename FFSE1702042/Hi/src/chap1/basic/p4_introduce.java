package chap1.basic;
import java.util.Scanner;
public class p4_introduce {
	public static void main(String[] args) {
		Scanner input	= new Scanner(System.in);
		System.out.println("Hãy nhập vào 1 số");
		int n	=	input.nextInt();
		String str1= " dương";
		String str2	= " chẵn";
		if(n==0) {System.out.println("số không");}
		else {
			if (n<0) str1=" âm";
		    if(n%2!=0) str2=" lẻ";}
		System.out.println("Số nguyên"+ str1 +str2);
	}
}
