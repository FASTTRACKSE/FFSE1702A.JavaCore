package cuuchuong;

import java.util.Scanner;

public class tiendien {
	 public static void main(String args[]) { 
	        Scanner sd = new Scanner(System.in); 
	        System.out.print("Nhap so dien : "); 
	        int n = sd.nextInt();  
	        if ( n <= 50) {
	        	   System.out.println("so tien cua "+ n +" so la : " + (n * 1.549) + " vnd "); 
	        	   System.out.println("thue 10 % : "+ (n * 1.549*0.1));
	        	   System.out.println("Tong tien : "+ ((n * 1.549*0.1) + (n*1.549))+ " vnd ");
	        	   
	        }
	        else if(n <= 100) {
	        	System.out.println("so tien Bac 1 cua 50 so dien la : " + (50 * 1.549)+ " vnd ");
	        	System.out.println("so tien Bac 2 cua "+ (n-50) +" so dien la : " + ((n-50) * 1.600)+ " vnd ");
	        	 System.out.println("thue 10 % : "+ (((50 * 1.549 + (n-50)*1.600))*0.1));
	        	   System.out.println("Tong tien : "+ (((50 * 1.549 + (n-50)*1.600)*0.1) + ((50 * 1.549 + (n-50)*1.600)))+ " vnd ");
	        }
	        else if(n <= 200) {
	        	System.out.println("so tien Bac 1 cua 50 so dien  la : " + (50 * 1.549)+ " vnd ");
	        	System.out.println("so tien Bac 2 cua 50 so dien  la : " + (50 * 1.600)+ " vnd ");
	        	System.out.println("so tien Bac 3 cua "+ (n-100) +" so dien la : " + ((n-100) * 1.858)+ " vnd ");
	        	 System.out.println("thue 10 % : "+ (((50 * 1.549 + 50 * 1.600+(n-100)*1.858))*0.1));
	        	   System.out.println("Tong tien : "+ (((50 * 1.549 + 50 * 1.600+(n-100)*1.858)*0.1) + ((50 * 1.549 + 50*1.600 +(n-100)*1.858)))+ " vnd ");
	        }
	        else if(n <= 300) {
	        	System.out.println("so tien Bac 1 cua 50 so dien la : " + (50 * 1.549)+ " vnd ");
	        	System.out.println("so tien Bac 2 cua 50 so dien la : " + (50 * 1.600)+ " vnd ");
	        	System.out.println("so tien Bac 3 cua 100 so dien la : " + (100 * 1.858)+ " vnd ");
	        	System.out.println("so tien Bac 4 cua "+ (n-200) +" so dien la : " + ((n-200) * 2.340)+ " vnd ");
	        	 System.out.println("thue 10 % : "+ (((50 * 1.549 + 50 * 1.600+ 100 *1.858 +(n-200)*2.340))*0.1));
	        	   System.out.println("Tong tien : "+ (((50 * 1.549 + 50 * 1.600+ 100*1.858 +(n-200)*2.340)*0.1) + ((50 * 1.549 + 50*1.600 +100*1.858+(n-200)*2.340)))+ " vnd ");
	        }
	        else if(n <= 400) {
	        	System.out.println("so tien Bac 1 cua 50 so dien la : " + (50 * 1.549)+ " vnd ");
	        	System.out.println("so tien Bac 2 cua 50 so dien la : " + (50 * 1.600)+ " vnd ");
	        	System.out.println("so tien Bac 3 cua 100 so dien la : " + (100 * 1.858)+ " vnd ");
	        	System.out.println("so tien Bac 4 cua 100 so dien la : " + (100 * 2.340)+ " vnd ");
	        	System.out.println("so tien Bac 5 cua "+ (n-300) +" so dien la : " + ((n-300) * 2.615)+ " vnd ");
	        	 System.out.println("thue 10 % : "+ (((50 * 1.549 + 50 * 1.600+ 100 *1.858 +100*2.340+(n-300) * 2.615))*0.1));
	        	   System.out.println("Tong tien : "+ (((50 * 1.549 + 50 * 1.600+ 100*1.858 +100*2.340+(n-300) * 2.615)*0.1) + ((50 * 1.549 + 50*1.600 +100*1.858+100*2.340+(n-300) * 2.615)))+ " vnd ");
	        }
	        else{
	        	System.out.println("so tien Bac 1 cua 50 so dien la : " + (50 * 1.549)+ " vnd ");
	        	System.out.println("so tien Bac 2 cua 50 so dien la : " + (50 * 1.600)+ " vnd ");
	        	System.out.println("so tien Bac 3 cua 100 so dien la : " + (100 * 1.858)+ " vnd ");
	        	System.out.println("so tien Bac 4 cua 100 so dien la : " + (100 * 2.340)+ " vnd ");
	        	System.out.println("so tien Bac 5 cua 100 so dien la : " + ((n-300) * 2.615)+ " vnd ");
	        	System.out.println("so tien Bac 6 cua "+ (n-400) +" so dien la : " + ((n-400) * 2.701)+ " vnd ");
	        	 System.out.println("thue 10 % : "+ (((50 * 1.549 + 50 * 1.600+ 100 *1.858 +100*2.340+100 * 2.615+(n-400) * 2.701))*0.1));
	        	   System.out.println("Tong tien : "+ (((50 * 1.549 + 50 * 1.600+ 100*1.858 +100*2.340+100 * 2.615+(n-400) * 2.701)*0.1) + ((50 * 1.549 + 50*1.600 +100*1.858+100*2.340+100 * 2.615+(n-400) * 2.701)))+ " vnd ");
	        }
	        }
	       }
