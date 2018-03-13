package java_1;
        import java.util.Scanner;
public class Maytincanhan {
       public static void main(String args[]) {
           Scanner myinput = new Scanner(System.in);
           String text = "Yes";
           while(text == "Yes") {
           System.out.println(">> MÁY TÍNH CÁ NHÂN <<");
           System.out.println("+--------------------------------+");
           System.out.println("|    1: CỘNG                  |");
           System.out.println("|    2: TRỪ                     |");
           System.out.println("|    3: KẾT THÚC            |");
           System.out.println("+--------------------------------+");
           System.out.println(">> CHỌN CHƯC NĂNG <<");
              int answer = myinput.nextInt();
           
                       if(answer == 1) {
                           System.out.println("Thực hiện phép cộng");
                           Scanner myinput1 = new Scanner(System.in);
                           System.out.println("Xin mời nhập số a");
                           int a1 = myinput1.nextInt();
                           System.out.println("Xin mời nhập số b");
                           int b1 = myinput1.nextInt();
                           System.out.println("Tổng 2 số a +b la :" +"a +b = "+ (a1+b1) );
                       }
                       else if(answer ==2) {
                           System.out.println("Thực hiện phép trừ");
                       }
                       else if(answer == 3) {
                           System.exit(0);
                       }
                       else
                           System.out.println("Xin mời bạn chọn lại chức năng!!");
                       Scanner myinputend = new Scanner(System.in);
                       String text1 = myinputend.nextLine();
                       for(int b =0;b<text1.length(); b++) {
                       if(text1.charAt(b) == 'Y') {
                           text = "Yes";
                       }
                       else
                           System.out.println("Xin moi nhajp lai");
                       }
           }
       }    
}
