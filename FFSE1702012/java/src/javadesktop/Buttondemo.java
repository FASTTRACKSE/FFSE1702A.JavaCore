package javadesktop;

    import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;

public class Buttondemo  extends JFrame implements ActionListener
{
    private JLabel label;
       public void Buttondemo() {
           this.setSize(400,250);
           setVisible(true);
           setLocation(500, 350);
           setResizable(false);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            label = new JLabel("Hello World");
//           label.setToolTipText("Hung dep choai");
           label.setSize(20, 50);
           add(label);
           JButton button = new JButton("Hit me");
           add(button, "North",1);
           button.addActionListener(this);            
          }
//       public void changetext() {
//           label.setText("I am a studfdhdhgent");
//       }
       public static void main(String args[]) {
           Buttondemo button = new Buttondemo();
           button.Buttondemo();
       }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        label.setText("I am Student");
    }
}
