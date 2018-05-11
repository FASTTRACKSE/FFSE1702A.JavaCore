package Ass4;
import java.util.Scanner;
public class TienDien extends KhachHang {
   private int chiSoCu;
   private int chiSoMoi;
   private int soTienTra;
public TienDien() {}

public TienDien(String hoTen, String maCT, int soNha, int chiSoCu, int chiSoMoi, int soTienTra) {
	super(hoTen, maCT, soNha);
	this.chiSoCu = chiSoCu;
	this.chiSoMoi = chiSoMoi;
	this.soTienTra = soTienTra;
}
public int getChiSoCu() {
	return chiSoCu;
}
public void setChiSoCu(int chiSoCu) {
	this.chiSoCu = chiSoCu;
}
public int getChiSoMoi() {
	return chiSoMoi;
}
public void setChiSoMoi(int chiSoMoi) {
	this.chiSoMoi = chiSoMoi;
}
public int getSoTienTra() {
	return soTienTra;
}
public void setSoTienTra(int soTienTra) {
	this.soTienTra = soTienTra;
}
   
public void xuat1 () {
	   super.xuat();
	   System.out.println( "- chỉ số  cũ       : " + getChiSoCu()+ "\n- chỉ số mới       : " + getChiSoMoi() + " \n" );
	   
   }
   public void nhap () {
	   Scanner nhapTT = new Scanner(System.in);
	   super.nhapthongtin();
	   System.out.println("nhập chỉ số  mới  :");
	   int moi = nhapTT.nextInt();
	   this.setChiSoMoi(moi);
	   
	   System.out.println("nhập chỉ số  củ  :");
	   int cu = nhapTT.nextInt();
	   this.setChiSoCu(cu);
	   
		int sotienphaitra =(int) (chiSoMoi - chiSoCu ) * 750 ; 
		this.setSoTienTra(sotienphaitra);
   }
   public void tinhtien () {
	   super.xuat();
	   System.out.println( "- chỉ số  cũ       : " + getChiSoCu()+ "\n- chỉ số mới       : " + getChiSoMoi() + " \n" );
	   System.out.println("- So tien phai tra :" + soTienTra);
   }
   
	public static void main(String agrs[]) {
		
		TienDien[] listKh = new TienDien[50];
		int controller = 9 ;
		int soluong = 0;
		do 
		{ 
		    System.out.print("\n*************************************************\n");
		    System.out.print("* số 1 : nhập thông tin khách hàng               *\n");
		    System.out.print("* số 2 : xem thông tin khách hàng                *\n");
		    System.out.print("* số 3 : tính tiền điện khách hàng               *\n");
		    System.out.print("*************************************************\n ");
		    System.out.print("\n chọn chức năng bạn muốn : ");
			Scanner scanner = new Scanner(System.in);
			
			controller = scanner.nextInt();
			if(controller == 1) {
	    		System.out.println("*******************************************");
	    		System.out.print("\nbạn muốn  bao nhiêu khách hàng :");
	        int number = scanner.nextInt();
			
	        for(int i = 0 ; i< number ; i++ ) 
	        {
		   
	        		int dem = i + 1;
	        		System.out.println("thông tin khách hàng thứ " + dem );
	        	 	TienDien td = new TienDien();
	        		td.nhap();
	        		
	        		listKh[soluong] = td;
	        		soluong ++ ;  
	        	      
	        }
		    }else if(controller == 2 ) 
		    {
		    	for(int i = 0 ; i< soluong ; i++ ) 
		        {
		    		//System.out.println(listKh[i].hoten);
		    		listKh[i].xuat1();
		        }
		    }else if(controller == 3) {
		    	for(int i = 0 ; i< soluong ; i++ ) 
		        {
		    		//System.out.println(listKh[i].hoten);
		    		listKh[i].tinhtien();
		        }
		    	
		    }
			
			
		}while(controller != 0);
	}
}
