package text;

import java.util.Scanner;

public class BienLai extends KhachHang {
	int chiSoCu;
	int chiSoMoi;
	float soTienPhaiTra = 0;
	private KhachHang khachHang;

	public BienLai() {

	}

	public BienLai(String hoTen, String soNha, String maSoCongTo, int chiSoCu, int chiSoMoi, float soTienPhaiTra) {
		super(hoTen, soNha, maSoCongTo);
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.soTienPhaiTra = soTienPhaiTra;
	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public float getSoTienPhaiTra() {
		return soTienPhaiTra;
	}

	public void setSoTienPhaiTra(float soTienPhaiTra) {
		this.soTienPhaiTra = soTienPhaiTra;
	}

	public BienLai(String hoTen, String soNha, String maSoCongTo, KhachHang khachHang) {
		super(hoTen, soNha, maSoCongTo);
		this.khachHang = khachHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public void nhapbienlai() {
		super.nhap();

		Scanner congto = new Scanner(System.in);
		System.out.print("Nháº­p sá»‘ cÃ´ng tÆ¡ má»›i: ");
		int chiSoMoi = congto.nextInt();
		this.setChiSoMoi(chiSoMoi);

		System.out.print("Nháº­p sá»‘ cÃ´ng tÆ¡ cÅ©: ");
		int chiSoCu = congto.nextInt();
		this.setChiSoCu(chiSoCu);

		float soTienPhaiTra = ((chiSoMoi - chiSoCu) * 750);
		this.setSoTienPhaiTra(soTienPhaiTra);
	}

	public void xuatbienlai() {
		super.xuat();
		System.out.println("Sá»‘ cÃ´ng tÆ¡ cÅ©: " + this.getChiSoCu() + "\n" + "Sá»‘ cÃ´ng tÆ¡ má»›i: "
				+ this.getChiSoMoi() + "\n" + "Sá»‘ tiá»�n pháº£i tráº£: " + this.getSoTienPhaiTra() + "Ä‘");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BienLai[] dsKH = new BienLai[50];
		int index = 0;
		for (;;) {
			try {
				System.out.print("");
				System.out.println("+>>      Menu      <<+");
				System.out.println("+|    1. ThÃªm KH    |+");
				System.out.println("+|    2. Update KH  |+");
				System.out.println("+|    3. XÃ³a KH     |+");
				System.out.println("+|    4. Sáº¯p xáº¿p KH |+");
				System.out.println("+|    5. List KH    |+");
				System.out.println("+>> Chá»�n chá»©c nÄƒng <<+");

				Scanner myInput = new Scanner(System.in);
				int answer = myInput.nextInt();

				if (answer == 1) {
					System.out.print("Sá»‘ há»™ gia Ä‘Ã¬nh cáº§n nháº­p: ");
					int m = scanner.nextInt();

					for (int i = 0; i < m; i++) {
						BienLai bl = new BienLai();
						System.out.println("Nháº­p thÃ´ng tin biÃªn lai cá»§a há»™ gia Ä‘Ã¬nh: ");
						bl.nhapbienlai();
						System.out.println("ThÃ´ng tin biÃªn lai cá»§a cÃ¡c há»™ gia Ä‘Ã¬nh: ");
						bl.xuatbienlai();
						dsKH[index] = bl;
						index++;

					}
				}

				else if (answer == 2) {
					/*
					 * System.out.print("Nháº­p ID cá»§a sinh viÃªn cáº§n thay Ä‘á»•i: "); Scanner
					 * update = new Scanner(System.in); String id = update.nextLine();
					 * 
					 * for (int i = 0; i < index; i++) { if (dsSV[i].getId().equals(id)) {
					 * System.out.print("Nháº­p tÃªn sinh viÃªn: "); Scanner tenSV = new
					 * Scanner(System.in); String name = tenSV.nextLine(); dsSV[i].setName(name); }
					 * }
					 */
				}

				else if (answer == 3) {
					/*
					 * System.out.print("Nháº­p ID cá»§a sinh viÃªn cáº§n xÃ³a: "); Scanner update =
					 * new Scanner(System.in); String id = update.nextLine();
					 * 
					 * for (int i = 0; i < index; i++) { if (dsSV[i].getId().equals(id)) { for (int
					 * j = i + 1; j < index; j++) { dsSV[i] = dsSV[j]; } } } dsSV[index - 1] = null;
					 * index--;
					 */
				}

				else if (answer == 4) {
					/*
					 * for (int i = 0; i < index; i++) { for (int j = i + 1; j < index; j++) { int a
					 * = dsSV[i].getName().compareTo(dsSV[j].getName()); if (a>0) { sinhvien1 bien =
					 * dsSV[i]; dsSV[i] = dsSV[j]; dsSV[j] = bien;
					 * 
					 * } } }
					 */
				}

				else if (answer == 5) {
					for (int i = 0; i < index; i++) {
						dsKH[i].xuatbienlai();
					}
				}

				else {
					System.out.println(
							"+>> Nháº­p sai chá»©c nÄƒng vui lÃ²ng nháº­p láº¡i chá»©c nÄƒng trong khoáº£ng tá»« 1 Ä‘áº¿n 4 <<+");
				}
			} catch (Exception e) {
				System.out.println("+>> Error! Vui lÃ²ng nháº­p láº¡i <<+");
			}
		}

	}
}
