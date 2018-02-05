package Nhap1mang.com;
import java.util.*;
public class Nhapmang {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		Scanner myCheck = new Scanner(System.in);
		int check = 3;
		int n = 0;
		int[] A = new int[0];
		while(check == 3) {
			System.out.print("Nhập vào số phần tử trong mảng A: ");
			n = myInput.nextInt();
			A = new int[n];

			for(int i = 0; i < n; i++) {
				System.out.print("Nhập phần tử A[" + i + "] = ");
				A[i] = myInput.nextInt();
			}
			System.out.println("Bạn muốn chọn phương án nào để in ra màn hình:");
			System.out.println("- Nhập 1 để sắp xếp mảng từ cao đến thấp");
			System.out.println("- Nhập 2 để sắp xếp mảng từ thấp đến cao");
			System.out.println("- Nhập 3 để nhập lại mảng");
			System.out.println("- Nhập 4 để kết thúc");
			System.out.print("Nhập vào đây: ");
			check = myCheck.nextInt();
		}
		int tam = 0;
		if(check == 1) {
			for(int i = 0; i < n-1; i++) {
				for(int j = i+1; j < n; j++) {
					if(A[i] > A[j]) {
						tam = A[i];
						A[i] = A[j];
						A[j] = tam;
					}
				}
			}
			System.out.println("Sắp xếp tăng dần: ");
			for(int i = 0; i < A.length; i++) {
				System.out.print(A[i] + " ");
			}
		} else if(check == 2) {
			for(int i = 0; i < n-1; i++) {
				for(int j = i+1; j < n; j++) {
					if(A[j] > A[i]) {
						tam = A[i];
						A[i] = A[j];
						A[j] = tam;
					}
				}
			}
			System.out.println("Sắp xếp giảm dần: ");
			for(int i = 0; i < A.length; i++) {
				System.out.print(A[i] + " ");
			}
		} else {
			System.out.print("Xin chào và hẹn gặp lại!!");
		}
	}
}
