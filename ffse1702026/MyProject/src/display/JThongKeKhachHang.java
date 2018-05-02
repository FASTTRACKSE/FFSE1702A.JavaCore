package display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import com.toedter.calendar.JMonthChooser;

import database.dbKhachHang;
import database.phuong;
import database.quan;
import object.KhachHang;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class JThongKeKhachHang extends JFrame {

	private JPanel pnmain;
	private JTable tablekhachhang;
	private JPanel brandpanel;
	private JPanel inputpanel;

	private JPanel panelquan;
	private JLabel lbQuan;
	private JComboBox cbQuan;
	private JPanel panelphuong;
	private JLabel lbPhuong;
	private JComboBox cbPhuong;
	private JPanel panel;

	private JButton btnQuan;

	private JButton btnphuong;
	private JPanel panelbutton;
	private JButton btnBack;
	String[] tieude = { "ID", "Họ Tên", "Mã Công Tơ", "Địa Chỉ", "Số Điện Thoại", "Email" };
	DefaultTableModel modelTable = new DefaultTableModel(tieude, 0);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JThongKeKhachHang frame = new JThongKeKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JThongKeKhachHang() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("b.jpg"));

		setTitle("ỨNG DỤNG QUẢN LÝ TIỀN ĐIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 650);

		pnmain = new JPanel();
		pnmain.setBackground(SystemColor.controlHighlight);

		setContentPane(pnmain);

		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		brandpanel = new JPanel();
		pnmain.add(brandpanel);
		brandpanel.setLayout(new BoxLayout(brandpanel, BoxLayout.X_AXIS));

		JLabel lblbrand = new JLabel("Thống kê danh sách khách hàng");
		lblbrand.setBackground(SystemColor.controlHighlight);
		brandpanel.add(lblbrand);
		lblbrand.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblbrand.setForeground(new Color(102, 51, 0));
		lblbrand.setFont(new Font("Times New Roman", Font.BOLD, 32));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		inputpanel = new JPanel();
		inputpanel.setMaximumSize(new Dimension(1800, 150));
		inputpanel.setBackground(SystemColor.controlHighlight);

		pnmain.add(inputpanel);
		inputpanel.setLayout(new GridLayout(0, 1, 0, 10));

		panelquan = new JPanel();
		panelquan.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelquan);

		panelquan.setLayout(new BoxLayout(panelquan, BoxLayout.X_AXIS));

		panelquan.add(Box.createRigidArea(new Dimension(220, 20)));

		lbQuan = new JLabel("Quận");
		lbQuan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbQuan.setBackground(new Color(51, 102, 0));
		panelquan.add(lbQuan);

		panelquan.add(Box.createRigidArea(new Dimension(65, 20)));

		cbQuan = new JComboBox();
		ArrayList<String> arrQuan = quan.getQuan();
		cbQuan.setModel(new DefaultComboBoxModel(arrQuan.toArray()));
		cbQuan.setBackground(Color.WHITE);
		cbQuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quanSelect = cbQuan.getSelectedItem().toString();
				try {

					ArrayList<String> arrphuong = phuong.getPhuong(quanSelect);
					cbPhuong.setModel(new DefaultComboBoxModel(arrphuong.toArray()) {
					});
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelquan.add(cbQuan);

		panelquan.add(Box.createRigidArea(new Dimension(30, 20)));

		btnQuan = new JButton("Tìm kiếm");
		btnQuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quansl=cbQuan.getSelectedItem().toString();
				String sql="select * from ffse1702026_user where quan='"+quansl+"'";
				try {
					ArrayList<KhachHang>Kh=dbKhachHang.getInfo(sql);
					int rowCount = tablekhachhang.getRowCount();
					for (int i = rowCount - 1; i >= 0; i--) {
						modelTable.removeRow(i);
					}

					for (KhachHang kh : Kh) {

						String[] khachhang = { kh.getMaKhackHang(), kh.getTenKhachHang(), kh.getMaCongTo(),
								kh.getDiaChi() + ", " + kh.getPhuong() + ", " + kh.getQuan(), kh.getPhone(),
								kh.getEmail() };
						modelTable.addRow(khachhang);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnQuan.setBackground(SystemColor.activeCaption);
		panelquan.add(btnQuan);

		panelquan.add(Box.createRigidArea(new Dimension(220, 20)));

		panelphuong = new JPanel();
		panelphuong.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelphuong);
		panelphuong.setLayout(new BoxLayout(panelphuong, BoxLayout.X_AXIS));

		panelphuong.add(Box.createRigidArea(new Dimension(220, 20)));

		lbPhuong = new JLabel("Phường");
		lbPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbPhuong.setBackground(new Color(51, 102, 0));
		panelphuong.add(lbPhuong);

		panelphuong.add(Box.createRigidArea(new Dimension(50, 20)));

		cbPhuong = new JComboBox();
		cbPhuong.setModel(new DefaultComboBoxModel(new String[] { "Bình Hiên", "Bình Thuận", "Hải Châu 1", "Hải Châu 2",
				"Hòa Cường Bắc", "Hòa Cường Nam" }));
		cbPhuong.setBackground(Color.WHITE);
		panelphuong.add(cbPhuong);

		panelphuong.add(Box.createRigidArea(new Dimension(30, 20)));

		btnphuong = new JButton("Tìm kiếm");
		btnphuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phuongsl=cbPhuong.getSelectedItem().toString();
				String sql="select * from ffse1702026_user where phuong='"+phuongsl+"'";
				try {
					ArrayList<KhachHang>Kh=dbKhachHang.getInfo(sql);
					int rowCount = tablekhachhang.getRowCount();
					for (int i = rowCount - 1; i >= 0; i--) {
						modelTable.removeRow(i);
					}

					for (KhachHang kh : Kh) {

						String[] khachhang = { kh.getMaKhackHang(), kh.getTenKhachHang(), kh.getMaCongTo(),
								kh.getDiaChi() + ", " + kh.getPhuong() + ", " + kh.getQuan(), kh.getPhone(),
								kh.getEmail() };
						modelTable.addRow(khachhang);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnphuong.setBackground(SystemColor.activeCaption);
		panelphuong.add(btnphuong);

		panelphuong.add(Box.createRigidArea(new Dimension(220, 20)));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 51, 0)), "Danh Sách Khách Hàng",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 51, 0)));
		pnmain.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		panel.add(Box.createRigidArea(new Dimension(30, 20)));

		tablekhachhang = new JTable();
		tablekhachhang.setBackground(SystemColor.activeCaption);
		tablekhachhang.setModel(modelTable);

		JScrollPane sctable = new JScrollPane();
		panel.add(sctable);
		sctable.setViewportView(tablekhachhang);

		panel.add(Box.createRigidArea(new Dimension(30, 20)));

		pnmain.add(Box.createRigidArea(new Dimension(30, 20)));

		panelbutton = new JPanel();
		panelbutton.setBackground(SystemColor.controlHighlight);
		pnmain.add(panelbutton);

		btnBack = new JButton("Quay lại");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JMain main=new JMain();
				main.setVisible(true);
			}
		});
		panelbutton.add(btnBack);

		pnmain.add(Box.createRigidArea(new Dimension(30, 20)));

	}
}
