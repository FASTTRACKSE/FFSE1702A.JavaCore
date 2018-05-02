package ffse;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import model.KetNoiSQL;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TongKetDiem extends JPanel {

	//private static final long serialVersionUID = 1L;
	int Id;
	private JPanel pnMain, pnLeft, pnRight, pnLeftTop, pnLeftBot, pnRightTop, pnRightBot, pnRightBot1, pnRightBot2, pnRightBot3;
	private JLabel lbloc, lbtieude, id, hoten, lbdiemcn, lbdiemta, space, lop, lbdiemtong, lbxeploai;
	private JComboBox boxlop, boxlop1, boxxeploai;
	private JTextField txtid, txthoten, txtdiemcn, txtdiemta, txtdiemtong, txtmaSV;
	private JButton btnloclop, bttim,  lbupdate, btreset;
	private JTable table;
	ImageIcon update, check, reset, delete;
	Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029","12345");
	DefaultTableModel model;

	public TongKetDiem() {
		addPanels();
		addEvents();
	}
	// chọn dữ liệu từ bảng
		MouseAdapter event = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				String[] row = new String[8];
				for (int j = 0; j < 8; j++) {
					row[j] = (String) table.getValueAt(i, j);
				}
				String ID=row[0];
				Id = Integer.parseInt(ID);
				txtid.setText(row[1]);
				txthoten.setText(row[2]);
				boxlop1.setSelectedItem(row[3]);
				txtdiemcn.setText(row[4]);
				txtdiemta.setText(row[5]);
				txtdiemtong.setText(row[6]);
				boxxeploai.setSelectedItem(row[7]);
			}
		};
	private void loadData() {
		String[] col = {"id","Mã số sinh viên", "Họ & Tên", "Lớp", "công nghệ", "tiếng anh", " điểm tổng", "xếp loại"  };
		String sql = "SELECT * FROM `admin`";
		ResultSet rs = null;
		java.sql.Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			model = new DefaultTableModel(col, 0);

			while (rs.next()) {
				 Vector v = new Vector(); 
				 	v.add(rs.getString("ID")); 
				 	v.add(rs.getString("Masv")); 
		            v.add(rs.getString("Name")); 
		            v.add(rs.getString("Lop"));
		            v.add(rs.getString("Diem_CN"));
		            v.add(rs.getString("Diem_TA"));
		            v.add(rs.getString("Diem_Tong"));
		            v.add(rs.getString("Xep_Loai"));
		            model.addRow(v); 
			}
			// Ẩn cột
			table.setModel(model);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
	public void addPanels() {
		pnMain = new JPanel();
		this.add(pnMain);

		/* Panel Main */
		 pnLeft = new JPanel();
		 pnRight = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
		pnMain.add(pnLeft);
		pnMain.add(pnRight);

		/* Panel Main* - Left */

		pnLeftTop = new JPanel();
		pnLeftTop.setBackground(SystemColor.activeCaption);
		pnLeftTop.setBorder(new CompoundBorder());
		pnLeftBot = new JPanel();
		pnLeftBot.setBackground(SystemColor.inactiveCaption);
		pnLeftBot.setBorder(new CompoundBorder());

		pnLeftTop.setLayout(new BoxLayout(pnLeftTop, BoxLayout.Y_AXIS));
		pnLeftBot.setLayout(new BoxLayout(pnLeftBot, BoxLayout.Y_AXIS));

		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		pnLeft.add(pnLeftTop);
		pnLeft.add(pnLeftBot);

		/* Panel Main* - Left - top */

		lbloc = new JLabel("Lọc Dữ Liệu");
		lbloc.setBorder(new EmptyBorder(50, 10, 10, 60));
		lbloc.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnLeftTop.add(lbloc);

		
		pnLeftTop.add(Box.createVerticalStrut(10));
		 boxlop = new JComboBox();
		boxlop.setModel(
				new DefaultComboBoxModel(new String[] { "FFSE1701", "FFSE1702" }));
		pnLeftTop.add(boxlop);

		pnLeftTop.add(Box.createVerticalStrut(10));

		btnloclop = new JButton("lọc");
		btnloclop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lop = boxlop.getSelectedItem().toString();

				String sql = "SELECT * FROM `admin` WHERE Lop='" + lop + "'";
				ResultSet rs = null;
				java.sql.Statement st = null;
				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					model.setRowCount(0);

					while(rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("ID")); 
						 	v.add(rs.getString("Masv")); 
				            v.add(rs.getString("Name")); 
				            v.add(rs.getString("Lop"));
				            v.add(rs.getString("Diem_CN"));
				            v.add(rs.getString("Diem_TA"));
				            v.add(rs.getString("Diem_Tong"));
				            v.add(rs.getString("Xep_Loai"));
						model.addRow(v);
						
					} 

					table.setModel(model);
					

				} catch (Exception ex) {

				}
			}
		});
		pnLeftTop.add(btnloclop);

		pnLeftTop.add(Box.createVerticalStrut(20));

		Label masvLB = new Label();
		masvLB.setText("Mã sinh viên");
		pnLeftTop.add(masvLB);
		txtmaSV = new JTextField();
		pnLeftTop.add(txtmaSV);
		pnLeftTop.setVisible(true);
		pnLeftTop.add(Box.createVerticalStrut(5));
		 bttim = new JButton("Tìm");
		 bttim.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String masv = txtmaSV.getText();
					String sql = "SELECT * FROM `admin` WHERE Masv='"+ masv +"'";
					ResultSet rs = null;
					java.sql.Statement st = null;
					try {
						st = conn.createStatement();
						rs = st.executeQuery(sql);
						model.setRowCount(0);

						while (rs.next()) {
							Vector v = new Vector();
							v.add(rs.getString("ID")); 
							v.add(rs.getString("Masv")); 
				            v.add(rs.getString("Name")); 
				            v.add(rs.getString("Lop"));
				            v.add(rs.getString("Diem_CN"));
				            v.add(rs.getString("Diem_TA"));
				            v.add(rs.getString("Diem_Tong"));
				            v.add(rs.getString("Xep_Loai"));
							model.addRow(v);
						}
						table.setModel(model);
						

					} catch (Exception ex) {

					}
				}
			});
		 pnLeftTop.add(bttim);

		space = new JLabel("");
		space.setBorder(new EmptyBorder(10, 10, 280, 10));
		pnLeftTop.add(space);
		pnLeftTop.add(Box.createVerticalStrut(20));





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
		lbtieude = new JLabel("Tổng Kết Điểm");
		lbtieude.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightTop.add(lbtieude);

		table = new JTable();

		String[] col = {"id", "Mã số sinh viên", "Họ & Tên", "Lớp", "công nghệ", "tiếng anh", " điểm tổng", "xếp loại" };
		String sql = "SELECT * FROM `admin`";
		 ResultSet rs = null; 
		 java.sql.Statement st = null;
		 try { 
		        st = conn.createStatement(); 
		        rs = st.executeQuery(sql); 
		        model = new DefaultTableModel(col, 0);
		        
				while(rs.next()){ 
		            Vector v = new Vector(); 
		            v.add(rs.getString("ID")); 
		            v.add(rs.getString("Masv")); 
		            v.add(rs.getString("Name")); 
		            v.add(rs.getString("Lop"));
		            v.add(rs.getString("Diem_CN"));
		            v.add(rs.getString("Diem_TA"));
		            v.add(rs.getString("Diem_Tong"));
		            v.add(rs.getString("Xep_Loai"));
		            model.addRow(v); 
		        } 
		        table.setModel(model); 
		    } catch (Exception ex) { 
		             
		    } finally { 
		        try { 
		            rs.close(); 
		            st.close(); 
		        } catch (SQLException ex) { 
		                 
		        } 
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
	
		id = new JLabel("Mã sinh viên:");
		id.setPreferredSize(new Dimension(120, 20));
		id.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(id);

		txtid = new JTextField();
		pnRightBot1.add(txtid);
		txtid.setColumns(10);

		hoten = new JLabel("họ và tên:");
		hoten.setPreferredSize(new Dimension(120, 20));
		hoten.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(hoten);

		txthoten = new JTextField();
		pnRightBot1.add(txthoten);
		txthoten.setColumns(10);
		
		lop = new JLabel("Lớp:");
		lop.setPreferredSize(new Dimension(40, 20));
		lop.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(lop);

		boxlop1 = new JComboBox();
		boxlop1.setModel(new DefaultComboBoxModel(new String[] { "--lớp--", "FFSE1701", "FFSE1702" }));
		pnRightBot1.add(boxlop1);
		
		lbdiemcn = new JLabel("điểm công nghệ:");
		lbdiemcn.setPreferredSize(new Dimension(120, 20));
		lbdiemcn.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot2.add(lbdiemcn);

		txtdiemcn = new JTextField();
		pnRightBot2.add(txtdiemcn);
		txtdiemcn.setColumns(3);

		lbdiemta = new JLabel("điểm tiếng anh:");
		lbdiemta.setPreferredSize(new Dimension(120, 20));
		lbdiemta.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot2.add(lbdiemta);

		txtdiemta = new JTextField();
		pnRightBot2.add(txtdiemta);
		txtdiemta.setColumns(3);
		
		lbdiemtong = new JLabel("điểm tổng:");
		lbdiemtong.setPreferredSize(new Dimension(80, 20));
		lbdiemtong.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot2.add(lbdiemtong);

		txtdiemtong = new JTextField();
		pnRightBot2.add(txtdiemtong);
		txtdiemtong.setColumns(3);
		
		lbxeploai = new JLabel("xếp loại:");
		lbxeploai.setPreferredSize(new Dimension(60, 20));
		lbxeploai.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot2.add(lbxeploai);

		boxxeploai = new JComboBox();
		boxxeploai.setModel(new DefaultComboBoxModel(new String[] { "--xếp loại--", "giỏi", "khá", "trung bình","yếu","kém" }));
		pnRightBot2.add(boxxeploai);
		
		space = new JLabel("");
		space.setPreferredSize(new Dimension(500, 20));
		pnRightBot3.add(space);
		
		check = new ImageIcon(
				new ImageIcon("check.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		delete = new ImageIcon(
				new ImageIcon("delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		ImageIcon update = new ImageIcon(
				new ImageIcon("update.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		 lbupdate = new JButton("Sửa  ", update);
		 lbupdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String sqlupdate = "UPDATE admin SET `Masv`=?, `Name`=?, `Lop`=?, `Diem_CN`=?, `Diem_TA`=?, `Diem_Tong`=?, `Xep_Loai`=? WHERE ID="+Id;
					PreparedStatement pst = null;
					try {
						pst = (PreparedStatement) conn.prepareStatement(sqlupdate);
						pst.setString(1, txtid.getText());
						pst.setString(2, txthoten.getText());
						pst.setString(3, (String) boxlop1.getSelectedItem());
						pst.setString(4, txtdiemcn.getText());
						pst.setString(5, txtdiemta.getText());
						pst.setString(6, txtdiemtong.getText());
						pst.setString(7, (String) boxxeploai.getSelectedItem());
						
						
						if (pst.executeUpdate() > 0) {
							JOptionPane.showMessageDialog(null, "sửa thành công", "sửa điểm",
									JOptionPane.PLAIN_MESSAGE, check);
							model.setRowCount(0);
							loadData();
						} else {
							JOptionPane.showMessageDialog(null, "Lỗi khi sửa ", "sửa điểm",
									JOptionPane.PLAIN_MESSAGE, delete);
						}
					} catch (SQLException e) {
						System.out.println("insert error \n" + e.toString());
					}
				}
			});
		 pnRightBot3.add(lbupdate);

		

		 reset = new ImageIcon(
					new ImageIcon("reset.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
			btreset = new JButton("reset", reset);
			btreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtid.setText(null);
					txthoten.setText(null);
					boxlop1.setModel(new DefaultComboBoxModel(new String[] { "--lớp--", "FFSE1701", "FFSE1702" }));
					txtdiemcn.setText(null);
					txtdiemta.setText(null);
					txtdiemtong.setText(null);
					boxxeploai.setModel(new DefaultComboBoxModel(new String[] { "--xếp loại--", "giỏi", "khá", "trung bình","yếu","kém" }));
					boxlop.setModel(
							new DefaultComboBoxModel(new String[] { "FFSE1701", "FFSE1702" }));
					txtmaSV.setText(null);
					loadData();
				}
			});
			pnRightBot3.add(btreset);

	}

	public void addEvents() {
		table.addMouseListener(event);
	}
}
