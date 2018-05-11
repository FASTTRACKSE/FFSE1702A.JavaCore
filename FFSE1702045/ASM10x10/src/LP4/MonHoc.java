package LP4;
import LP4.connect;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

public class MonHoc extends JFrame {
	




	public MonHoc(){
		  Connection conn = (Connection) connect.getConnect();
			String[] colsName = { "ID","Tên môn học", "Mã môn học", "số tín chỉ", "Thời lượng" };
	        tableModel.setColumnIdentifiers(colsName);  
	        table.setModel(tableModel);    
	        connect connect = new connect();
	        initComponent();    // Khởi tạo các components trên JFrame    
	        updateData(connect.view()); // gọi hàm view để truy suất dữ liệu sau đó truyền cho hàm updateData để đưa dữ liệu vào tableModel và hiện lên Jtable trong Frame
	    }
	JTable table = new JTable();
	DefaultTableModel tableModel = new DefaultTableModel();
	Container con = getContentPane();
	






	public void Controls() {
		Border border = BorderFactory.createLineBorder(Color.black);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Tìm kiếm");
		JScrollPane scroll = JTable.createScrollPaneForTable(table);
		JPanel PanelMain = new JPanel();
	//	PanelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPanel Table = new JPanel();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		JPanel PanelHead = new JPanel();
		PanelHead.setBorder(borderTittle);
		PanelMain.setLayout(new BoxLayout(PanelMain, BoxLayout.Y_AXIS));
		JLabel Content = new JLabel("Danh sách môn học");
		PanelHead.add(Content);
		scroll.add(Table);
		PanelMain.add(PanelHead);
		PanelMain.add(scroll);
		con.add(PanelMain);
	}

	public void initComponent() {
		Controls();
	
	}


	public void updateData(ResultSet result) {
		String[] colsName = { "ID","Tên môn học", "Mã môn học", "số tín chỉ", "Thời lượng" };
		tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

		try {
			while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[5];
				rows[0] = result.getString(1);
				rows[1] = result.getString(2);
				rows[2] = result.getString(3);
				rows[3] = result.getString(4);
				rows[4] = result.getString(5);
				tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
				// trên frame
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
