package ffse037;

import java.util.Scanner;

public class assignment2 {
	public static void main(String[] args) {
		for(int k=1; k<1000; k++) {
		 int a,b,c,d,n;
		 Scanner myInput = new Scanner(System.in);
		 System.out.print("nhập 1 số : ");	
		 n = myInput.nextInt();
		 a = Math.round(n/1000);
            switch(a){
                                     case 1:  System.out.print("một nghìn");break;
                                     case 2:  System.out.print("hai nghìn") ; break;
                                     case 3:  System.out.print (" ba nghìn"); break;
                                     case 4:  System.out.print("bốn nghìn"); break;
                                     case 5:  System.out.print ("năm mươi"); break;
                                     case 6:  System.out.print("sáu nghìn"); break;
                                     case 7:  System.out.print("bảy nghìn"); break;
                                     case 8:  System.out.print("tám nghìn"); break;
                                     case 9:  System.out.print ("chín nghìn"); break;
                                      }
            b = Math.round((n-a*1000)/100);
            switch(b){
            						case 0:  System.out.print(" không trăm");break;
                                     case 1:  System.out.print(" một trăm");break;
                                     case 2:  System.out.print(" hai trăm") ; break;
                                     case 3:  System.out.print (" ba trăm"); break;
                                     case 4:  System.out.print(" bốn trăm"); break;
                                     case 5:  System.out.print (" năm mươi"); break;
                                     case 6:  System.out.print(" sáu trăm"); break;
                                     case 7:  System.out.print(" bảy trăm"); break;
                                     case 8:  System.out.print(" tám trăm"); break;
                                     case 9:  System.out.print (" chín trăm"); break;
                                      }
  
	     c = Math.round((n-a*1000-b*100)/10);
            switch(c){
            						 case 0:  System.out.print(" linh");break;
                                     case 1:  System.out.print(" mười");break;
                                     case 2:  System.out.print(" hai mươi") ; break;
                                     case 3:  System.out.print (" ba mươi"); break;
                                     case 4:  System.out.print(" bốn mươi"); break;
                                     case 5:  System.out.print (" năm mươi"); break;
                                     case 6:  System.out.print(" sáu mươi"); break;
                                     case 7:  System.out.print(" bảy mươi"); break;
                                     case 8:  System.out.print(" tám mươi"); break;
                                     case 9:  System.out.print (" chín mươi"); break;
                                      }
  
 d = n-a*1000-b*100-c*10;
             switch(d){
             	
                                       
                                        case 2: System.out.println(" hai");break;
                                        case 3: System.out.println(" ba");break;
                                        case 4: System.out.println (" bốn");break;
                                        case 5: System.out.println(" lăm");break;
                                        case 6: System.out.println (" sáu"); break;
                                        case 7: System.out.println (" bảy");break;
                                        case 8: System.out.println (" tám"); break;
                                        case 9:  System.out.println(" chín"); break;
                      }
             if(d==1) {
            	
            	 if(c<=1) {
            		 System.out.println(" Một");
            	 }else {
            		 System.out.println(" Mốt");
            	 }
             }
             System.out.println("bạn có muốn chạy lại chương trình không");
       	  Scanner myInput1 = new Scanner(System.in);
       	  String nhapchu = myInput1.nextLine();
       	  String chu = "N";
       	  if(nhapchu.equals(chu)) {
       		 break;
       		  }
          }
	}
}