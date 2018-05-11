
import java.util.Scanner;

public class Bangcuuchuong
{
	public static void main(String args[])
	{ 	
		int j = 9;
		do{
			System.out.print("Bảng Cửu Chương\n");
			Scanner myInput	= new Scanner(System.in);
			System.out.print("Nhập vào một số : ");
			j = myInput.nextInt();
			for (int k = 1 ; k <= 10 ;k++) 
				{
				for(int i = 1; i<=j;i++) 
					{
						System.out.format("%10d x %d = %2d",k,i,i*k);
					}
				System.out.println();
				}
		}while(j != 0 );
	}
}
