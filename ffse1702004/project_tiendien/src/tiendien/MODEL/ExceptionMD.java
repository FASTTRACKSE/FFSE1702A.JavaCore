package tiendien.MODEL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import tiendien.UI.customerUI;
import tiendien.UI.quanlybienlaiUI;

public class ExceptionMD extends Exception {
	static 	Connection conn = database.getConnect("localhost", "quanlytiendien", "quanlytiendien", "quanlytiendien");
	static PreparedStatement ptmt = null;
	static ResultSet res;
	static String makh, chisomax,idMax,chisoCt,chisocu ;

	public ExceptionMD() {
		// TODO Auto-generated constructor stub
		super();
	}

	// kiểm tra mã khách Hàng
	public boolean chkMakh(String str) throws ExceptionMD {
		try {
			String sql = "SELECT maKH FROM ffse004_customer";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				if (str.equals(result.getString(1))) {
					JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại!");
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// kiểm tra có để rỗng hay không
	public boolean chkEmpty(String str) throws ExceptionMD {
		if (str.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		}
		return true;
	}

	// kiểm tra có để rỗng mã công tơ hay không
	public boolean chkEmptyMct(String str) throws ExceptionMD {
		if (str.equals("")) {
			JOptionPane.showMessageDialog(null, " Mã Công Tơ không được để trống!");
			return false;
		}
		return true;
	}

	// kiểm tra mã công tơ điện
	public boolean chkMaCongTo(String str) throws ExceptionMD {
		try {
			String sql = "SELECT macongto FROM ffse004_customer";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				if (str.equals(result.getString(1))) {
					JOptionPane.showMessageDialog(null, "Mã công tơ đã tồn tại!");
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	// kiểm tra số điện thoại

	public boolean chkPhone(String str) throws ExceptionMD {
		if (str.equals("")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!");
			return false;
		} else {
			try {
				Integer.parseInt(str);
				if (str.length() < 6) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số chính xác vào phần số điện thoại !");
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số vào phần số điện thoại !");
				return false;
			}
		}
		return true;
	}

	// kiểm tra chỉ số

	public boolean chkChiSo(String str) throws ExceptionMD {
		if (str.equals("")) {
			JOptionPane.showMessageDialog(null, "Chỉ Số không được để trống!");
			return false;
		} else {
			try {
				int chiSo = Integer.parseInt(str);
				try {
				if (chiSo < -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số dương vào phần Chỉ Số !");
					return false;
				}
				if (chiSo == 0) {
					chisocu = "0";
					String sql = "SELECT MAX(chisocongto) FROM ffse004_bienlai WHERE macongto = '"
							+ quanlybienlaiUI.text_mct.getText() + "'";
					Statement statement = (Statement) conn.createStatement();
					ResultSet result = statement.executeQuery(sql);
					if (result.next()) {
						chisomax = result.getString(1);
					}
					int chkChiso = Integer.parseInt(chisomax);
					if (chkChiso > chiSo) {
						JOptionPane.showMessageDialog(null, "Chỉ Số Mới Không Được Bé Hơn Chỉ Số Cũ ");
						return false;
					}
					if (chkChiso == chiSo) {
						return true;	
					}
					return true;
					
				}else {
					String sql = "SELECT MAX(chisocongto) FROM ffse004_bienlai WHERE macongto = '"
							+ quanlybienlaiUI.text_mct.getText() + "'";
					Statement statement = (Statement) conn.createStatement();
					ResultSet result = statement.executeQuery(sql);
					if (result.next()) {
						chisomax = result.getString(1);
						chisocu = result.getString(1);
					}
					int chkChiso = Integer.parseInt(chisomax);
					if (chkChiso > chiSo) {
						JOptionPane.showMessageDialog(null, "Chỉ Số Mới Không Được Bé Hơn Chỉ Số Cũ ");
						return false;
					}
					if (chkChiso == chiSo) {
						chisocu = String.valueOf(chkChiso); 
						return true;
					}
				}
			} catch (Exception e) {
				return true;
			}
			}catch(Exception e )
			{
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số vào phần chỉ số !");
				return false;
			}
			
		}
		return true;
	}

	// kiểm tra chu kỳ nhập
	public boolean chkCk(String str, String str2) throws ExceptionMD {
		try {
			String sql = "SELECT month,year FROM ffse004_bienlai where month = '"
					+ quanlybienlaiUI.cb_chukythang.getSelectedItem() + "' and year = '"
					+ quanlybienlaiUI.cb_chukynam.getSelectedItem() + "' and macongto = '"
					+ quanlybienlaiUI.text_mct.getText() + "' ";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (str.equals(result.getString(1)) && str2.equals(result.getString(2))) {
					JOptionPane.showMessageDialog(null, "chu kỳ đã được nhập !");
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// kiểm tra chu kỳ nhập của tháng trước đã được nhập vào hay chưa ?
	public boolean chkCkNext() throws ExceptionMD {
		try {
			String mth = (String) quanlybienlaiUI.cb_chukythang.getSelectedItem();
			String ye = (String) quanlybienlaiUI.cb_chukynam.getSelectedItem();
			int Month = Integer.parseInt(mth);
			int Year = Integer.parseInt(ye);
			String cs = quanlybienlaiUI.text_chiso.getText();
			int csCt = Integer.parseInt(cs);
			if (csCt == 0) {
				return true;
			} else {
				if (Month == 1) {
					Year -= 1;
					String str = "12";
					String str2 = Integer.toString(Year);
					String sql = "SELECT month,year FROM ffse004_bienlai where month = '12' and year = '" + Year
							+ "' and  macongto = '" + quanlybienlaiUI.text_mct.getText() + "' ";

					Statement statement = (Statement) conn.createStatement();
					ResultSet result = statement.executeQuery(sql);
					while (result.next()) {
						if (str.equals(result.getString(1)) && str2.equals(result.getString(2))) {
							return true;
						}
					}
					JOptionPane.showMessageDialog(null, "chu kỳ tháng trước chưa được nhập !");
					return false;

				} else {
					Month -= 1;
					String str = Integer.toString(Month);
					String str2 = Integer.toString(Year);
					String sql = "SELECT month,year FROM ffse004_bienlai where month = '" + Month + "' and year = '" + Year
							+ "' and  macongto = '" + quanlybienlaiUI.text_mct.getText() + "' ";

					Statement statement = (Statement) conn.createStatement();
					ResultSet result = statement.executeQuery(sql);
					while (result.next()) {

						if (str.equals(result.getString(1)) && str2.equals(result.getString(2))) {
							return true;
						}
					}
					JOptionPane.showMessageDialog(null, "chu kỳ tháng trước chưa được nhập !");
					return false;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "chu kỳ tháng trước chưa được nhập !");
		}
		return false;
	}

	// kiểm tra mã công tơ điện có tồn tại hay không ?
	public boolean chkMct(String str) throws ExceptionMD {
		try {
			String sql = "SELECT macongto FROM ffse004_customer";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (str.equals(result.getString(1))) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "mã công tơ không tồn tại  !");
		return false;
	}

	// Checkmail

	public boolean chkEmail(String str) throws ExceptionMD {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(str);
		if (!matcher.matches()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập email đúng định dạng!");
			return false;
		}
		return true;
	}

	// kiểm tra tìm kiếm
	public boolean chkSearch(String str) throws ExceptionMD {
		try {
			String sql = "SELECT * FROM ffse004_customer WHERE hoten LIKE '%" + str + "%'";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "tên khách hàng không tồn tại!");
		return false;
	}

	// Check login
	public boolean chkLogin(String str) throws ExceptionMD {

		if (str == null) {
			return true;
		} else {
			return false;
		}
	}
	
	//kiểm tra xem tháng cuối cùng nhập vào 
	public boolean chk_chuky(String m, String y) throws ExceptionMD {
		// TODO Auto-generated method stub
		try {
			String chkchuky = y+""+m;
			String sql = "SELECT MAX(chuky) FROM ffse004_bienlai WHERE macongto = '"+ quanlybienlaiUI.text_mct.getText() + "'";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (chkchuky.equals(result.getString(1))) {
					return true;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "khách hàng chưa được thêm biên lai !");
			return false;
		}
		JOptionPane.showMessageDialog(null, "vui lòng chỉ sửa chu kỳ mới nhất của khách hàng !");
		return false;
	}
	
	// kiểm tra chỉ số lớn thứ 2

		public boolean chkChiSoThu2(String str) throws ExceptionMD {
			if (str.equals("")) {
				JOptionPane.showMessageDialog(null, "Chỉ Số không được để trống!");
				return false;
			} else {
				try {
					int chiSo = Integer.parseInt(str);
					try {
					if (chiSo < -1) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập số dương vào phần Chỉ Số !");
						return false;
					}
					if (chiSo == 0) {
						chisocu = "0";
						String sql = "SELECT MAX(chisocongto) FROM ffse004_bienlai WHERE macongto = '"
								+ quanlybienlaiUI.text_mct.getText() + "'";
						Statement statement = (Statement) conn.createStatement();
						ResultSet result = statement.executeQuery(sql);
						if (result.next()) {
							chisomax = result.getString(1);
						}
						int chkChiso = Integer.parseInt(chisomax);
						if (chkChiso > chiSo) {
							JOptionPane.showMessageDialog(null, "Chỉ Số Mới Không Được Bé Hơn Chỉ Số Cũ ");
							return false;
						}
						if (chkChiso == chiSo) {
							return true;
						}
						return true;
					}else {
						String sql = "SELECT MAX(id) FROM ffse004_bienlai WHERE macongto = '"+quanlybienlaiUI.text_mct.getText()+"'";
						Statement statement = (Statement) conn.createStatement();
						ResultSet result = statement.executeQuery(sql);
						if (result.next()) {
							idMax = result.getString(1);
						}
						
						int chkId = Integer.parseInt(idMax);
						chkId -= 1;
						 sql = "SELECT chisocongto FROM ffse004_bienlai WHERE id = '"+chkId+"' ";
						 statement = (Statement) conn.createStatement();
						 result = statement.executeQuery(sql);
						if (result.next()) {
							chisoCt = result.getString(1);
							chisocu = result.getString(1);
						}
						int chkChiso = Integer.parseInt(chisoCt);
						if (chkChiso > chiSo) {
							JOptionPane.showMessageDialog(null, "Chỉ Số Mới Không Được Bé Hơn Chỉ Số Cũ ");
							return false;
						}
						if (chkChiso == chiSo) {
							chisocu = String.valueOf(chkChiso); 
							return true;
						}
					}
				} catch (Exception e) {
					return true;
				}
				}catch(Exception e )
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số vào phần chỉ số !");
					return false;
				}
				
			}
			return true;
		}


}
