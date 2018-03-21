package java_asm;


	import java.util.ArrayList;
	import java.util.Scanner;

	public class KhachHang 
	{
		String hoTen ;
		String maSoCongTo ;
		String soNha ;
		public KhachHang() {}
		public KhachHang(String hoten, String masocongto, String sonha) 
		{
			super();
			this.hoTen = hoten;
			this.maSoCongTo = masocongto;
			this.soNha = sonha;
		}
		public String getHoten() 
		{
			return hoTen;
		}
		public void setHoten(String hoten) 
		{
			this.hoTen = hoten;
		}
		public String getMasocongto() 
		{
			return maSoCongTo;
		}
		public void setMasocongto(String masocongto) 
		{
			this.maSoCongTo = masocongto;
		}
		public String getSonha() 
		{
			return soNha;
		}
		public void setSonha(String sonha) 
		{
			this.soNha = sonha;
		}
		
		public void xuat() 
		{
			System.out.print("\n------------------------------------------------\n");
		    System.out.println( "- tên chủ hộ       : " + getHoten()+ "\n- mã số công tơ    : " + getMasocongto() + " \n- số nhà           : " + getSonha() );
		    
		}
		public void nhapthongtin() 
		{
			Scanner scanner = new Scanner(System.in);

			System.out.println("nhập tên chủ hộ :");
			String ten = scanner.nextLine();
			this.setHoten(ten);
			
			System.out.println("nhập số nhà của chủ hộ  :");
			String sonha = scanner.nextLine();
			this.setSonha(sonha);
			
			System.out.println("Nhập mã số công tơ của khách hàng :");
			String maso = scanner.nextLine();
			this.setMasocongto(maso);
		}
		
		
	}

