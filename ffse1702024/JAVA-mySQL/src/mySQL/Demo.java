package mySQL;

	
	import java.sql.Statement;
import java.awt.BorderLayout;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
	import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
	 
	public class Demo extends JFrame {
		JTextField txt_ma,txt_ten,txt_tuoi;
		JComboBox txt_lop;
		JButton btn_them,btn_luu,btn_sua,btn_xoa,btn_thoat;
		JLabel l2,l3,l1,l5;
		JFrame f; 
	    private Connection connect = null;
	    private JTable jtable = new JTable();
	    private DefaultTableModel tableModel = new DefaultTableModel();
	 
	     
	    public Demo(){
	  
	         String country[]={"FFSE1702-A","FFSE1702","FFSE1703","FFSE1704"};  
			 JComboBox cb=new JComboBox(country);  
			 cb.setBounds(50, 50,90,20);  
			 
	    	  
	    	         
	    	    
	    	Box b = Box.createVerticalBox();
	    	Box b1 = Box.createHorizontalBox();
	    	Box b2= Box.createHorizontalBox();
	    	Box b3 = Box.createHorizontalBox();
	    	Box b4 = Box.createHorizontalBox();
	    	Box b5 = Box.createHorizontalBox();
	    	b.add(b5);  
	    	b.add(Box.createVerticalStrut(15));
	    	
	    	b.add(b1);
	    	 
	    	b.add(Box.createVerticalStrut(5));
	    	b.setLocation(20,300);
	    	b.add(b2);
	    	
	    	b.add(Box.createVerticalStrut(5));
	    	b.add(b3);
	    	b.add(Box.createVerticalStrut(5));
	    	b.add(b4);
	    	b.add(Box.createVerticalStrut(10));
	    	b.setSize(20, 50);
	    	this.add(b,BorderLayout.SOUTH);
	    	b.setSize(20, 50);
	    	
	    	b5.add(l5 = new JLabel("Lop"));
	    	b5.add(cb = new JComboBox(country));
	    	
	    	b1.add(l1= new JLabel("Ma sinh vien"));
	    	b1.add(txt_ma = new JTextField(20));
	    	b2.add(l2= new JLabel ("Ten sv"));
	    	b2.add(txt_ten = new JTextField(20));
	    	b3.add(l3 = new JLabel("Tuoi sv"));
	    	b3.add(txt_tuoi = new JTextField(20));
	    	
	    	l2.setPreferredSize(l1.getPreferredSize());
	    	l3.setPreferredSize(l1.getPreferredSize());
	    	l5.setPreferredSize(l1.getPreferredSize());
	    	
	    
	    	
	    	JPanel panel = new JPanel();
	    	b4.add(panel);
	    	
			panel.add(btn_them = new JButton("Add"));
	    	panel.add(btn_luu = new JButton("Save"));
	    	panel.add(btn_sua = new JButton("Edit"));
	    	panel.add(btn_xoa = new JButton("Del"));
	    	panel.add(btn_thoat = new JButton("Out"));
	        jtable.setModel(tableModel);    
	         
	        initComponent();    // Khởi tạo các components trên JFrame
	        connectSQL();       // kết nối cơ sở dữ liệu
	        updateData(view()); // gọi hàm view để truy suất dữ liệu sau đó truyền cho hàm updateData để đưa dữ liệu vào tableModel và hiện lên Jtable trong Frame
	    }
	     
	    public void updateData(ResultSet result ){
	        String []colsName = {"Mã SV", "Họ Tên", "Tuổi"};
	        tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName
	        
	        try {
	            while(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
	                String rows[] = new String[3];
	                rows[0] = result.getString(1); 
	                rows[1] = result.getString(2); 
	                rows[2]	= result.getString(3);
	            
	                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
	                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại trên frame
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	    }
	     
	    public void initComponent(){
	        this.setSize(600, 400);
	        this.setLocationRelativeTo(null);
	        JScrollPane scroll = JTable.createScrollPaneForTable(jtable);   
	        this.add(scroll); // Đưa thanh cuộn vào Frame (hiện thanh cuộn trên frame)
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        this.setVisible(true);
	    }
	     
	    public void connectSQL(){
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            String url = new String("jdbc:mysql://localhost:3306/quangnc1");
	            try {
	                connect = DriverManager.getConnection(url, "quangnc1", "abc123");
	                
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	         
	    }
	     
	    public ResultSet view(){
	        ResultSet result = null;
	        String sql = "SELECT * FROM sinhvien";
	        try {
	            Statement statement = (Statement) connect.createStatement();
	            return statement.executeQuery(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	     
	    public static void main(String[] args) {
	        new Demo();
	    }
	 
	}

