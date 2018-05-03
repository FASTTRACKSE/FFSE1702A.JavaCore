package ffse;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import model.KetNoiSQL;

public class ThoiKhoaBieu extends JPanel {

	// private static final long serialVersionUID = 1L;
	int Id;
	private JPanel pnMain, pntop, pnBot, pnBot1, pnBot2, pnRightBot1, pnRightBot2, pnRightBot3;
	private JLabel lbtieude, lbchonlop, monhoc, ngayhoc, thoigian, space;
	private JComboBox chonlop, boxlop;
	private JButton btadd, btupdate, btdelete, btreset;
	private JTable table;
	private JTextField txtmonhoc, txtngayhoc, txtthoigian;
	DefaultTableModel model;
	ImageIcon update, delete, add, check, reset;
	Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029", "12345");

	public ThoiKhoaBieu() {
		addPanels();
		addEvents();
	}

	// chọn dữ liệu từ bảng
	MouseAdapter event = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			String[] row = new String[5];
			for (int j = 0; j < 5; j++) {
				row[j] = (String) table.getValueAt(i, j);
			}
			String ID = row[0];
			Id = Integer.parseInt(ID);
			boxlop.setSelectedItem(row[1]);
			txtmonhoc.setText(row[2]);
			txtngayhoc.setText(row[3]);
			txtthoigian.setText(row[4]);

		}
	};

	// load data
	private void loadData() {
		String[] col = { "id", "Môn Học", "Mã dự án", "Tên dự án", "Số Tín Chỉ" };
		String sql = "SELECT * FROM `thoi_khoa_bieu`";
		ResultSet rs = null;
		java.sql.Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			model = new DefaultTableModel(col, 0);

			while (rs.next()) {
				Vector<String> v = new Vector();
				v.add(rs.getString("ID"));
				v.add(rs.getString("Lop"));
				v.add(rs.getString("Mon_hoc"));
				v.add(rs.getString("Ngay_hoc"));
				v.add(rs.getString("Thoi_gian"));
				model.addRow(v);
			}
			table.setModel(model);
			table.getColumnModel().getColumn(0).setMinWidth(20);
			table.getColumnModel().getColumn(0).setMaxWidth(20);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void addPanels() {
		pnMain = new JPanel();
		this.add(pnMain);

		/* Panel Main */
		pntop = new JPanel();
		pnBot = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnMain.add(pntop);
		pnMain.add(pnBot);

		/* Panel Main* - top */

		pntop.setLayout(new BoxLayout(pntop, BoxLayout.X_AXIS));

		lbtieude = new JLabel("Thời khóa biểu");
		lbtieude.setFont(new Font("Tahoma", Font.BOLD, 14));
		pntop.add(lbtieude);

		lbtieude.setPreferredSize(new Dimension(600, 20));

		lbchonlop = new JLabel("chọn lớp");
		lbchonlop.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbchonlop.setFont(new Font("Tahoma", Font.BOLD, 12));
		pntop.add(lbchonlop);

		pntop.add(Box.createVerticalStrut(10));

		chonlop = new JComboBox();
		chonlop.setModel(new DefaultComboBoxModel(new String[] { "ffse1701", "ffse1702" }));
		chonlop.setSize(100, 30);
		pntop.add(chonlop);
		chonlop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lop = chonlop.getSelectedItem().toString();
				String lop_sql = "SELECT * FROM thoi_khoa_bieu WHERE Lop = '" + lop + "'";
				ResultSet lop_rs = null;
				Statement lop_st;
				model.setRowCount(0);
				try {
					lop_st = conn.createStatement();
					lop_rs = lop_st.executeQuery(lop_sql);

					while (lop_rs.next()) {
						Vector v = new Vector();
						v.add(lop_rs.getString("ID"));
						v.add(lop_rs.getString("Lop"));
						v.add(lop_rs.getString("Mon_hoc"));
						v.add(lop_rs.getString("Ngay_hoc"));
						v.add(lop_rs.getString("Thoi_gian"));
						model.addRow(v);
					}
				} catch (Exception ex) {

				}
			}
		});
		/* Panel Main* - bot */
		pnBot1 = new JPanel();
		pnBot1.setBackground(SystemColor.scrollbar);
		pnBot1.setBorder(new EmptyBorder(1, 1, 1, 1));
		pnBot2 = new JPanel();
		pnBot2.setBackground(SystemColor.inactiveCaptionBorder);
		pnBot2.setBorder(new BevelBorder(BevelBorder.LOWERED));
		pnBot.setLayout(new BoxLayout(pnBot, BoxLayout.Y_AXIS));
		pnBot.add(pnBot1);
		pnBot.add(pnBot2);

		/* Panel Main* - Right - Top */
		pnBot1.setLayout(new BoxLayout(pnBot1, BoxLayout.Y_AXIS));

		table = new JTable();
		String[] col = { "id", "Lớp", "Môn học", "Ngày học", "Thời gian" };
		String sql = "SELECT * FROM `thoi_khoa_bieu`";
		ResultSet rs = null;
		java.sql.Statement st = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			model = new DefaultTableModel(col, 0);

			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("ID"));
				v.add(rs.getString("Lop"));
				v.add(rs.getString("Mon_hoc"));
				v.add(rs.getString("Ngay_hoc"));
				v.add(rs.getString("Thoi_gian"));
				model.addRow(v);
			}
			table.setModel(model);
			table.getColumnModel().getColumn(0).setMinWidth(20);
			table.getColumnModel().getColumn(0).setMaxWidth(20);
		} catch (Exception ex) {

		}

		table.setModel(model);
		JScrollPane sp = new JScrollPane(table);
		pnBot1.add(sp);

		/* Panel Main* - Right - Bot */

		pnBot2.setLayout(new BoxLayout(pnBot2, BoxLayout.Y_AXIS));
		pnRightBot1 = new JPanel();
		pnRightBot2 = new JPanel();
		pnRightBot3 = new JPanel();
		pnRightBot1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		pnRightBot2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		pnRightBot3.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		pnBot2.add(pnRightBot1);
		pnBot2.add(pnRightBot2);
		pnBot2.add(pnRightBot3);
		
		monhoc = new JLabel("Môn học:");
		monhoc.setPreferredSize(new Dimension(115, 20));
		monhoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(monhoc);

		txtmonhoc = new JTextField();
		pnRightBot2.add(txtmonhoc);
		txtmonhoc.setColumns(10);

		ngayhoc = new JLabel("Ngày học:");
		ngayhoc.setPreferredSize(new Dimension(230, 20));
		ngayhoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(ngayhoc);

		txtngayhoc = new JTextField();
		pnRightBot2.add(txtngayhoc);
		txtngayhoc.setColumns(20);

		thoigian = new JLabel("Thời gian học:");
		thoigian.setPreferredSize(new Dimension(100, 20));
		thoigian.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(thoigian);

		txtthoigian = new JTextField();
		pnRightBot2.add(txtthoigian);
		txtthoigian.setColumns(10);

		boxlop = new JComboBox();
		boxlop.setModel(new DefaultComboBoxModel(new String[] { "--lớp--", "ffse1701", "ffse1702" }));
		pnRightBot2.add(boxlop);

		space = new JLabel("");
		space.setPreferredSize(new Dimension(400, 20));
		pnRightBot3.add(space);

		check = new ImageIcon(new ImageIcon("check.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		delete = new ImageIcon(new ImageIcon("delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		add = new ImageIcon(new ImageIcon("add.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btadd = new JButton("Thêm", add);
		btadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "INSERT INTO thoi_khoa_bieu (Mon_hoc, Ngay_hoc, Thoi_gian, Lop) VALUE(?, ?, ?, ?)";
				PreparedStatement pst = null;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sql);

					pst.setString(1, txtmonhoc.getText());
					pst.setString(2, txtngayhoc.getText());
					pst.setString(3, txtthoigian.getText());
					pst.setString(4, (String) boxlop.getSelectedItem());

					if (pst.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Thêm thành công", "Thêm Môn Học",
								JOptionPane.PLAIN_MESSAGE, check);
						model.setRowCount(0);
						loadData();
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi khi thêm", "Thêm Môn Học", JOptionPane.PLAIN_MESSAGE,
								delete);
					}
				} catch (SQLException e) {
					System.out.println("insert error" + e.toString());
				}
			}
		});
		pnRightBot3.add(btadd);

		update = new ImageIcon(new ImageIcon("update.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btupdate = new JButton("sửa", update);
		btupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sqlupdate = "UPDATE thoi_khoa_bieu SET `Lop`=?, `Mon_hoc`=?, `Ngay_hoc`=?, `Thoi_gian`=?  WHERE ID="+ Id;
				PreparedStatement pst = null;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sqlupdate);
					pst.setString(1, (String) boxlop.getSelectedItem());
					pst.setString(2, txtmonhoc.getText());
					pst.setString(3, txtngayhoc.getText());
					pst.setString(4, txtthoigian.getText());
					if (pst.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "sửa thành công", "sửa học sinh", JOptionPane.PLAIN_MESSAGE,
								check);
						model.setRowCount(0);
						loadData();
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi khi sửa ", "sửa học sinh", JOptionPane.PLAIN_MESSAGE,
								delete);
					}
				} catch (SQLException e) {
					System.out.println("insert error \n" + e.toString());
				}
			}
		});
		pnRightBot3.add(btupdate);

		delete = new ImageIcon(new ImageIcon("delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btdelete = new JButton("Xóa", delete);
		btdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sqldelete = "DELETE FROM `thoi_khoa_bieu` WHERE ID=" + Id;
				PreparedStatement pst = null;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sqldelete);
					int n = JOptionPane.showConfirmDialog(btdelete, "Bạn thật sự muốn xóa?", "Xóa",
							JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION)
					if (pst.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công", "xóa", JOptionPane.PLAIN_MESSAGE,
								check);
						loadData();
						
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi khi xóa ", "xóa", JOptionPane.PLAIN_MESSAGE,
								delete);
					}
				} catch (SQLException e) {
					System.out.println("delete error \n" + e.toString());
				}
			}
			
		});
		pnRightBot3.add(btdelete);

		reset = new ImageIcon(new ImageIcon("reset.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btreset = new JButton("reset", reset);
		btreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmonhoc.setText(null);
				txtngayhoc.setText(null);
				txtthoigian.setText(null);
				boxlop.setModel(new DefaultComboBoxModel(new String[] { "--lớp--", "ffse1701", "ffse1702" }));
				loadData();
			}
		});
		pnRightBot3.add(btreset);

	}

	public void addEvents() {
		table.addMouseListener(event);
	}
}
