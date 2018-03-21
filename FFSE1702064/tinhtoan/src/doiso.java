import java.util.Scanner;
public class doiso {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	for(;;) {
    System.out.println("Nhập vào một số từ 1 đến 9999: ");
    int n=input.nextInt();
    int ng=n/1000;
    int tr=(n-ng*1000)/100;
    int ch=(n-ng*1000-tr*100)/10;
    int dv=(n-ng*1000-tr*100-ch*10);
    if(n==0) {break;}
    if(n < 1 || n > 9999) { System.out.print("Mời nhập lại");}
    else {
    if (n==11) {
  	  System.out.print("mười một ");
    }
    else {
    	  switch(ng) {
         
         case 1:System.out.println("Một nghìn  ");break;
         case 2:System.out.print("Hai nghìn ");break;
         case 3:System.out.print("Ba nghìn  ");break;
         case 4:System.out.print("Bốn nghìn  ");break;
         case 5:System.out.print("Năm nghìn  ");break;
         case 6:System.out.print("Sáu nghìn  ");break;
         case 7:System.out.print("Bảy nghìn  ");break;
         case 8:System.out.print("Tám nghìn  ");break;
         case 9:System.out.print("Chín nghìn ");break;
     }
    	  switch(tr) {
         
         case 1:System.out.print("Một trăm  ");break;
         case 2:System.out.print("Hai trăm ");break;
         case 3:System.out.print("Ba trăm  ");break;
         case 4:System.out.print("Bốn trăm  ");break;
         case 5:System.out.print("Năm trăm  ");break;
         case 6:System.out.print("Sáu trăm  ");break;
         case 7:System.out.print("Bảy trăm  ");break;
         case 8:System.out.print("Tám trăm  ");break;
         case 9:System.out.print("Chín trăm ");break;
     }
           switch(ch) {
           
            case 1:System.out.print("Mười  ");break;
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

            case 1:System.out.println("mốt ");break;
            case 2:System.out.println("hai ");break;
            case 3:System.out.println("ba ");break;
            case 4:System.out.println("bốn ");break;
            case 5:System.out.println("lăm ");break;
            case 6:System.out.println("sáu ");break;
            case 7:System.out.println("bảy ");break;
            case 8:System.out.println("tám ");break;
            case 9:System.out.println("chín");break;
        }
    } 
    }
    System.out.println("Nhập 0 sẽ dừng lại");
}}
}