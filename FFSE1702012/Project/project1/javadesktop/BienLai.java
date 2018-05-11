package project1.javadesktop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

public class BienLai {
	private String mact;
	private JDateChooser date;
	private JYearChooser yearChooser;
	private int csct;
	private static double tiendien;

	public BienLai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BienLai(String mact, JDateChooser date, JYearChooser yearChooser, int csct, double tiendien) {
		super();
		this.mact = mact;
		this.date = date;
		this.yearChooser = yearChooser;
		this.csct = csct;
		this.tiendien = tiendien;
	}

	public String getMact() {
		return mact;
	}

	public void setMact(String mact) {
		this.mact = mact;
	}

	public JDateChooser getDate() {
		return date;
	}

	public void setDate(JDateChooser date) {
		this.date = date;
	}

	public JYearChooser getYearChooser() {
		return yearChooser;
	}

	public void setYearChooser(JYearChooser yearChooser) {
		this.yearChooser = yearChooser;
	}

	public int getCsct() {
		return csct;
	}

	public void setCsct(int csct) {
		this.csct = csct;
	}

	public double getTiendien() {
		return tiendien;
	}

	public void setTiendien(double tiendien) {
		this.tiendien = tiendien;
	}

	public static double getTien(int chisomoi, String mact, int month, int year) {
		int chisocu = 0;
		tiendien = 0;
		Connection conn = Connection_Database.Ketnoi();
		PreparedStatement ptmt = null;
		// cho biet hien tai khach hang dang duoc nhap da co thong tin nao trong bang co
		// so du lieu cua Bien Lai chua?
		String sql = "select * from BienLai where Macongto = '" + mact + "'";
		int i = 0;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * tinh tien dien i la so row cua moi khach hang trong table:
		 */
		if (i == 0) {
			chisocu = 0;
			// code tinh tien:
			int a = chisomoi - chisocu;// so luong dien tieu thu:
			tiendien = congthuc(tiendien, a);
		} else if (i > 0) {
			String sql1 = "";
			// doi voi tu thangs 1->12
			if (month > 1 && month <= 12) {
				sql1 = "select * from BienLai where Macongto = '" + mact + "'" + "and Thang = " + (month - 1);
				try {
					ptmt = (PreparedStatement) conn.prepareStatement(sql1);
					ResultSet rs = ptmt.executeQuery();

					while (rs.next()) {
						chisocu = rs.getInt("Chiso");
					}
					int a = chisomoi - chisocu;// so luong dien tieu thu:
					tiendien = congthuc(tiendien, a);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// doi voi month == 1:
			else if (month == 1) {
				int a = chisomoi - 0;// so luong dien tieu thu:
				tiendien = congthuc(tiendien, a);
			}


		}
		return tiendien;
	}
	public static double congthuc(double tiendien1, int a1)
	{
		tiendien1 = 0;
		// co 6 bac de tinh tien dien:
		if (a1 <= 50) {
			// my code
			tiendien1 = a1 * 1549;
		}
		if (a1 > 50) {
			// bac2(a);
			tiendien1 = 50 * 1549 + (a1 - 50) * 1600;
		}
		if (a1 > 100) {
			// bac3(a);
			tiendien1 = 50 * 1549 + 50 * 1600 + (a1 - 100) * 1858;
		}
		if (a1 > 200) {
			// bac4(a);
			tiendien1 = 50 * 1549 + 50 * 1600 + 50 * 1858 + (a1 - 150) * 2340;
		}
		if (a1 > 300) {
			// bac5(a);
			tiendien1 = 50 * 1549 + 50 * 1600 + 50 * 1858 + 50 * 2340 + (a1 - 200) * 2615;
		}
		if (a1 > 400) {
			// bac6(a);
			tiendien1 = 50 * 1549 + 50 * 1600 + 50 * 1858 + 50 * 2340 + 50 * 2615 + (a1 - 250) * 2701;
		}
		return tiendien1;
	}
}
