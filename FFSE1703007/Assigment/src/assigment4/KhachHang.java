package assigment4;

import java.util.ArrayList;
import java.util.Scanner;

public class KhachHang {
	String ten;
	String sonha;
	String maso;
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getSonha() {
		return sonha;
	}

	public void setSonha(String sonha) {
		this.sonha = sonha;
	}

	public String getMaso() {
		return maso;
	}

	public void setMaso(String maso) {
		this.maso = maso;
	}

	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên");
		String ten = scan.nextLine();

		System.out.println("Nhập số nhà");
		String sonhha = scan.nextLine();

		System.out.println("Nhập mã số");
		String maso = scan.nextLine();
		
		this.setTen(ten);
		this.setSonha(sonhha);
		this.setMaso(maso);
		
	}
}
