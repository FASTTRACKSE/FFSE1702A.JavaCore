import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) 
	{
		ArrayList<CanBo> list = new ArrayList<CanBo>();
		int controller = 9 ;
		int soluong = 0;
		do 
		{ 
		    System.out.print("\n*************************************************\n");
		    System.out.print("* số 1 : nhập thông tin                           *\n");
		    System.out.print("* số 2 : xem thông tin                            *\n");
		    System.out.print("* số 3 : Tổng số lương trường phải trả cho cán bộ *\n");
		    System.out.print("* số 3 : Sắp xếp cán bộ theo lương , tên          *\n");
		    System.out.print("***************************************************\n ");
		    System.out.print("\n chọn chức năng bạn muốn : ");
			Scanner scanner = new Scanner(System.in);
			
		    controller = Integer.parseInt(scanner.nextLine()) ;
		   
		    if( controller == 1 ) 
		    {
		    		
		    		
		    		int luonggv = 0 ;
		    		int key = 9 ;
		    		System.out.print("* số 1 : nhập thông tin giảng viên             *\n");
			    System.out.print("* số 2 : xem thông tin  nhân viên              *\n");
			    System.out.print("\n chọn chức năng bạn muốn : ");
			    key = Integer.parseInt(scanner.nextLine()) ;
			    
			    if(key == 1) 
			    { 
		    			System.out.println("*******************************************");
		    			System.out.print("\nbạn muốn  bao nhiêu giảng viên  :");
		    			int number = Integer.parseInt(scanner.nextLine());

		    			for(int i = 0 ; i< number ; i++ ) 
		    			{	
		        		
		    				System.out.println("-------------------------------------" );
		    				int dem = i + 1;
		    				System.out.println("thông tin giảng viên thứ " + dem );
		        		
		    				GiangVien gv  = new GiangVien();
		    				//kiểm tra mã cán bộ 
		    				for(;;)
		    				{
		    					System.out.print("nhập mã cán bộ : ");
		    					try 
		    					{
				    					String MaCanBo = scanner.nextLine();
				    					CanBoException.chkHoten(MaCanBo);
				    					CanBoException.chkMaCanBo(MaCanBo, list);	
				    					gv.setMaCanBo(MaCanBo);
				    					break;
							}catch(CanBoException e)
							{
								System.out.print(e);
							}
		    				}
				    		
		    				gv.nhap();
		    				list.add(gv);
		    				soluong ++ ;
		    			}
		    			
			    }else if(key ==2 )
			    {
			    	System.out.println("*******************************************");
	    			System.out.print("\nbạn muốn  bao nhiêu nhân  viên  :");
	    			int number = Integer.parseInt(scanner.nextLine());
	    			for(int i = 0 ; i< number ; i++ ) 
	    			{	
	    				System.out.println("-------------------------------------" );
	    				int dem = i + 1;
	    				System.out.println("thông tin nhân viên thứ " + dem );
	    				NhanVien nv  = new NhanVien();
	    				//kiểm tra mã cán bộ 
	    				for(;;)
	    				{
	    					System.out.print("nhập mã cán bộ : ");
	    					try 
						{
			    				String MaCanBo = scanner.nextLine();
							CanBoException.chkMaCanBo(MaCanBo, list);	
							nv.setMaCanBo(MaCanBo);
							break;
						}catch(CanBoException e)
						{
							System.out.print(e);
						}
	    				}
	    				
	    				nv.nhap();
	    				list.add(nv);
	    				soluong ++ ; 
			    }
			    }
			}else if(controller == 2 ) 
		    {
				System.out.println("\n---------------------------------------");
				System.out.println("Danh Sách Giảng Viên :");
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i) instanceof GiangVien) {
						GiangVien gv = (GiangVien)list.get(i);
						gv.xuat();
						
					} 
				}
				System.out.println("\n---------------------------------------");
				System.out.println("Danh Sách Nhân Viên :");
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i) instanceof NhanVien) {
						NhanVien nv = (NhanVien)list.get(i);
						nv.xuat();
					}
				}
				
		}else if(controller== 3 ) 
		{
			float tongluong = 0;
			
			for(int i = 0 ; i < list.size();i++ )
			{CanBo cb = list.get(i);
			tongluong  += cb.getLuong();
			}
			System.out.print("tong : " + tongluong);
		}else if(controller == 4) 
	    {
			Collections.sort(list, new Comparator<CanBo>() {

				@Override
				public int compare(CanBo o1, CanBo o2) {
					if(o1.getHesoluong() == o2.getHesoluong()) {
						return o2.getHoten().compareTo(o1.getHoten());
					} else {
					// TODO Auto-generated method stub
					return (o1.getHesoluong() > o2.getHesoluong())? -1 : 1;
					}
				}
				
			});
			}
		    }while(controller != 0);

	}
}
