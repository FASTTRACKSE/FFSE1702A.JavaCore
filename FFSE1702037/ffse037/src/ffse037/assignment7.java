package ffse037;

import java.util.Scanner;

public class assignment7 {

	public static void main(String[] args) {
		for (;;) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Nhập số phần tử của mảng: ");
			int n = scanner.nextInt();
			SinhVien a[] = new SinhVien[n];
			String ten;
			String ngaysinh;
			int diem1;
			int diem2;
			float dtb;
			String xeploai;
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < n; i++) {
				a[i] = new SinhVien();
				System.out.println("Mời bạn nhập họ tên sinh viên");
				ten = sc.nextLine();
				a[i].setTen(ten);
				System.out.println("Mời bạn nhập ngày sinh của sinh viên");
				ngaysinh = sc.nextLine();
				a[i].setNgaysinh(ngaysinh);
				System.out.println("Mời bạn nhập điểm 1 của sinh viên");
				diem1 = sc.nextInt();
				a[i].setDiem1(diem1);
				System.out.println("Mời bạn nhập điểm 2 của sinh viên");
				diem2 = sc.nextInt();
				a[i].setDiem2(diem2);
				
				//a[i].setDtb(diem1,diem2);
			a[i].setDtb((float) ((a[i].getDiem1() + a[i].getDiem2()) / 2.0));
				
				
				sc.nextLine();

			}
			for (;;) {
				System.out.println("+-------------------------------------+");
				System.out.println("+----Nhập 1 hiển thị danh sách------------------------+");
				System.out.println("+----Nhập 2 để sắp xếp tên sinh viên từ A->Z-------------------+");
				System.out.println(
						"+----Nhập 3 để sắp xếp điểm trung bình từ thấp đến cao------------------------------+");
				System.out.println("+----Nhập 4 để kết thúc------------------------+");
				System.out.println("+-------------------------------------+");
				try {
					Scanner myInput = new Scanner(System.in);
					int answer = myInput.nextInt();

					if (answer == 1) {
						System.out.println("+---------------+---------------+--------+--------+---------+----------+");
						System.out.println("| Họ và tên\t|  Ngày sinh    | Điểm 1 | Điểm 2 | Điểm TB | Xếp loại |");
						System.out.println("|---------------|---------------|--------|--------|---------|----------|");
						for (int i = 0; i < n; i++) {

							System.out.println("| " + a[i].getTen() + "\t|   " + a[i].getNgaysinh() + "  |   "
									+ a[i].getDiem1() + "    |   " + a[i].getDiem2() + "    |  " + a[i].getDtb()
									+ "    |     " + a[i].getXeploai() + "    |");

							System.out.println();
						}
						System.out.println("|---------------|---------------|--------|--------|---------|----------|");

					} else if (answer == 2) {
						for (int i = 0; i < n; i++) {

							for (int j = i + 1; j < n; j++) {
								
								if (a[i].getTen().compareTo(a[j].getTen()) < 0) {
									
									SinhVien temp = new SinhVien();
									temp = a[j];
									a[j] = a[i];
									a[i] = temp;
								}
							}
						}
						System.out.println("+---------------+---------------+--------+--------+---------+----------+");
						System.out.println("| Họ và tên\t|  Ngày sinh    | Điểm 1 | Điểm 2 | Điểm TB | Xếp loại |");
						System.out.println("|---------------|---------------|--------|--------|---------|----------|");
						for (int i = 0; i < n; i++) {

							System.out.println("| " + a[i].getTen() + "\t|   " + a[i].getNgaysinh() + "  |   "
									+ a[i].getDiem1() + "    |   " + a[i].getDiem2() + "    |  " + a[i].getDtb()
									+ "    |     " + a[i].getXeploai() + "    |");

							System.out.println();
						}
						System.out.println("|---------------|---------------|--------|--------|---------|----------|");

					} else if (answer == 3) {
						for (int i = 0; i < n; i++) {
							for (int j = i + 1; j < n; j++) {
								if (a[i].getDtb() > a[j].getDtb()) {
									SinhVien temp = new SinhVien();
									temp = a[i];
									a[i] = a[j];
									a[j] = temp;
								}
							}
						}
						System.out.println("+---------------+---------------+--------+--------+---------+----------+");
						System.out.println("| Họ và tên\t|  Ngày sinh    | Điểm 1 | Điểm 2 | Điểm TB | Xếp loại |");
						System.out.println("|---------------|---------------|--------|--------|---------|----------|");
						for (int i = 0; i < n; i++) {

							System.out.println("| " + a[i].getTen() + "\t|   " + a[i].getNgaysinh() + "  |   "
									+ a[i].getDiem1() + "    |   " + a[i].getDiem2() + "    |  " + a[i].getDtb()
									+ "    |     " + a[i].getXeploai() + "    |");

							System.out.println();
						}
						System.out.println("|---------------|---------------|--------|--------|---------|----------|");

					} else if (answer == 4) {
						break;
					} else if (answer != 1 && answer != 2 && answer != 3 && answer != 4) {
						System.out.println("vui lòng nhập số 1,2,3,4");
					}
				} catch (Exception ex) {
					System.out.println("vui lòng nhập số ");
				}
			}

		}
	}
}

class SinhVien {
	private String ten;
	private String ngaysinh;
	private int diem1;
	private int diem2;
	private float dtb;
	private String xeploai;
	

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTen() {
		return ten;
	}

	public void setXeploai(float dtb) {
		this.xeploai = xeploai;
		if (dtb >= 8.5) {
			//a[i].setXeploai("A");
			this.xeploai="A";
		} else if (dtb >= 7.0) {
			this.xeploai="B";
		} else if (dtb >= 5.0) {
			this.xeploai="C";
		} else {
			this.xeploai="D";
		}
	}

	public String getXeploai() {
		
		return xeploai;
	}

	public void setDtb(float dtb) {
		this.dtb = dtb;
	}

	public float getDtb() {
		
		return dtb;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setDiem1(int diem1) {
		this.diem1 = diem1;
	}

	public void setDiem2(int diem2) {
		this.diem2 = diem2;
	}

	public int getDiem1() {
		return diem1;
	}

	public int getDiem2() {
		return diem2;
	}
	
}