import java.io.Serializable;
import java.util.Scanner;

public class CanBo implements Serializable {
	String hoten ;
	int phucap ;
	int hesoluong ;
	float luong ;
	String MaCanBo ;
	
	public CanBo(String hoten, int phucap, int hesoluong, float luong, String maCanBo) {
		super();
		this.hoten = hoten;
		this.phucap = phucap;
		this.hesoluong = hesoluong;
		this.luong = luong;
		MaCanBo = maCanBo;
	}
	public CanBo() {}

	
	public String getMaCanBo() {
		return MaCanBo;
	}
	public void setMaCanBo(String maCanBo) {
		MaCanBo = maCanBo;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getPhucap() {
		return phucap;
	}
	public void setPhucap(int phucap) {
		this.phucap = phucap;
	}
	public int getHesoluong() {
		return hesoluong;
	}
	public void setHesoluong(int hesoluong) {
		this.hesoluong = hesoluong;
	}

	public void nhap()
	{
		Scanner nhap = new Scanner(System.in);
		for(;;) 
		{
			System.out.println("nhập tên của nhân viên hoặc giáo  : ");
			String hoten = nhap.nextLine();
			try 
			{
				CanBoException.chkHoten(hoten);	
				this.setHoten(hoten);
				break;
			}catch(CanBoException e)
			{
				System.out.print(e);
			}
		}
		for(;;)
		{
			System.out.println("nhập hệ số lương  của nhân viên hoặc giáo  : ");
			
			try 
			{	
				int hesoluong = Integer.parseInt(nhap.nextLine());
				CanBoException.chkso(hesoluong);
				this.setHesoluong(hesoluong);
				break;
			}catch(CanBoException e )
			{
				System.out.print(e);
			}catch (Exception e )
			{
				System.out.print("vui lòng nhập số  \n ");
			}
			
		}
	}
}
