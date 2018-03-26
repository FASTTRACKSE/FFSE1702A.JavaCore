package javadesktop;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Giaiptb2 extends JFrame implements ActionListener {
  //  private static GraphicsConfiguration ptb2;
    private  float a, b, c, x1, x2;
    private JLabel lba, lbb, lbc, lbketqua;
    private JTextField tfa, tfb, tfc;
    private JButton btketqua, btthoat;
    
    public void Giaiptbac2() {
//       super("giai ptb2");
        setSize(400,300);
        setVisible(true);
       setLocation(200, 100);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      thiết lập 5 hàng 2 cọt cho GridLayout:
       this.setLayout(new GridLayout(5, 2));
//       nhap a
       lba =  new JLabel("Nhap a =");
       tfa =  new JTextField();
       this.add(lba);
       this.add(tfa);
//       nhap b  
       lbb = new JLabel("Nhập b =");
       tfb = new JTextField();
       this.add(lbb);
       this.add(tfb);
//       nhap c
       lbc = new JLabel("Nhập c");
       tfc = new JTextField();
       this.add(lbc);
       this.add(tfc);
//       ket qua
       lbketqua = new JLabel("Kết quả = ");
       this.add(lbketqua);
//       action
       btketqua = new JButton("Kết quả");
       btketqua.addActionListener(this);
       this.add(btketqua);
       btthoat = new JButton("Exit");
       btthoat.addActionListener(this);
       this.add(btthoat);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        float a = Float.parseFloat(tfa.getText());
        float b = Float.parseFloat(tfb.getText());
        float c = Float.parseFloat(tfc.getText());
//        float ketqua = 0;
        JButton button = (JButton) e.getSource();
        if (button == btketqua) {
                if (a == 0) {
                        if (b == 0) {
                                if (c == 0) {
                                lbketqua.setText("Phương trình vô số nghiệm");
                                } else {
                                lbketqua.setText("Phương trình vô nghiệm");
                                }
                        } else {
                        lbketqua.setText("Phương trinh co nghiệm" + String.valueOf(-c / b));
                        }
                } else {
                tinhDelta(a, b, c);
                }
            }
            if (button == btthoat) {
            System.exit(0);
            }
    }
    //constructor tinh toan delta:
    public void tinhDelta(float a,float b,float c) {
        this.a =  a;
        this.b = b;
        this.c = c;
        float delta;
        delta = b*b - 4*a*c;
        if(delta == 0) {
            // String.valueOf() trả về biểu diễn chuổi của tham số truyền vào:
            lbketqua.setText("Phương trình có nghiệm kép" + String.valueOf(-b/(2*a)));
        }else if(delta <0) {
            lbketqua.setText("Phương trình vô nghiệm");
        }else if(delta >0 ) {
            lbketqua.setText("Phương trình có 2 nghiệm" + " x1 = " + String.valueOf(x1) + "  x2 = " + String.valueOf(x2));
        }
        
    }
    // main chinh de hoa dong
    public static void main(String args[]) {
        Giaiptb2 ptb2 =  new Giaiptb2();
        ptb2.Giaiptbac2();
    }
    
}
