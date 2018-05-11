package ffse;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

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
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import model.KetNoiSQL;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

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

public class DS_MonHoc extends JPanel {

	// private static final long serialVersionUID = 1L;
	int Id;
	private JTextField txtmaduan, txttenduan, txtsotinchi;
	private JPanel pnLeft, pnRight, pnRightTop, pnRightBot, pnRightBot1, pnRightBot2, pnRightBot3;
	private JLabel lbtieude, maduan, tenduan, sotinchi, space;
	private JButton btncongnghe, btntienganh, btadd, btupdate, btdelete, btreset;
	private JTable table;
	private JComboBox boxmon;
	DefaultTableModel model;
	ImageIcon update, delete, add, check, reset;
	Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029", "12345");

	public DS_MonHoc() {
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
			txtmaduan.setText(row[2]);
			txttenduan.setText(row[3]);
			txtsotinchi.setText(row[4]);
			boxmon.setSelectedItem(row[1]);

		}
	};

	// load data
	private void loadData() {
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
			// Ẩn cột
			table.setModel(model);
			table.getColumnModel().getColumn(0).setMinWidth(20);
			table.getColumnModel().getColumn(0).setMaxWidth(20);
			table.getColumnModel().getColumn(1).setMinWidth(120);
			table.getColumnModel().getColumn(1).setMaxWidth(120);
			table.getColumnModel().getColumn(2).setMinWidth(120);
			table.getColumnModel().getColumn(2).setMaxWidth(120);
			table.getColumnModel().getColumn(4).setMinWidth(80);
			table.getColumnModel().getColumn(4).setMaxWidth(80);

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
		JPanel pnMain = new JPanel();
		this.add(pnMain);

		/* Panel Main */
		pnLeft = new JPanel();
		pnRight = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnMain.add(pnLeft);
		pnMain.add(pnRight);

		/* Panel Main* - Left */

		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.X_AXIS));

		btncongnghe = new JButton("Công Nghệ");
		pnLeft.add(btncongnghe);
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

		pnLeft.add(Box.createVerticalStrut(20));

		btntienganh = new JButton("Tiếng anh");
		pnLeft.add(btntienganh);
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

		/* Panel Main* - Right */
		pnRightTop = new JPanel();
		pnRightTop.setBackground(SystemColor.scrollbar);
		pnRightTop.setBorder(new EmptyBorder(1, 1, 1, 1));
		pnRightBot = new JPanel();
		pnRightBot.setBackground(SystemColor.inactiveCaptionBorder);
		pnRightBot.setBorder(new BevelBorder(BevelBorder.LOWERED));
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		pnRight.add(pnRightTop);
		pnRight.add(pnRightBot);

		/* Panel Main* - Right - Top */
		pnRightTop.setLayout(new BoxLayout(pnRightTop, BoxLayout.Y_AXIS));
		lbtieude = new JLabel("Danh Sách Môn Học");
		lbtieude.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightTop.add(lbtieude);

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
			table.getColumnModel().getColumn(0).setMinWidth(20);
			table.getColumnModel().getColumn(0).setMaxWidth(20);
			table.getColumnModel().getColumn(1).setMinWidth(120);
			table.getColumnModel().getColumn(1).setMaxWidth(120);
			table.getColumnModel().getColumn(2).setMinWidth(120);
			table.getColumnModel().getColumn(2).setMaxWidth(120);
			table.getColumnModel().getColumn(4).setMinWidth(80);
			table.getColumnModel().getColumn(4).setMaxWidth(80);
		} catch (Exception ex) {

		}
		table.setModel(model);
		JScrollPane sp = new JScrollPane(table);
		pnRightTop.add(sp);

		/* Panel Main* - Right - Bot */

		pnRightBot.setLayout(new BoxLayout(pnRightBot, BoxLayout.Y_AXIS));
		pnRightBot1 = new JPanel();
		pnRightBot2 = new JPanel();
		pnRightBot3 = new JPanel();
		pnRightBot1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		pnRightBot2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		pnRightBot3.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		pnRightBot.add(pnRightBot1);
		pnRightBot.add(pnRightBot2);
		pnRightBot.add(pnRightBot3);

		maduan = new JLabel("Mã Dự Án:");
		maduan.setPreferredSize(new Dimension(115, 20));
		maduan.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(maduan);

		txtmaduan = new JTextField();
		pnRightBot2.add(txtmaduan);
		txtmaduan.setColumns(10);

		tenduan = new JLabel("Tên Dự Án:");
		tenduan.setPreferredSize(new Dimension(230, 20));
		tenduan.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(tenduan);

		txttenduan = new JTextField();
		pnRightBot2.add(txttenduan);
		txttenduan.setColumns(20);

		sotinchi = new JLabel("Số Tín Chỉ:");
		sotinchi.setPreferredSize(new Dimension(95, 20));
		sotinchi.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(sotinchi);

		txtsotinchi = new JTextField();
		pnRightBot2.add(txtsotinchi);
		txtsotinchi.setColumns(10);

		boxmon = new JComboBox();
		boxmon.setModel(new DefaultComboBoxModel(new String[] { "--môn học--", "Công nghệ", "Tiếng anh" }));
		pnRightBot2.add(boxmon);

		space = new JLabel("");
		space.setPreferredSize(new Dimension(400, 20));
		pnRightBot3.add(space);

		add = new ImageIcon(new ImageIcon("add.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btadd = new JButton("Thêm", add);
		btadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "INSERT INTO mon_hoc (Ten_mon_hoc, Ma_du_an, Ten_du_an, So_tin_chi) VALUE(?, ?, ?, ?)";
				PreparedStatement pst = null;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sql);
					pst.setString(1, (String) boxmon.getSelectedItem());
					pst.setString(2, txtmaduan.getText());
					pst.setString(3, txttenduan.getText());
					pst.setString(4, txtsotinchi.getText());

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
		check = new ImageIcon(new ImageIcon("check.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		delete = new ImageIcon(new ImageIcon("delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		update = new ImageIcon(new ImageIcon("update.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btupdate = new JButton("Sửa", update);
		btupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sqlupdate = "UPDATE mon_hoc SET `Ten_mon_hoc`=?, `Ma_du_an`=?, `Ten_du_an`=?, `So_tin_chi`=?  WHERE ID="
						+ Id;
				PreparedStatement pst = null;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sqlupdate);
					pst.setString(1, (String) boxmon.getSelectedItem());
					pst.setString(2, txtmaduan.getText());
					pst.setString(3, txttenduan.getText());
					pst.setString(4, txtsotinchi.getText());
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
				String sqldelete = "DELETE FROM `mon_hoc` WHERE ID=" + Id;
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
							JOptionPane.showMessageDialog(null, "Lỗi khi xóa", "xóa", JOptionPane.PLAIN_MESSAGE,
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
				txtmaduan.setText(null);
				txttenduan.setText(null);
				txtsotinchi.setText(null);
				boxmon.setModel(new DefaultComboBoxModel(new String[] { "--môn học--", "Công nghệ", "Tiếng anh" }));
				loadData();
			}
		});
		pnRightBot3.add(btreset);

	}

	public void addEvents() {
		table.addMouseListener(event);
	}
}
