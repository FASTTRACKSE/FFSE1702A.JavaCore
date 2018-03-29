package assignment;
import java.util.ArrayList;
import java.util.Scanner;

public class TinhTien{

	public static void main(String[] args) {
		int a = 0;
		BienLai bienlai;
		Scanner scanner= new Scanner(System.in);
		ArrayList<BienLai> arbienlai=new ArrayList<>();
		System.out.println("Nhập số hộ gia đình:");
		a=scanner.nextInt();
		for(int i=0;i<a;i++) {
			bienlai=new BienLai();
			System.out.println("Nhập thông tin biên lai của hộ gia đình thứ " + (i + 1) + ": ");
            bienlai.nhap();
            arbienlai.add(bienlai);
        }
         
        System.out.println("Thông tin biên lai của các hộ gia đình: ");
        for (int i = 0; i < arbienlai.size(); i++) {
            System.out.println("Thông tin biên lai hộ gia đình thứ " + (i + 1) + ": ");
            arbienlai.get(i).xuat();
        }
    }
}
