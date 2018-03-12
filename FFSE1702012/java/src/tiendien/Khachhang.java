package tiendien;
import java.util.Scanner;
import java.util.ArrayList;
public class Khachhang {
        private String name;
        private int address;
        private int masocongto;
        ArrayList<Khachhang> kh= new ArrayList();
        public Khachhang() {
            super();
            // TODO Auto-generated constructor stub
        }
        public Khachhang(String name, int address, int masocongto) {
            super();
            this.name = name;
            this.address = address;
            this.masocongto = masocongto;
        }
        public static Scanner myinput = new Scanner(System.in);
        public  void nhap() {
     
            System.out.println("Nhap so luong khach hang can nhap");
            int n = Integer.parseInt(myinput.nextLine());
            for(int i =0; i<n; i++) {
                Khachhang kh1 = new Khachhang();
                System.out.println("Thông tin khach hang thứ " + (i + 1));
                System.out.print("Nhap ten khach hang \n ");
                kh1.name = myinput.nextLine();
                System.out.print("Nhap số nhà khach hang \n ");
                kh1.address =Integer.parseInt(myinput.nextLine());
                System.out.print("Nhap mã  số công tơ nhà khach hang \n ");
                kh1.masocongto = Integer.parseInt(myinput.nextLine());
                kh.add(kh1);
            }
        }
        public void xuat() {
            System.out.println("Danh sách sinh viên");
            System.out.println("+--------+----------------------+-----+----------------------+------+");
            System.out.println("|        Name         |      Address        |  masocongto |");
            System.out.println("+------------------------+-------------------------+-------------------+");
            for (int i = 0; i < kh.size(); i++) {
                System.out.printf("| %-22s | %-22s | %-17s |\n", kh.get(i).name , kh.get(i).address , kh.get(i).masocongto);
                System.out.println("+------------------------+-------------------------+-------------------+");
            }
}
}