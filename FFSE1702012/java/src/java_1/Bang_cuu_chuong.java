package java_1;
import java.util.Scanner;
public class Bang_cuu_chuong {
    public static void main(String args[ ]) {
        Scanner myinput = new Scanner(System.in);
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
    }
}
