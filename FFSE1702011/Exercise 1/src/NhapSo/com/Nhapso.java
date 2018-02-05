package NhapSo.com;
import java.util.Scanner;
public class Nhapso {
	public static void main(String[] args) {
		int check = 1;
		Scanner myInput = new Scanner(System.in);
		
		while (check == 1) {
		System.out.print("Nhập vào một số: ");
		int number = myInput.nextInt(),
			nghin = number/1000,
			tram = (number%1000)/100,
			chuc = ((number%1000)%100)/10,
			donvi = ((number%1000)%100)%10;	
			if(number == 0) {
				System.out.print("Không");
			} else {
				switch(nghin) {
				case 1:System.out.print("một nghìn ");break;
				case 2:System.out.print("hai nghìn ");break;
				case 3:System.out.print("ba nghìn ");break;
				case 4:System.out.print("bốn nghìn ");break;
				case 5:System.out.print("năm nghìn ");break;
				case 6:System.out.print("sáu nghìn ");break;
				case 7:System.out.print("bảy nghìn ");break;
				case 8:System.out.print("tám nghìn ");break;
				case 9:System.out.print("chín nghìn ");break;
				}
				
				switch(tram) {
				case 0:if(nghin > 0) { 
					System.out.print("không trăm ");break;
				} else {
					System.out.print("");break;
				}
				case 1:System.out.print("một trăm ");break;
				case 2:System.out.print("hai trăm ");break;
				case 3:System.out.print("ba trăm ");break;
				case 4:System.out.print("bốn trăm ");break;
				case 5:System.out.print("năm trăm ");break;
				case 6:System.out.print("sáu trăm ");break;
				case 7:System.out.print("bảy trăm ");break;
				case 8:System.out.print("tám trăm ");break;
				case 9:System.out.print("chín trăm ");break;
				}
				
				switch(chuc) {
				case 0:if(nghin > 0 && tram == 0 || tram > 0) {
					System.out.print("lẻ ");break;
				} else {
					System.out.print("");break;
				}
				case 1:System.out.print("mười ");break;
				case 2:System.out.print("hai mươi ");break;
				case 3:System.out.print("ba mươi ");break;
				case 4:System.out.print("bốn mươi ");break;
				case 5:System.out.print("năm mươi ");break;
				case 6:System.out.print("sáu mươi ");break;
				case 7:System.out.print("bảy mươi ");break;
				case 8:System.out.print("tám mươi ");break;
				case 9:System.out.print("chín mươi ");break;
				}
				
				switch(donvi) {
				case 1:if(chuc == 0 || chuc == 1) {
					System.out.print("một");break;
				} else {
					System.out.print("mốt ");break;
				}
				case 2:System.out.print("hai");break;
				case 3:System.out.print("ba");break;
				case 4:System.out.print("tư");break;
				case 5:if(tram == 0) {
					System.out.print("năm");break;
				} else {
					System.out.print("lăm");break;
				}
				case 6:System.out.print("sáu");break;
				case 7:System.out.print("bảy");break;
				case 8:System.out.print("tám");break;
				case 9:System.out.print("chín");break;
				}
			}
		System.out.println();
		System.out.print("Bạn có muốn tiếp tục - Ghi 1 để tiếp tục - Ghi 0 để dừng lại: ");
		check = myInput.nextInt();
		}
		System.out.println("Tạm biệt! Hẹn gặp lại!!");
	}
}
