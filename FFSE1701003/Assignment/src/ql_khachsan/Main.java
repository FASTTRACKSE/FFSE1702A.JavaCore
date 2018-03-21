package ql_khachsan;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<KhachSan> ds;
		int n;
		
		System.out.println("Nhap so luong khach tro :");
		n = sc.nextInt();
		sc.nextLine();
		
		ds = new ArrayList<KhachSan>(n);
		KhachSan b;
		
		for(int i=0; i<n; i++) {
			b = new KhachSan();
			b.nguoi.nhapthongtin(sc);
			ds.add(b);
		}
		
		System.out.println("Danh sach khach tro :");
		for(int i=0; i<ds.size(); i++) {
			ds.get(i).hienThongTin();
		}
		
		String tim;
		System.out.println("Nhap so chung minh nhan danh khach hang can thanh toan: ");
		tim = sc.nextLine();
		
		for(int i = 0; i< ds.size(); i++) {
			if(ds.get(i).getNguoi().getSoCMND().equalsIgnoreCase(tim)) {
				System.out.println("Tien phai thanh toan: "+ ds.get(i).thanhTien());
			}
		}
	}

}
