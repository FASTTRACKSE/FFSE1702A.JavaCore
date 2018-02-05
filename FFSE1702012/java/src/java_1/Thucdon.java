package java_1;

import java.util.Scanner;

public class Thucdon {
        
    public static void main(String args[]) {
          String textmain;
          String textcong;
          String texttru;
          textmain = "No";
          while(textmain== "No") {
          thucdon();
         Scanner myinput0 = new Scanner(System.in);
         int answer = myinput0.nextInt();
         /*
          * xu ly phuong thuc phep cong:
          */
        
         if(answer ==1) {
                              textcong = "Yes";
                             while(textcong == "Yes") {
                             phepcong();
                             System.out.println("Bạn có muốn tiếp tục không? Nhấn Y để tiếp tục và N để chọn lại chức năng");
                             Scanner myinput1 = new Scanner(System.in);
                             String textcong1 = myinput1.nextLine();
                             for(int b1 =0; b1<textcong1.length();b1++) {
                                 if(textcong1.charAt(b1) == 'Y') {
                                     textcong = "Yes";
                                 }
                                 else if(textcong1.charAt(b1) == 'N') {
                                    textcong = "No";
                                    textmain = "No";
                                 }
                             }
                         }
                         }
                             /*
                              * xu ly phep tru:
                              */
                             if(answer == 2 ) {
                                 texttru = "Yes";
                                while(texttru == "Yes") {
                                pheptru();
                                System.out.println("Bạn có muốn tiếp tục không? Nhấn Y để tiếp tục và N để chọn lại chức năng");
                                Scanner myinput2 = new Scanner(System.in);
                                String texttru1 = myinput2.nextLine();
                                for(int b2 =0; b2<texttru1.length();b2++) {
                                    if(texttru1.charAt(b2) == 'Y') {
                                        texttru = "Yes";
                                    }
                                    else if(texttru1.charAt(b2) == 'N') {
                                       texttru = "No";
                                       textmain = "No";
                                    }
                                }
                            }
                       }
                             /*
                              * exist out:
                              */
                             if(answer == 3) {
                                 System.exit(0);
                             }
                             /*
                              * xu ly khi nhập khác số:
                              */
                             if(answer !=1 && answer != 2 && answer !=3 ) {
                                 System.out.println("Vui lòng chọn đúng chức năng!!");
                             }

    }
   }
    public static void thucdon() {
                
                System.out.println(">> MÁY TÍNH CÁ NHÂN <<");
                System.out.println("+--------------------------------+");
                System.out.println("|    1: CỘNG                  |");
                System.out.println("|    2: TRỪ                     |");
                System.out.println("|    3: KẾT THÚC            |");
                System.out.println("+--------------------------------+");
                System.out.println(">> CHỌN CHƯC NĂNG <<");
    }
    public static void phepcong() {
                System.out.println("Thực hiện phép cộng");
                Scanner myinput1 = new Scanner(System.in);
                System.out.println("Xin mời nhập số a");
                int a1 = myinput1.nextInt();
                System.out.println("Xin mời nhập số b");
                int b1 = myinput1.nextInt();
                System.out.println("Tổng 2 số a +b la :" +"a +b = "+ (a1+b1) );
    }
    public static void pheptru() {
                System.out.println("Thực hiện phép trừ");
                Scanner myinput1 = new Scanner(System.in);
                System.out.println("Xin mời nhập số a");
                int a1 = myinput1.nextInt();
                System.out.println("Xin mời nhập số b");
                int b1 = myinput1.nextInt();
                System.out.println("Hiệu 2 số a - b la :" +"a -  b = "+ (a1- b1) );
    }
}
