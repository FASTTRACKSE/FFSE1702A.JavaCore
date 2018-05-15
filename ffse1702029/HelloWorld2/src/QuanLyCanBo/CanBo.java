package QuanLyCanBo;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Scanner;

public class CanBo {
	private String hoTen;
	private int phuCap;
	private float luong;
	private float heSoLuong;

	public CanBo() {
	}

	public CanBo(String hoTen, int phuCap, float luong, float heSoLuong) {
		this.hoTen = hoTen;
		this.phuCap = phuCap;
		this.luong = luong;
		this.heSoLuong = heSoLuong;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public void nhapHoTen() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập họ tên");
		String hoTen;
		while (true) {
			try {
				hoTen = scn.nextLine();
				MyException.chkHoTen(hoTen, Main.list);
				break;
			} catch (MyException e) {
				System.err.println(e);
			}
		}
		this.setHoTen(hoTen);
	}

	public void nhapHeSoLuong() {
		float heSoLuong = 0;
		String input;
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập hệ số lương");
		while (true) {
			try {
				input = scn.nextLine();
				MyException.chkhesoluong(input);
				heSoLuong = Float.parseFloat(input);
				break;
			} catch (MyException e) {
				System.err.println(e);
			}
		}
		this.setHeSoLuong(heSoLuong);
	}
}
=======
import java.util.Scanner;

public class CanBo {
	private String hoTen, loaiCanBo;
    private double heSoLuong;
    private int phuCap;
    protected int choose;
    Scanner scanner = new Scanner(System.in);
    CanBo canBo;
     
    public CanBo() {
        super();
    }
 
    public CanBo(String hoTen, String loaiCanBo, double heSoLuong, int phuCap) {
        super();
        this.hoTen = hoTen;
        this.loaiCanBo = loaiCanBo;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }
 
    public String getHoTen() {
        return hoTen;
    }
 
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
 
    public String getLoaiCanBo() {
        return loaiCanBo;
    }
 
    public void setLoaiCanBo(String loaiCanBo) {
        this.loaiCanBo = loaiCanBo;
    }
 
    public double getHeSoLuong() {
        return heSoLuong;
    }
 
    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
 
    public int getPhuCap() {
        return phuCap;
    }
 
    public void setPhuCap(int phuCap) {
        this.phuCap = phuCap;
    }
     
    public void nhap() {
        System.out.print("Nhập họ tên: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập hệ số lương: ");
        heSoLuong = Double.parseDouble(scanner.nextLine());
    }
     
    public long tinhLuong() {
        return 0;
    }
     
    @Override
    public String toString() {
        return "Tên: " + this.hoTen + ", hệ số lương: " + this.heSoLuong + ", phụ cấp: " + 
                phuCap + ", lương: " + this.tinhLuong();
    }
}
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing
