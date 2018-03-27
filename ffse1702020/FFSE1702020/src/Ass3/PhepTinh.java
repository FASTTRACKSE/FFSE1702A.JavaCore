package Ass3;
	import java.util.Scanner;
public class PhepTinh {

		public static void main(String[] args) {
			for(;;) {
		System.out.println("+-------------------------------------+");
		System.out.println("+----Nhập 1 để cộng-------------------+");
		System.out.println("+----Nhập 2 để trừ------------------------------+");
		System.out.println("+----Nhập 3 để kết thúc------------------------+");
		System.out.println("+-------------------------------------+");
		
		try {
			Scanner myInput = new Scanner(System.in);
			int answer = myInput.nextInt();
			if(answer !=1 && answer!=2 && answer!=3) {
			 
					System.out.println("vui lòng nhập số 1,2,3");
			}
				
				
			if(answer==1) {		
				System.out.println("vui lòng nhập số thứ 1");			
				int soa = myInput.nextInt();
				System.out.println("vui lòng nhập số thứ 2");			
				int sob = myInput.nextInt();
				int kq = soa+sob;
				System.out.println(soa+"+"+sob+"="+kq);
			}
			else if(answer==2) {
				System.out.println("vui lòng nhập số thứ 1");			
				int soa = myInput.nextInt();
				System.out.println("vui lòng nhập số thứ 2");			
				int sob = myInput.nextInt();
				int kq = soa-sob;
				System.out.println(soa+"-"+sob+"="+kq);
			}else if(answer==3) {
				break;
			}		
			
		}catch(Exception ex) {
			System.out.println("vui lòng nhập số ");
		}
		}
		}
		
	}

