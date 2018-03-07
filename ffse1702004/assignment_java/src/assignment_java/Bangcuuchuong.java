package assignment_java;

import java.util.Scanner;

public class Bangcuuchuong
{
	public static void main(String args[])
	{ 
		
	Scanner myInput	= new Scanner(System.in);
	System.out.print("Nhập vào một số : ");
	int j = myInput.nextInt();
	for (int k = 1 ; k <= j ;k++) 
		{
		for(int i = 1; i<=10;i++) 
			{
				System.out.format("%2d x %d = %2d",k,i,i*k);
			}
			System.out.println();
		}
	}
}
