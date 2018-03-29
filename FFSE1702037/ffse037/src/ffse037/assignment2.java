package ffse037;

import java.util.Scanner;

public class assignment2 {
	public static void main(String[] args) {
<<<<<<< HEAD
		for(;;) {
		 int a,b,c,d,n;
		 Scanner myInput = new Scanner(System.in);
		 System.out.print("nhập 1 số : ");	
		 
		 n = myInput.nextInt();
		 a = Math.round(n/1000);
		 b = Math.round((n-a*1000)/100);
		 c = Math.round((n-a*1000-b*100)/10);
		 d = n-a*1000-b*100-c*10;
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
            if(b==0 && d>0 ) {System.out.print(" không trăm");}
           
            switch(b){
            						
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
            if(c==0 && d>0) {System.out.print(" linh");}
	   
            switch(c){
            						
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
  

             switch(d){
             	
                                       
                                        case 2: System.out.println(" hai");break;
                                        case 3: System.out.println(" ba");break;
                                        case 4: System.out.println (" bốn");break;
                                   
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
             }else if(d==5) {
            	 if(c>=1) {
            		 System.out.println(" lăm");
            	 }else {
            		 System.out.println(" năm");
            	 }
             }
            
             System.out.println();
             System.out.println("nhập N để dừng chương trình");
   		  System.out.println("nhập phím bất kỳ để tiếp tục chương trình");
       	  Scanner myInput1 = new Scanner(System.in);
       	  String nhapchu = myInput1.nextLine();
       	  String chu = "N";
       	  if(nhapchu.equals(chu)) {
       		 break;
       		  }
          }
=======
		for (;;) {
			int a, b, c, d, n;
			Scanner myInput = new Scanner(System.in);
			System.out.print("nhập 1 số : ");

			n = myInput.nextInt();
			a = Math.round(n / 1000);
			b = Math.round((n - a * 1000) / 100);
			c = Math.round((n - a * 1000 - b * 100) / 10);
			d = n - a * 1000 - b * 100 - c * 10;
			switch (a) {
			case 1:
				System.out.print("một nghìn");
				break;
			case 2:
				System.out.print("hai nghìn");
				break;
			case 3:
				System.out.print(" ba nghìn");
				break;
			case 4:
				System.out.print("bốn nghìn");
				break;
			case 5:
				System.out.print("năm nghìn");
				break;
			case 6:
				System.out.print("sáu nghìn");
				break;
			case 7:
				System.out.print("bảy nghìn");
				break;
			case 8:
				System.out.print("tám nghìn");
				break;
			case 9:
				System.out.print("chín nghìn");
				break;
			}
			if (b == 0 && d > 0) {
				System.out.print(" không trăm");
			}

			switch (b) {

			case 1:
				System.out.print(" một trăm");
				break;
			case 2:
				System.out.print(" hai trăm");
				break;
			case 3:
				System.out.print(" ba trăm");
				break;
			case 4:
				System.out.print(" bốn trăm");
				break;
			case 5:
				System.out.print(" năm mươi");
				break;
			case 6:
				System.out.print(" sáu trăm");
				break;
			case 7:
				System.out.print(" bảy trăm");
				break;
			case 8:
				System.out.print(" tám trăm");
				break;
			case 9:
				System.out.print(" chín trăm");
				break;
			}
			if (c == 0 && d > 0) {
				System.out.print(" linh");
			}

			switch (c) {

			case 1:
				System.out.print(" mười");
				break;
			case 2:
				System.out.print(" hai mươi");
				break;
			case 3:
				System.out.print(" ba mươi");
				break;
			case 4:
				System.out.print(" bốn mươi");
				break;
			case 5:
				System.out.print(" năm mươi");
				break;
			case 6:
				System.out.print(" sáu mươi");
				break;
			case 7:
				System.out.print(" bảy mươi");
				break;
			case 8:
				System.out.print(" tám mươi");
				break;
			case 9:
				System.out.print(" chín mươi");
				break;
			}

			switch (d) {

			case 2:
				System.out.println(" hai");
				break;
			case 3:
				System.out.println(" ba");
				break;
			case 4:
				System.out.println(" bốn");
				break;

			case 6:
				System.out.println(" sáu");
				break;
			case 7:
				System.out.println(" bảy");
				break;
			case 8:
				System.out.println(" tám");
				break;
			case 9:
				System.out.println(" chín");
				break;
			}
			if (d == 1) {

				if (c <= 1) {
					System.out.println(" Một");
				} else {
					System.out.println(" Mốt");
				}
			} else if (d == 5) {
				if (c >= 1) {
					System.out.println(" lăm");
				} else {
					System.out.println(" năm");
				}
			}

			System.out.println();
			System.out.println("nhập N để dừng chương trình");
			System.out.println("nhập phím bất kỳ để tiếp tục chương trình");
			Scanner myInput1 = new Scanner(System.in);
			String nhapchu = myInput1.nextLine();
			String chu = "N";
			if (nhapchu.equals(chu)) {
				break;
			}
		}
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
	}
}