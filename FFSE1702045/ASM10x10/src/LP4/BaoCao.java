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

public class BaoCao extends JFrame {
	static Vector<String> arr2 = new Vector<String>();
	static JTextField diem = new JTextField();
	static JComboBox jComBoLopHocBC = new JComboBox();
	static JComboBox jComBoNamHocBC = new JComboBox();
	private static String[] data = { "", "HK1", "HK2", "HK3", "HK4" };
	static JComboBox jComBoHocki = new JComboBox(data);
	JButton Choose, Choose1;
	int x = 0;
	String title = "Xem danh sách Sinh Viên";
	
	public BaoCao() {
		Controls();
		updateDataNamHoc(connect.NamHoc());
		Connection conn = (Connection) connect.getConnect();
		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Lớp", "Tỉnh/Tp", "Quận/Huyện", "Xã/Phường" };
		tableModel.setColumnIdentifiers(colsName);
		table.setModel(tableModel);
		connect connect = new connect();
		updateAllMonHoc(connect.viewAllMonHoc());
		jComBoNamHocBC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDataTimNam(connect.viewTimLopHocBC());

			}
		});
		jComBoLopHocBC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllTableRows(table);
				updateDataTKD(connect.viewTKD());
			}
		});
		
	}

	JTable table = new JTable();
	DefaultTableModel tableModel = new DefaultTableModel();
	Container con = getContentPane();

	public void Controls() {
		String title = "Xem danh sách Sinh Viên";
		Choose = new JButton(title);
		Choose1 = new JButton("Xem thống kê lớp");
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
		JLabel JLabelInputNamHoc = new JLabel("Chọn Năm Học");
		PanelNamHoc.add(JLabelInputNamHoc);
		PanelInputLop.add(jComBoNamHocBC);

		JLabel JLabelInputLop = new JLabel("Chọn Lớp");
		PanelInputLop.add(JLabelInputLop);
		PanelInputLop.add(jComBoLopHocBC);

		
		PanelHead.add(PanelNamHoc);
		PanelHead.add(PanelInputLop);
		Choose1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllTableRows(table);
				JLabelInputLop.setVisible(false);
				jComBoLopHocBC.setVisible(false);
				updateDataThongKe(connect.viewThongKe());
			}
		});
		Choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllTableRows(table);
				JLabelInputLop.setVisible(true);
				jComBoLopHocBC.setVisible(true);
				updateDataTKD(connect.viewTKD());
			}
		});
		PanelHead.add(PanelChoose);
		scroll.add(Table);

		PanelChoose.add(Choose);
		PanelChoose.add(Choose1);

		PanelCon.add(scroll);

		PanelMain.add(PanelHead);
		PanelMain.add(PanelCon);
		PanelMain.add(PanelUpdateData);

		con.add(PanelMain);

	}

	public void updateAllMonHoc(ResultSet resultAllMonHoc) {
		Vector<String> data2 = new Vector<String>();
		data2.add("ID");
		data2.add("Họ Và tên");
		data2.add("Lớp");
		data2.add("MSSV");

		try {
			while (resultAllMonHoc.next()) {
				data2.addElement(resultAllMonHoc.getString(1));
				String[] cos = (String[]) data2.toArray(new String[data2.size()]);
				arr2 = new Vector(Arrays.asList(cos));
				arr2.add("AVG");
				arr2.add("Xếp Loại");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private void deleteAllTableRows(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	public static void updateDataTimNam(ResultSet resultTimNam1) {
		Vector<String> data3 = new Vector<String>();
		try {
			while (resultTimNam1.next()) {
				data3.addElement(resultTimNam1.getString(1));
				jComBoLopHocBC.setModel(new DefaultComboBoxModel(data3));
		

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
				jComBoNamHocBC.setModel(new DefaultComboBoxModel(data2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDataTKD(ResultSet resultTKD) {
		
		String[] colsName = arr2.toArray(new String[0]);
		int i = colsName.length;
		tableModel.setColumnIdentifiers(colsName);
		try {
			
			while (resultTKD.next()) {
				String rows[] = new String[i + 1];
				rows[i] = resultTKD.getString(1);
				for (int j = 0; j < i; j++) {
					rows[j] = resultTKD.getString(j + 1);
					if (j + 1 == i) {
						tableModel.addRow(rows);
					}
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

		public void updateDataThongKe(ResultSet resultThongke) {
			String[] colsName = { "Lớp", "Số lượng học sinh", "Giỏi", "Khá", "Trung Bình", "Yếu"};
			tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName
			try {
				while (resultThongke.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
					String rows[] = new String[8];
					rows[0] = resultThongke.getString(1);
					rows[1] = resultThongke.getString(2);
					rows[2] = resultThongke.getString(3);
					rows[3] = resultThongke.getString(4);
					rows[4] = resultThongke.getString(5);
					rows[5] = resultThongke.getString(6);
					tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
					// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
					// trên frame
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

}
