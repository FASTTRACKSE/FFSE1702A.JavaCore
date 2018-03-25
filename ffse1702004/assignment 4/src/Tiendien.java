import java.util.Scanner;

public class Tiendien extends Khachhang {
	private int chisocu ;
	private int chisomoi ;
	private int sotienphaitra ;
	public Tiendien() {}
	public Tiendien(int chisocu, int chisomoi, int sotienphaitra) {
		super();
		this.chisocu = chisocu;
		this.chisomoi = chisomoi;
		this.sotienphaitra = sotienphaitra;
	}
	public float getChisocu() {
		return chisocu;
	}
	public void setChisocu(int chisocu) {
		this.chisocu = chisocu;
	}
	public float getChisomoi() {
		return chisomoi;
	}
	public void setChisomoi(int chisomoi) {
		this.chisomoi = chisomoi;
	}
	public float getSotienphaitra() {
		return sotienphaitra;
	}
	public void setSotienphaitra(int sotienphaitra) {
		this.sotienphaitra = sotienphaitra;
	}
	public void xuat1() {
		super.xuat() ;
	    System.out.println( "- chỉ số  cũ       : " + getChisocu()+ "\n- chỉ số mới       : " + getChisomoi() + " \n" );

	}
	public void tinhtien() {
		super.xuat() ;
	    System.out.println( "- chỉ số  cũ       : " + getChisocu()+ "\n- chỉ số mới       : " + getChisomoi() + " \n- số tiền phải trả : " + getSotienphaitra() );
	    
	}
	public void nhap() {
		
		Scanner scanner = new Scanner(System.in);
		super.nhapthongtin();
		System.out.println("nhập chỉ số  mới  :");
		int chisomoi = Integer.parseInt(scanner.nextLine());
		this.setChisomoi(chisomoi);
		
		System.out.println("nhập chỉ số  cũ   :");
		int chisocu = Integer.parseInt(scanner.nextLine());
		this.setChisocu(chisocu);
		
		int sotienphaitra =(int) (chisomoi - chisocu ) * 750 ; 
		this.setSotienphaitra(sotienphaitra);
		
	}
	public static void main(String agrs[]) {
		
		Tiendien[] listKh = new Tiendien[50];
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
			
		    controller = Integer.parseInt(scanner.nextLine()) ;
		    System.out.print(controller);
		    if( controller == 1 ) 
		    {
		    		

		    		System.out.println("*******************************************");
		    		System.out.print("\nbạn muốn  bao nhiêu khách hàng :");
		        int number = Integer.parseInt(scanner.nextLine());
		        
		        for(int i = 0 ; i< number ; i++ ) 
		        {
			   
		        		int dem = i + 1;
		        		System.out.println("thông tin khách hàng thứ " + dem );
		        	 	Tiendien td = new Tiendien();
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
