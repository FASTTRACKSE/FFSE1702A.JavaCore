package cuuchuong;

import java.util.Scanner;

public class cuuchuong {
	 public static void main(String args[]) {
		 String[] aryString = new String[10] ;
		 aryString[0] ="mươi";
		 aryString[1] ="một";
		 aryString[2] ="hai";
		 aryString[3] ="ba";
		 aryString[4] ="bốn";
		 aryString[5] ="năm";
		 aryString[6] ="sáu";
		 aryString[7] ="bảy";
		 aryString[8] ="tám";
		 aryString[9] ="chín";
		 
		
		 
		 Scanner bien = new Scanner(System.in);
		 System.out.println("Nhap vao 1 so : ");
		 int n = bien.nextInt();
		 int x = n/10;
		 int y = n-x*10;
		  if(x==1 && y==0) {
			 System.out.println("mười" );
			 
		 }
		  else if(x>1 && y==1) {
				 System.out.println(aryString[x] +" "+"mươi mốt" );
				 
			 }
		  else if(x==1) {
			 System.out.println("mười" +" "+aryString[y]);
		 }
		
		 else if(y==0) {
			 System.out.println(aryString[x] +" "+"mươi" );
			 
		 }
		
		
			 
		 else { 
		 System.out.println(aryString[x] +" "+"mươi" +" "+aryString[y]);

		 }
	 }

		 }
		 
		 
		 
				
