package java_1;
import java.util.Scanner;
public class Bang_cuu_chuong {
    public static void main(String args[ ]) {
        Scanner myinput = new Scanner(System.in);
        String text = "Yes";
        while(text == "Yes") {
         System.out.println(" Nhap vao 1 so");
         int i=myinput.nextInt();
         int num=1;
         int j;
         while(num<=10) {
            j =1;
             while(j<=i) {
                 int kq = num*j;
                 System.out.printf("%5d x %3d = %2d",j,num,kq);
                 j++;
             }
         num++;
         System.out.println();
         }
         System.out.println("\n" + "Bạn có muốn tiếp tục không?");
         Scanner myinput1 = new Scanner(System.in);
         text = myinput1.nextLine();
         for(int b=0; b<text.length(); b++) {
             if(text.charAt(b) == 'Y') {
                 text = "Yes";
             }
             if(text.charAt(b) == 'N') {
                 text = "No";
                 System.out.println("Xin cám ơn!!");
             }
         }
    }
    }
}
