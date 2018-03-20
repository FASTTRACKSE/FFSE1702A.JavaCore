import java.util.Scanner;

public class NhanVien extends CanBo {
	String phongban ;
	int songaycong ;
	String chucvu ; 
	public NhanVien() {}
	
	public NhanVien(String phongban, int songaycong, String chucvu, int luongnv) {
		super();
		this.phongban = phongban;
		this.songaycong = songaycong;
		this.chucvu = chucvu;
	}

	public String getPhongban() {
		return phongban;
	}

	public void setPhongban(String phongban) {
		this.phongban = phongban;
	}
	public int getSongaycong() {
		return songaycong;
	}
	public void setSongaycong(int songaycong) {
		this.songaycong = songaycong;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	
	public void xuat()
	{
		System.out.print("\nhọ và tên    : " + getHoten() + "\nphòng ban    : " + getPhongban()  + "\nchức vụ      : " + getChucvu()  + "\nphụ cấp      : " + getPhucap() + "\nsố ngày công : " + getSongaycong() + "\nhệ số lương  : " + getHesoluong()   );
		System.out.print("\n--------------------------------------------\n");

	}
	public void nhap()
	{
		int keytrinhdo = 0;
		Scanner nhap = new Scanner(System.in);
		super.nhap();
		for(;;)
		{
			System.out.println("nhập phòng ban của nhân viên : ");
			try 
			{
				String phongban = nhap.nextLine();
				CanBoException.chkHoten(phongban);	
				this.setPhongban(phongban);
				break;
			}catch(CanBoException e)
			{
				System.out.print(e);
			}
			}
		for(;;) 
		{
			System.out.println("nhập chức vụ của nhân viên :");
			System.out.println("- nhập số 1 : trưởng phòng \n- nhập số 2 : phó phòng \n- nhập số 3 : nhân viên ");
			try 
			{
				keytrinhdo = Integer.parseInt(nhap.nextLine()) ;
				if(keytrinhdo == 1 )
				{
					int truongphong = 2000 ;
					this.setChucvu("Trưởng Phòng");
					this.setPhucap(truongphong);
					break;
					
				}else if(keytrinhdo == 2 )
				{
					int phophong = 1000;
					this.setChucvu("phó phòng");
					this.setPhucap(phophong);
					break;
				}else if(keytrinhdo ==3 )
				{
					int nhanvien = 1000 ;
					this.setChucvu("nhân viên");
					this.setPhucap(nhanvien);
					break;
				}else
				{
					System.out.print("vui lòng nhập đúng yêu cầu \n");
				}
			}catch(Exception e )
			{
				System.out.print("vui lòng nhập số \n ");
			}
		}
		for(;;)
		{
			System.out.println("nhập số ngày công của nhân viên :");
			try {
			int songaycong  = Integer.parseInt(nhap.nextLine()) ;
			CanBoException.chkso(songaycong);
			this.setSongaycong(songaycong);
			break;
			}catch(CanBoException e )
			{
				System.out.print(e);
			}catch (Exception e )
			{
				System.out.print("vui lòng nhập số  \n ");
			}
			
		}
		float luong = ( this.getHesoluong() * 730 ) + this.getPhucap() + ( this.getSongaycong() * 30  ) ;
		this.setLuong(luong);
	}
	

}
