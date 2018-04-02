package Assignment.UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Assignment2UI extends JFrame {
	JLabel a,b,c,title;
	JTextField text,text1,text2;
	JButton b1,b2,b3,b4;
	DefaultTableModel tb = new DefaultTableModel();
	final JTable tbl = new JTable(tb);
	
	public Assignment2UI() {
		super("Quản Lý Sinh Viên - Oracle ");
		addControls();
		addEvents();
	}

	private void addControls() {
		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll, BoxLayout.Y_AXIS));
		con.add(boxAll);
		
		JLabel titleBox  = new JLabel("chương trình quản lý sinh viên ");
	    titleBox.setFont(new Font("Courier New", Font.ITALIC, 12));
	    
		
		JPanel box1 = new JPanel();
		//set box1 
		
		a = new JLabel("mã sinh viên  : ");
		 text=new JTextField(10);  
	     
	     box1.add(a);
	     box1.add(text);
	     
		JPanel box2 = new JPanel();
		//set box2
		
		b = new JLabel("tên sinh viên : ");
		 text1=new JTextField(10);  
	    
	     box2.add(b);
	     box2.add(text1);
	     
		JPanel box3 = new JPanel();
		//set box3
		c = new JLabel(" tuổi             : ");
		text2=new JTextField(10);  
         
         box3.add(c);
	     box3.add(text2);
		
	     
		//o button 
		JPanel box = new JPanel();
		//set button 
		
		b1 = new JButton("lưu");
		b2 = new JButton("Mới");
		b3 = new JButton("xoá");
		b4 = new JButton("thoát");
		box.add(b1);		box.add(b2);		box.add(b3);		box.add(b4);
		JLabel titleBox1  = new JLabel("danh sách : ");
		JPanel box4 = new JPanel();
		//set box4
		
		tb.addColumn("ma");
		tb.addColumn("ten");
		tb.addColumn("tuoi");
		
		
		tb.addRow(new String [] {"1","nguyen van a" , " 19 "});
		tb.addRow(new String [] {"1","nguyen van a" , " 19 "});
		JScrollPane sc = new JScrollPane(tbl);
		box4.setLayout(new BorderLayout());
		box4.add(sc,BorderLayout.CENTER);
		

		boxAll.add(titleBox);
		boxAll.add(box1);
		boxAll.add(box2);
		boxAll.add(box3);
		boxAll.add(box);
		boxAll.add(titleBox1);
		boxAll.add(box4);
		box.setLayout(new FlowLayout());
		
		
		
		
	}

	//đây là sự kiện 
	
		ActionListener bt1 = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	               luu();
	        }
	 };

	 ActionListener bt2  = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	               moi();
	        }
	 };
	 ActionListener bt3  = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	               xoa();
	        }
	 };
	 

	 protected void luu() {
	        String hsa = text.getText();
	        String hsb = text1.getText();
	        String hsc = text2.getText();
	        tb.addRow(new String [] {hsa,hsb,hsc});
	 }

	 public void moi() {
		 text.setText("");
		 text1.setText("");
		 text2.setText("");
	 }
	 public void xoa() {
	        tbl.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	 }
	
	private void addEvents() {
		
		b1.addActionListener(bt1);
		
		b2.addActionListener(bt2);
		
        b3.addActionListener(bt3);
		//tuỳ chỉnh button thoát 
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                  System.exit(0);
            }
     });
		
	}
	public void showWindow() {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
