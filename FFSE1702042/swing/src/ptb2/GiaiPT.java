package ptb2;

import java.util.Scanner;
public class GiaiPT {
        public static void main(String args[]) {
            String text = "Yes";
            while(text == "Yes") {
            System.out.println("GIAI PHƯƠNG TRÌNH CÓ DẠNG: ax + b = 0");
            gpt();
            Scanner myinput = new Scanner(System.in);
            String text1 = myinput.nextLine();
            for(int a = 0; a<text1.length(); a++) {
                if(text1.charAt(a) == 'Y') {
                    text =  "Yes";
                }
                else if(text1.charAt(a) == 'N') {
                    text ="No";
                }
            }
           }   
        }
        public static void gpt() {
            Scanner myinput = new Scanner(System.in);
            System.out.println("Nhập a:");
           int a = myinput.nextInt();
           if(a==0) {
               System.out.println("Phương trình vô nghiệm:");
           }
           else {
            System.out.println("Nhập b:");
           int  b = myinput.nextInt();
           float c = b/a;
            System.out.println("Nghiệm tìm được là: x = "+ c);
           }
            System.out.println("Bạn có muốn tiếp tục không ?");
        }
}