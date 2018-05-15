package assignment_java;
import java.util.ArrayList;
import java.util.Scanner;

public class Khachhang 
{
	String hoten ;
	String masocongto ;
	String sonha ;
	public Khachhang() {}
	public Khachhang(String hoten, String masocongto, String sonha) 
	{
		super();
		this.hoten = hoten;
		this.masocongto = masocongto;
		this.sonha = sonha;
	}
	public String getHoten() 
	{
		return hoten;
	}
	public void setHoten(String hoten) 
	{
		this.hoten = hoten;
	}
	public String getMasocongto() 
	{
		return masocongto;
	}
	public void setMasocongto(String masocongto) 
	{
		this.masocongto = masocongto;
	}
	public String getSonha() 
	{
		return sonha;
	}
	public void setSonha(String sonha) 
	{
		this.sonha = sonha;
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

