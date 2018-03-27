package src.tiendien;

import java.util.Scanner;

public class tiendien {
	public static void main(String[] args) {
		String kt ="yes";
		while( kt == "yes") {
			try {
		System.out.print("Nhập số chữ điện\n");
		Scanner myInput= new Scanner(System.in);
		int chudien =myInput.nextInt();
		int a = 50*1549;
		int b = 50*1600;
		int c = 100*1858;
		int d = 100*2340;
		int e = 100*2615;
		
		if(chudien <= 50) {
			double thue = (chudien*1549)/10;
			System.out.print("Ti�?n điện :"+ ((chudien*1549)+ thue));
		}
		else if(chudien <= 100 ) {
			double thue = (a + ((chudien-50)*1600))/10;
			System.out.print("Ti�?n điện :"+ ((a + ((chudien-50)*1600))+ thue ));
		}
		else if(chudien <= 200 ) {
			double thue = (a + b + ((chudien-100)*1858))/10;
			System.out.print("Ti�?n điện :"+ ((a + b + ((chudien-100)*1858))+thue));
		}
		else if(chudien <= 300 ) {
			double thue = (a + b + c + ((chudien-200)*2340))/10;
			System.out.print("Ti�?n điện :"+ ((a + b + c + ((chudien-200)*2340))+ thue));
		}
		else if(chudien <= 400 ) {
			double thue = (a + b + c + d + ((chudien-200)*2615))/10;
			System.out.print("Ti�?n điện :"+ ((a + b + c + d + ((chudien-300)*2615))+ thue));
		}
		else if(chudien > 400) {
			double thue = (a + b + c + d + e + ((chudien-200)*2701))/10;
			System.out.print("Ti�?n điện :"+ ((a + b + c + d + e + (chudien*2701))+ thue));
		 }
			} catch(Exception ex) {
				System.out.print("\n vui lòng nhập số");
			}
		Scanner myInput2 = new Scanner(System.in);
		System.out.println("\n Muốn dừng nhấn N không muốn dừng thì tùy thích mà nhấn nhé  ");
		kt = myInput2.nextLine();
		if (kt.equalsIgnoreCase("N") || kt.equalsIgnoreCase("No")) {
			break;
		} else {
			kt = "yes";
		}
		}
	}


}
