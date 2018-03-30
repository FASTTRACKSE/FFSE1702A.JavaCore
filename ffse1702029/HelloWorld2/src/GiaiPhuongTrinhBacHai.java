import java.util.Scanner;

public class GiaiPhuongTrinhBacHai {

	public static void main(String[] args) {
		int a;
		int b;
		int c;
		a=NhapSoNguyen("nhap he so a: ");
		b=NhapSoNguyen("nhap he so b: ");
		c=NhapSoNguyen("nhap he so c: ");
		GiaiPhuongTrinhBacHai(a, b, c);
	}
	public static int NhapSoNguyen(String str) {
		int x;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(str);
		x=sc.nextInt();
		return x;
	}
	public static void GiaiPhuongTrinhBacHai(int a, int b, int c) {
		if(a==0) {
			if(b==0) {
				if(c==0) 
					System.out.println("pt vo so nghiem");
				else
					System.out.println("pt vo nghiem");
			}
			else
				System.out.println("pt co 1 nghiem la x ="+(-c/b));
		}
		else {
			double x1;
			double x2;
			double detail=Math.pow(b, 2)-4*a*c;
			if(detail<0)
				System.out.println("ptvn");
			else if(detail>0) {
				x1=(-b+Math.sqrt(detail))/(2*a);
				x2=(-b+Math.sqrt(detail))/(2*a);
				System.out.println("pt co nghiem x1 ="+x1);
				System.out.println("pt co nghiem x2 ="+x2);
			}
			else 
				System.out.println("pt co nghiem kep x1=x2= "+(-b/(2*a)));
			
			
		}
	}


}

