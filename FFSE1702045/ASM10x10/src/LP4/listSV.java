package LP4;

import LP4.connect;
import QLcanbo.canboinfoexception;
import LP4.MonHoc;
import LP4.user;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;

import JavaSwing.Asm2;
import JavaSwing.Demo;

public class listSV extends JFrame {
	protected static final String LP4 = null;
	static JTextField textMSSV, textName, textName2, textMSSV2, textSdt, textSoNha, textEmail, textMSSV1, textName1;
	static JPasswordField textPassword;
	static String mssv11, id, mssvv, getmail, getsdt;
	Vector<String> arss = new Vector<String>();

	JButton btnAdd, btnEdit, btnDel, btnExit, btnSave, btnTim;
	private static java.sql.Connection connect = null;
	static JTable jtable = new JTable();
	static int y = 0, j = 0, k = 0;
	static String MSSV1, email1, sdt2;
	static JComboBox jComBo = new JComboBox();
	static JComboBox jComBoTinh = new JComboBox();
	static JComboBox jComBoHuyen = new JComboBox();
	static JComboBox jComBoXa = new JComboBox();
	static JComboBox jComBoTinh1 = new JComboBox();
	static JComboBox jComBoHuyen1 = new JComboBox();
	static JComboBox jComBoXa1 = new JComboBox();

	static private DefaultTableModel tableModel = new DefaultTableModel();

	public void cbbTinh(ResultSet resultTinh) throws SQLException {
		while (resultTinh.next()) {
			jComBoTinh.addItem(resultTinh.getString(1));
		}
	}

	public listSV(String title) {
		super(title);
		updateDataTinh(((LP4.connect) connect).viewTinh());
		updateData(((LP4.connect) connect).view1());
		updateDataHuyen(((LP4.connect) connect).viewHuyen());
		updateDataHuyen1(((LP4.connect) connect).viewHuyen1());
		updateDataXa(((LP4.connect) connect).viewXa());
		updateLop(((LP4.connect) connect).viewLop1());
		updateDataXa1(((LP4.connect) connect).viewXa1());
	
		createGUI();
		Events();
		String nam = (String) LopHoc.jComBoNamHoc.getSelectedItem();

	}

	public void Events() {
		btnDel.setEnabled(false);
		btnEdit.setEnabled(false);
		btnSave.setEnabled(false);
		textMSSV.setEditable(false);
		textName.setEditable(false);
		textEmail.setEditable(false);
		textSdt.setEditable(false);
		textSoNha.setEditable(false);
		textPassword.setEditable(false);
		btnTim.addActionListener(eventTimKiem);
		btnAdd.addActionListener(eventAdd);
		btnEdit.addActionListener(eventEdit);
		btnDel.addActionListener(eventDel);
		jtable.addMouseListener(eventGetRow);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void createGUI() {
		add(createTabbedPane());
	}

	/**
	 * create a JTabbedPane contain three tab
	 */
	private JTabbedPane createTabbedPane() {
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon img1 = new ImageIcon(new ImageIcon(
				"C:\\Users\\ASUS\\Documents\\GitHub\\FFSE1702A.JavaCore\\FFSE1702045\\ASM10x10\\src\\1.png").getImage()
						.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		ImageIcon img2 = new ImageIcon(new ImageIcon(
				"C:\\Users\\ASUS\\Documents\\GitHub\\FFSE1702A.JavaCore\\FFSE1702045\\ASM10x10\\src\\2.png").getImage()
						.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		ImageIcon img3 = new ImageIcon(new ImageIcon(
				"C:\\Users\\ASUS\\Documents\\GitHub\\FFSE1702A.JavaCore\\FFSE1702045\\ASM10x10\\src\\3.png").getImage()
						.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		ImageIcon img4 = new ImageIcon(new ImageIcon(
				"C:\\Users\\ASUS\\Documents\\GitHub\\FFSE1702A.JavaCore\\FFSE1702045\\ASM10x10\\src\\4.png").getImage()
						.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		ImageIcon img5 = new ImageIcon(new ImageIcon(
				"C:\\Users\\ASUS\\Documents\\GitHub\\FFSE1702A.JavaCore\\FFSE1702045\\ASM10x10\\src\\5.png").getImage()
						.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		JPanel PanelMain = new JPanel();
		Container con = getContentPane();
		JPanel Panel0 = new JPanel();
		JPanel Panel00 = new JPanel();
		JPanel Panel000 = new JPanel();
		JPanel Panel0000 = new JPanel();
		JPanel Panel00000 = new JPanel();
		JPanel PanelC = new JPanel();
		JPanel Panel1 = new JPanel();
		JPanel Panel2 = new JPanel();
		JPanel Panel3 = new JPanel();
		JPanel Panel6 = new JPanel();
		JPanel Panel4 = new JPanel();
		JPanel Panel5 = new JPanel();
		JPanel Panel7 = new JPanel();
		JPanel Panel8 = new JPanel();
		Panel8.setLayout(new BoxLayout(Panel8, BoxLayout.X_AXIS));
		PanelMain.setLayout(new BoxLayout(PanelMain, BoxLayout.Y_AXIS));
		PanelC.setLayout(new BoxLayout(PanelC, BoxLayout.X_AXIS));
		Panel00000.setLayout(new BoxLayout(Panel00000, BoxLayout.Y_AXIS));
		Panel0000.setLayout(new BoxLayout(Panel0000, BoxLayout.Y_AXIS));
		Panel000.setLayout(new BoxLayout(Panel000, BoxLayout.X_AXIS));
		Panel00.setLayout(new BoxLayout(Panel00, BoxLayout.X_AXIS));
		Panel0.setLayout(new BoxLayout(Panel0, BoxLayout.X_AXIS));
		Border border = BorderFactory.createLineBorder(Color.black);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Tìm kiếm");

		Panel0.setBorder(borderTittle);

		Panel1.setLayout(new BoxLayout(Panel1, BoxLayout.Y_AXIS));
		Panel2.setLayout(new BoxLayout(Panel2, BoxLayout.X_AXIS));
		Panel3.setLayout(new BoxLayout(Panel3, BoxLayout.X_AXIS));
		Panel4.setLayout(new BoxLayout(Panel4, BoxLayout.X_AXIS));
		Panel5.setLayout(new BoxLayout(Panel5, BoxLayout.Y_AXIS));
		Panel6.setLayout(new BoxLayout(Panel6, BoxLayout.X_AXIS));
		Panel7.setLayout(new BoxLayout(Panel7, BoxLayout.X_AXIS));
		JPanel bottom = new JPanel();
		bottom.setAlignmentY(Component.RIGHT_ALIGNMENT);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
		JPanel PanelTitle = new JPanel();

		JPanel PanelInputMSSV = new JPanel();
		JLabel LabelInputMSSV = new JLabel("Mã số sinh viên");
		textMSSV2 = new JTextField(8);
		textMSSV = new JTextField(16);
		PanelInputMSSV.add(LabelInputMSSV);
		PanelInputMSSV.add(textMSSV2);
		PanelInputMSSV.add(textMSSV);

		JPanel PanelInputMSSV1 = new JPanel();
		JLabel LabelInputMSSV1 = new JLabel("Mã số sinh viên");
		textMSSV1 = new JTextField(24);
		PanelInputMSSV1.add(LabelInputMSSV1);
		PanelInputMSSV1.add(textMSSV1);

		JPanel PanelInputSoNha = new JPanel();
		JLabel LabelInputSonha = new JLabel("Địa chỉ Số Nhà ");
		textSoNha = new JTextField(24);
		PanelInputSoNha.add(LabelInputSonha);
		PanelInputSoNha.add(textSoNha);

		JPanel PanelInputName = new JPanel();
		JLabel LabelInputName = new JLabel("Tên sinh viên   ");
		textName = new JTextField(24);
		PanelInputName.add(LabelInputName);
		PanelInputName.add(textName);

		JPanel PanelInputName1 = new JPanel();
		JLabel LabelInputName1 = new JLabel("Tên sinh viên   ");
		textName1 = new JTextField(12);
		PanelInputName1.add(LabelInputName1);
		PanelInputName1.add(textName1);

		JPanel PanelInputAge = new JPanel();
		JLabel LabelInputAge = new JLabel("Số điện thoại     ");
		textSdt = new JTextField(24);
		PanelInputAge.add(LabelInputAge);
		PanelInputAge.add(textSdt);

		JPanel PanelInputEmail = new JPanel();
		JLabel LabelInputEmail = new JLabel("   Thư điện tử   ");
		textEmail = new JTextField(24);
		PanelInputEmail.add(LabelInputEmail);
		PanelInputEmail.add(textEmail);

		JPanel PanelInputPassword = new JPanel();
		JLabel LabelInputPassword = new JLabel("   Password     ");
		textPassword = new JPasswordField(24);
		PanelInputPassword.add(LabelInputPassword);
		PanelInputPassword.add(textPassword);

		JPanel PanelInputClass = new JPanel();
		JPanel PanelInputTinh = new JPanel();
		JPanel PanelInputQuan = new JPanel();
		JPanel PanelInputPhuong = new JPanel();
		JPanel rong = new JPanel();
		JPanel PanelInputTinh1 = new JPanel();
		JPanel PanelInputQuan1 = new JPanel();
		JPanel PanelInputPhuong1 = new JPanel();
		JLabel JLabelInputClass = new JLabel("Lớp");
		JLabel JLabelInputTinh = new JLabel("Tỉnh/Thành Phố");
		JLabel JLabelInputQuan = new JLabel("Quận/Huyện");
		JLabel JLabelInputPhuong = new JLabel("Xã/Phường");
		PanelInputClass.add(JLabelInputClass);
		PanelInputTinh.add(JLabelInputTinh);
		PanelInputQuan.add(JLabelInputQuan);
		PanelInputPhuong.add(JLabelInputPhuong);
		rong.setPreferredSize(new Dimension(265, 0));
		PanelInputTinh1.add(JLabelInputTinh);
		PanelInputQuan1.add(JLabelInputQuan);
		PanelInputPhuong1.add(JLabelInputPhuong);

		PanelInputClass.add(jComBo);
		PanelInputTinh.add(jComBoTinh);
		PanelInputQuan.add(jComBoHuyen);
		PanelInputPhuong.add(jComBoXa);

		PanelInputTinh1.add(jComBoTinh1);
		PanelInputQuan1.add(jComBoHuyen1);
		PanelInputPhuong1.add(jComBoXa1);

		JPanel PanelAction = new JPanel();
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		btnExit = new JButton("Thóa");
		btnSave = new JButton("Lưu");
		btnTim = new JButton("Tìm Kiếm");
		PanelAction.add(btnSave);
		PanelAction.add(btnAdd);
		PanelAction.add(btnDel);
		PanelAction.add(btnEdit);

		JScrollPane scrollPanel = new JScrollPane();

		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Lớp", "Tỉnh/Tp", "Quậnn/Huyện", "Xã/Phường", "SÐT",
				"Mail", "Số nhà" };
		tableModel.setColumnIdentifiers(colsName);
		jtable.setModel(tableModel);

		JPanel panelTable = new JPanel();
		con.add(panelTable);

		JScrollPane scroll = JTable.createScrollPaneForTable(jtable);
		panelTable.add(scroll);
		PanelC.add(Panel1);
		PanelC.add(Panel5);

		Panel5.add(Panel3);
		Panel5.add(Panel2);
		Panel5.add(Panel4);
		Panel5.add(Panel6);
		Panel5.add(Panel8);
		Panel0.add(Panel0000);
		Panel0.add(Panel00000);

		Panel8.add(rong);
		Panel8.add(PanelAction);

		Panel0000.add(Panel00);
		Panel0000.add(Panel000);

		Panel00.add(PanelInputTinh1);
		Panel00.add(PanelInputQuan1);
		Panel00.add(PanelInputPhuong1);

		Panel000.add(PanelInputMSSV1);
		Panel000.add(PanelInputName1);
		Panel00000.add(btnTim);

		Panel1.add(panelTable);

		Panel3.add(PanelInputTinh);
		Panel3.add(PanelInputQuan);
		Panel3.add(PanelInputPhuong);
		Panel3.add(PanelInputClass);

		Panel2.add(PanelInputMSSV);
		Panel2.add(PanelInputName);

		Panel4.add(PanelInputAge);
		Panel4.add(PanelInputSoNha);

		Panel6.add(Panel7);
		Panel6.add(PanelInputEmail);
		Panel6.add(PanelInputPassword);

		PanelMain.add(Panel0);
		PanelMain.add(PanelC);

		con.add(PanelMain);
		MonHoc MonHoc = new MonHoc();
		LopHoc LopHoc = new LopHoc();
		BaoCao BaoCao = new BaoCao();
		connect connect = new connect();
		user user = new user();
		int i = Integer.parseInt(Login.levelString);
		if (i == 3) {
			tabbedPane.addTab("Quản lí sinh viên", img1, PanelMain, "");
			tabbedPane.addTab("Lớp Học", img2, LopHoc.con, "");
			tabbedPane.addTab("Môn Học", img3, MonHoc.con, "");
			tabbedPane.addTab("Thống kê", img4, BaoCao.con, "");
			tabbedPane.addTab("User", img5, user.con, "");

		} else if (i == 2) {
			tabbedPane.addTab("Lớp Học", img2, LopHoc.con, "");
			tabbedPane.addTab("Môn Học", img3, MonHoc.con, "");
			tabbedPane.addTab("Thống kê", img4, BaoCao.con, "");
			tabbedPane.addTab("User", img5, user.con, "");

		} else if (i == 1) {
			tabbedPane.addTab("Lớp Học", img2, LopHoc.con, "");
			tabbedPane.addTab("Môn Học", img3, MonHoc.con, "");
			tabbedPane.addTab("Thống kê", img4, BaoCao.con, "");
			tabbedPane.addTab("User", img5, user.con, "");

		}
		return tabbedPane;

	}

	ActionListener eventAdd = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			indexValue();
			deleteAllTableRows(jtable);
			updateDataTinh(((LP4.connect) connect).viewTinh());
			btnDel.setEnabled(false);
			btnEdit.setEnabled(false);
			btnAdd.setEnabled(false);
			btnSave.setEnabled(true);
			y = 1;
			textMSSV.setEditable(true);
			textName.setEditable(true);
			textEmail.setEditable(true);
			textSdt.setEditable(true);
			textSoNha.setEditable(true);
			textPassword.setEditable(true);
			textMSSV.setText("");
			textName.setText("");
			textSdt.setText("");
			textEmail.setText("");
			textSoNha.setText("");
			textPassword.setText("");
		}
	};

	ActionListener eventTim = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Timkiem();
		}

		private void Timkiem() {
			String tinh1 = (String) jComBoTinh1.getSelectedItem();
			String quan1 = (String) jComBoHuyen1.getSelectedItem();
			String phuong1 = (String) jComBoXa1.getSelectedItem();
			String mssv1 = textMSSV1.getText();
		}
	};

	ActionListener eventDel = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			indexValue();
			((LP4.connect) connect).del();
			((LP4.connect) connect).del1();
			((LP4.connect) connect).del2();
			deleteAllTableRows(jtable);
			updateDataTinh(((LP4.connect) connect).viewTinh());
		}
	};

	MouseListener eventGetRow = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			y = 0;
			getRow();
			changeMSSV();
		}
	};

	public void getRow() {
		btnDel.setEnabled(true);
		btnEdit.setEnabled(true);
		btnAdd.setEnabled(true);
		btnSave.setEnabled(false);
		if (y == 0) {
			textMSSV.setEditable(false);
			textName.setEditable(false);
			textEmail.setEditable(false);
			textSdt.setEditable(false);
			textSoNha.setEditable(false);
			textPassword.setEditable(false);
		} else if (y == 2) {
			textMSSV.setEditable(true);
			textName.setEditable(true);
			textEmail.setEditable(true);
			textSdt.setEditable(true);
			textSoNha.setEditable(true);
			textPassword.setEditable(false);
		}

		int column = jtable.getColumnCount();
		int selectRow = jtable.getSelectedRow();
		id = (String) tableModel.getValueAt(selectRow, 0);
		getmail = (String) tableModel.getValueAt(selectRow, 8);
		getsdt = (String) tableModel.getValueAt(selectRow, 7);
		mssvv = (String) tableModel.getValueAt(selectRow, 1);
		textMSSV.setText(tableModel.getValueAt(selectRow, 1).toString());
		textName.setText(tableModel.getValueAt(selectRow, 2).toString());
		textSdt.setText(tableModel.getValueAt(selectRow, 7).toString());
		textEmail.setText(tableModel.getValueAt(selectRow, 8).toString());
		textSoNha.setText(tableModel.getValueAt(selectRow, 9).toString());
		String dataLop = tableModel.getValueAt(selectRow, 3).toString();
		String dataTinh = tableModel.getValueAt(selectRow, 4).toString();
		String dataHuyen = tableModel.getValueAt(selectRow, 5).toString();
		String dataQuan = tableModel.getValueAt(selectRow, 6).toString();
		jComBo.getModel().setSelectedItem(dataLop);
		jComBoTinh.getModel().setSelectedItem(dataTinh);
		jComBoHuyen.getModel().setSelectedItem(dataHuyen);
		jComBoXa.getModel().setSelectedItem(dataQuan);
	}

	ActionListener eventEdit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			y = 2;
			deleteAllTableRows(jtable);
			updateDataTinh(((LP4.connect) connect).viewTinh());
			btnEdit.setEnabled(false);
			btnDel.setEnabled(false);
			btnAdd.setEnabled(true);
			btnSave.setEnabled(true);

			textMSSV.setEditable(false);
			textName.setEditable(true);
			textEmail.setEditable(true);
			textSdt.setEditable(true);
			textSoNha.setEditable(true);
		}
	};
	ActionListener eventTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			deleteAllTableRows(jtable);
			updateDataTimKiem(((LP4.connect) connect).viewTimKiem());
		}
	};

	public void updateData(ResultSet resultTinh) {
		Vector<String> data = new Vector<String>();

		try {

			while (resultTinh.next()) {
				data.addElement(resultTinh.getString(1));
				jComBoTinh.setModel(new DefaultComboBoxModel(data));
				jComBoTinh1.setModel(new DefaultComboBoxModel(data));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDataHuyen(ResultSet resultHuyen) {
		Vector<String> data2 = new Vector<String>();

		try {

			while (resultHuyen.next()) {
				data2.addElement(resultHuyen.getString(1));
				jComBoHuyen.setModel(new DefaultComboBoxModel(data2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDataHuyen1(ResultSet resultHuyen1) {
		Vector<String> data1 = new Vector<String>();

		try {

			while (resultHuyen1.next()) {
				data1.addElement(resultHuyen1.getString(1));
				jComBoHuyen1.setModel(new DefaultComboBoxModel(data1));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDataXa(ResultSet resultXa) {
		Vector<String> data2 = new Vector<String>();

		try {

			while (resultXa.next()) {
				data2.addElement(resultXa.getString(1));
				jComBoXa.setModel(new DefaultComboBoxModel(data2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateLop(ResultSet resultLop) {
		Vector<String> data2 = new Vector<String>();

		try {

			while (resultLop.next()) {
				data2.addElement(resultLop.getString(1));
				jComBo.setModel(new DefaultComboBoxModel(data2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDataXa1(ResultSet resultXa1) {
		Vector<String> data2 = new Vector<String>();

		try {

			while (resultXa1.next()) {
				data2.addElement(resultXa1.getString(1));
				jComBoXa1.setModel(new DefaultComboBoxModel(data2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDataTinh(ResultSet result) {
		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Lớp", "Tỉnh/Tp", "Quậnn/Huyện", "Xã/Phường", "SÐT",
				"Mail", "Số nhà" };
		tableModel.setColumnIdentifiers(colsName); // Ð?t tiêu d? cho b?ng theo các giá tr? c?a m?ng colsName
		try {
			while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[11];
				rows[0] = result.getString(1);
				rows[1] = result.getString(2);
				rows[2] = result.getString(4);
				rows[3] = result.getString(3);
				rows[4] = result.getString(8);
				rows[5] = result.getString(7);
				rows[6] = result.getString(6);
				rows[7] = result.getString(9);
				rows[8] = result.getString(10);
				rows[9] = result.getString(5);

				tableModel.addRow(rows);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void deleteAllTableRows(JTable jtable) {
		DefaultTableModel model = (DefaultTableModel) jtable.getModel();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

	}


	public void CheckMSSV(ResultSet resultMSSV){
		try {
			while (resultMSSV.next()) {
			mssv11 = resultMSSV.getString("MSSV");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void CheckMail(ResultSet resultMail){
		try {
			while (resultMail.next()) {
			email1 = resultMail.getString("mail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void CheckSDT(ResultSet resultSDT){
		try {
			while (resultSDT.next()) {
			sdt2 = resultSDT.getString("sdt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateDataTimKiem(ResultSet resultTimKiem) {
		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Lớp", "Tỉnh/Tp", "Quậnn/Huyện", "Xã/Phường", "SÐT",
				"Mail", "Số nhà" };
		tableModel.setColumnIdentifiers(colsName);
		try {
			jComBoTinh1.getModel().setSelectedItem("");
			jComBoHuyen1.getModel().setSelectedItem("");
			jComBoXa1.getModel().setSelectedItem("");
			textName1.setText("");
			textMSSV1.setText("");
			while (resultTimKiem.next()) {
				String rows[] = new String[11];
				rows[0] = resultTimKiem.getString(1);
				rows[1] = resultTimKiem.getString(2);
				rows[2] = resultTimKiem.getString(4);
				rows[3] = resultTimKiem.getString(3);
				rows[4] = resultTimKiem.getString(8);
				rows[5] = resultTimKiem.getString(7);
				rows[6] = resultTimKiem.getString(6);
				rows[7] = resultTimKiem.getString(9);
				rows[8] = resultTimKiem.getString(10);
				rows[9] = resultTimKiem.getString(5);
				tableModel.addRow(rows);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void indexValue() {
		LopHoc.jComBoNamHoc.getModel().setSelectedItem("2017");
		LopHoc.updateDataTimNam(((LP4.connect) connect).viewTimLopHoc());
		BaoCao.updateDataTimNam(((LP4.connect) connect).viewTimLopHocBC());
		jComBoTinh1.getModel().setSelectedItem("");
		jComBoHuyen1.getModel().setSelectedItem("");
		jComBoXa1.getModel().setSelectedItem("");
		jComBoXa.getModel().setSelectedItem("Chọn xã");
		jComBoTinh.getModel().setSelectedItem("Chọn tỉnh");
		jComBoHuyen.getModel().setSelectedItem("Chọn huyện");
		jComBo.getModel().setSelectedItem("Chọn lớp");

	}

	public void changeMSSV() {
		String subs = mssvv.substring(8, 11);
		textMSSV.setText(subs);
	}

	public void showWindow() {
		user.logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 dispose();
				Login.levelString = "0";
				new Login();
			}
		});
		indexValue();
		this.setSize(1292, 678);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		textMSSV2.setEditable(false);
		jComBoTinh1.getModel().setSelectedItem("");
		jComBoHuyen1.getModel().setSelectedItem("");
		jComBoXa1.getModel().setSelectedItem("");
		jComBoTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jComBoXa.getModel().setSelectedItem("Chọn xã");
				updateDataHuyen(((LP4.connect) connect).viewHuyen());
			}
		});
		jComBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cls = (String) listSV.jComBo.getSelectedItem();
				String sub = cls.substring(0, 8);
				textMSSV2.setText(sub);
				MSSV1 = sub;
			}
		});
		textMSSV2.setText("");
		jComBoHuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDataXa(((LP4.connect) connect).viewXa());
			}
		});

		jComBoTinh1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDataHuyen1(((LP4.connect) connect).viewHuyen1());
				jComBoHuyen1.getModel().setSelectedItem("");

			}
		});
		jComBoHuyen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDataXa1(((LP4.connect) connect).viewXa1());
				jComBoXa1.getModel().setSelectedItem("");

			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckMSSV(((LP4.connect) connect).checkMSSV());
				CheckMail(((LP4.connect) connect).checkMail());
				CheckSDT(((LP4.connect) connect).checkMSSV());
				if (y == 1) {
					try {
						String cls = (String) listSV.jComBo.getSelectedItem();
						String tinh = (String) listSV.jComBoTinh.getSelectedItem();
						String quan = (String) listSV.jComBoHuyen.getSelectedItem();
						String phuong = (String) listSV.jComBoXa.getSelectedItem();
						String sdt = textSdt.getText();
						String mssvv = listSV.textMSSV.getText();
						String mssv = listSV.MSSV1 + mssvv;
						String adress = listSV.textSoNha.getText();
						String name = listSV.textName.getText();
						String mail = listSV.textEmail.getText();
						String pass = listSV.textPassword.getText();
						j = 1;
						QLSVException.checkAdd(mssv11, email1, sdt2, sdt, cls, tinh, quan, phuong, mssv, adress, name,
								mail, pass);
					} catch (QLSVException e1) {
						System.out.println(e1);
						JOptionPane.showMessageDialog(null, e1);
						j = 0;
						y = 1;
					} finally {
						if (j == 1) {
							((LP4.connect) connect).addInfoDiem();
							((LP4.connect) connect).addInfo();
							((LP4.connect) connect).addUser();
							listSV.textMSSV.setText("");
							listSV.textName.setText("");
							listSV.textSdt.setText("");
							listSV.textEmail.setText("");
							listSV.textSoNha.setText("");
							listSV.textPassword.setText("");
							y = 0;
							listSV.indexValue();
							deleteAllTableRows(jtable);
							updateDataTinh(((LP4.connect) connect).viewTinh());
						}
					}

				} else if (y == 2) {
					try {
						String cls = (String) listSV.jComBo.getSelectedItem();
						String tinh = (String) listSV.jComBoTinh.getSelectedItem();
						String quan = (String) listSV.jComBoHuyen.getSelectedItem();
						String phuong = (String) listSV.jComBoXa.getSelectedItem();
						String sdt = textSdt.getText();
						String mssv = listSV.textMSSV.getText();
						String adress = listSV.textSoNha.getText();
						String name = listSV.textName.getText();
						String mail = listSV.textEmail.getText();
						String pass = listSV.textPassword.getText();
						int i = Integer.parseInt(mssv);
						System.out.print(i);
						k = 1;
						QLSVException.checkEdit(mssv11, email1, sdt2, sdt, cls, tinh, quan, phuong, mssv, adress, name,
								mail, pass);
					} catch (QLSVException e1) {
						System.out.println(e1);
						JOptionPane.showMessageDialog(null, e1);
						k = 0;
						y = 2;
					} finally {
						if (k == 1) {
							((LP4.connect) connect).edit();
							y = 0;
							deleteAllTableRows(jtable);
							updateDataTinh(((LP4.connect) connect).viewTinh());
						}
					}
				}

				if (y == 0) {
					btnAdd.setEnabled(true);
					btnEdit.setEnabled(false);
					btnDel.setEnabled(false);
					btnSave.setEnabled(false);
					textMSSV.setEditable(false);
					textName.setEditable(false);
					textEmail.setEditable(false);
					textSdt.setEditable(false);
					textSoNha.setEditable(false);
					textPassword.setEditable(false);
				} else if (y == 1) {
					btnAdd.setEnabled(false);
					btnEdit.setEnabled(false);
					btnDel.setEnabled(false);
					btnSave.setEnabled(true);
					textMSSV.setEditable(true);

					textName.setEditable(true);
					textEmail.setEditable(true);
					textSdt.setEditable(true);
					textSoNha.setEditable(true);
					textPassword.setEditable(true);
				}
				if (y == 2) {
					btnEdit.setEnabled(false);
					btnDel.setEnabled(false);
					btnAdd.setEnabled(true);
					btnSave.setEnabled(true);

					textMSSV.setEditable(false);
					textName.setEditable(true);
					textEmail.setEditable(true);
					textSdt.setEditable(true);
					textSoNha.setEditable(true);
					textPassword.setEditable(false);
				} else if (y == 0) {
					btnAdd.setEnabled(true);
					btnEdit.setEnabled(false);
					btnDel.setEnabled(false);
					btnSave.setEnabled(false);
					textMSSV.setEditable(false);
					textName.setEditable(false);
					textEmail.setEditable(false);
					textSdt.setEditable(false);
					textSoNha.setEditable(false);
					textPassword.setEditable(false);
				}

				deleteAllTableRows(jtable);
				updateDataTinh(((LP4.connect) connect).viewTinh());
			}
		});
	}

}
