package tiendien;
    import java.util.Scanner;
public class Menu {
    public static Scanner myinput =  new Scanner(System.in);


        public static void showMenu() {
            System.out.print("+----------------------------------------------------------------+\n");
            System.out.print("|                              MENU                          |");
            System.out.printf("\n| %-47s |", "1. Nhập thông tin hộ sử dụng điện.");
            System.out.printf("\n| %-46s |", "2. Hiển thị thông tin .về các biên lai đả nhập");
            System.out.printf("\n| %-47s |", "3.Tính số tiền điện cho các hộ gia đình");
            System.out.printf("\n| %-52s |\n", "0. Kết thúc chương trình.", "|");
            System.out.println("+----------------------------------------------------------------+");
       } 
        public static void main(String args[]) {
            Khachhang kh = new Khachhang();
            Menu menu = new Menu();
            Bienlai bienlai = new Bienlai();
            do {
            showMenu();
            int control;
            System.out.print("Xin mời quý khách chọn chức năng \n");
            control = myinput.nextInt();
            if(control == 1) {
                kh.nhap();
                kh.xuat();
            }
            if(control == 2) {
                bienlai.xuat();
            }
            if(control == 3) {
                bienlai.nhap();
                if(bienlai.chisocu<bienlai.chisomoi) {
                bienlai.xuat();}
                else
                    System.out.println("Yêu cầu nhập lai chỉ số công tơ mới >= chỉ số công tơ củ");
            }
            if(control !=1 && control !=2 && control !=3) {
                System.out.print("Xin mời quý khách chọn lại chức năng \n");
           
            }
        }while(true);
}
}
