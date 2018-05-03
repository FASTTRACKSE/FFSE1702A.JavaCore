package LP4;

import LP4.connect;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.lang.model.util.Elements;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

public class LopHoc extends JFrame {
	static JTextField diem = new JTextField();
	static JComboBox jComBoLopHoc = new JComboBox();
	static JComboBox jComBoNamHoc = new JComboBox();
	private static String[] data = {"HK1", "HK2", "HK3", "HK4" };
	static JComboBox jComBoHocki = new JComboBox(data);
	static JComboBox jComBoLopHoc1 = new JComboBox();
	static JComboBox jComBoNamHoc1 = new JComboBox();
	static JComboBox jComBoDS = new JComboBox();
	static JComboBox jComBoMonHoc = new JComboBox();
	// static ArrayList arr1 = new ArrayList();
	static Vector<String> arr = new Vector<String>();
	static Vector<String> arr1 = new Vector<String>();

	JButton Choose, Update;
	int x = 0;
	String title = "Xem danh sách Sinh Viên";

	public LopHoc() {

		Connection conn = (Connection) connect.getConnect();
		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Lớp", "Tỉnh/Tp", "Quận/Huyện", "Xã/Phường" };
		tableModel.setColumnIdentifiers(colsName);
		table.setModel(tableModel);
		connect connect = new connect();
		initComponent(); // Khởi tạo các components trên JFrame
		updateData(connect.viewSinhVien());
		updateDataTim(connect.viewTimLopHoc());
		updateDataNamHoc(connect.NamHoc());

	}

	JTable table = new JTable();
	DefaultTableModel tableModel = new DefaultTableModel();
	Container con = getContentPane();

	public void Controls() {
		String title = "Xem danh sách Sinh Viên";
		Choose = new JButton(title);
		Update = new JButton("Cập nhật điểm");
		Border border = BorderFactory.createLineBorder(Color.black);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Tìm kiếm");
		JScrollPane scroll = JTable.createScrollPaneForTable(table);
		JPanel PanelMain = new JPanel();
		JPanel PanelCon = new JPanel();
		JPanel PanelChoose = new JPanel();
		JPanel Table = new JPanel();
		JPanel PanelUpdateData = new JPanel();
		PanelUpdateData.setLayout(new BoxLayout(PanelUpdateData, BoxLayout.X_AXIS));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		JPanel PanelHead = new JPanel();
		PanelHead.setBorder(borderTittle);
		PanelMain.setLayout(new BoxLayout(PanelMain, BoxLayout.Y_AXIS));
		PanelCon.setLayout(new BoxLayout(PanelCon, BoxLayout.X_AXIS));
		JLabel Content = new JLabel("Danh sách lớp học");

		JPanel PanelNamHoc = new JPanel();
		JPanel PanelInputLop = new JPanel();
		JPanel PanelInputHK = new JPanel();
		JPanel PanellInputDS = new JPanel();
		JPanel PanelInputMonHoc = new JPanel();
		JPanel PanelInputDiem = new JPanel();

		diem = new JTextField(6);
		JLabel JLabelDiem = new JLabel("Nhập điểm");
		PanelInputDiem.add(JLabelDiem);
		PanelInputDiem.add(diem);

		JLabel JLabelInputNamHoc = new JLabel("Chọn Năm Học");
		PanelNamHoc.add(JLabelInputNamHoc);
		PanelInputLop.add(jComBoNamHoc);

		JLabel JLabelInputLop = new JLabel("Chọn Lớp");
		PanelInputLop.add(JLabelInputLop);
		PanelInputLop.add(jComBoLopHoc);

		JLabel JLabelInputHK = new JLabel("Chọn Học Kì");
		PanelInputHK.add(JLabelInputHK);
		PanelInputHK.add(jComBoHocki);

		JLabel JLabelInputDS = new JLabel("Chọn Sinh Viên");
		PanellInputDS.add(JLabelInputDS);
		PanellInputDS.add(jComBoDS);

		JLabel JLabelInputMonHoc = new JLabel("Chọn Môn Học");
		PanelInputMonHoc.add(JLabelInputMonHoc);
		PanelInputMonHoc.add(jComBoMonHoc);

		PanelUpdateData.add(PanellInputDS);
		PanelUpdateData.add(PanelInputMonHoc);
		PanelUpdateData.add(PanelInputDiem);
		PanelUpdateData.add(Update);

		PanelHead.add(PanelNamHoc);
		PanelHead.add(PanelInputLop);
		PanelHead.add(PanelInputHK);
		PanelHead.add(PanelChoose);
		scroll.add(Table);
		PanelUpdateData.setVisible(false);
		Choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (x == 1) {
					Choose.setText("Xem bảng điểm");
					PanelUpdateData.setVisible(false);
					deleteAllTableRows(table);
					updateDataLop(connect.viewLop());
					x = 0;
				} else {
					Choose.setText("Xem danh sách sinh viên");
					int i = Integer.parseInt(Login.levelString);
					if(i==2) {
					PanelUpdateData.setVisible(true);
					}
					else {
						PanelUpdateData.setVisible(false);	
					}
					deleteAllTableRows(table);
					updateDiem(connect.viewDiem());

					x = 1;
				}
			}
		});
		PanelChoose.add(Choose);

		PanelCon.add(scroll);

		PanelMain.add(PanelHead);
		PanelMain.add(PanelCon);
		PanelMain.add(PanelUpdateData);

		con.add(PanelMain);

	}
	
	private void deleteAllTableRows(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void initComponent() {
		Controls();
		
		jComBoLopHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllTableRows(table);
				updateDataLop(connect.viewLop());
				
			}
		});

		jComBoNamHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDataTimNam(connect.viewTimLopHoc());
			}
		});
		jComBoHocki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = 0;
				Choose.setText("Xem bảng điểm");
				updateKi(connect.viewHocKi());
				deleteAllTableRows(table);
				updateDataLop(connect.viewLop());
			}
		});
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect.eventUpdate();
				deleteAllTableRows(table);
				updateDiem(connect.viewDiem());
			}
		});
	}

	public void updateKi(ResultSet resultKi) {
		Vector<String> data1 = new Vector<String>();
		Vector<String> data2 = new Vector<String>();
		data1.add("ID");
		data1.add("Họ Và tên");
		data1.add("Lớp");
		data1.add("MSSV");

		try {
			while (resultKi.next()) {

				data1.addElement(resultKi.getString(1));
				data2.addElement(resultKi.getString(1));
				jComBoMonHoc.setModel(new DefaultComboBoxModel(data2));
				String[] cos = (String[]) data1.toArray(new String[data1.size()]);
				List<String> conver = Arrays.asList(cos);
				arr = new Vector(Arrays.asList(cos));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDataMon(ResultSet resultMon) {
		Vector<String> data1 = new Vector<String>();

		try {

			while (resultMon.next()) {
				data1.addElement(resultMon.getString(1));
				String[] cos = (String[]) data1.toArray(new String[data1.size()]);
				arr1 = new Vector(Arrays.asList(cos));
				System.out.print(arr1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDataTim(ResultSet resultTimCls) {
		Vector<String> data1 = new Vector<String>();

		try {

			while (resultTimCls.next()) {
				data1.addElement(resultTimCls.getString(2));
				jComBoLopHoc.setModel(new DefaultComboBoxModel(data1));
				jComBoLopHoc1.setModel(new DefaultComboBoxModel(data1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDiem(ResultSet resultDiem) {
		

		String[] colsName = arr.toArray(new String[0]);
	     int i = colsName.length;
	   
	    
		tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName
		try {
			while (resultDiem.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[i];
				for(int j = 0;j<i;j++) {
				rows[j] = resultDiem.getString(j+1);
				if(j+1==i) {
				tableModel.addRow(rows);
				}
				}
		} 
		}
			catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDataLop(ResultSet resultLop) {
		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Lớp", "Tỉnh/Tp", "Quận/Huyện", "Xã/Phường", "SĐT",
				"Mail", "Số nhà" };
		Vector<String> data2 = new Vector<String>();
		tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName
		try {
			while (resultLop.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[11];
				rows[0] = resultLop.getString(1);
				rows[1] = resultLop.getString(2);
				rows[2] = resultLop.getString(4);
				rows[3] = resultLop.getString(3);
				rows[4] = resultLop.getString(8);
				rows[5] = resultLop.getString(7);
				rows[6] = resultLop.getString(6);
				rows[7] = resultLop.getString(9);
				rows[8] = resultLop.getString(10);
				rows[9] = resultLop.getString(5);
				data2.addElement(resultLop.getString(2));
				jComBoDS.setModel(new DefaultComboBoxModel(data2));
				tableModel.addRow(rows);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateDataTimNam(ResultSet resultTimNam) {
		Vector<String> data2 = new Vector<String>();
		try {
			while (resultTimNam.next()) {
				data2.addElement(resultTimNam.getString(1));
				jComBoLopHoc.setModel(new DefaultComboBoxModel(data2));
		

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDataNamHoc(ResultSet Resultnamhoc) {
		Vector<String> data2 = new Vector<String>();

		try {

			while (Resultnamhoc.next()) {
				data2.addElement(Resultnamhoc.getString(1));
				jComBoNamHoc.setModel(new DefaultComboBoxModel(data2));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateData(ResultSet resultSinhVien) {

		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Lớp", "Tỉnh/Tp", "Quận/Huyện" };

		tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

		try {
			while (resultSinhVien.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[11];
				rows[0] = resultSinhVien.getString(1);
				rows[1] = resultSinhVien.getString(2);
				rows[2] = resultSinhVien.getString(4);
				rows[3] = resultSinhVien.getString(3);
				rows[4] = resultSinhVien.getString(8);
				rows[5] = resultSinhVien.getString(7);
				rows[6] = resultSinhVien.getString(6);
				rows[7] = resultSinhVien.getString(9);
				rows[8] = resultSinhVien.getString(10);
				rows[9] = resultSinhVien.getString(5);

				tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
				// trên frame
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
