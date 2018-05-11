package fasttrack.edu.vn.main;

	
	import java.sql.Statement;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	 
	import javax.swing.JFrame;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
	 
	public class Demo extends JFrame {
	 
	    private Connection connect = null;
	    private JTable jtable = new JTable();
	    private DefaultTableModel tableModel = new DefaultTableModel();
	 
	     
	    public Demo(){
	        String []colsName = {"Mã", "Họ Tên", "Tuổi"};
	        tableModel.setColumnIdentifiers(colsName);  
	        jtable.setModel(tableModel);    
	         
	        initComponent();    // Khởi tạo các components trên JFrame
	        connectSQL();       // kết nối cơ sở dữ liệu
	        updateData(view()); // gọi hàm view để truy suất dữ liệu sau đó truyền cho hàm updateData để đưa dữ liệu vào tableModel và hiện lên Jtable trong Frame
	    }
	     
	    public void updateData(ResultSet result){
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
	            String url = new String("jdbc:mysql://localhost:3306/lp4");
	            try {
	                connect = DriverManager.getConnection(url, "lp4", "locloc123");
	                
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	         
	    }
	     
	    public ResultSet view(){
	        ResultSet result = null;
	        String sql = "SELECT * FROM KetNoiData";
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