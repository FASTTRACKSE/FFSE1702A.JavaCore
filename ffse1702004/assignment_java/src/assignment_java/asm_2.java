package assignment_java;

import java.util.Scanner;

public class asm_2 {
	public static void main(String args[]){ 
	Scanner myInput	= new Scanner(System.in);
	System.out.print("Nhập vào một số : ");
	int j = myInput.nextInt();
	for(int i = 1; i<=10;i++) {
	System.out.format("%2d x %d = %3d\n",j,i,i*j);

	}
	}

}
