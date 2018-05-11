package Process;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import Process.MyException;


import Data.Connect;
import Data.phuong;


public class SachUI extends JPanel {
	JComboBox comboBox,comboBoxSach ;
	Connect cn = new Connect();

	Connection conn = (Connection) Connect.getConnect();
	JTextField txtTKS ,txtTS,txtMS,txtTG,txtNXB,txtSL,txtNamXB;
	JButton jbThem, jbSua, jbXoa, jbThoat, jbTKS;
	JScrollPane spListSach = new JScrollPane();
	JTable tbListSach = new JTable();
	String tbSach[] = { "Mã Sách","Tên sách", "Tên tác gải","Nhà xuất bản", "Năm xuất bản", "Tình trạng","Thể Loại"};
	DefaultTableModel mdTableSach = new DefaultTableModel(tbSach, 0);
	
	
	ActionListener evUpdate = new ActionListener() {
	    @Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
	    	
			try {
				update();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	};
	ActionListener evInsert = new ActionListener() {
	    @Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
        
			try {
				insert();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
			
	};
	
	ActionListener evDelete = new ActionListener() {
	    @Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
	    	
			delete();
		}
			
	};
	ActionListener evTimKiem = new ActionListener() {
	    @Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
	    	
			TimKiem();
		}
			
	};
	public SachUI() {
		controls();
		Display();
		addEvents();
		combobox();
	}
	MouseAdapter eventselect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbListSach.getSelectedRow();
			String[] row = new String[7];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbListSach.getValueAt(i, j);
			}
			
			txtMS.setText(row[0]);
			txtTS.setText(row[1]);
			txtTG.setText(row[2]);
			txtNXB.setText(row[3]);
			txtNamXB.setText(row[4]);
			txtSL.setText(row[5]);
			comboBox.setSelectedItem(row[6]);
		

		}
	}; 
	


	public void controls() {
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTimKiemS = new JPanel();


		txtTKS = new JTextField();
		txtTKS.setColumns(20);
		Font fTk = new Font("arial", Font.PLAIN, 15);
		txtTKS.setFont(fTk);
		jbTKS = new JButton("Tìm kiếm");
		jbTKS.setPreferredSize(new Dimension(100, 20));
		
		pnTimKiemS.add(txtTKS);
		pnTimKiemS.add(jbTKS);

		JPanel pnSach = new JPanel();

		JLabel lbMS = new JLabel("Mã sách");
		lbMS.setPreferredSize(new Dimension(80, 20));
		txtMS = new JTextField();
		Font fMS = new Font("arial", Font.PLAIN, 12);
		lbMS.setFont(fMS);
		txtMS.setColumns(15);

		JLabel lbNXB = new JLabel("Nhà sản xuất");
		lbNXB.setPreferredSize(new Dimension(100, 20));
		txtNXB = new JTextField();
		Font fNXB = new Font("arial", Font.PLAIN, 12);
		lbNXB.setFont(fNXB);
		txtNXB.setColumns(15);

		pnSach.add(lbMS);
		pnSach.add(txtMS);
		pnSach.add(lbNXB);
		pnSach.add(txtNXB);

		JPanel pnSach1 = new JPanel();

		JLabel lbTS = new JLabel("Tên sách");
		lbTS.setPreferredSize(new Dimension(80, 20));
	    txtTS = new JTextField();
		Font fTS = new Font("arial", Font.PLAIN, 12);
		lbTS.setFont(fTS);
		txtTS.setColumns(15);

		JLabel lbNamXB = new JLabel("Năm xuất bản");
		lbNamXB.setPreferredSize(new Dimension(100, 20));
		txtNamXB = new JTextField();
		Font fNamXB = new Font("arial", Font.PLAIN, 12);
		lbNamXB.setFont(fNamXB);
		txtNamXB.setColumns(15);

		pnSach1.add(lbTS);
		pnSach1.add(txtTS);
		pnSach1.add(lbNamXB);
		pnSach1.add(txtNamXB);


		JPanel pnSach2 = new JPanel();

		JLabel lbTG = new JLabel("Tác giả");
		lbTG.setPreferredSize(new Dimension(80, 20));
		txtTG = new JTextField();
		Font fTG = new Font("arial", Font.PLAIN, 12);
		lbTG.setFont(fTG);
		txtTG.setColumns(15);

		JLabel lbSL = new JLabel("Số lượng");
		lbSL.setPreferredSize(new Dimension(100, 20));
		txtSL = new JTextField();
		Font fSL = new Font("arial", Font.PLAIN, 12);
		lbSL.setFont(fSL);
		txtSL.setColumns(15);

		pnSach2.add(lbTG);
		pnSach2.add(txtTG);
        pnSach2.add(lbSL);
		pnSach2.add(txtSL);

		JPanel pnSuKien = new JPanel();

		JPanel pnThem = new JPanel();
		jbThem = new JButton("Thêm");
		jbThem.setPreferredSize(new Dimension(100, 20));
		pnThem.add(jbThem);

		JPanel pnSua = new JPanel();
		jbSua = new JButton("Sửa");
		jbSua.setPreferredSize(new Dimension(100, 20));
		pnSua.add(jbSua);

		JPanel pnXoa = new JPanel();
		jbXoa = new JButton("Xóa");
		jbXoa.setPreferredSize(new Dimension(100, 20));
		pnXoa.add(jbXoa);

		JPanel pnThoat = new JPanel();
		jbThoat = new JButton("Quay lại");
		jbThoat.setPreferredSize(new Dimension(100, 20));
		jbThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
			MainUI.login.addShow();
			MainUI.home.dispose();
			
			}
		});
		pnThoat.add(jbThoat);

		pnSuKien.add(pnThem);
		pnSuKien.add(pnSua);
		pnSuKien.add(pnXoa);
		pnSuKien.add(pnThoat);

		JPanel pnTableKH = new JPanel();

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sach");
		spListSach.setBorder(borderTittle);
		tbListSach.setModel(mdTableSach);
		spListSach.setViewportView(tbListSach);
		pnTableKH.add(spListSach);
		
		JPanel pnTheLoai = new JPanel();
		JLabel lbTL = new JLabel("Thể loại");
		lbTL.setPreferredSize(new Dimension(50, 20));
		lbTL.setFont(new Font("Arial", Font.PLAIN, 12));

		comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(170, 20));

		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setToolTipText("");

		pnTheLoai.add(lbTL);
		pnTheLoai.add(comboBox);

		pnMain.add(pnTimKiemS);
		pnMain.add(pnSach);
		pnMain.add(pnSach1);
		pnMain.add(pnSach2);
		pnMain.add(pnTheLoai);
		pnMain.add(pnSuKien);
		pnMain.add(pnTableKH);
		
		this.add(pnMain);
	}
	public void TimKiem() {
		if(conn != null) {
		 //    System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM QuanLy_Sach WHERE ten_s LIKE '%"+txtTKS.getText()+"%'and the_loai LIKE '%"+comboBox.getSelectedItem().toString()+"%'";
			
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				
				ResultSet rs = ptmt.executeQuery();
				mdTableSach.setRowCount(0);
				//mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {
					
					String rows[] = new String[7];
					
					rows[0] = rs.getString(2);
					
					rows[1] = rs.getString(3);
					rows[2] = rs.getString(4);
					rows[3] = rs.getString(5);
					rows[4] = rs.getString(6);
					rows[5] = rs.getString(7);
					rows[6] = rs.getString(8);

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		
		}
	}
	public void insert() throws MyException{
        try {
	
			if(MyException.ChekMSach(txtMS.getText())&&MyException.ChekEmpty(txtMS.getText())&&MyException.ChekEmpty(txtTS.getText())&&MyException.ChekEmpty(txtTG.getText())
					&&MyException.ChekEmpty(txtNXB.getText())&&MyException.ChekEmpty(txtNamXB.getText())&&MyException.ChekSo(txtSL.getText())
					) {

		if(conn != null) {
			String sql = "INSERT INTO `QuanLy_Sach`( `ma_s`, `ten_s`, `tac_gia`, `nha_xb`,`nam_xb`,  `so_luong_s`,`the_loai`,`tong_sach`) VALUES (?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ptmt.setString(1, txtMS.getText());
				ptmt.setString(2, txtTS.getText());
				

				ptmt.setString(3, txtTG.getText());
				ptmt.setString(4, txtNXB.getText());
				ptmt.setString(5, txtNamXB.getText());
				ptmt.setString(6, txtSL.getText());
				ptmt.setString(7, comboBox.getSelectedItem().toString());
				ptmt.setString(8, txtSL.getText());
				int k = ptmt.executeUpdate();
				if (k != 0) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					String[]row = {txtMS.getText(),txtTS.getText(),txtTG.getText(),txtNXB.getText(),txtNamXB.getText(),txtSL.getText(),comboBox.getSelectedItem().toString()};
					mdTableSach.addRow(row);
					
					txtMS.setText("");
					txtTS.setText("");
					txtTG.setText("");
					txtNXB.setText("");
					txtNamXB.setText("");
					txtSL.setText("");
					comboBox.setSelectedItem("");
				} else
					JOptionPane.showMessageDialog(null, "Thêm không thành công");
			}catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		}else {
			System.out.println("Kết nối MYSQL thất bại");
		}
			}}catch(MyException e ) {
			System.out.println(e);
		}
	}
	public void update() throws MyException{
        try {
	
			if(MyException.ChekEmpty(txtMS.getText())&&MyException.ChekEmpty(txtTS.getText())&&MyException.ChekEmpty(txtTG.getText())
					&&MyException.ChekEmpty(txtNXB.getText())&&MyException.ChekEmpty(txtNamXB.getText())&&MyException.ChekSo(txtSL.getText())
					) {
		if(conn != null) {
			String sql = "UPDATE `QuanLy_Sach` SET `ma_s`=?,`ten_s`=?,`tac_gia`=?,`nha_xb`=?,`nam_xb`=?,`so_luong_s`=?,`the_loai`=? WHERE ma_s=?";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ptmt.setString(1, txtMS.getText());
				ptmt.setString(2, txtTS.getText());
//				ptmt.setString(3, jcQuan.getSelectedItem().toString());
//				ptmt.setString(4, jcPhuong.getSelectedItem().toString());
				ptmt.setString(3, txtTG.getText());
				ptmt.setString(4, txtNXB.getText());
				ptmt.setString(5, txtNamXB.getText());
				ptmt.setString(6, txtSL.getText());
				ptmt.setString(7, comboBox.getSelectedItem().toString());

				
				ptmt.setString(8, txtMS.getText());
				
				int t = tbListSach.getSelectedRow();
				String[]row = {txtMS.getText(),txtTS.getText(),txtTG.getText(),txtNXB.getText(),txtNamXB.getText(),txtSL.getText(),comboBox.getSelectedItem().toString()};
				for(int j=0;j<7;j++){
					tbListSach.setValueAt(row[j],t,j);
					}
				int k = ptmt.executeUpdate();
				if (k != 0) {
					JOptionPane.showMessageDialog(null, "Sửa thành công");
					//mdTableSach.setRowCount(0);

					txtMS.setText("");
					txtTS.setText("");
					txtTG.setText("");
					txtNXB.setText("");
					txtNamXB.setText("");
					//jcLop.setSelectedItem("");
					
					txtSL.setText("");
					comboBox.setSelectedItem("");
				} else
					JOptionPane.showMessageDialog(null, "Sửa không thành công");
			}catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		}else {
			System.out.println("Kết nối MYSQL thất bại");
		}
			}}catch(MyException e ) {
			System.out.println(e);
		}
	}
	public void delete() {
		if(conn != null) {
			String sql = "DELETE FROM `QuanLy_Sach` WHERE ma_s=?";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

				
				
				ptmt.setString(1, txtMS.getText());
				
				int kt = ptmt.executeUpdate();
				if (kt != 0) {
					int j = tbListSach.getSelectedRow();
					JOptionPane.showMessageDialog(null, "Xóa thành công");
//					mdTableSach.setRowCount(0);
					mdTableSach.removeRow(j);
					txtMS.setText("");
					txtTS.setText("");
					txtTG.setText("");
					//jcLop.setSelectedItem("");
					txtNXB.setText("");
					txtNamXB.setText("");
					txtSL.setText("");
					comboBox.setSelectedItem("");
				} else
					JOptionPane.showMessageDialog(null, "Xóa không thành công");
			}catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		}else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}
	public void combobox() {
		if(conn != null) {
			String sql = "select * from The_Loại";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				
				while(rs.next()) {
					String Theloai=rs.getString("the_loai");
					comboBox.addItem(Theloai);
				}
			}catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		}else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}
	
	PreparedStatement ptmt = null;
	public void Display() {
		if (conn != null) {

			String sql = "select * from QuanLy_Sach";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[8];
					
					rows[0] = rs.getString(2);
					
					rows[1] = rs.getString(3);
					rows[2] = rs.getString(4);
					rows[3] = rs.getString(5);
					rows[4] = rs.getString(6);
					rows[5] = rs.getString(7);
					rows[6] = rs.getString(8);
					

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}
	public void addEvents() {
		tbListSach.addMouseListener(eventselect);
		jbSua.addActionListener(evUpdate);
		jbThem.addActionListener(evInsert);
		jbXoa.addActionListener(evDelete);
		jbTKS.addActionListener(evTimKiem);

	}
	public void addOut() {
		HomeUI home = new HomeUI();
		home.addOut();
	}

}
