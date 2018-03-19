package Lap5;

import java.util.ArrayList;
import java.util.Scanner;



public class lap5 {
	public static void main(String[] agrs) {
		KhachSan khachSan;
		ArrayList<KhachSan> KS = new ArrayList<>();
		System.out.println("nhap so luong khach hang:");
		Scanner input1= new Scanner(System.in);
		int n = input1.nextInt();
		int dem;
		for(int i=0; i<n; i++) {
			dem= i+1;
			khachSan = new KhachSan();
			System.out.println("khach hang:"+dem);
			khachSan.nhapKS();
			KS.add(khachSan);
		}
		System.out.println("khach tro:");
		for(int i=0; i < KS.size();i++) {
			System.out.println("khach can tinh tien:");
			String tim;
			tim = input1.next();
			for(i =0; i < KS.size(); i++) {
				if(KS.get(i).getKhach().getcMND().equalsIgnoreCase(tim)) {
					System.out.println("tiền:"+ KS.get(i).thanhTien());
				}
					
			}
		}
	}

}
