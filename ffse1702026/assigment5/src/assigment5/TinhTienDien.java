package assigment5;
import java.util.Scanner;
public class TinhTienDien {
	public static void main(String args[]) {
		int n;
		double tong=0;
		System.out.print("nhập số KW điện : ");
		Scanner input= new Scanner(System.in);
		n=input.nextInt();
		System.out.print("STT   " +"Điện tiêu thụ   "+ "Đơn giá   " + "Số tiền ");
		System.out.println("");
		if(n<=50) {
			System.out.printf("%3s %12d %10.3f %10.3f %n",1,n,1.549,n*1.549  );
			tong=n*1.549;
		}
		if(n>50&&n<=100) {
			System.out.printf("%3s %12d %10.3f %10.3f %n",1,50,1.549,50*1.549  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",2,n-50,1.600,(n-50)*1.6  );
			tong=50*1.549+(n-50)*1.6;
		}
		if(n>100&&n<=200) {
			System.out.printf("%3s %12d %10.3f %10.3f %n",1,50,1.549,50*1.549  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",2,50,1.600,50*1.6  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",3,n-100,1.858,(n-100)*1.858  );
			tong=50*1.549+50*1.6+(n-100)*1.858;
		}
		if(n>200&&n<=300) {
			System.out.printf("%3s %12d %10.3f %10.3f %n",1,50,1.549,50*1.549  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",2,50,1.600,50*1.6  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",3,100,1.858,100*1.858  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",4,n-200,2.340,(n-200)*2.340  );
			tong=50*1.549+50*1.6+100*1.858+(n-200)*2.340;
		}
		if(n>300&&n<=400) {
			System.out.printf("%3s %12d %10.3f %10.3f %n",1,50,1.549,50*1.549  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",2,50,1.600,50*1.6  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",3,100,1.858,100*1.858  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",4,100,2.340,100*2.340  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",5,n-300,2.615,(n-300)*2.615  );
			tong=50*1.549+50*1.6+100*1.858+100*2.340+(n-300)*2.615;
		}
		if(n>400) {
			System.out.printf("%3s %12d %10.3f %10.3f %n",1,50,1.549,50*1.549  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",2,50,1.600,50*1.6  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",3,100,1.858,100*1.858  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",4,100,2.340,100*2.340  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",5,100,2.615,100*2.615  );
			System.out.printf("%3s %12d %10.3f %10.3f %n",6,n-400,2.701,(n-400)*2.701  );
			tong=50*1.549+50*1.6+100*1.858+100*2.340+100*2.615+(n-400)*2.701;
		}
		System.out.printf("Tổng ĐNTT: %5d %21.3f %n",n,tong );
		System.out.print("Thuế VAT(10%):");
		System.out.printf(" %23.3f %n",tong/10);
		System.out.printf("Tổng tiền: %27.3f", (tong*1.1) );
		
	}

}
