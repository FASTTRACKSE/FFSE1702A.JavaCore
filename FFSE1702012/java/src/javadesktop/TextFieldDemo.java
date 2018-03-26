package javadesktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TextFieldDemo extends JFrame implements ActionListener{
        private JTextField tfName;
        private JButton button;
    
    public void TextFieldDemo() {
       this.setSize(300,200);
        setVisible(true);
        setResizable(true);
        setLocation(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tfName =  new JTextField();
        add(tfName, "North",0);
        button =  new JButton("hit me");
        add(button, "South", 0);    
        button.addActionListener(this);
    }
    public static void main(String args[]) {
        TextFieldDemo text =  new TextFieldDemo();
        text.TextFieldDemo(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton b = (JButton) e.getSource();
        if(b == button) {
            //JOptionPane.showMessageDialog(null,tfName.getText());
            tfName.setText("Hung dep chai");
        }
    }
}
