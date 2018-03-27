package java_asm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
        ArrayList<CanBo> arrCanBo = new ArrayList<>(); 
        int choose, soCanBo=0,controller;
        long tongLuong = 0, luong;
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
		        for (;;) {
		        
		        System.out.print("Nhập số lượng cán bộ trong trường: ");
		        soCanBo = scanner1.nextInt();
		        
		        try {
		        	CanBoException.chkSoNguyen(soCanBo);
		        	break;
		        }
		        catch(CanBoException e) {
		        	 System.out.println(e);
		        }
		        }
	        
		        for (int i = 0; i < soCanBo; i++) {
		            System.out.println("Nhập thông tin cán bộ thứ " + (i + 1) + ":");
		            do {
		                System.out.print("Chọn loại cán bộ (1 - giảng viên, 2 - nhân viên): ");
		                choose = scanner1.nextInt();
		                for(;;) {
		                System.out.print("nhap ma: ");
			        	String maCanBo = scanner.nextLine();
			        	try {
				        	CanBoException.chkMaCanBo(maCanBo, arrCanBo);
				        	break;
				        	}
			        		catch(CanBoException e) {
				        	System.out.print(e);
				        	}
		                }
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
		            
		        }
		        
	        }
	        else if(controller==2) { 
	        	FileOutputStream fos = new FileOutputStream("thongtincanbo.txt",true);
		         PrintWriter pw = new PrintWriter(fos);

	        System.out.println("Hiển thị danh sách cán cán bộ trong trường: ");
	        pw.println("Thong tin can bo trong truong: ");
	        for (CanBo cb : arrCanBo) {
	            System.out.println(cb.toString());
	            pw.println(cb.toString());
	        }
	        pw.close();
	        fos.flush();
	        fos.close();
}
	        else if(controller==3) {
	        for (CanBo cb : arrCanBo) {
	            luong = cb.tinhLuong();
	            tongLuong += luong;
	        }
	        System.out.println("Tổng lương phải trả cho cán bộ trong trường = " + tongLuong);
	        }
	        }while(controller!=0);
}
	}