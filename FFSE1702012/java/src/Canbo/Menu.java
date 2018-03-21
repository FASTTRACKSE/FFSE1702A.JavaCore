package Canbo;

import java.util.Scanner;
public class Menu {
    public static void showMenu() {
        System.out.print("+------------------------------------------+\n");
        System.out.print("|                   MENU                   ");
        System.out.printf("\n| %-40s ", "1. Thêm Giảng viên.");
        System.out.printf("\n| %-40s ", "2. Thêm nhân viên.");
        
        
        System.out.printf("\n| %-40s ", "3. Xuất danh sách giảng viên theo khoa");
        System.out.printf("\n| %-40s ", "4. Xuất danh sách nhân viên theo phòng ban");
        System.out.printf("\n| %-40s ", "5. Tổng lương các nhân viên.");
        System.out.printf("\n| %-40s ", "6.Tổng lương các giáo viên");
        System.out.printf("\n| %-40s ", "7.Hiển thị giảng viên");
        System.out.printf("\n| %-40s ", "8.Hiển thị nhân viên");
        System.out.printf("\n| %-40s ", "9.Sắp xếp giáng viên ");
        System.out.printf("\n| %-40s \n", "10 Sắp xếp Nhận viên", "");
        System.out.printf("\n| %-40s \n", "0 Thoát", "");
        System.out.println("+------------------------------------------+");
    }

    public static void main(String[] args) {
        Scanner myinput = new Scanner(System.in);
        Main main = new Main();
        main.nhanviendefault();
        main.giangviendefault();
        showMenu();
        do {
            System.out.print("Chọn chức năng (nhấn 11 để hiện lại menu): ");
            int choose = myinput.nextInt();
            System.out.println("--------------------------------------------");
            switch (choose) {
            case 1:
                main.themgiangvien();
                break;
            case 2:
                main.themnhanvien();
                 break;
            case 3:
                main.getDsgv();
                break;
            case 4:
                main.getDsnv();
                break;
            case 5:
                main.tinhluongnhanvien();
                break;
            case 6:
               main.tinhluonGiangvien();
                break;
            case 7:
                main.hienThiGiangvien();
                break;
            case 8:
                main.hienThiNhanvien();
                break;
            case 9:
               main.sortGv();
               main.hienThiGiangvien();
                break;
            case 10:
                main.sortNv();
                main.hienThiNhanvien();
                break;
            case 11:
              showMenu();
                break;
            case 0:
                System.out.println("Kết thúc chương trình");
                System.exit(0);
                break;
            default:
                System.out.println("Vui lòng nhập số từ 0-7\n");
                break;
            }
        } while (true);
    }

}
