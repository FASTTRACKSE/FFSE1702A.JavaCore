package javadesktop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Giaiptbac1 extends JFrame implements ActionListener{
    JFrame f;
    private Float a, b,x1;
    private JLabel tt, lba, lbb, lbketqua;
    private JTextField tfa, tfb, tfketqua;
    private JButton btketqua, btthoat, bthelp;
    
    public void Giaiptbac1() {
        //nhap tieu de
        f=new JFrame("LOG IN FORM");
//        frame.setTitle("JFrame Demo");
        this.setSize(400,400);
   
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        tt = new JLabel("Giải Phương trình bậc 1 ");
        tt.setForeground(Color.RED);
        tt.setSize(50, 50);
        tt.setBounds(100,30,200,70);
        this.add(tt);
        // nhap a:
        lba = new JLabel("Hệ số a:");
        lba.setBounds(20,100,80,30);
        tfa = new JTextField();
        tfa.setBounds(100,100,200,30);
        this.add(lba);
        this.add(tfa);
        // nhap b:
        lbb =  new JLabel("Hệ số b");
        lbb.setBounds(20,150,80,30);
        tfb = new JTextField();
        tfb.setBounds(100,150,200,30);
        this.add(lbb);
        this.add(tfb);
        //3 button chúc năng:
        btketqua = new JButton("Giải");
        btketqua.setBounds(40,200,70,40);
        btketqua.addActionListener(this);
        this.add(btketqua);
        //thoat:
             btthoat = new JButton("Thoat");
  //           ImageIcon icon = new ImageIcon("turnoff.jpg");
 //            btthoat.setIcon(icon);
             btthoat.setBounds(150,200,70,40);
             btthoat.addActionListener(this);
             this.add(btthoat);
         //help
             bthelp = new JButton("Help");
             bthelp.setBounds(260,200,70,40);
             bthelp.addActionListener(this);
             this.add(bthelp);
        lbketqua = new JLabel("Kết quả");
        lbketqua.setBounds(20,260,80,30);
        tfketqua = new JTextField();
        tfketqua.setBounds(100,260,200,30);
        this.add(lbketqua);
        this.add(tfketqua);
        this.setVisible(true);
              
    }
       @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
           Float a = Float.parseFloat(tfa.getText());
           Float b = Float.parseFloat(tfb.getText());
           JButton bt = (JButton) e.getSource();
      if(bt == btketqua) {
          if(a ==0) {
              if(b==0) {
                  tfketqua.setText("Phương trình vô số nghiệm");
              }
              if(b != 0) {
                  tfketqua.setText(" phương trình vô nghiệm");
              }
          }
          else {
              tfketqua.setText("Phương trình có nghiệm x = " + (-b/a));
          }
      }
      if(bt  == btthoat) {
          System.exit(0);
      }
      if(bt == bthelp) {
          String name = " Chúng tôi dang cố gắng hoàn thiện chương trình sớm nhất";  
          JOptionPane.showMessageDialog(null,"Name : " + name,"mr.hung", JOptionPane.QUESTION_MESSAGE);
      }
        
    }
    public static void main(String args[]) {
        Giaiptbac1 ptb1 =  new Giaiptbac1();
        ptb1.Giaiptbac1();
    }
}
