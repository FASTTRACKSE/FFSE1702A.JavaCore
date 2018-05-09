package Giaodien.ui;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DesktopUI extends JFrame { 
	
	public DesktopUI() {
		
		
		addControls();
		addEvents();
		
	}

	private void addControls() {
		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll,BoxLayout.Y_AXIS));
		
		con.add(boxAll);
		
		
		JPanel box1 = new JPanel();
		JLabel a = new JLabel("he so a= ");
		JTextField text = new JTextField(20);
		box1.add(a);
		box1.add(text);
		
		JButton b1 = new JButton("Home");
		JButton b2 = new JButton("Login");
		JButton b3 = new JButton("Out");
		
		JButton sv = new JButton("QLSV");
		JButton lh = new JButton("QLLH");
		JButton mh = new JButton("QLMH");
		JButton bc = new JButton("Bao Cao");		
		JButton b4 = new JButton("Home");
		
		JButton add = new JButton("ADD");
		JButton edit  = new JButton("EDIT");
		JButton dele = new JButton("DELE");
		JButton save = new JButton("SAVE");		

		
		
		JPanel panelall = new JPanel();
		panelall.setLayout(new BoxLayout(panelall,BoxLayout.Y_AXIS));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
		
		JPanel panel11 = new JPanel();
		panel11.setLayout(new BoxLayout(panel11,BoxLayout.Y_AXIS));
		
		JPanel panel12 = new JPanel();
		panel12.setLayout(new BoxLayout(panel12,BoxLayout.Y_AXIS));
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
		
		
		JPanel panel21 = new JPanel();
		panel21.setLayout(new BoxLayout(panel21,BoxLayout.Y_AXIS));
		

		JPanel panel22 = new JPanel();
		panel22.setLayout(new BoxLayout(panel22,BoxLayout.Y_AXIS));
		
		JPanel panel221 = new JPanel();
		panel221.setLayout(new BoxLayout(panel221,BoxLayout.Y_AXIS));
		
		JPanel panel222 = new JPanel();
		panel222.setLayout(new BoxLayout(panel222,BoxLayout.Y_AXIS));
		
		JPanel panel2221 = new JPanel();
		panel2221.setLayout(new BoxLayout(panel2221,BoxLayout.Y_AXIS));
		
		JPanel panel2222 = new JPanel();
		panel2222.setLayout(new BoxLayout(panel2222,BoxLayout.Y_AXIS));
		
		

		panelall.add(panel1);
		panelall.add(panel2);	

		boxAll.add(panel1);
		boxAll.add(panel2);
		
		panel1.add(panel11);
		panel1.add(panel12);
		
		panel2.add(panel21);
		panel2.add(panel22);
		
		panel22.add(panel221);
		panel22.add(panel222);
		
		panel222.add(panel2221);
		panel222.add(panel2222);
		
		
		 panel1.add(box1);
		 panel1.add(b2);
		 panel1.add(b3);
		 
		 panel12.add(b1);
		 
		 panel21.add(sv);
		 panel21.add(mh);
		 panel21.add(lh);
		 panel21.add(bc);
		 
		
		 panel2222.add(add);
		 panel2222.add(edit);
		 
		
	}
	
	

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
	
	
	
	public void windows() {
	this.setSize(1280,876);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
}}
