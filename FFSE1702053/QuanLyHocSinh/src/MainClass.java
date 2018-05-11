import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HocSinh[] dsHs = new HocSinh[2];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < dsHs.length; i++) {
			HocSinh hs = new HocSinh();
			System.out.println("----Nhap thong tin hs thu " + (i+1) + "------");
			System.out.println("Ho ten:");
			hs.hoTen = sc.nextLine();
			System.out.println("Ngay sinh:");
			hs.ngaySinh = sc.nextLine();
			System.out.println("Diem hoa:");		
			hs.diemHoa = Float.parseFloat(sc.nextLine());
			System.out.println("Diem ly:");
			hs.diemLy = Float.parseFloat(sc.nextLine());
			System.out.println("Diem toan:");
			hs.diemToan= Float.parseFloat(sc.nextLine());
		
			dsHs[i] = hs;
		}
		
		for (int i = 0; i < dsHs.length; i++) {
			System.out.println("----thong tin hs thu " + (i+1) + "------");
		  System.out.println(dsHs[i].hoTen);	
		  System.out.println(dsHs[i].ngaySinh);	
		  System.out.println(dsHs[i].diemToan);	
		  System.out.println(dsHs[i].diemLy);	
		  System.out.println(dsHs[i].diemHoa);	
		  System.out.println("Xep loai: " + dsHs[i].xepLoaiHs());
		}
	}
}
