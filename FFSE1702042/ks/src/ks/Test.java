package ks;
import java.util.Scanner;
import java.util.ArrayList;
public class Test {
		private static int i;

		public static void main(String[] args) {
			Scanner sc	=	new Scanner(System.in);
			ArrayList<KhachSan>ds;
			int n;
			System.out.println("Nhập số lượng khách trọ: ");
			n=sc.nextInt();sc.nextLine();
			ds=new ArrayList<KhachSan>(n);
			KhachSan b;
			for(int i=0; i<n; i++) {
				b =	new KhachSan();
				b.nhapThongTin(sc);
				ds.add(b);
			}
		System.out.println("Danh sách khách trọ: ");
		for(int i=0; i<ds.size();i++)
			ds.get(i).hienThongTin();
			String tim;
			System.out.println(" Nhập số CMND của khách hàng cần thanh toán:");
			tim	=	sc.nextLine();
			for(int i=0; i<ds.size(); i++) 
				if(ds.get(i).getKhach().getSoCMND().equalsIgnoreCase(tim));
				System.out.println("Tiền phải thanh toán " + ds.get(i).thanhTien());
		
		}
}
