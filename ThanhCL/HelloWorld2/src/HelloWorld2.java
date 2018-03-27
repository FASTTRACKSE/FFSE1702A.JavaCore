import java.util.Scanner;

public class HelloWorld2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhập vào 1 số: ");
		int so1 = myInput.nextInt();

		myInput.nextLine(); // Nhận ký tự Enter từ nextInt ở trên
		System.out.print("Nhập vào tên bạn: ");
		String myName = myInput.nextLine();
		
		System.out.print("Nhập vào tuổi bạn: ");
		int myAge = myInput.nextInt();
		myInput.nextLine();
		
		System.out.print("Nhập vào địa chỉ nhà bạn: ");
		String myAddress = myInput.nextLine();
	}

}
