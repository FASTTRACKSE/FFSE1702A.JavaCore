package ffse;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import model.KetNoiSQL;

public class DS_MH_admin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbtieude;
	private JPanel pnTop, pnBot;
	private JScrollPane pnTable;
	private JButton btncongnghe, btntienganh;
	private JTable table;
	DefaultTableModel model;
	Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029", "12345");

	public DS_MH_admin() {
		addPanels();
		addEvents();

	}

	private void addPanels() {
		/* Panel Main */
		pnTop = new JPanel();
		pnBot = new JPanel();
		pnTable = new JScrollPane();

		this.setLayout(new BorderLayout());
		this.add(pnTop, BorderLayout.NORTH);
		this.add(pnTable, BorderLayout.CENTER);

		pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.X_AXIS));
		btncongnghe = new JButton("Công Nghệ");
		pnTop.add(btncongnghe);
		btncongnghe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "SELECT * FROM `mon_hoc` WHERE `Ten_mon_hoc` = 'Công nghệ'";
				ResultSet rs = null;
				Statement st;

				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					model.setRowCount(0);
					while (rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("ID"));
						v.add(rs.getString("Ten_mon_hoc"));
						v.add(rs.getString("Ma_du_an"));
						v.add(rs.getString("Ten_du_an"));
						v.add(rs.getString("So_tin_chi"));
						model.addRow(v);
					}

				} catch (Exception ex) {

				}
			}
		});

		pnTop.add(Box.createVerticalStrut(20));

		btntienganh = new JButton("Tiếng anh");
		pnTop.add(btntienganh);
		btntienganh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "SELECT * FROM `mon_hoc` WHERE Ten_mon_hoc = 'Tiếng anh'";
				ResultSet rs = null;
				java.sql.Statement st = null;
				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					model.setRowCount(0);

					while (rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("ID"));
						v.add(rs.getString("Ten_mon_hoc"));
						v.add(rs.getString("Ma_du_an"));
						v.add(rs.getString("Ten_du_an"));
						v.add(rs.getString("So_tin_chi"));
						model.addRow(v);
					}

				} catch (Exception ex) {

				}
			}
		});

		table = new JTable();
		String[] col = { "id", "Môn Học", "Mã dự án", "Tên dự án", "Số Tín Chỉ" };

		String sql = "SELECT * FROM `mon_hoc`";
		ResultSet rs = null;
		java.sql.Statement st = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			model = new DefaultTableModel(col, 0);

			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("ID"));
				v.add(rs.getString("Ten_mon_hoc"));
				v.add(rs.getString("Ma_du_an"));
				v.add(rs.getString("Ten_du_an"));
				v.add(rs.getString("So_tin_chi"));
				model.addRow(v);
			}
			table.setModel(model);

		} catch (Exception ex) {

		}
		table.setModel(model);
		pnTable.setViewportView(table);

	}

	private void addEvents() {

	}
}