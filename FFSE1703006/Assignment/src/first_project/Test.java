package first_project;

<<<<<<< HEAD
import java.text.DecimalFormat;

public class Test {
	static String[] ten = { "Nguyễn Văn A", "Trần Thị B", "Trương Văn C", "Dương Thị D", "Trần Văn E" };

	public static void main(String[] args) {
		// float rate = (float) 10.3546645;
		// System.out.println(rate);
		// System.out.println((float) Math.floor(rate * 100) / 100);
		float rate1 = (float) (13456 * 1.0 / 1000);
		System.out.println(rate1);
		// System.out.println(Math.floor(13456 / 1000));
		DecimalFormat df = new DecimalFormat("#.0");
		System.out.println(df.format(rate1));
	}

}
=======
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Test extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar mb;
	JMenu file;
	JMenuItem open;
	JTextArea ta;

	Test() {
		open = new JMenuItem("Open File");
		open.addActionListener(this);
		file = new JMenu("File");
		file.add(open);
		mb = new JMenuBar();
		mb.setBounds(0, 0, 800, 20);
		mb.add(file);
		ta = new JTextArea(800, 800);
		ta.setBounds(0, 20, 800, 800);
		add(mb);
		add(ta);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == open) {
			JFileChooser fc = new JFileChooser();
			int i = fc.showOpenDialog(this);
			if (i == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String filepath = f.getPath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(filepath));
					String s1 = "", s2 = "";
					while ((s1 = br.readLine()) != null) {
						s2 += s1 + "\n";
					}
					ta.setText(s2);
					br.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Test om = new Test();
		om.setSize(500, 500);
		om.setLayout(null);
		om.setVisible(true);
		om.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
