package java_ám;


import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        ArrayList<CanBo> arrCanBo = new ArrayList<>();
        int choose, soCanBo,controller;
        long tongLuong = 0, luongThapNhat, luong;
        CanBo canBo = null;
        Scanner scanner = new Scanner(System.in);
   do {
	        System.out.print("\n*************************************************\n");
		    System.out.print("* số 1 : nhập thông tin cán bộ               *\n");
		    System.out.print("* số 2 : xem thông tin                 *\n");
		    System.out.print("* số 3 : tổng tiền lương phải trả               *\n");
		    System.out.print("*************************************************\n ");
		    System.out.print("\n chọn chức năng bạn muốn : ");
			Scanner scanner1 = new Scanner(System.in);
			
		   controller = Integer.parseInt(scanner1.nextLine()) ;
		    System.out.print(controller);
	        if (controller ==1) {
	        
	        System.out.print("Nhập số lượng cán bộ trong trường: ");
	        soCanBo = scanner1.nextInt();
	        for (int i = 0; i < soCanBo; i++) {
	            System.out.println("Nhập thông tin cán bộ thứ " + (i + 1) + ":");
	            do {
	                System.out.print("Chọn loại cán bộ (1 - giảng viên, 2 - nhân viên): ");
	                choose = scanner1.nextInt();
	                switch (choose) {
	                    case 1:
	                        canBo = new GiangVien();
	                        canBo.nhap();
	                        arrCanBo.add(canBo);
	                        break;
	                    case 2:
	                        canBo = new NhanVien();
	                        canBo.nhap();
	                        arrCanBo.add(canBo);
	                        break;
	                    default:
	                        System.out.println("Chọn không hợp lệ.");
	                        break;
	                    }
	            } while (choose < 1 || choose > 3);
	        }}
	        else if(controller==2) {
	         
	        System.out.println("Hiển thị danh sách cán cán bộ trong trường: ");
	        for (CanBo cb : arrCanBo) {
	            System.out.println(cb.toString());
	        }}
	        else if(controller==3) {
	        for (CanBo cb : arrCanBo) {
	            luong = cb.tinhLuong();
	            tongLuong += luong;
	        }
	        System.out.println("Tổng lương phải trả cho cán bộ trong trường = " + tongLuong);
    }}while(controller != 0);}
 
}