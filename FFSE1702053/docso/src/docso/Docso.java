package docso;
import java.util.Scanner; 

public class Docso {

	public static void main(String[] args) {
		 int a,b,n;
		 Scanner myInput = new Scanner(System.in);
		 System.out.print("nhập 2 số : ");	
		 n = myInput.nextInt();
	     a = Math.round(n/10);
            switch(a){
                                     case 1:  System.out.print("mười"); ;break;
                                     case 2:  System.out.print(" hai mươi") ; break;
                                     case 3:  System.out.print (" ba mươi "); break;
                                     case 4:  System.out.print(" bốn mươi "); break;
                                     case 5:  System.out.print (" năm mươi "); break;
                                     case 6:  System.out.print(" sáu mươi "); break;
                                     case 7:  System.out.print(" bảy mươi "); break;
                                     case 8:  System.out.print(" tám mươi "); break;
                                     case 9:  System.out.print (" chín mươi"); break;
                                      }
  
  b = n-(a*10);
             switch(b){
                                        case 1:if(a<=1) { System.out.print(" một"); break;}else {System.out.print(" mốt"); break;}
                                        case 2: System.out.print(" hai");break;
                                        case 3: System.out.print(" ba ");break;
                                        case 4: System.out.print (" bốn");break;
                                        case 5: System.out.print(" lăm");break;
                                        case 6: System.out.print (" sáu "); break;
                                        case 7: System.out.print (" bảy");break;
                                        case 8: System.out.print (" tám"); break;
                                        case 9:  System.out.print(" chín"); break;
                      }
          }
}
