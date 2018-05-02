package ks;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Nguoi {
	private String hoTen;
	private Date ngaySinh;
	private String soCMND;
	public Nguoi()
		{
		
	}
	public Nguoi(String hoTen, Date ngaySinh, String soCMND) {
		this.hoTen		=	hoTen;
		this.ngaySinh	=	ngaySinh;
		this.soCMND		=	soCMND;	
		}
	public void nhapThongTin(Scanner sc)
	{
		System.out.println("Nhập họ và tên khách hàng");
		this.hoTen	=	sc.nextLine();
		System.out.println("Nhập ngày sinh(dd-mm-yyyy)");
		String ns=sc.nextLine();
		this.ngaySinh=chuyenStringDate(ns);		
		System.out.println("Nhập số CMND");
		this.soCMND	=	sc.nextLine();
	}
	public void hienThongTin()
	{
		System.out.println("Họ và tên: "+ this.hoTen);
		System.out.println("Ngày sinh: "+ this.ngaySinh);
		System.out.println("Số CMND: "	+ this.soCMND);
	}
	public Date chuyenStringDate(String str) {
		Date ns	=	null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			ns=sdf.parse(str);
		} catch(Exception e)
		{
			System.out.println("Lỗi định dạng thời gian");
		}
		return ns;
	}
	public String getSoCMND()
	{	return this.soCMND;
	}
}
