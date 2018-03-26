package javadesktop;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Messagedialogdemo  extends JFrame implements ActionListener{
    private JLabel label;
    public void Messagedialogdemo() {
        setSize(300,200);
        setVisible(true);
        setResizable(true);
        setLocation(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         label =  new JLabel("Welcom");
         add(label);
        JButton button =  new JButton("Hit me");
        add(button, "South", 1);
        button.addActionListener(this);
       }
    public static void main(String args[]) {
        Messagedialogdemo message =  new Messagedialogdemo();
        message.Messagedialogdemo();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        label.setText("Myname Is Hung");
        String name = "Ducky";
        // thong bao hien thi tren giao dien: 
        JOptionPane.showMessageDialog(null,"Name : " + name,"Title", JOptionPane.QUESTION_MESSAGE);
    }
    
}
