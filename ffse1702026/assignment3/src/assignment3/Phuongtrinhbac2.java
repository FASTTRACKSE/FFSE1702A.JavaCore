package assignment3;
import java.util.Scanner;

public class Phuongtrinhbac2 {

	public static void main(String[] args) {
		float a,b,c;
		double x1,x2,delta;
		try {
		System.out.println("giải phương  trình bậc 2: ax2 + bx + c= 0");
		System.out.print("nhập a: ");
		Scanner input= new Scanner(System.in);
		a=input.nextFloat();
		System.out.print("nhập b: ");
		Scanner input1= new Scanner(System.in);
		b=input1.nextFloat();
		System.out.print("nhập c: ");
		Scanner input2= new Scanner(System.in);
		c=input2.nextFloat();
		if (a==0)
		{
			if (b==0)
			{
				if (c==0) System.out.println("Phuong trinh vo so nghiem");
				else System.out.printf("Phuong trinh vo nghiem");
			}
			else
			{
				x1=-c/b;
				System.out.printf("Phuong trinh co 1 nghiem:%.2f",x1);
			}
		}
		else {
		delta = Math.pow(b,2) - 4*a*c;
		if (delta<0) {
			System.out.print("Phương trình vô nghiệm ");
		}
		else if (delta==0) {
			x1=-b/(2*a);
			System.out.printf("Phương trình có nghiệm kép : x1=x2= %.2f",x1);
		}
		else {
			x1=(-b+Math.sqrt(delta))/(2*a);
			x2=(-b-Math.sqrt(delta))/(2*a);
			System.out.printf("Phương trình có 2 nghiệm  : x1=%.2f và x2=%.2f",x1,x2);
		}
		}
		}
		catch(Exception ex) {
			System.out.print("Vui lòng nhập số ");
		}
	}

}
