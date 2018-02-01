package tung;
import java.util.Scanner;
public class Hello {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	      System.out.print("Nhập vào một số có hai chữ số: ");
	      int n=input.nextInt();
	      int ch=n/10;
	      int dv= n%10;
	    if(n==0) {
	    	System.out.print("Không");
	    }
	   if (n==11) {
		   System.out.println("Mười một");
	   }else if(n==1) {
		   System.out.println("Một");
	   }else {
	      
	             switch(ch) {
	             case 0:System.out.print("");break;
	              case 1:System.out.print("mười  ");break;
	              case 2:System.out.print("Hai mươi ");break;
	              case 3:System.out.print("Ba mươi  ");break;
	              case 4:System.out.print("Bốn mươi  ");break;
	              case 5:System.out.print("Năm mươi  ");break;
	              case 6:System.out.print("Sáu mươi  ");break;
	              case 7:System.out.print("Bảy mươi  ");break;
	              case 8:System.out.print("Tám mươi  ");break;
	              case 9:System.out.print("Chín mươi ");break;
	          }
	                switch(dv) {
	                
	              case 1:System.out.print("mốt ");break;
	              case 2:System.out.print("hai ");break;
	              case 3:System.out.print("ba ");break;
	              case 4:System.out.print("bốn ");break;
	              case 5:System.out.print("lăm ");break;
	              case 6:System.out.print("sáu ");break;
	              case 7:System.out.print("bảy ");break;
	              case 8:System.out.print("tám ");break;
	              case 9:System.out.print("chín");break;
	          }
	   }
	}
	}


