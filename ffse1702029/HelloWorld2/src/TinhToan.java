import java.util.Scanner;

public class TinhToan {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner TinhToan = new Scanner(System.in);
		System.out.println(">> MÁY TÍNH CÁ NHÂN<<");
		System.out.println("+-------------------+");
		System.out.println("| 1. Cộng           |");
		System.out.println("| 2. Trừ            |");
		System.out.println("| 3. Kết thúc       |");
		System.out.println("+-------------------+");
		System.out.println(">> Chọn chức năng? ");
		System.out.println("Xin mời nhập số ");
		
		int n= TinhToan.nextInt();
		
		if(n<1||n>3){
			System.out.println("Nhập số từ 1 đến 3");
		}
		if(n==1) {
			@SuppressWarnings("resource")
			Scanner so =new Scanner(System.in);
			System.out.println("Mời nhập số thứ 1");
			int a= so.nextInt();
			@SuppressWarnings("resource")
			Scanner so2 =new Scanner(System.in);
			System.out.println("Mời nhập số thứ 2");
			int b= so2.nextInt();
			System.out.println(a+b);
		}
		if(n==2) {
			@SuppressWarnings("resource")
			Scanner so =new Scanner(System.in);
			System.out.println("Mời nhập số thứ 1");
			int a= so.nextInt();
			@SuppressWarnings("resource")
			Scanner so2 =new Scanner(System.in);
			System.out.println("Mời nhập số thứ 2");
			int b= so2.nextInt();
			System.out.println(a-b);
		}
		
	}

}
