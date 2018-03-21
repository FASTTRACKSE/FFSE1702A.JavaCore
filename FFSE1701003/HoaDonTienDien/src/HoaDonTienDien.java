import java.util.Scanner;

public class HoaDonTienDien {
	public static Scanner scanner = new Scanner(System.in) ;
	public static void main(String [] strs) {
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
			price_surplus1 = 100 * 1600;
			// Tiền mức 101 - 200
			price_surplus2 = (num - 100) * 1858;
			
			System.out.printf("Hóa đơn tiền điện là: %f", price + price_surplus1 + price_surplus2);
		}else if(num >= 201 && num <= 300) {
			// Tiền ở mức 50
			price = 50 * 1549;
			// Tiền mức 51 - 100
			price_surplus1 = 100 * 1600;
			// Tiền mức 101 - 200
			price_surplus2 = (num - 100) * 1858;
			
			System.out.printf("Hóa đơn tiền điện là: %f", price + price_surplus1 + price_surplus2);
		}
	}
}
