import java.util.Scanner;

public class Calculator {
	public static void main(String args[]){ 
		for(int i = 0;i>=i++;i++) {
			Scanner myInput	= new Scanner(System.in);
			System.out.print(" +------------------------+\n");
			System.out.print(" |>> may tinh ca nhan <<  | \n");
			System.out.print(" |+--------------------+  |\n");
			System.out.print(" | nhap so 1 : tru        | \n");
			System.out.print(" | nhap so 2 : cong       |\n");
			System.out.print(" | nhap so 3 : ket thuc   |\n");
			System.out.print(" +------------------------+\n");
			System.out.print(" nhap so : \n");
			int j = myInput.nextInt();
			try {
				switch(j) {
				case 1 : {
					Scanner sothunhat	= new Scanner(System.in);
					System.out.print("Nhập vào so thu nhat :");
					int number1 = sothunhat.nextInt();
					Scanner sothuhai 	= new Scanner(System.in);
					System.out.print("Nhập vào so thu hai  : ");
					int number2 = sothuhai.nextInt();
					System.out.printf("-------------------->>>>> %d - %d = %d \n",number1,number2,number1-number2);
					};break;
				case 2 : {
					Scanner sothunhat1	= new Scanner(System.in);
					System.out.print("Nhập vào so thu nhat :");
					int number12 = sothunhat1.nextInt();
					Scanner sothuhai1 	= new Scanner(System.in);
					System.out.print("Nhập vào so thu hai  : ");
					int number22 = sothuhai1.nextInt();
					System.out.printf("-------------------->>>>> %d + %d = %d\n ",number12,number22,number12+number22);
					};break;
				case 3 : System.exit(0);
				default:System.out.print(" vui long nhap theo dung yeu cau\n");break;
		}
		}
		catch(Exception ex) {
			System.out.print(" vui long nhap so !");
		}
	}
	}
}

