package QuanLyCanBo;

<<<<<<< HEAD
import java.awt.List;
import java.util.Scanner;

public class NhanVien extends CanBo {
	String phongban;
	int songaycong;
	String chucvu;

	public NhanVien() {
		super();
	}

	public NhanVien(String phongban, int songaycong, String chucvu) {
		super();
		this.phongban = phongban;
		this.songaycong = songaycong;
		this.chucvu = chucvu;
	}

	public NhanVien(String hoTen, int phuCap, float luong, float heSoLuong) {
		super(hoTen, phuCap, luong, heSoLuong);
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Nhanvien [phongban=" + phongban + ", songaycong=" + songaycong + ", chucvu=" + chucvu + "] \r\n";
	}

	public void nhap() {
		String chucvu;
		String input;
		super.nhapHoTen();

		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên phòng ban");
		String phongban = scan.nextLine();

		System.out.println("Nhập chức vụ");
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

		System.out.println("Nhập số ngày công");
		int songaycong = Integer.parseInt(scan.nextLine());

		super.nhapHeSoLuong();

		this.setChucvu(chucvu);
		this.setPhongban(phongban);
		this.setSongaycong(songaycong);

		if (chucvu.equals("nhân viên")) {
			this.setPhuCap(500);
		} else if (chucvu.equals("phó phòng")) {
			this.setPhuCap(1000);
		} else if (chucvu.equals("trưởng phòng")) {
			this.setPhuCap(2000);
		}

		this.tinhluong();
	}

	public void xuat() {
		System.out.println("Tên giảng viên: " + this.getHoTen());
		System.out.println("Phòng ban: " + this.getPhongban());
		System.out.println("Chức vụ: " + this.getChucvu());
		System.out.println("Số ngày công: " + this.getSongaycong());
		System.out.println("Phụ cấp: " + this.getPhuCap());
		System.out.println("Lương: " + this.getLuong());
	}

	public void tinhluong() {
		float luong = this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSongaycong() * 30;
		this.setLuong(luong);
	}
}
=======
public class NhanVien  extends CanBo {
    private String phongBan, chucVu;
    private int soNgayCong, choose;
     
    public NhanVien() {
        super();
    }
 
    public NhanVien(String phongBan, String chucVu, int soNgayCong) {
        super();
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.soNgayCong = soNgayCong;
    }
 
    public String getPhongBan() {
        return phongBan;
    }
 
    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
 
    public String getChucVu() {
        return chucVu;
    }
 
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
 
    public int getSoNgayCong() {
        return soNgayCong;
    }
 
    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }
 
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhập phòng ban: ");
        phongBan = scanner.nextLine();
        do {
            System.out.print("Nhập chức vụ (1 - trưởng phòng, 2 - phó phòng, 3 - nhân viên): ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    chucVu = "trưởng phòng";
                    this.setPhuCap(2000);
                    break;
                case 2:
                    chucVu = "phó phòng";
                    this.setPhuCap(1000);
                    break;
                case 3:
                    chucVu = "nhân viên";
                    this.setPhuCap(500);
                    break;
                default:
                    System.out.println("Chọn không đúng!");
                    break;
            }
        } while (choose < 1 || choose > 3);
        System.out.print("Nhập số ngày công: ");
        soNgayCong = scanner.nextInt();
    }
 
    @Override
    public long tinhLuong() {
        return (long) (this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoNgayCong() * 200);
    }
 
    @Override
    public String toString() {
        return super.toString() + ", phòng ban: " + this.phongBan + ", chức vụ: " + this.chucVu + 
            ", số ngày công: " + this.soNgayCong;
    }
     
}
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing
