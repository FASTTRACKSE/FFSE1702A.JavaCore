package fasttrack.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindows extends JFrame  {
	private static final long serialVersionUID = 1L;

	public  MyWindows(String title)

	{

	setTitle(title);

	JPanel pnFlow=new JPanel();

	pnFlow.setLayout(new FlowLayout());

	pnFlow.setBackground(Color.RED);

	JButton btn1=new JButton("FlowLayout");
	JButton btn2=new JButton("Add các control");
	JButton btn3=new JButton("Trên 1 dòng");
	JButton btn4=new JButton("Hết chỗ chứa");
	JButton btn5=new JButton("Thì xuống dòng");
	
	JButton btn6=new JButton("Đây xuống luôn :v");

	pnFlow.add(btn1);

	pnFlow.add(btn2);

	pnFlow.add(btn3);

	pnFlow.add(btn4);

	pnFlow.add(btn5);
	
	pnFlow.add(btn6);

	Container con=getContentPane();

	con.add(pnFlow);

	}

	public static void main(String[] args)

	{

		MyWindows myUI=new MyWindows("Demo FlowLayout");

	myUI.setSize(600, 100);

	myUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	myUI.setLocationRelativeTo(null);

	myUI.setVisible(true);

	}

	}