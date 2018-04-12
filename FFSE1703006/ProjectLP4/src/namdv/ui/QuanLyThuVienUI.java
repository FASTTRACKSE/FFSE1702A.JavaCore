package namdv.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class QuanLyThuVienUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane tabbedPaneContent;
	JLabel lblHeader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyThuVienUI frame = new QuanLyThuVienUI("Quản lí thư viện - JunBjn");
					frame.showWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void showWindow() {
		this.setSize(800, 575);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public QuanLyThuVienUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();
	}

	private void addControls() {
		Container con = getContentPane();

		// HEADER
		JPanel header = new JPanel();
		header.setPreferredSize(new Dimension(200, 45));

		lblHeader = new JLabel("Quản lí bạn đọc");
		header.add(lblHeader);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 15));

		// CENTER
		tabbedPaneContent = new JTabbedPane(JTabbedPane.TOP);

		BanDocUI banDocUI = new BanDocUI();
		tabbedPaneContent.addTab("Quản lý bạn đọc", banDocUI);

		SachUI sachUI = new SachUI();
		tabbedPaneContent.addTab("Quản lý sách", sachUI);

		MuonSachUI muonSachUI = new MuonSachUI();
		tabbedPaneContent.addTab("Mượn sách", muonSachUI);

		TraSachUI traSachUI = new TraSachUI();
		tabbedPaneContent.addTab("Trả sách", traSachUI);

		ThongKeBaoCao thongKeBaoCao = new ThongKeBaoCao();
		tabbedPaneContent.addTab("Thống kê báo cáo", thongKeBaoCao);

		// ADD TO CONTAINER
		con.add(header, BorderLayout.NORTH);
		con.add(tabbedPaneContent, BorderLayout.CENTER);
	}

	private void addEvents() {
		tabbedPaneContent.addChangeListener(new SelectedTab());
	}

	private class SelectedTab implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			int choose = tabbedPaneContent.getSelectedIndex();
			switch (choose) {
			case 0:
				lblHeader.setText("Quản lí bạn đọc");
				break;
			case 1:
				lblHeader.setText("Quản lý sách");
				break;
			case 2:
				lblHeader.setText("Quản lí mượn sách");
				break;
			case 3:
				lblHeader.setText("Quản lí trả sách");
				break;
			case 4:
				lblHeader.setText("Thống kê báo cáo");
				break;
			}
		}
	}
}
