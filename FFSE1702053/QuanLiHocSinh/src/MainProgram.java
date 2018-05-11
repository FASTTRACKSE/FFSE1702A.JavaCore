import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Nhap vao so luong lop:");
//		int n = new Scanner(System.in).nextInt();
//		
//		String[] hoTen = new String[3];
//		
//		String[][] lop = new String[n][3];
//		
//		Scanner sc = new Scanner(System.in);
//		
//		for(int i = 0; i < lop.length; i++) {
//			for(int j = 0; j < lop[i].length; j++) {
//				System.out.println("Nhap ten HS thu " + (j+1) + " thuoc lop thu " + (i+1));
//				lop[i][j] = sc.nextLine();
//			}
//		}
//		
//		System.out.println("Nhap xong ds HS!");
//		
//		System.out.println("----------------Xuat DS hS--------------");
//		
//		for(int i = 0; i < lop.length; i++) {
//			System.out.println("------------DS HS lop thu " + (i+1) + "-----------");
//			for(int j = 0; j < lop[i].length; j++) {
//				System.out.println((j+1) + "/ " + lop[i][j]);
//			}
//		}
	
//	
		matrixExample();
	}
	
	//	0			1			2			3
	//	A			B			C			D
	//	D			E			F			G
	//	H			J			K			L
	//	Z			X			C			V
	
	private static void matrixExample() {
	
		String[][] matrix = new String[5][4];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.println("nhap dong thu"+ (i+1) + "cot thu" + (j+1));
				matrix[i][j] = sc.nextLine();
			
			}
	
		}
		

		System.out.println("Nhap xong mang!");
		
		System.out.println("----------------Xuat mang --------------");
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
				if(j == matrix[i].length - 1) {
					System.out.println("\n");
				}
			
			}
	
		}
	}
}
	
