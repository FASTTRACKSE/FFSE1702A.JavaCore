package javadesktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Buttondemo2 extends JFrame implements ActionListener {
    private static final JButton JButton = null;

    private JLabel label;

    private JButton button, button1;

    public void Buttondemo2() {
        this.setSize(400, 250);
        setVisible(true);
        setLocation(500, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Hello World");
        // label.setToolTipText("Hung dep choai");
        label.setSize(20, 50);
        add(label);
        // button:
        button = new JButton("Hit me");
        add(button, "North", 1);
        button.addActionListener(this);
        // button.addActionListener(new ActionListener() {
        //
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // // TODO Auto-generated method stub
        // changetext();
        // }
        // });
        button1 = new JButton("Hit me 1");
        add(button1, "South", 1);
        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton b = (JButton) e.getSource();
        if (b == button) {
////////////            label.setText("I am student");
        }
        if (b == button1) {
            label.setText("Welcom my class");
        }
    }

    public static void main(String args[]) {
        Buttondemo2 a = new Buttondemo2();
        a.Buttondemo2();
    }
}
