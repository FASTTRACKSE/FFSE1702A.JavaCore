package ffse;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import model.KetNoiSQL;

public class TKB_admin extends JPanel {

	DefaultTableModel model;
	Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029", "12345");

	public TKB_admin() {
		addPanels();
		addEvents();
	}

	private void addPanels() {
		JPanel pnMain = new JPanel();
		this.add(pnMain);

		this.setLayout(new BorderLayout());
//		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JTable table = new JTable();
		String[] col = { "Môn học", "Ngày học", "Thời gian" };
		String sql = "SELECT * FROM `thoi_khoa_bieu` WHERE lop = '" + LoginHS.lop + "'";
		ResultSet rs = null;
		java.sql.Statement st = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			model = new DefaultTableModel(col, 0);

			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Mon_hoc"));
				v.add(rs.getString("Ngay_hoc"));
				v.add(rs.getString("Thoi_gian"));
				model.addRow(v);
			}
			table.setModel(model);
		} catch (Exception ex) {

		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException ex) {

			}
		}
		table.setModel(model);
		JScrollPane sp = new JScrollPane(table);
		this.add(sp);

	}

	private void addEvents() {
		// TODO Auto-generated method stub

	}
}