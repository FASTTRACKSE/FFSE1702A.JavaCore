import java.util.Scanner;
public class GiangVien extends CanBo {
	String khoa ;
	String trinhdo ;
	int sotietday ;
	public GiangVien() {}
	
	public GiangVien(String khoa, String trinhdo, int sotietday) {
		super();
		this.khoa = khoa;
		this.trinhdo = trinhdo;
		this.sotietday = sotietday;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	public String getTrinhdo() {
		return trinhdo;
	}
	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}
	public int getSotietday() {
		return sotietday;
	}
	public void setSotietday(int sotietday) {
		this.sotietday = sotietday;
	}
	
	public void xuat()
	{
		
		System.out.print("\nhọ và tên    : " + getHoten() + "\nkhoa         : " + getKhoa()  + "\ntrình độ     : " + getTrinhdo()  + "\nphụ cấp      : " + getPhucap() + "\nsố tiết dạy  : " + getSotietday() + "\nhệ số lương  : " + getHesoluong()   );
		System.out.print("\n--------------------------------------------\n");
	}
	public void nhap()
	{
		
		int keytrinhdo = 0;
		Scanner nhap = new Scanner(System.in);
		super.nhap();
		for(;;)
		{
			System.out.println("nhập khoa của giảng viên : ");
			try 
			{	
				String khoa = nhap.nextLine();
				CanBoException.chkHoten(khoa);
				this.setKhoa(khoa);
				break;
			}catch(CanBoException e)
			{System.out.print(e);}
		}	
		for(;;) 
		{
			System.out.println("nhập trình độ của giảng viên :");
			System.out.println("- nhập số 1 : Cử Nhân  \n- nhập số 2 : Thạc Sỹ  \n- nhập số 3 : Tiến Sỹ  ");
			try 
			{
				String key = nhap.nextLine();
				CanBoException.chkso1(key);
				keytrinhdo = Integer.parseInt(key);
				if(keytrinhdo == 1 )
					{
						int cunhan = 300 ;
						this.setTrinhdo("Cử Nhân");
						this.setPhucap(cunhan);
						break;
					}else if(keytrinhdo == 2 )
					{
						int thacsy = 500;
						this.setTrinhdo("Thạc Sỹ");
						this.setPhucap(thacsy);
						break;
					}else if(keytrinhdo ==3 )
					{
						int tiensy = 1000 ;
						this.setTrinhdo("Tiến Sỹ");
						this.setPhucap(tiensy);
						break;
					}
			}catch(CanBoException e)
			{
				System.out.print(e);
			}
		}
		for(;;) 
		{
			System.out.println("nhập số tiết dạy của giảng viên :");
			try 
			{
				int sotietday  = Integer.parseInt(nhap.nextLine()) ;
				CanBoException.chkso(sotietday);
				this.setSotietday(sotietday);
				break ;
			}catch(CanBoException e )
			{
				System.out.print(e);
			}catch (Exception e )
			{
				System.out.print("vui lòng nhập số  \n ");
			}
		}
		float luong  = ( this.getHesoluong() * 730 ) + this.getPhucap() + ( this.getSotietday() * 45  ) ;
		this.setLuong(luong);
		 

		 
	}
}
