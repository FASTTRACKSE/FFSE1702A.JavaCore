import java.util.Scanner;
public class Longtlp {
public static void main(String[] args) {
	String kt = "yes";
	
	while( kt == "yes") {
	Scanner myInput = new Scanner(System.in);
	System.out.print("Nhập số từ 1 đến 9999 :\n ");
    int n=myInput.nextInt();
    int ng=n/1000;
    int tr=(n%1000)/100;
    int ch=((n%1000)%100)/10;
    int dv= n%10;
   
    if ( n < 1 || n > 9999)
    {
    	System.out.print("Vui lòng nhập số từ 1 đến 9999:\n ");
    	kt = "yes";
    }else {
    switch(ng) {
    
     case 1:System.out.print("một nghìn ");break;
     case 2:System.out.print("Hai nghìn ");break;
     case 3:System.out.print("Ba nghìn  ");break;
     case 4:System.out.print("Bon nghìn ");break;
     case 5:System.out.print("Nam nghìn ");break;
     case 6:System.out.print("Sau nghìn ");break;
     case 7:System.out.print("Bay nghìn ");break;
     case 8:System.out.print("Tam nghìn ");break;
     case 9:System.out.print("Chin nghìn ");break;
 }
       switch(tr) {
    case 0: if ( ng != 0) {System.out.print(" khong trăm ");}break;
     case 1:System.out.print("Một trăm ");break;
     case 2:System.out.print("Hai trăm ");break;
     case 3:System.out.print("Ba trăm  ");break;
     case 4:System.out.print("Bon trăm ");break;
     case 5:System.out.print("Nam trăm ");break;
     case 6:System.out.print("Sau trăm ");break;
     case 7:System.out.print("Bay trăm ");break;
     case 8:System.out.print("Tam trăm ");break;
     case 9:System.out.print("Chin trăm ");break;
 }
           switch(ch) {
           case 0: if (tr != 0) {System.out.print("Le ");}break;
            case 1:System.out.print("Muoi");break;
            case 2:System.out.print("Hai muoi ");break;
            case 3:System.out.print("Ba muoi  ");break;
            case 4:System.out.print("Bon muoi ");break;
            case 5:System.out.print("Nam muoi ");break;
            case 6:System.out.print("Sau muoi ");break;
            case 7:System.out.print("Bay muoi ");break;
            case 8:System.out.print("Tam muoi ");break;
            case 9:System.out.print("Chin muoi ");break;
        }
              switch(dv) {

            case 1:
            	if (ch == 1||ch==0) {
				 System.out.println("một ");break;
			    } else {
				System.out.println("mốt ");break;
			    }
            case 2:System.out.print("hai \n ");break;
            case 3:System.out.print("ba  \n ");break;
            case 4:System.out.print("bốn \n ");break;
            case 5:System.out.print("lăm \n ");break;
            case 6:System.out.print("sáu \n ");break;
            case 7:System.out.print("bảy \n ");break;
            case 8:System.out.print("tám \n ");break;
            case 9:System.out.print("chín\n");break;
        }
              
				
    }      
    }           
 }
}
