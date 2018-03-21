package quanly;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		NhanVien nhanVien;
		GiangVien giangVien;
		CanBo canBo;
		int key=0;
		int chon=0;
		int n;
		  ArrayList<CanBo> arrcanbo = new ArrayList<>();
		  ArrayList<GiangVien> arrgiangvien = new ArrayList<>();
		  ArrayList<NhanVien> arrnhanvien = new ArrayList<>();
		 do {
		System.out.println("1.Nhập thông tin cán bộ trong trường \n2.Xuất danh sách giảng viên khoa x, hoặc nhân viên phòng ban y nào đó\n3.Tổng số lương phải trả cho cán bộ \n4.Sắp xếp cán bộ theo lương, nếu lương bằng thì xếp theo tên");
		Scanner so=new Scanner(System.in);
		key=so.nextInt();
		if(key==1)
		{
			System.out.println("1.Nhập giảng viên\n2.Nhập nhân viên");
			chon=so.nextInt();
		if (chon==1)
		{ 
			System.out.print("ban muon nhap bao nhieu giag vien : ");
			n=so.nextInt();
			for(int i=0;i<n;i++)
			{
				giangVien=new GiangVien();
				System.out.println("Nhập giảng viên thứ "+(i+1)+":");
				for(;;) 
					{
						try 
						{
							System.out.print("nhap ma can bo :" );
							String macb;
							macb = so.next();
							CanBoException.chkHoten(macb);
							CanBoException.chkMaCanBo(macb, arrcanbo);
							giangVien.setMaCanBo(macb);
							break;
						}catch(Exception e)
						{
							System.out.print(e);
						}
					}
				giangVien.nhapCanBo();
				giangVien.nhapGiangVien();
				arrcanbo.add(giangVien);
				arrgiangvien.add(giangVien);
			}
		}
		else if (chon==2)
		{
			System.out.print("ban muon nhap bao nhieu nhan vien :");
			n=so.nextInt();
			for(int i=0;i<n;i++) 
			{
				nhanVien=new NhanVien();
				System.out.println("Nhập nhân viên thứ "+(i+1)+":");
				try {
				System.out.print("nhap ma can bo :" );
				String macb;
				macb = so.next();
				CanBoException.chkHoten(macb);
				CanBoException.chkMaCanBo(macb, arrcanbo);
				nhanVien.setMaCanBo(macb);
				break;
					
				}catch(Exception e) {
					System.out.print(e);
				}
				nhanVien.nhapCanBo();
				nhanVien.nhapNhanVien();
				arrcanbo.add(nhanVien);
				arrnhanvien.add(nhanVien);
			}
		}
		}
        if (key==2) {        
        	System.out.println("Xuất danh sách giảng viên hoặc nhân viên");
        	System.out.println("1.Xuất danh sách giảng viên\n2.Xuất danh sách nhân viên");
        	Scanner arr =new Scanner(System.in);
        	int keyy=0;
        	keyy=arr.nextInt();
        	if(keyy==1) {
        		for(int i = 0 ; i < arrcanbo.size() ; i++ ) {
        	arrgiangvien.get(i).XuatGiangVien();
        		}
        	}
        	if(keyy==2) {
        		for(int i = 0 ; i < arrcanbo.size() ; i++ ) {
        	arrnhanvien.get	(i).xuatNhanVien();
        	}
        	}
        	}
        if(key==3) {
        	float tongluong=0;
        	for(int i=0;i<arrcanbo.size();i++) {
        		tongluong+=arrcanbo.get(i).getLuong();
        	}
        	System.out.println("Tổng lương:"+tongluong);
        }
        if (key == 4) {
        	Collections.sort(arrcanbo, new Comparator<CanBo>() {
        		public int compare(CanBo s1, CanBo s2) {
        			if (s1.getLuong() > s2.getLuong()) 
        				return 1;
        			else if (s1.getLuong() < s2.getLuong()) return -1;
        			else return s1.getHoTen().compareTo(s2.getHoTen());
        		}
        	});	
        	for(int i = 0 ; i < arrcanbo.size() ; i++ ) {
        		System.out.println(	arrcanbo.get(i).getHoTen());
        		System.out.println(	arrcanbo.get(i).getLuong());
        	}
        }       	
	}while (key != 9) ;
		 }

}
