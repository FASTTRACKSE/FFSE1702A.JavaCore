package ffse;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DssvAdmin extends JFrame {
	String mahs;

	public String getMahs() {
		return mahs;
	}

	public void setMahs(String mahs) {
		this.mahs = mahs;
	}

	public DssvAdmin(String title) {
		super(title);
		addControls();
	}

	private void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setBackground(new Color(135, 206, 250));
		pnMain.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnMain.setLayout(new BorderLayout());

		final CardLayout cardLayout = new CardLayout();
		final JPanel cardPanel = new JPanel(cardLayout);

		JPanel DS_SV_admin = new DS_SV_admin();
		JPanel DS_MH_admin = new DS_MH_admin();
		JPanel TKB_admin = new TKB_admin();
		JPanel ThongTinCaNhan = new ThongTinCaNhan();
		
		JPanel card5 = new JPanel();
		card5.setBackground(new Color(173, 216, 230));

		cardPanel.add(DS_SV_admin, "dssv");
		cardPanel.add(DS_MH_admin, "dsmh");
		cardPanel.add(TKB_admin, "tkb");
		cardPanel.add(ThongTinCaNhan, "ttcn");
		cardPanel.add(card5, "logout");

		JPanel buttonPanel = new JPanel();
		JButton dssv = new JButton("DS lớp bạn");
		JButton dsmh = new JButton("DS môn học");
		JButton tkb = new JButton("Thời khóa biểu");
		JButton ttcn = new JButton("thông tin cá nhân");
		JButton logout = new JButton("logout");

		buttonPanel.add(dssv);
		buttonPanel.add(dsmh);
		buttonPanel.add(tkb);
		buttonPanel.add(ttcn);
		buttonPanel.add(logout);

		dssv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "dssv");
			}
		});

		dsmh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "dsmh");
			}
		});
		tkb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "tkb");
			}
		});
		ttcn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "ttcn");
			}
		});
		logout.addActionListener(new ActionListener() {
			ActionListener loghome = new ActionListener() {
				public	void actionPerformed(ActionEvent e ) {
					log_home();
				}
			};
			
			protected void log_home() {
				 setVisible(false);
				 Login myUI = new Login("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
			        myUI.showWindow();
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				logout.addActionListener(loghome);
			}
		});

		pnMain.add(cardPanel, BorderLayout.CENTER);
		pnMain.add(buttonPanel, BorderLayout.NORTH);
		pnMain.setVisible(true);
		con.add(pnMain);

	}

//	public static void main(String[] args) {
//		DssvAdmin myUI = new DssvAdmin("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
//		myUI.showWindow();
//
//	}

	public void showWindow() {
		this.setSize(800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
