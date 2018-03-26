package assignment1;

import java.util.Scanner;

public class BangCuuChuong {
	
	public static void main(String[] strs) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap 1 so nguyen tu ban phim:");
		int a = scanner.nextInt();
		
		while(a>0) {
			for(int i=1; i<=10; i++) {
				for(int j=1; j<=a; j++) {
					System.out.printf(j + "    *   " + i + "    =    %d   " + "      ",(i*j));
					if(j==a) {
						System.out.println();
					}
				}
			}
			
			System.out.println("Ban co muon chay lai chuong trinh hay khong:");
			a = scanner.nextInt();
		}
	}
}
