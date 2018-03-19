import java.util.Scanner;

public class HoaDonTienDien {
	public static Scanner scanner = new Scanner(System.in) ;
	public static void main(String [] strs) {
		System.out.print("Nhap muc dien tieu thu :");
		float a = scanner.nextFloat();
		showHoaDon(a);
	}
	
	
	public static void showHoaDon(float num) {
		float price, price_surplus1, price_surplus2, price_surplus3, price_surplus4, price_surplus5, 
				surplus1, surplus2, surplus3, surplus4, surplus5;
		if(num >= 0 && num <= 50) {
			price = num * 1549;
			System.out.printf("Hóa đơn tiền điện là: %f", price);
		}else if(num >= 51 && num <= 100) {
			// Tiền ở mức 50
			price = 50 * 1549;
			// Tiền mức 51 - 100
			surplus1 = num - 50;
			price_surplus1 = surplus1 * 1600;
			System.out.printf("Hóa đơn tiền điện là: %f", price + price_surplus1);
		}else if(num >= 101 && num <= 200) {
			// Tiền ở mức 50
			price = 50 * 1549;
			// Tiền mức 51 - 100
			price_surplus1 = 50 * 1600;
			// Tiền mức 101 - 200
			price_surplus2 = (num - 100) * 1858;
			System.out.printf("Hóa đơn tiền điện là: %f", price + price_surplus1 + price_surplus2);
		}else if(num >= 201 && num <= 300) {
			// Tiền ở mức 50
			price = 50 * 1549;
			// Tiền mức 51 - 100
			price_surplus1 = 50 * 1600;
			// Tiền mức 101 - 200
			price_surplus2 = 100 * 1858;
			// Tiền mức 201 - 300
			price_surplus3 = (num - 200) * 2340;
			System.out.printf("Hóa đơn tiền điện là: %f", price + price_surplus1 + price_surplus2 + price_surplus3);
		}else if(num >= 301 && num <= 400) {
			// Tiền ở mức 50
			price = 50 * 1549;
			// Tiền mức 51 - 100
			price_surplus1 = 50 * 1600;
			// Tiền mức 101 - 200
			price_surplus2 = 100 * 1858;
			// Tiền mức 201 - 300
			price_surplus3 = 100 * 2340;
			// Tiền mức 301 - 400
			price_surplus4 = (num - 300) * 2615;
			System.out.printf("Hóa đơn tiền điện là: %f", price + price_surplus1 + price_surplus2 + price_surplus3 + price_surplus4);
		}else if(num >= 401) {
			// Tiền ở mức 50
			price = 50 * 1549;
			// Tiền mức 51 - 100
			price_surplus1 = 50 * 1600;
			// Tiền mức 101 - 200
			price_surplus2 = 100 * 1858;
			// Tiền mức 201 - 300
			price_surplus3 = 100 * 2340;
			// Tiền mức 301 - 400
			price_surplus4 = 100 * 2615;
			// Tiền mức >=401
			price_surplus5 = (num - 400) * 2701;
			System.out.printf("Hóa đơn tiền điện là: %f", price + price_surplus1 + price_surplus2 + price_surplus3 + price_surplus4 + price_surplus5);
		}
	}
}
