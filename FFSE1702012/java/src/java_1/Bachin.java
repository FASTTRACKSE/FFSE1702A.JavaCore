package java_1;

import java.util.Scanner;

public class Bachin {
    public static void main(String args[]) {
         Scanner myinput = new Scanner(System.in);
         System.out.println("Nhập Y để tiếp tục");
         String a = myinput.nextLine();

         for(int b =0; b<a.length(); b++) {
             while(a.charAt(b) == 'Y') {

                 System.out.println("\n"+"Nhap vao 1 so");
                 int i=myinput.nextInt();
                 int hn   = (i/1000)%10; 
                 int ht   = (i/100)%10;
                 int hc  = (i/10)%10;
                 int hdv = i%10;    
                 String[] hn1 = {"Một nghìn", "Hai nghìn", "Ba nghìn","Bốn nghìn", "Năm nghìn", "Sáu nghìn", "Bảy nghìn","Tám nghìn","Chín nghìn"};
                 String[] ht1 = {"Một trăm", "Hai trăm", "Ba trăm","Bốn trăm", "Năm trăm", "Sáu trăm", "Bảy trăm","Tám trăm","Chín trăm"};
                 String[] hc1 = {"Mười", "Hai mươi", "Ba mươi","Bốn mươi", "Năm mươi", "Sáu mươi", "Bảy mươi","Tám mươi","Chín mươi"};
                 String[] hdv1 = {"Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín"};
          
                 if(hn !=0) {
                     System.out.print(' ' + hn1[hn-1] + ' ');
                 }
                 if(ht!=0) {
                     System.out.print(' ' + ht1[ht-1] + ' ');
                 }
                 if(hc!=0) {
                     System.out.print(' ' + hc1[hc-1] + ' ');
                 }
                 if(hdv !=0) {
                     System.out.print(hdv1[hdv-1]);
                  }
       
             }
         }
         }
      
         } 



