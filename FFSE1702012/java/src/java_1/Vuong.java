package java_1;

import java.util.Scanner;

public class Vuong extends ChuNhat {
    public Vuong(int canh) {
        super(canh , canh);
    }
    void xuat() {
        System.out.println("canh " + super.getDai());
        System.out.println("Chiều dai " + super.getChuVi());
        System.out.println("Chiều dai " + super.getDienTich());
   }
    public static void main(String args[]) {
        
        System.out.println("Nhap chieu dai");
        Scanner scan = new Scanner(System.in);
        int dai = scan.nextInt();
        System.out.println("chieu rong");
        int rong = scan.nextInt();
        ChuNhat cn1 = new ChuNhat(dai, rong);
        cn1.xuat();
        
        System.out.println(" ");
        ChuNhat cn = new ChuNhat(4,5);
        cn.xuat();
        
        
        System.out.println(" Hinh Vuong");
        System.out.println(" Nhap canh cua hinh vuong");
        int canh = scan.nextInt();
        
        Vuong vuong = new Vuong(canh);
        vuong.xuat();
    }
}
