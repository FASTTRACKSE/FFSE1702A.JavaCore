package canBo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
	public static void Main(String[]args) {
		ArrayList<CanBo> arrCanBo	=	new ArrayList<>();
		int soCanBo;
		double tongLuong	=	0, luong;
		CanBo canBo;
		Scanner scn	=	new Scanner(System.in);
		int menu;
		do {
			System.out.print("\n*************************************************\n");
			System.out.print("* số 1 : nhập thông tin cán bộ               *\n");
			System.out.print("* số 2 : Hiển thị danh sách cán bộ                *\n");
			System.out.print("* số 3 : tổng tiền lương             *\n");
			System.out.print("* số 4 : Sắp xếp cán bộ theo lương, nếu lương bằng thì sắp xếp theo tên*\n");
			System.out.print("*************************************************\n ");
			System.out.print("\n chọn chức năng bạn muốn : ");
			Scanner scn1	=	new Scanner(System.in);
			menu	=	Integer.parseInt(scn1.nextLine());
			if(menu==1) {
				System.out.println("");
				System.out.println("1. Nhập danh sách giảng viên");
				System.out.println("2. Nhập danh sách nhân viên ");
				int cb	=	Integer.parseInt(scn1.next());
				if(cb==1) {
					System.out.println("Số lượng giảng viên cần nhập:");
					int sl	=	Integer.parseInt(scn1.next());
					
				}
				
			}
		}while(menu!=0);
	}
}
