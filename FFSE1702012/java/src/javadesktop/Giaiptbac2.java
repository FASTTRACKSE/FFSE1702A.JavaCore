package javadesktop;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Hoang
 */
public class Giaiptbac2 extends JFrame implements ActionListener {
    private static GraphicsConfiguration ptb2;

    public float a, b, c, x1, x2;

    public JLabel lba, lbb, lbc, lbketqua;

    public JTextField tfa, tfb, tfc;

    public JButton btketqua, btthoat;

Giaiptbac2() {
            //super(“giai ptb2 “);
            setLocation(200, 100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new GridLayout(5, 2));
            lba = new JLabel(“Nhap a= “);
            this.add(lba);
            tfa = new JTextField();
            this.add(tfa);
            lbb = new JLabel(“Nhap b= “);
            this.add(lbb);
            tfb = new JTextField();
            this.add(tfb);
            lbc = new JLabel(“Nhap c= “);
            this.add(lbc);
            tfc = new JTextField();
            this.add(tfc);
            lbketqua = new JLabel(“Ket qua= “);
            this.add(lbketqua);
//            this.add(new JLabel());
            btketqua = new JButton(“Ket qua”);
            btketqua.addActionListener(this);
            this.add(btketqua);
            btthoat = new JButton(“Thoat”);
            btthoat.addActionListener(this);
            this.add(btthoat);
            }
            
            public void tinhDelta(float a, float b, float c) {
            this.a = a;
            this.b = b;
            this.c = c;
            float delta;
            delta = b * b – 4 * a * c;
            if (delta == 0) {
            lbketqua.setText(“phuong trinh co nghiem kep: ” + String.valueOf(-b / (2 * a)));
            } else if (delta < 0) {
            lbketqua.setText(“phuong trinh vo nghiem”);
            } else {
            lbketqua.setText(“phuong trinh co hai nghiem phan biet”);
            x1 = (float) ((-b – sqrt(delta)) / (2 * a));
            x2 = (float) ((-b + sqrt(delta)) / (2 * a));
            lbketqua.setText(” x1= ” + String.valueOf(x1) + ” x2= ” + String.valueOf(x2));
            }
}

    public static void main(String[] args) {
        Giaiptbac2 ptb2 = new Giaiptbac2();
        ptb2.setVisible(true);
        ptb2.setSize(400, 300);
    }

@Override
public void actionPerformed(ActionEvent e) {
                float a = Float.parseFloat(tfa.getText());
                float b = Float.parseFloat(tfb.getText());
                float c = Float.parseFloat(tfc.getText());
                float ketqua = 0;
                if (e.getSource() == btketqua) {
                if (a == 0) {
                if (b == 0) {
                if (c == 0) {
                lbketqua.setText(“phuong trinh vo so nghiem”);
                } else {
                lbketqua.setText(“phuong trinh vo nghiem”);
                }
                } else {
                lbketqua.setText(“phuong trinh co nghiem :” + String.valueOf(-c / b));
                }
                } else {
                tinhDelta(a, b, c);
                }
                }
                if (e.getSource() == btthoat) {
                System.exit(0);
                }
}
}