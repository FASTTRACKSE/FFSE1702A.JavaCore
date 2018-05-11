package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import com.toedter.calendar.JMonthChooser;

import models.KhachHang;
import models.District;
import models.ItemRenderer;
import models.Ward;
import controllers.KhachHangController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BaoCaoKH extends JFrame {

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
					BaoCaoKH frame = new BaoCaoKH();
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
	public BaoCaoKH() throws SQLException {
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
		lblbrand.setForeground(Color.BLACK);
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
		
		District.getListDistric(cbQuan);
		cbQuan.setRenderer(new ItemRenderer());
		cbQuan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				District d = (District)((JComboBox) e.getSource()).getSelectedItem();
				int maQuan = d.getMaQuan();
				cbPhuong.removeAllItems();
				Ward.getListWard(cbPhuong, maQuan);
				cbPhuong.setRenderer(new ItemRenderer());
			}
		});
		
		panelquan.add(cbQuan);

		panelquan.add(Box.createRigidArea(new Dimension(30, 20)));

		btnQuan = new JButton("Tìm kiếm");
		btnQuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHangController.timKiemKhachHang(getInformations(), tablekhachhang);
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
		cbPhuong.addItem(new Ward(0, ""));
		cbPhuong.setRenderer(new ItemRenderer());
		cbPhuong.setBackground(Color.WHITE);
		panelphuong.add(cbPhuong);

		panelphuong.add(Box.createRigidArea(new Dimension(30, 20)));

		panelphuong.add(Box.createRigidArea(new Dimension(220, 20)));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Danh Sách Khách Hàng",
				TitledBorder.CENTER, TitledBorder.TOP, null,Color.red));
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

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
//				JMain main=new JMain();
//				main.setVisible(true);
			}
		});
		panelbutton.add(btnBack);

		pnmain.add(Box.createRigidArea(new Dimension(30, 20)));

	}
	
	private KhachHang getInformations()
	{
		KhachHang kh = new KhachHang();
	
		kh.setHoTen("");
		kh.setDiaChi("");
		kh.setEmail("");
		kh.setMaCongTo("");
		kh.setSoDienThoai("");
		District d = (District)cbQuan.getSelectedItem();
		Ward w = (Ward)cbPhuong.getSelectedItem();
		kh.setQuan(d);
		kh.setPhuong(w);
		return kh;
	}
}
