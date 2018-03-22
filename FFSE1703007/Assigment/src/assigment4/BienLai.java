package assigment4;

import java.util.ArrayList;
import java.util.Scanner;

public class BienLai extends KhachHang {
	int chisocu;
	int chisomoi;
	int sotien;
	
	public int getChisocu() {
		return chisocu;
	}

	public void setChisocu(int chisocu) {
		this.chisocu = chisocu;
	}

	public int getChisomoi() {
		return chisomoi;
	}

	public void setChisomoi(int chisomoi) {
		this.chisomoi = chisomoi;
	}

	public int getSotien() {
		return sotien;
	}

	public void setSotien(int sotien) {
		this.sotien = sotien;
	}

	public void add() {
		super.add();
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập chỉ số cũ");
		int chisocu = Integer.parseInt(scan.nextLine());

		System.out.println("Nhập chỉ số mới");
		int chisomoi = Integer.parseInt(scan.nextLine());
				
		this.chisocu = chisocu;
		this.chisomoi = chisomoi;
		this.tinhsotien();	
	}

	public void tinhsotien() {
		int sotien = (this.chisomoi - this.chisocu) * 750;
		this.sotien = sotien;
	}
}
