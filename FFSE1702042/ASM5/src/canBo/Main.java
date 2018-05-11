package canBo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ArrayList<CanBo> arrCanBo = new ArrayList<>();
		try {
			FileInputStream fos = new FileInputStream("CanBo.doc");
			ObjectInputStream oos = new ObjectInputStream(fos);
			arrCanBo = (ArrayList<CanBo>) oos.readObject();
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Co loi" + e);
		}

		int soCanBo;
		double tongluong = 0, luong;
		CanBo canBo;
		Scanner scn = new Scanner(System.in);
		int menu;

		do {

			System.out.print("\n*************************************************\n");
			System.out.print("* số 1 : nhập thông tin cán bộ               *\n");
			System.out.print("* số 2 : xem thông tin                 *\n");
			System.out.print("* số 3 : tổng tiền lương phải trả               *\n");
			System.out.print("* số 4 : Sắp xếp cán bộ theo lương, nếu lương bằng thì sắp xếp theo tên*\n");
			System.out.print("* số 5 : Kết thúc chương trình*\n");
			System.out.print("*************************************************\n ");
			System.out.print("\n chọn chức năng bạn muốn : ");
			Scanner scn1 = new Scanner(System.in);
			menu = Integer.parseInt(scn1.nextLine());
			if (menu == 1) {
				System.out.print("Nhập số lượng cán bộ trong trường: ");
				soCanBo = scn1.nextInt();
				for (int i = 0; i < soCanBo; i++) {
					System.out.print("Nhập thông tin cán bộ  " + (i + 1) + " \n");

					System.out.print("Nhập 1 chọn giảng viên, 2 chọn nhân viên");
					int cb;
					cb = scn.nextInt();

					if (cb == 1) {

						canBo = new GiangVien();
						canBo.nhap();

						for (;;) {
							System.out.print("nhập mã cán bộ");
							String maCanBo = scn.next();
							try {
								CanBoException.chkMaCanBo(maCanBo, arrCanBo);
								canBo.setMaCanBo(maCanBo);
								break;
							} catch (CanBoException e) {
								System.out.print(e);
							}

						}

						arrCanBo.add(canBo);
						try {
							FileOutputStream fos = new FileOutputStream("CanBo.doc");
							ObjectOutputStream oos = new ObjectOutputStream(fos);

							oos.writeObject(arrCanBo);

							oos.close();
							fos.close();

						} catch (IOException e) {
							System.out.println(e);
						}

					} else if (cb == 2) {
						canBo = new NhanVien();
						canBo.nhap();
						for (;;) {
							System.out.print("nhập mã cán bộ");
							String maCanBo = scn.next();
							try {
								CanBoException.chkMaCanBo(maCanBo, arrCanBo);
								canBo.setMaCanBo(maCanBo);
								break;
							} catch (CanBoException e) {
								System.out.print(e);
							}

						}

						arrCanBo.add(canBo);
						try {

							FileOutputStream fos = new FileOutputStream("CanBo.doc");
							ObjectOutputStream oos = new ObjectOutputStream(fos);

							oos.writeObject(arrCanBo);

							oos.close();
							fos.close();

						} catch (IOException e) {
							System.out.println(e);
						}

					}

				}

			} else if (menu == 2) {
				System.out.println("Xuất danh sách giảng viên khoa x(chọn 1), hoặc nhân viên phòng ban y(chọn 2): ");
				int i = Integer.parseInt(scn1.nextLine());
				if (i == 1) {
					System.out.println("nhập khoa:");
					String tenKhoa = scn.next();
					for (int j = 0; j < arrCanBo.size(); j++) {

						CanBo cb = arrCanBo.get(j);
						if (cb instanceof GiangVien) {
							GiangVien gv = (GiangVien) cb;
							if (gv.getKhoa().equals(tenKhoa)) {

								gv.xuat();

							}
						}
					}
				} else {
					System.out.println("nhập phòng:");
					String tenPhong = scn.next();

					for (int j = 0; j < arrCanBo.size(); j++) {
						CanBo cb = arrCanBo.get(j);
						if (cb instanceof NhanVien) {
							NhanVien nv = (NhanVien) cb;
							if (nv.getPhongBan().equals(tenPhong)) {

								nv.xuat();
							}
						}
					}
				}
			} else if (menu == 3) {
				for (CanBo cb : arrCanBo) {
					luong = cb.tinhLuong();
					tongluong += luong;
				}
				System.out.println("Tổng lương phải trả cho cán bộ trong trường = " + tongluong);
			} else if (menu == 4) {
				System.out.println("sắp xếp cán bộ theo lương");
				Collections.sort(arrCanBo, new Comparator<CanBo>() {
					@Override
					public int compare(CanBo cb1, CanBo cb2) {
						if (cb1.getLuong() > cb2.getLuong()) {
							return 1;
						} else {
							if (cb1.getLuong() == cb2.getLuong()) {
								return cb1.getHoTen().compareTo(cb2.getHoTen());
							} else {
								return -1;
							}
						}
					}
				});
				System.out.println("Danh sách sắp xếp theo tên trong bảng chữ cái a - b - c: ");
				for (int i = 0; i < arrCanBo.size(); i++) {
					System.out.println("Tên: " + arrCanBo.get(i).getHoTen() + " Lương: " + arrCanBo.get(i).tinhLuong());
				}
			} else if (menu == 5) {

				System.out.println("kết thúc chương trình ");
				System.exit(0);
			}
		} while (menu != 0);
	}
	public void getConnect( String strServer, String strDatabase, String strUser, String strPwd) {
		java.sql.Connection conn	=	null;
		String strConnect=	"jdbc: mysql://"+ strServer+ "/"+ strDatabase;
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try
		{
		com.mysql.jdbc.Driver driver=new Driver();
		conn=driver.connect(strConnect, pro);
		}
		catch(SQLException ex)
		{
		ex.printStackTrace();
		}
		return;
		}
	Connection conn= getConnect("localhost", ”database", ”user",
			”password");
			if(conn!=null)
			{
			System.out.println("Kết nối MYSQL thành công");
			}
			else
			{
			System.out.println("Kết nối MYSQL thất bại");
			}
	

}	


