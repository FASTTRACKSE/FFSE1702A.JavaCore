package java_1;
    import java.util.Scanner;
public class Assignment5 {
      public static Scanner myinput = new Scanner(System.in); 
     public static void main(String args[]) {
         System.out.print("Xin mời nhập lượng điện tiêu thụ N = ");
         int a = myinput.nextInt();
         if(a<=50) {
             bac1(a);
         }
         if(a>50 && a<=100) {
             bac2(a);
         }
         if(a>100 && a<=200) {
             bac3(a);
         }
         if(a>200&& a<=300) {
             bac4(a);
         }
         if(a>300&& a<=400) {
             bac5(a);
         }
         if(a>400) {
             bac6(a);
         }
         
     } 
         public static void khac(int c) {
             double vat = c*0.1;
             System.out.println("Thuế VAT (10%) = "+ (vat)+  "(vnd)" );
             System.out.println("Tổng tiên = "+ (c+vat)+  "(vnd)" );
         }
         public static void bac1(int a) {
              int  c = a * 1549;
              System.out.println("1 | " + "Điện tiêu thụ = " + a +" | Đơn giá = 1.549 | Số tiền = " + c +" (vnd)" );
         }
         public static void bac2(int a) {
             int c1 = 50*1549;
             int c2 = (a-50)*1600;
             int c = c1+c2;
             System.out.println("1 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.549 | Số tiền = " + c1 +" (vnd)" );
             System.out.println("2 | " + "Điện tiêu thụ = " + (a-50)  +" | Đơn giá = 1600 | Số tiền = " + c2 +" (vnd)" );
             System.out.println("Tổng ĐNTT = "+ (c1+c2)+  "(vnd)" );
             khac(c);
         }
         public static void bac3(int a) {
             int c1 = 50*1549;
             int c2 = 50*1600;
             int c3 = (a-50)*1858;
             int c = c1+c2+c3;
             System.out.println("1 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.549 | Số tiền = " + c1 +" (vnd)" );
             System.out.println("2 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.600 | Số tiền = " + c2 +" (vnd)" );
             System.out.println("3 | " + "Điện tiêu thụ = " + (a-100)  +" | Đơn giá = 1.858 | Số tiền = " + c3 +" (vnd)" );
             System.out.println("Tổng ĐNTT = "+ (c1+c2+c3)+  "(vnd)" );
             khac(c);
             }
         public static void bac4(int a) {
             int c1 = 50*1549;
             int c2 = 50*1600;
             int c3 = 50*1858;
             int c4 = (a-50)*2340;
             int c = c1+c2+c3+c4;
             System.out.println("1 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.549 | Số tiền = " + c1 +" (vnd)" );
             System.out.println("2 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.600 | Số tiền = " + c2 +" (vnd)" );
             System.out.println("3 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.858 | Số tiền = " + c3 +" (vnd)" );
             System.out.println("4 | " + "Điện tiêu thụ = " + (a-150)  +" | Đơn giá = 2340 | Số tiền = " + c4 +" (vnd)" );
             System.out.println("Tổng ĐNTT = "+ (c1+c2+c3+c4)+  "(vnd)" );
             khac(c);
         }
         public static void bac5(int a) {
             int c1 = 50*1549;
             int c2 = 50*1600;
             int c3 = 50*1858;
             int c4 = 50*2340;
             int c5 = (a-50)*2615;
             int c = c1+c2+c3+c4+c5;
             System.out.println("1 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.549 | Số tiền = " + c1 +" (vnd)" );
             System.out.println("2 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.600 | Số tiền = " + c2 +" (vnd)" );
             System.out.println("3 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.858 | Số tiền = " + c3 +" (vnd)" );
             System.out.println("4 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 2.340 | Số tiền = " + c4 +" (vnd)" );
             System.out.println("5 | " + "Điện tiêu thụ = " + (a-200)  +" | Đơn giá = 2615 | Số tiền = " + c5 +" (vnd)" );
             System.out.println("Tổng ĐNTT = "+ (c1+c2+c3+c4+c5)+  "(vnd)" );
             khac(c);
         }
         public static void bac6(int a) {
             int c1 = 50*1549;
             int c2 = 50*1600;
             int c3 = 50*1858;
             int c4 = 50*2340;
             int c5 = 50*2615;
             int c6 = (a-50)*2701;
             int c = c1+c2+c3+c4+c5+c6;
             System.out.println("1 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.549 | Số tiền = " + c1 +" (vnd)" );
             System.out.println("2 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.600 | Số tiền = " + c2 +" (vnd)" );
             System.out.println("3 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 1.858 | Số tiền = " + c3 +" (vnd)" );
             System.out.println("4 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 2.340 | Số tiền = " + c4 +" (vnd)" );
             System.out.println("5 | " + "Điện tiêu thụ = " + 50 +" | Đơn giá = 2.615 | Số tiền = " + c5 +" (vnd)" );
             System.out.println("6 | " + "Điện tiêu thụ = " + (a-250)  +" | Đơn giá = 2701 | Số tiền = " + c6 +" (vnd)" );
             System.out.println("Tổng ĐNTT = "+ (c1+c2+c3+c4+c5+c6)+  "(vnd)" ); 
             khac(c);
         }
     
}
