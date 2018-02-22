package sapxepmang;

import java.util.Scanner;

public class sapxepmang {
	public static void main(String[] args) {
		String kt = "yes";
		while(kt == "yes") {
			try {
		System.out.print("nhập số phần tử\n");
		Scanner sopt = new Scanner(System.in);
		int pt = sopt.nextInt();
		int mang[]= new int[pt];
		for(int i=0;i<mang.length;i++) {
		   System.out.print("nhập số "+(i+1)+":");
		   mang[i]=sopt.nextInt();
		}
		System.out.println("lựa chọn phương án in:");
		System.out.println("1.Sắp xếp mảng từ cao đến thấp");
		System.out.println("2.Sắp xếp mảng từ thấp đến cao");
		System.out.println("3.Nhập lại mảng");
		System.out.println("4.Thoát khỏi chương trình");
		Scanner input = new Scanner(System.in);
		int answer = input.nextInt();
		if(answer == 1) {
			tangdan(mang, pt);
		}
		if(answer == 2) {
			giamdan(mang, pt);
		}
		if(answer == 3) {
			continue;
		}
		if(answer == 4) {
			System.exit(0);
		}
			} catch(Exception ex) {
				System.out.print("\n nhập số nguyên");
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
	

	public static void tangdan(int [] mang, int pt) {
		int temp;
		for(int i = 0; i <mang.length - 1; i++) {
			for(int j = i + 1; j < mang.length; j++) {
				if(mang[i]>mang[j]) {
					temp=mang[j];
					mang[j]=mang[i];
					mang[i]=temp;
					
				}
			}
		}
		for (int i = 0; i < mang.length; i++) {
            System.out.print(mang[i] + " ");
        }
	}
	public static void giamdan(int [] mang, int pt) {
		int temp;
		for(int i = 0; i <mang.length - 1; i++) {
			for(int j = i + 1; j < mang.length; j++) {
				if(mang[i]<mang[j]) {
					temp=mang[j];
					mang[j]=mang[i];
					mang[i]=temp;
					
				}
			}
		}
		for (int i = 0; i < mang.length; i++) {
            System.out.print(mang[i] + " ");
        }
	}

        
    
}