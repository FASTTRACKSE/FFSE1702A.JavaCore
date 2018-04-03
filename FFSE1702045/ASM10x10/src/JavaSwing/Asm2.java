package JavaSwing;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;

public class Asm2 extends JFrame {
	String data[] = {"FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	JComboBox jComBo = new JComboBox(data);
	 private String statusClass;
	JTextField textMSSV, textName, textAge;
	JButton btnAdd, btnEdit, btnDel, btnExit,btnSave;
	JTable Table;
	JComboBox textClass;
	public Asm2(String title) {
		super(title);
		Controls();
		Events();
		
	}
	private void Controls() {
		Container con = getContentPane();
		JPanel PanelMain = new JPanel();
		PanelMain.setLayout(new BoxLayout(PanelMain, BoxLayout.Y_AXIS));
		
		JPanel PanelTitle = new JPanel();
		JLabel LabelTitle = new JLabel("Quản lý sinh viên");
		PanelTitle.add(LabelTitle);
		
		JPanel PanelInputMSSV = new JPanel();
		JLabel LabelInputMSSV = new JLabel("Mã số sinh viên");
		textMSSV = new JTextField(18);
		PanelInputMSSV.add(LabelInputMSSV);
		PanelInputMSSV.add(textMSSV);
		
		JPanel PanelInputName = new JPanel();
		JLabel LabelInputName = new JLabel("Tên sinh viên    ");
		textName = new JTextField(18);
		PanelInputName.add(LabelInputName);
		PanelInputName.add(textName);
	
		
		JPanel PanelInputAge = new JPanel();
		JLabel LabelInputAge = new JLabel("Tuổi sinh viên   ");
		textAge = new JTextField(18);
		PanelInputAge.add(LabelInputAge);
		PanelInputAge.add(textAge);
		
		JPanel PanelInputClass = new JPanel();
		JLabel JLabelInputClass = new JLabel("Lớp");
		PanelInputClass.add(JLabelInputClass);
		PanelInputClass.add(jComBo);
		
		JPanel PanelAction = new JPanel();
		btnAdd = new JButton("Add");
		btnEdit = new JButton("Edit");
		btnDel = new JButton("Delete");
		btnExit = new JButton("Exit");
		btnSave = new JButton("Save");
		PanelAction.add(btnAdd);
		PanelAction.add(btnEdit);
		PanelAction.add(btnDel);
		PanelAction.add(btnExit);
		PanelAction.add(btnSave);
		
		JScrollPane scrollPanel = new JScrollPane();
		Table = new JTable();
		Table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Lớp","Mã", "Tên", "Tuổi" }));
		scrollPanel.setViewportView(Table);
        


		
		PanelMain.add(PanelTitle);
		PanelMain.add(PanelInputClass);
		PanelMain.add(PanelInputMSSV);
		PanelMain.add(PanelInputName);
		PanelMain.add(PanelInputAge);
		PanelMain.add(PanelAction);
		PanelMain.add(scrollPanel);

		
		
		con.add(PanelMain);
	}
	

	ActionListener eventAdd = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			addInfo();
		}
	};
	

	
	
	
	
	
	public void addInfo() {
		String cls =(String) jComBo.getSelectedItem();
		String mssv = textMSSV.getText();
		String name = textName.getText();
		String age = textAge.getText();
		DefaultTableModel TableModel = (DefaultTableModel) Table.getModel();
		TableModel.addRow(new Object[] {cls,mssv, name, age});
		textMSSV.setText("");
		textName.setText("");
		textAge.setText("");
		jComBo.setSelectedItem(data[0]);
	}
	 	ActionListener eventDel = new ActionListener() {
	 		@Override
	 		public void actionPerformed(ActionEvent e) {
				del();
	 	}
};
			public void del() {
				int row =Table.getSelectedRow();
				int modelRow = Table.convertRowIndexToModel(row);
				DefaultTableModel model =(DefaultTableModel) Table.getModel();
				model.removeRow(modelRow);
				textMSSV.setText("");
				textName.setText("");
				textAge.setText("");
		}
			MouseListener eventGetRow = new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					getRow();
				}

};

			public void getRow() {
				
				DefaultTableModel model = (DefaultTableModel) Table.getModel();
				int column = Table.getColumnCount();
				int selectRow= Table.getSelectedRow();

				textMSSV.setText(model.getValueAt(selectRow, 1).toString());
				textName.setText(model.getValueAt(selectRow, 2).toString());
				textAge.setText(model.getValueAt(selectRow, 3).toString());
			}
			ActionListener eventEdit = new ActionListener() {

				@Override
			public void actionPerformed(ActionEvent e) {
					edit();
				}
			};
			
			public void edit() {
				JComboBox cb[] = new JComboBox[] {jComBo};
				JTextField Text[] = new JTextField[]{textMSSV, textName, textAge};
				DefaultTableModel model = (DefaultTableModel) Table.getModel();
				int column = Table.getColumnCount();
				int selectRow= Table.getSelectedRow();
				for(int i=0;i<column;i++) {
					String n = Text[i].getText();
					model.setValueAt(n, selectRow, i);	
				}
			}
			
			public void Events() {
				btnAdd.addActionListener(eventAdd);
				btnDel.addActionListener(eventDel);
				btnEdit.addActionListener(eventEdit);
				Table.addMouseListener(eventGetRow);
				btnExit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
			}

			public void showWindow() {
				this.setSize(350, 500);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
			}
			public static void main(String[] args) {
				Asm2 run = new Asm2("Chương trình Quản lí sinh viên");
				run.showWindow();
		}
			public Connection getConnect(String strServer,String strDatabase,
					String strUser,String strPwd)
					{
					java.sql.Connection conn=null;
					String strConnect="jdbc:mysql://"+strServer+"/"+strDatabase;
					Properties pro=new Properties();
					pro.put("vuna", strUser);
					pro.put("123456", strPwd);
					try
					{
					com.mysql.jdbc.Driver driver=new Driver();
					conn=driver.connect(strConnect, pro);
					}
					catch(SQLException ex)
					{
					ex.printStackTrace();
					}
					return (Connection) conn;
					}
			
			
}