package javadesktop;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.omg.PortableServer.ServantRetentionPolicyValue;

public class Label_Demo extends JFrame {
    public  void Label_Demo() {
        //thiet lap kich thuoc
        this.setSize(200,150);
        setVisible(true);
        //thiet lap vi tri xuat hien
        setLocation(200, 200);
        //thiet lap kha nang thay doi kich thuoc
        setResizable(false);
        //thiet lap label
        JLabel label = new JLabel("Hello World");
        add(label);
        label.setText("Hùng");
        label.setToolTipText("Vô cùng đẹp trai");           // chú giải:
        label.setForeground(Color.blue);                    // set màu chử:
        }

    public static void main(String args[]) {
        Label_Demo label_demo = new Label_Demo();
        label_demo.Label_Demo();
    }
}
