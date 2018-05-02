package LP4;

import LP4.LopHoc;
import QLcanbo.canboinfoexception;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.gjt.mm.mysql.Driver;

public class connect {
	static int x = 0;
	private static String strServer = "localhost";
	private static String strDatabase = "anhvu";
	private static String strUser = "anhvu";
	private static String strPwd = "abc123";

	public static Connection getConnect() {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public static void eventUpdate() {
		Connection conn = (Connection) connect.getConnect();
		String mon = (String) LopHoc.jComBoMonHoc.getSelectedItem();
		String mssv = (String) LopHoc.jComBoDS.getSelectedItem();
		String diem = LopHoc.diem.getText();

		try {
			String sql = "UPDATE `bangdiem` SET `diem`='" + diem + "' WHERE MSSV = '" + mssv + "' AND MAMONHOC = '"
					+ mon + "'";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);

			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Lưu OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ResultSet view() {
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultTinh = null;
		String sql = "SELECT* FROM monhoc";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultTinh;
	}
	public static void ChangePass() {
		Connection conn = (Connection) connect.getConnect();
		String pass = user.pass2.getText();
		
		try {
			String sql = "	UPDATE `users` SET users.password='"+pass+"' WHERE users.username='"+Login.UserNameString+"'";
			
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);

			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thay mật khẩu đổi thành công !!!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}



	public static ResultSet checkUsers() {
		String username = Login.UserName.getText();
		String password = Login.PassWord.getText();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultUser = null;
				String sql = "SELECT * FROM `users` WHERE users.username = '" + username + "' AND users.password = '"
						+ password + "'";
				try {

					Statement statement = (Statement) conn.createStatement();
					return statement.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}

		return resultUser;
	}

	public static ResultSet checkMSSV() {
		String mssvv = listSV.textMSSV.getText();
		String mssv = listSV.MSSV1+ mssvv;
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultMSSV = null;
				String sql = "SELECT * FROM `sinhvien` WHERE sinhvien.MSSV = '" + mssv + "'";
				try {

					Statement statement = (Statement) conn.createStatement();
					return statement.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}

		return resultMSSV;
	}
	
	public static ResultSet checkMail() {
		String mail = listSV.textEmail.getText();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultMail = null;
				String sql = "SELECT * FROM `sinhvien` WHERE sinhvien.mail = '" + mail + "'";
				try {

					Statement statement = (Statement) conn.createStatement();
					return statement.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}

		return resultMail;
	}
	
	public static ResultSet checkSDT() {
		String sdt = listSV.textSdt.getText();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultSDT = null;
				String sql = "SELECT * FROM `sinhvien` WHERE sinhvien.sdt = '" + sdt + "'";
				try {

					Statement statement = (Statement) conn.createStatement();
					return statement.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}

		return resultSDT;
	}

	public static ResultSet viewLop() {
		String lop = (String) LopHoc.jComBoLopHoc.getSelectedItem();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultLop = null;
		String sql = "SELECT * FROM `sinhvien` WHERE Class = '" + lop + "'";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultLop;
	}

	public ResultSet viewSinhVien() {
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultSinhVien = null;
		String sql = "SELECT* FROM sinhvien";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSinhVien;
	}

	public static ResultSet viewHocKi() {
		String ki = (String) LopHoc.jComBoHocki.getSelectedItem();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultKi = null;
		String sql = "SELECT monhoc.code FROM `hocki` INNER JOIN `monhoc` WHERE monhoc.HK = hocki.maki AND maki = '"
				+ ki + "'";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultKi;
	}

	public static ResultSet viewDiem() {
		String hk = (String) LopHoc.jComBoHocki.getSelectedItem();
		String cls = (String) LopHoc.jComBoLopHoc.getSelectedItem();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultDiem = null;
		/*
		 * String sql =
		 * "Create Table bangdiem1 SELECT sinhvien.Name, bangdiem.MSSV, bangdiem.MAMONHOC , bangdiem.diem FROM `monhoc` JOIN `hocki` ON monhoc.HK = hocki.maki JOIN `bangdiem` ON bangdiem.MAMONHOC = monhoc.code JOIN `sinhvien` ON sinhvien.MSSV = bangdiem.MSSV WHERE sinhvien.Class = 'FFSE1702' AND hocki.maki = 'HK2';Create Table bangdiem2 SELECT bangdiem1.MSSV ,SUM(CASE WHEN bangdiem1.MAMONHOC = 'LP0' THEN bangdiem1.DIEM END) AS 'LP0' FROM bangdiem1 GROUP BY bangdiem1.MSSV"
		 * ;
		 */
		String sql = "SELECT sinhvien.id, sinhvien.Name, sinhvien.Class, " + hk + ".*  FROM `" + hk
				+ "` JOIN `sinhvien` ON sinhvien.MSSV = " + hk + ".MSSV WHERE sinhvien.Class = '" + cls + "'";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDiem;
	}

	public static ResultSet viewTimLopHoc() {
		String nam = (String) LopHoc.jComBoNamHoc.getSelectedItem();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultTimNam = null;
		String sql = "SELECT tenlop FROM `lophoc` WHERE LEFT(malop,2) LIKE RIGHT('" + nam + "',2)";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultTimNam;
	}

	public static ResultSet viewTimLopHocBC() {
		String nam = (String) BaoCao.jComBoNamHocBC.getSelectedItem();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultTimNam1 = null;
		String sql = "SELECT tenlop FROM `lophoc` WHERE LEFT(malop,2) LIKE RIGHT('" + nam + "',2)";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultTimNam1;
	}

	public static ResultSet viewThongKe() {
		String nam = (String) BaoCao.jComBoNamHocBC.getSelectedItem();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultThongke = null;
		String sql = "SELECT thongke.Class , thongke.sl , thongke1.Gioi,thongke1.Kha,thongke1.`Trung Binh`, thongke1.Yeu FROM `thongke` JOIN `thongke1` ON thongke.Class = thongke1.Class JOIN lophoc ON lophoc.tenlop = thongke.Class WHERE LEFT(lophoc.malop,2) LIKE RIGHT('"
				+ nam + "',2)";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultThongke;
	}

	public static ResultSet NamHoc() {

		Connection conn = (Connection) connect.getConnect();
		ResultSet Resultnamhoc = null;
		String sql = "SELECT `namhoc` FROM `namhoc` WHERE 1";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Resultnamhoc;
	}

	public static ResultSet viewAllMonHoc() {
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultTKD = null;
		String sql = "SELECT monhoc.code FROM monhoc WHERE 1";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultTKD;
	}

	public static ResultSet viewTKD() {
		String cls = (String) BaoCao.jComBoLopHocBC.getSelectedItem();
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultTKD = null;

		String sql = "SELECT sinhvien.ID, sinhvien.Name,sinhvien.class ,bangdiemView.* , xeploai.xeploai FROM `sinhvien` JOIN `bangdiemView` ON sinhvien.MSSV = bangdiemView.mssv JOIN `xeploai` ON xeploai.MSSV = bangdiemview.MSSV WHERE sinhvien.class = '"
				+ cls + "'";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultTKD;
	}

	public static ResultSet viewTimKiem() {
		Connection conn = (Connection) connect.getConnect();
		String tinh1 = (String) listSV.jComBoTinh1.getSelectedItem();
		String huyen1 = (String) listSV.jComBoHuyen1.getSelectedItem();
		String phuong1 = (String) listSV.jComBoXa1.getSelectedItem();
		String mssv1 = listSV.textMSSV1.getText();
		String name1 = listSV.textName1.getText();
		ResultSet resultTimKiem = null;
		String sql = "SELECT * FROM sinhvien WHERE tinh LIKE '%" + tinh1 + "%' AND quan LIKE '%" + huyen1
				+ "%' AND phuong LIKE '%" + phuong1 + "%' AND Name LIKE '%" + name1 + "%'  AND MSSV LIKE '%" + mssv1
				+ "%'";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultTimKiem;
	}

	public static ResultSet viewXa() {
		Connection conn = (Connection) connect.getConnect();
		String huyen = (String) listSV.jComBoHuyen.getSelectedItem();
		ResultSet resultXa = null;
		String sql = "SELECT devvn_xaphuongthitran.namexa FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen ON devvn_xaphuongthitran.maqh = devvn_quanhuyen.maqh AND devvn_quanhuyen.namehuyen = '"
				+ huyen + "'";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultXa;
	}

	public static ResultSet viewLop1() {
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultLop = null;
		String sql = "SELECT tenlop FROM `lophoc`";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultLop;
	}

	public static ResultSet viewXa1() {
		Connection conn = (Connection) connect.getConnect();
		String huyen1 = (String) listSV.jComBoHuyen1.getSelectedItem();
		ResultSet resultXa1 = null;
		String sql = "SELECT devvn_xaphuongthitran.namexa FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen ON devvn_xaphuongthitran.maqh = devvn_quanhuyen.maqh AND devvn_quanhuyen.namehuyen = '"
				+ huyen1 + "'";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultXa1;
	}

	public static ResultSet viewHuyen1() {
		Connection conn = (Connection) connect.getConnect();
		String tinh1 = (String) listSV.jComBoTinh1.getSelectedItem();
		ResultSet resultHuyen1 = null;
		String sql = "SELECT devvn_quanhuyen.namehuyen, devvn_tinhthanhpho.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho ON devvn_quanhuyen.matp = devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name = '"
				+ tinh1 + "'";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultHuyen1;
	}

	public static ResultSet viewHuyen() {
		Connection conn = (Connection) connect.getConnect();
		String tinh = (String) listSV.jComBoTinh.getSelectedItem();
		ResultSet resultHuyen = null;
		String sql = "SELECT devvn_quanhuyen.namehuyen, devvn_tinhthanhpho.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho ON devvn_quanhuyen.matp = devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name = '"
				+ tinh + "'";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultHuyen;
	}

	public static ResultSet viewTinh() {
		Connection conn = (Connection) connect.getConnect();
		ResultSet resultTinh = null;
		String sql = "SELECT* FROM sinhvien";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultTinh;
	}

	public static void addInfo() {
		Connection conn = (Connection) connect.getConnect();
		String cls = (String) listSV.jComBo.getSelectedItem();
		String sub = cls.substring(4, 6);
		int namhoc = 2000 + Integer.parseInt(sub);
		String tinh = (String) listSV.jComBoTinh.getSelectedItem();
		String quan = (String) listSV.jComBoHuyen.getSelectedItem();
		String phuong = (String) listSV.jComBoXa.getSelectedItem();
		String mssvv = listSV.textMSSV.getText();
		String mssv = listSV.MSSV1+ mssvv;
		System.out.print(mssvv);
		String adress = listSV.textSoNha.getText();
		String name = listSV.textName.getText();
		String sdt = listSV.textSdt.getText();
		String mail = listSV.textEmail.getText();
		DefaultTableModel TableModel = (DefaultTableModel) listSV.jtable.getModel();
		TableModel.addRow(new Object[] { "", mssv, name, cls, tinh, quan, phuong, sdt, mail, adress });

		try {
			String sql = "INSERT INTO `anhvu`.`sinhvien` (`MSSV`, `Class`, `Name`, `Adress`, `phuong`, `quan`, `tinh`, `sdt`, `mail`,`nam`) VALUES ('"
					+ mssv + "', '" + cls + "', '" + name + "', '" + adress + "', '" + phuong + "','" + quan + "', '"
					+ tinh + "', '" + sdt + "', '" + mail + "','" + namhoc + "')";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);

			if (x > 0) {
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void addUser() {
		Connection conn = (Connection) connect.getConnect();
		String name = listSV.textName.getText();
		String mssvv = listSV.textMSSV.getText();
		String mssv = listSV.MSSV1+ mssvv;
		String pass = listSV.textPassword.getText();

		try {
			String sql = "INSERT INTO `anhvu`.`users` (`ID`, `name`, `username`, `password`, `level`) VALUES (NULL, '"
					+ name + "', '" + mssv + "', '" + pass + "', '1')";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);
			listSV.indexValue();
			if (x > 0) {
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void addInfoDiem() {
		Connection conn = (Connection) connect.getConnect();
		String mssvv = listSV.textMSSV.getText();
		String mssv = listSV.MSSV1+ mssvv;
		try {
			String sql = "INSERT INTO `anhvu`.`bangdiem` (`ID`, `MSSV`, `MAMONHOC`,`DIEM`) VALUES (NULL, '" + mssv
					+ "', 'ELS','0'), (NULL, '" + mssv + "', 'LP0','0'), (NULL, '" + mssv + "', 'LP1','0'), (NULL, '" + mssv + "', 'CSI','0'), (NULL, '"
					+ mssv + "', 'LP2','0'), (NULL, '" + mssv + "', 'LP3','0'), (NULL, '" + mssv
					+ "', 'EI1','0'), (NULL, '" + mssv + "', 'LP4','0'), (NULL, '" + mssv + "', 'EI2','0'), (NULL, '"
					+ mssv + "', 'LP4','0'), (NULL, '" + mssv + "', 'LP5','0'), (NULL, '" + mssv
					+ "', 'LP6','0'), (NULL, '" + mssv + "', 'E2T','0'), (NULL, '" + mssv + "', 'FPT','0'), (NULL, '"
					+ mssv + "', 'EI4','0'), (NULL, '" + mssv + "', 'OJT','0'), (NULL, '" + mssv + "', 'EI4','0')";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);

			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Lưu thành công !");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static ResultSet view1() {
		Connection conn = (Connection) connect.getConnect();

		ResultSet result = null;
		String sql = "SELECT name FROM `devvn_tinhthanhpho` WHERE 1";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void del1() {
		Connection conn = (Connection) connect.getConnect();
		try {
			String sql = "DELETE  FROM `bangdiem` WHERE bangdiem.MSSV = '" + listSV.mssvv + "'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Đã xóa !");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void del2() {
		Connection conn = (Connection) connect.getConnect();
		try {
			String sql = "DELETE FROM `users` WHERE users.username = '" + listSV.mssvv + "'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void del() {
		Connection conn = (Connection) connect.getConnect();

		try {
			String sql = "DELETE FROM `sinhvien` WHERE sinhvien.MSSV = '" + listSV.mssvv + "'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			listSV.textMSSV.setText("");
			listSV.textName.setText("");
			listSV.textSdt.setText("");
			listSV.textEmail.setText("");
			listSV.textSoNha.setText("");
			listSV.textPassword.setText("");
			listSV.textMSSV2.setText("");
			listSV.textMSSV1.setText("");
			if (x > 0) {	
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void edit() {
		Connection conn = (Connection) connect.getConnect();
		String mssvv = listSV.mssvv;
		String cls = (String) listSV.jComBo.getSelectedItem();
		String tinh = (String) listSV.jComBoTinh.getSelectedItem();
		String quan = (String) listSV.jComBoHuyen.getSelectedItem();
		String phuong = (String) listSV.jComBoXa.getSelectedItem();
		String mssv = listSV.textMSSV.getText();
		String adress = listSV.textSoNha.getText();
		String name = listSV.textName.getText();
		String sdt = listSV.textSdt.getText();
		String mail = listSV.textEmail.getText();
		listSV.textMSSV.setText("");
		listSV.textName.setText("");
		listSV.textSdt.setText("");
		listSV.textEmail.setText("");
		listSV.textSoNha.setText("");

		try {

			String sql = "UPDATE `sinhvien` SET `Class`='" + cls + "',`Name`='" + name
					+ "',`Adress`='" + adress + "',`phuong`='" + phuong + "',`quan`='" + quan + "',`tinh`='" + tinh
					+ "',`sdt`='" + sdt + "',`mail`='" + mail + "' WHERE sinhvien.mssv = '" + mssvv + "'";

			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Đã lưu !");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}