package assignment4;
import java.util.Scanner;
import java.util.ArrayList;
public class Xuat {
	
	 public static void main(String[] args)
	 {
		
	    BienLai bienLai;
        ArrayList<BienLai> BL = new ArrayList<>();
		System.out.println("nhap so luong khach hang:");
		Scanner input1= new Scanner(System.in);
		int n = input1.nextInt();
		int dem;
		for(int i=0; i<n; i++) {
			dem= i+1;
			bienLai = new BienLai();
			System.out.println("Khach Hang:"+ dem);
			bienLai.nhapBienLai();
			BL.add(bienLai);
		}
		System.out.println("Thông tin biên lai của các hộ gia đình: ");
		for(int i=0; i<BL.size();i++) {
			dem= i+1;
			System.out.println("Thông  hộ gia đình "+ dem);
			BL.get(i).xuatBienLai();
		}
	 }
}
