package chap1.basic;
import java.util.Scanner;
public class Switch {
	public static void main(String[] args) {
		Scanner input	=	new Scanner(System.in);
		System.out.println("Hãy nhập vào 1 số");
		int n	= input.nextInt();
		String result ="";
		
		switch(n) {
		case 2: 
			result= " Thứ hai";
			break;
		case 3:
			result= " Thứ Ba";break;
		case 4:
			result= " Thứ tư"; break;
		case 5:
			result= " Thứ năm"; break;
		case 6:
			result= "thứ sáu"; break;
		case 7:
			result= "thứ bảy";break;
			default:
				result= "chủ nhật"; break;
			
		}
		System.out.println(result);
	}
}
