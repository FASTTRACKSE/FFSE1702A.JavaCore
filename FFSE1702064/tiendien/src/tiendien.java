import java.util.Scanner;
public class tiendien {

	public static void main(String[] args) {
		System.out.println("Tính tiền điện");
		Scanner td = new Scanner(System.in); 
		for(;;) {
			
		int a = td.nextInt();
		if (a == 0) break;
		int b =50*1549;
		int c =50*1600;
		int d =100*1858;
		int e =100*2340;
		int f =100*2615;
		
		System.out.println("|  STT  | Điện tiêu thụ |  Đơn giá  |Số tiền|");
		if(a<50) {
			
			System.out.println("|   1   |       "+a+"      |   1,549   | "+(a*1549)+" |");
			System.out.println("|   Tổng ĐNTT : "+a+"                  | "+(a*1549)+" |");
			System.out.println("| Thuế VAT(10%)                     |  "+((a*1549)/10)+" |");
			System.out.println("| Tổng tiền                         |  "+((a*1549)+((a*1549)/10))+"|");
		}
		else {
			System.out.println("|   1   |       "+50+"       |   1,549   | "+b+" |");
			if (a<100) {
		
			
			System.out.println("|   2   |       "+(a-50)+"       |   1,600   | "+(a-50)*1600+" |");
			System.out.println("|   Tổng ĐNTT : "+a+"                   | "+(b+(a-50)*1600)+"|");
			System.out.println("| Thuế VAT(10%)                      | "+((b+(a-50)*1600)/10)+" |");
			System.out.println("| Tổng tiền                          | "+(b+((a-50)*1600)+(((b+(a-50)*1600)/10)))+"|");
		}
		else {
			System.out.println("|   2   |       "+50+"       |   1,600   | "+c+" |");

			if (a<200) {
		
			
			System.out.println("|   3   |       "+(a-100)+"       |   1,600   | "+(a-100)*1858+" |");
			System.out.println("|   Tổng ĐNTT : "+a+"                  | "+(b+c+(a-100)*1858)+"|");
			System.out.println("| Thuế VAT(10%)                      | "+((b+c+(a-100)*1858)/10)+" |");
			System.out.println("| Tổng tiền                          | "+(b+c+((a-100)*1858)+(((b+c+(a-100)*1858)/10)))+"|");
		}

		else {
			System.out.println("|   3   |       "+100+"      |   1,858   | "+d+" |");
			if (a<300) {
		
			
			System.out.println("|   4   |       "+(a-200)+"       |   2,340   | "+(a-200)*2340+" |");
			System.out.println("|   Tổng ĐNTT : "+a+"                  | "+(d+b+c+(a-200)*2340)+"|");
			System.out.println("| Thuế VAT(10%)                      | "+((d+b+c+(a-200)*2340)/10)+" |");
			System.out.println("| Tổng tiền                          | "+(d+b+c+((a-200)*2340)+(((d+b+c+(a-200)*2340)/10)))+"|");
		}
		else {
			System.out.println("|   4   |       "+100+"      |   2,340   | "+e+" |");
			if (a<400) {
			System.out.println("|   5   |       "+(a-300)+"       |   2,615   | "+(a-300)*2615+" |");
			System.out.println("|   Tổng ĐNTT : "+a+"                  | "+(e+d+b+c+(a-300)*2615)+"|");
			System.out.println("| Thuế VAT(10%)                      | "+((e+d+b+c+(a-300)*2615)/10)+" |");
			System.out.println("| Tổng tiền                          | "+(e+d+b+c+((a-300)*2615)+(((d+b+c+(a-300)*2615)/10)))+"|");
		}
		else {
			System.out.println("|   5   |       "+100+"      |   2,615   | "+f+" |");
			System.out.println("|   6   |       "+(a-400)+"      |   2,701   | "+(a-400)*2701+" |");
			System.out.println("|   Tổng ĐNTT : "+a+"                  | "+(e+d+b+c+(a-400)*2701)+"|");
			System.out.println("| Thuế VAT(10%)                      | "+((e+d+b+c+(a-400)*2701)/10)+" |");
			System.out.println("| Tổng tiền                          | "+(e+d+b+c+((a-400)*2701)+(((d+b+c+(a-400)*2701)/10)))+"|");
		}}}}}
	}
	}

}
