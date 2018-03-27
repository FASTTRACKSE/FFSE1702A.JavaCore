import java.util.Scanner;

public class Giaiphuongtrinh 
{
	public static void main(String args[])
	{
		int j = 9;
		do
		{
			System.out.print("tool giải phương trình bậc 2 1 ẩn : ax2 + bx +c = 0\n");
			Scanner myInput	= new Scanner(System.in);
			System.out.print("nhap vao a :");
			int a = myInput.nextInt();
			System.out.print("nhap vao b:");
			int b = myInput.nextInt();
			System.out.print("nhap vao c:");
			int c = myInput.nextInt();
			int result = b*b - 4*a*c;
			if(a == 0 && b == 0 && c == 0) 
			{
				System.out.print("phuong trinh nay vo so nghiem \n");
			}
			if(result < 0 ) 
			{
				System.out.print("phuong trinh nay vo nghiem\n");
			}else if (a != 0 && result == 0) 
			{
				System.out.print("phuong trinh nay co nghiem kep la : x1 = x2 = " + -b/2*a + "\n" );
			}else if (result > 0) 
			{
				 double x1 = (-b+Math.sqrt(result))/(2*a);
				 double x2 = (-b-Math.sqrt(result))/(2*a);
				 System.out.print("phuong trinh nay co nghiem x1 la : " + x1);
				 System.out.print("\nphuong trinh nay co nghiem x2 la : " + x2 +"\n"); 
			}
		}while(j != 0);
	}	
}
