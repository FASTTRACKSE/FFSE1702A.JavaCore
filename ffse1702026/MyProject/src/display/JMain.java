package display;

import java.awt.*;
import com.toedter.calendar.JMonthChooser;

import database.DBBienLai;
import database.dbKhachHang;
import database.phuong;
import database.quan;
import object.BienLai;
import object.KhachHang;
import object.MyException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JMain extends JFrame {

	private JPanel pnMain, panelBrand, panelBao, panelUD, panelQL, panelDem, panelChoice, panelBaoCh, panelQLCH,
			panelTKCH, panelDemCH;
	private JLabel labelUD, labelQL;
	private JButton btQLKH, btQLBL, btTKKH, btTKBL;
	private JLabel lbdem;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// JMain frame = new JMain();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public JMain() {
		setTitle("ỨNG DỤNG QUẢN LÝ TIỀN ĐIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("b.jpg"));
		setBounds(100, 100, 988, 650);
		pnMain = new JPanel();

		setContentPane(pnMain);
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));

		panelBrand = new JPanel();
		panelBrand.setBackground(new Color(153, 51, 0));
		pnMain.add(panelBrand);
		panelBrand.setLayout(new BoxLayout(panelBrand, BoxLayout.X_AXIS));

		panelBao = new JPanel();
		panelBao.setBackground(new Color(153, 0, 204));
		panelBrand.add(panelBao);
		panelBao.setLayout(new BoxLayout(panelBao, BoxLayout.Y_AXIS));
		panelBao.add(Box.createRigidArea(new Dimension(200, 200)));
		panelUD = new JPanel();
		FlowLayout fl_panelUD = (FlowLayout) panelUD.getLayout();
		panelUD.setBackground(new Color(153, 0, 204));
		panelUD.setMaximumSize(new Dimension(300, 50));
		panelBao.add(panelUD);

		labelUD = new JLabel("ỨNG DỤNG");
		labelUD.setForeground(new Color(240, 230, 140));
		labelUD.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelUD.add(labelUD);

		panelQL = new JPanel();
		panelQL.setBackground(new Color(153, 0, 204));
		panelBao.add(panelQL);

		labelQL = new JLabel("QUẢN LÝ TIỀN ĐIỆN");
		labelQL.setForeground(new Color(240, 230, 140));
		labelQL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelQL.add(labelQL);

		panelDem = new JPanel();
		panelDem.setBackground(new Color(153, 0, 204));
		panelBao.add(panelDem);

		panelBao.add(Box.createRigidArea(new Dimension(200, 250)));

		panelChoice = new JPanel();
		panelChoice.setBackground(new Color(102, 102, 204));
		pnMain.add(panelChoice);
		panelChoice.setLayout(new BoxLayout(panelChoice, BoxLayout.X_AXIS));

		panelBaoCh = new JPanel();
		panelBaoCh.setBackground(Color.WHITE);
		panelChoice.add(panelBaoCh);
		panelBaoCh.setLayout(new BoxLayout(panelBaoCh, BoxLayout.Y_AXIS));

		panelBaoCh.add(Box.createRigidArea(new Dimension(200, 200)));

		panelQLCH = new JPanel();
		panelQLCH.setBackground(Color.WHITE);
		panelQLCH.setMaximumSize(new Dimension(1000, 1000));
		panelBaoCh.add(panelQLCH);

		btQLKH = new JButton("Quản Lý Khách Hàng");
		btQLKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				try {
					jKhachHang kh = new jKhachHang();
					kh.setVisible(true);
				} catch (MyException | SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btQLKH.setForeground(new Color(102, 0, 51));

		btQLKH.setIcon(
				new ImageIcon(new ImageIcon("user.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		btQLKH.setPreferredSize(new Dimension(200, 40));
		panelQLCH.add(btQLKH);

		panelQLCH.add(Box.createRigidArea(new Dimension(30, 50)));

		btQLBL = new JButton("Quản Lý Biên Lai");
		btQLBL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JBienLai bl = new JBienLai();
				bl.setVisible(true);
			}
		});
		btQLBL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btQLBL.setIcon(
				new ImageIcon(new ImageIcon("bill.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		btQLBL.setForeground(new Color(102, 0, 51));

		btQLBL.setPreferredSize(new Dimension(200, 40));
		panelQLCH.add(btQLBL);

		panelTKCH = new JPanel();
		panelTKCH.setBackground(Color.WHITE);
		panelBaoCh.add(panelTKCH);

		btTKKH = new JButton("Thống Kê Khách Hàng");
		btTKKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				JThongKeKhachHang tkkh;
				try {
					tkkh = new JThongKeKhachHang();
					tkkh.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btTKKH.setIcon(
				new ImageIcon(new ImageIcon("tke.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		btTKKH.setForeground(new Color(102, 0, 51));
		btTKKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btTKKH.setPreferredSize(new Dimension(200, 40));
		btTKKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelTKCH.add(btTKKH);

		panelTKCH.add(Box.createRigidArea(new Dimension(30, 20)));

		btTKBL = new JButton("Thống Kê Biên Lai");
		btTKBL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				JThongKeBienLai tkbl;
				try {
					tkbl = new JThongKeBienLai();
					tkbl.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btTKBL.setForeground(new Color(102, 0, 51));
		btTKBL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btTKBL.setPreferredSize(new Dimension(200, 40));
		btTKBL.setIcon(new ImageIcon(
				new ImageIcon("checklist.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		panelTKCH.add(btTKBL);

		panelDemCH = new JPanel();
		panelDemCH.setBackground(Color.WHITE);
		panelBaoCh.add(panelDemCH);

		lbdem = new JLabel("                                                                               ");
		panelDemCH.add(lbdem);

		btnBack = new JButton("      Thoát          ");
		btnBack.setForeground(new Color(102, 0, 51));
		btnBack.setIcon(
				new ImageIcon(new ImageIcon("ex.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		btnBack.setPreferredSize(new Dimension(200, 40));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int output = JOptionPane.showConfirmDialog(pnMain, "Bạn có muốn thoát", "Thông Báo",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					setVisible(false);
					JLogin lg = new JLogin();
					lg.setVisible(true);
				}
			}
		});
		panelDemCH.add(btnBack);

		panelBaoCh.add(Box.createRigidArea(new Dimension(200, 200)));
	}
}
