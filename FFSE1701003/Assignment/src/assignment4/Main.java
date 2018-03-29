package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int n = 5;
		ArrayList<BienLai> listBienLai = new ArrayList<BienLai>(n);
		
		do {
			System.out.println("-----------Menu------------");
	        System.out.println("1. Nhap bien lai");
			System.out.println("2. Hien thi bien lai");
			System.out.println("3. Tinh tien dien");
			System.out.println("0. Thoat");
	        System.out.println("---------------------------");
	        System.out.println("Chon chuc nang: ");
	        
	        Scanner sc = new Scanner(System.in);
	        n = Integer.parseInt(sc.nextLine());
	        
	        if(n == 1) {
	        	System.out.println("Nhap so luong bien lai muon nhap");
	        	int soLuong = Integer.parseInt(sc.nextLine());
	        	
	        	for(int i=0; i< n; i++) {
	        		BienLai bienlai = new BienLai();
	        		bienlai.nhap(sc);
	        		listBienLai.add(bienlai);
	        	}
	        }else if(n==2) {
	        	System.out.println("Hien thi bien lai.");
	        	for(int i=0; i<listBienLai.size();i++) {
	        		listBienLai.get(i).xuat();
	        	}
	        }else if(n==3) {
	        	System.out.print("Tinh tien dien.");
	        	for(int i=0; i<listBienLai.size();i++) {
	        		listBienLai.get(i).tinhTienDien();
	        	}
	        }
		}while(n!=0);
		
	}

}
