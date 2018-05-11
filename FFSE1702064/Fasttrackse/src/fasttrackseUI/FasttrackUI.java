package fasttrackseUI;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class FasttrackUI extends JFrame {
	JTextField tx1,tx2,tx3;
	JButton btnkq,  btnThoat;
ActionListener eventGiaiPT = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
                giaiPT();}
};
public void giaiPT() {
	String sothu1=tx1.getText();
	String sothu2=tx2.getText();
	double a = Double.parseDouble(sothu1);
    double b = Double.parseDouble(sothu2);
    tx3.setText("Kết quả = " + -b/a);
    if (a==0&b==0) {
    	 tx3.setText("Phương trình có vô số nghiệm");
    	 }
    else if(a==0&b!=0) {
    	tx3.setText("Phương trình vô nghiệm");
    }
}
public FasttrackUI(String tieude) {
	super(tieude);
	addControls();
	addEvents();
}

private void addControls() {
	Container con = getContentPane();
    JPanel box = new JPanel();
    box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
    
    JPanel Title = new JPanel();
    JLabel lTitle = new JLabel("Giải phương trình");
    Font fontTitle = new Font("Arial", Font.BOLD, 20);
    lTitle.setFont(fontTitle);
    Title.add(lTitle);
    
    JPanel box1 = new JPanel();
    JLabel soA =new JLabel("Nhập số a");
    tx1 = new JTextField(20);
    Font fontsoA = new Font("Arial",Font.BOLD,20);
    soA.setFont(fontsoA);
    box1.add(soA);
    box1.add(tx1);
    
    JPanel box2 = new JPanel();
    JLabel soB =new JLabel("Nhập số b");
    tx2 = new JTextField(20);
    Font fontsoB = new Font("Arial",Font.BOLD,20);
    soB.setFont(fontsoB);
    box2.add(soB);
    box2.add(tx2);
    
    JPanel box3 = new JPanel();
    JLabel kq = new JLabel("   Kết quả ");
    tx3 = new JTextField(20);
    Font fontkq = new Font("Arial",Font.BOLD,20);
    kq.setFont(fontkq);
    box3.add(kq);
    box3.add(tx3);
    
    JPanel box4 = new JPanel();
    btnkq = new JButton("Kết quả");
    btnThoat = new JButton("Thoát");
    box4.add(btnkq);
    box4.add(btnThoat);
    box.add(Title);
    box.add(box1);
    box.add(box2);
    box.add(box3);
    box.add(box4);
  con.add(box);
}

public void addEvents() {
	 btnkq.addActionListener(eventGiaiPT);
	 btnThoat.addActionListener(new ActionListener() {
		 
         public void actionPerformed(ActionEvent e) {
               System.exit(0);
         }});
}
public void showWindow() {
    this.setSize(600, 400);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);

}
}

