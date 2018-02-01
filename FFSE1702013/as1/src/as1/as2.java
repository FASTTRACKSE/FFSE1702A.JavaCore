package as1;


import java.util.Scanner;

public class as2 {

    public static void menu() {
        int number;
        String check;

        Scanner input = new Scanner(System.in);

        System.out.print("Nhập vào một số: ");
        number = input.nextInt();

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= number; j++) {
                System.out.print(j + " x " + i + " = " + j * i + "\t");
            }
            System.out.println("");
        }

        System.out.print("Bạn có muốn chạy lại chương trình hay không (Y/N): ");
        check = input.next();

        if ("Y".equals(check) || "y".equals(check)) {
            menu();
        } else {
            System.exit(0);
        }
    }

    public static void bt2() {
        int number;
        String check;
        String[] arrNum = {"một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};

        Scanner input = new Scanner(System.in);

        System.out.print("Nhập vào một số: ");
        number = input.nextInt();

        while (number > 9999 || number < 1) {
            System.out.print("Nhập vào một số: ");
            number = input.nextInt();
        }

        System.out.print("Kết quả là: ");
        
        while (number > 0) {
            if (number / 1000 > 0) {
                System.out.print(arrNum[(number / 1000) - 1]);
                System.out.print(" ngàn ");
                number = number % 1000;
            } else if (number / 100 > 0) {
                System.out.print(arrNum[(number / 100) - 1]);
                System.out.print(" trăm ");
                number = number % 100;
            } else if (number / 10 > 0) {
                if(number / 10 != 1){
                    System.out.print(arrNum[(number / 10) - 1]);
                    System.out.print(" mươi ");
                }else{
                    System.out.print("mười ");
                }
                number = number % 10;
            } else{
                System.out.print(arrNum[number - 1]);
                number = number / 10;
                System.out.println("");
            }
        }
        
        System.out.print("Bạn có muốn chạy lại chương trình hay không (Y/N): ");
        check = input.next();

        if ("Y".equals(check) || "y".equals(check)) {
            bt2();
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // BT số 1
        // menu();

        // BT số 2
        bt2();
    }
}