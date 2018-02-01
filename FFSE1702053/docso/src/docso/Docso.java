package docso;
import java.util.Scanner; 

public class Docso {

	public static void main(String[] args) {
		 int a,b,c,d,n;
		 Scanner myInput = new Scanner(System.in);
		 System.out.print("nhập số : ");	
		 n = myInput.nextInt();
	     a = Math.round(n/1000);
            switch(a){
                                     case 1:  System.out.print("một ngàn "); ;break;
                                     case 2:  System.out.print(" hai ngàn ") ; break;
                                     case 3:  System.out.print (" ba ngàn  "); break;
                                     case 4:  System.out.print(" bốn ngàn  "); break;
                                     case 5:  System.out.print (" năm ngàn  "); break;
                                     case 6:  System.out.print(" sáu ngàn  "); break;
                                     case 7:  System.out.print(" bảy ngàn  "); break;
                                     case 8:  System.out.print(" tám ngàn  "); break;
                                     case 9:  System.out.print (" chín ngàn "); break;
                                      }
  
            b = (n-(a*1000))/100; 
             switch(b){
                                        case 0: System.out.print(" Không trăm");break;
                                        case 1: System.out.print(" một trăm"); break;
                                        case 2: System.out.print(" hai trăm");break;
                                        case 3: System.out.print(" ba trăm");break;
                                        case 4: System.out.print (" bốn trăm");break;
                                        case 5: System.out.print(" năm trăm");break;
                                        case 6: System.out.print (" sáu trăm"); break;
                                        case 7: System.out.print (" bảy trăm");break;
                                        case 8: System.out.print (" tám trăm"); break;
                                        case 9:  System.out.print(" chín trăm"); break;
                      }
             c = (n-((a*1000)+(b*100)))/10; 
             switch(c){
                                       case 0: System.out.print(" lẻ");break;
                                       case 1: System.out.print(" mười"); break;
                                       case 2: System.out.print(" hai mươi");break;
                                       case 3: System.out.print(" ba mươi");break;
                                       case 4: System.out.print (" bốn mươi");break;
                                       case 5: System.out.print(" năm mươi");break;
                                       case 6: System.out.print (" sáu mươi"); break;
                                       case 7: System.out.print (" bảy mươi");break;
                                       case 8: System.out.print (" tám mươi"); break;
                                       case 9:  System.out.print(" chín mươi"); break;
                    }
             d = (n-((a*1000)+(b*100)+(c*10)));
             switch(d){
                                     
                                       case 1:if(a<=1) { System.out.print(" một"); break;}else {System.out.print(" mốt"); break;}
                                       case 2: System.out.print(" hai ");break;
                                       case 3: System.out.print(" ba ");break;
                                       case 4: System.out.print (" bốn");break;
                                       case 5: System.out.print(" năm ");break;
                                       case 6: System.out.print (" sáu"); break;
                                       case 7: System.out.print (" bảy");break;
                                       case 8: System.out.print (" tám"); break;
                                       case 9:  System.out.print(" chín"); break;
                    }
          }
}
