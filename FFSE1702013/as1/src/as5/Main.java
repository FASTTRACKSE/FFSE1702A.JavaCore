package as5;

import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        ArrayList<Canbo> arrCanBo = new ArrayList<>();
        int choose, soCanBo;
        long tongLuong = 0, luongThapNhat, luong;
        Canbo canBo = null;
        Scanner scanner = new Scanner(System.in);
         
        System.out.print("Nhập số lượng cán bộ trong trường: ");
        soCanBo = scanner.nextInt();
        for (int i = 0; i < soCanBo; i++) {
            System.out.println("Nhập thông tin cán bộ thứ " + (i + 1) + ":");
            do {
                System.out.print("Chọn loại cán bộ (1 - giảng viên, 2 - nhân viên): ");
                choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        canBo = new Giangvien();
                        canBo.nhap();
                        arrCanBo.add(canBo);
                        break;
                    case 2:
                        canBo = new Nhanvien();
                        canBo.nhap();
                        arrCanBo.add(canBo);
                        break;
                    default:
                        System.out.println("Chọn không hợp lệ.");
                        break;
                    }
            } while (choose < 1 || choose > 3);
        }
         
        System.out.println("Hiển thị danh sách cán cán bộ trong trường: ");
        for (Canbo cb : arrCanBo) {
            System.out.println(cb.toString());
        }
         
        for (Canbo cb : arrCanBo) {
            luong = cb.tinhLuong();
            tongLuong += luong;
        }
        System.out.println("Tổng lương phải trả cho cán bộ trong trường = " + tongLuong);
    }
 
}
