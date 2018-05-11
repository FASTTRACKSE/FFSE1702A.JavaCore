package assigment5;

import java.awt.List;
import java.util.Scanner;

public class Nhanvien extends CanBo {
	String phongban;
	int songaycong;
	String chucvu;

	public Nhanvien() {
		super();
	}

	public Nhanvien(String phongban, int songaycong, String chucvu) {
		super();
		this.phongban = phongban;
		this.songaycong = songaycong;
		this.chucvu = chucvu;
	}

	public Nhanvien(String hoTen, int phuCap, float luong, float heSoLuong) {
		super(hoTen, phuCap, luong, heSoLuong);
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	
	
=======
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5

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

<<<<<<< HEAD
	public void nhap() {
		super.nhapHoTen();
		
=======
	@Override
	public String toString() {
		return "Nhanvien [phongban=" + phongban + ", songaycong=" + songaycong + ", chucvu=" + chucvu + "] \r\n";
	}

	public void nhap() {
		String chucvu;
		String input;
		super.nhapHoTen();

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên phòng ban");
		String phongban = scan.nextLine();

		System.out.println("Nhập chức vụ");
<<<<<<< HEAD
		String chucvu = scan.nextLine();
		
=======
		while (true) {
			try {
				input = scan.nextLine();
				MyException.chkChucVu(input);
				chucvu=input;
				break;
			} catch (MyException e) {
				// TODO: handle exception
				System.err.println(e);
			}
		}

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
		System.out.println("Nhập số ngày công");
		int songaycong = Integer.parseInt(scan.nextLine());

		super.nhapHeSoLuong();
<<<<<<< HEAD
		
		this.setChucvu(chucvu);
		this.setPhongban(phongban);
		this.setSongaycong(songaycong);
		
=======

		this.setChucvu(chucvu);
		this.setPhongban(phongban);
		this.setSongaycong(songaycong);

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
		if (chucvu.equals("nhân viên")) {
			this.setPhuCap(500);
		} else if (chucvu.equals("phó phòng")) {
			this.setPhuCap(1000);
		} else if (chucvu.equals("trưởng phòng")) {
			this.setPhuCap(2000);
		}
<<<<<<< HEAD
		
		this.tinhluong();
	}
	
=======

		this.tinhluong();
	}

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
	public void xuat() {
		System.out.println("Tên giảng viên: " + this.getHoTen());
		System.out.println("Phòng ban: " + this.getPhongban());
		System.out.println("Chức vụ: " + this.getChucvu());
		System.out.println("Số ngày công: " + this.getSongaycong());
		System.out.println("Phụ cấp: " + this.getPhuCap());
		System.out.println("Lương: " + this.getLuong());
	}

	public void tinhluong() {
<<<<<<< HEAD
		 float luong = this.getHeSoLuong()*730+this.getPhuCap()+this.getSongaycong()*30;
		 this.setLuong(luong);
	 }
=======
		float luong = this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSongaycong() * 30;
		this.setLuong(luong);
	}
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
}
