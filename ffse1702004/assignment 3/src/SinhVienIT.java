import java.util.Scanner;
public class SinhVienIT extends SinhVienFPT {
	double diemJava;
	double diemCSS;
	double diemHTML;
	
	public SinhVienIT(String hoTen ,double diemJava ,double diemCSS ,double diemHTML ){
		super(hoTen,"IT");
		this.diemJava = diemJava;
		this.diemCSS = diemCSS;
		this.diemHTML = diemHTML;
	}
	
	@Override
	double getDiem() 
	{	
		// TODO Auto-generated method stub
		return (2*this.diemJava + this.diemCSS + this.diemHTML)/4;
	}
	public static void main(String arg[])
	{
		System.out.println("nhập sinh viên");
		System.out.print("nhập họ Tên  :");
		Scanner nhapHoten = new Scanner(System.in);
		String hoTen = nhapHoten.nextLine();
		
		Scanner nhapdiem = new Scanner(System.in);
		System.out.print("nhập điểm  java : ");
		double diemJava = nhapdiem.nextDouble();
		
	
		System.out.print("nhập điểm  css : ");
		double diemCSS = nhapdiem.nextDouble();

		System.out.print("nhập điểm  HTML : ");
		double diemHTML = nhapdiem.nextDouble();
		
		SinhVienFPT sinhvien =  new SinhVienIT(hoTen,diemJava,diemCSS,diemHTML);
		
		System.out.print("---------->>>xuất  ra  màn hình<<<----------- \n ");
		sinhvien.xuat();
		
	}
}
