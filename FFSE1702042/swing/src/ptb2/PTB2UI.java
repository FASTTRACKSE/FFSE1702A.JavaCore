package ptb2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.*;

public class PTB2UI extends JFrame {

private static final long serialVersionUID = 1L;

public PTB2UI(String title)

{

setTitle(title);

}

public void doShow()

{

setSize(400, 300);

setLocationRelativeTo(null);

setDefaultCloseOperation(EXIT_ON_CLOSE);

addControl();

setResizable(false);

setVisible(true);

}

public void addControl()

{

JPanel pnBorder=new JPanel();

pnBorder.setLayout(new BorderLayout());

JPanel pnNorth=new JPanel();

JLabel lblTitle=new JLabel("Giải phương trình bậc 2");

pnNorth.add(lblTitle);

pnBorder.add(pnNorth,BorderLayout.NORTH);

lblTitle.setForeground(Color.BLUE);

Font ft=new Font("arial", Font.BOLD, 25);

lblTitle.setFont(ft);

JPanel pnSouth=new JPanel();

JButton btnGiai=new JButton("Giải");

JButton btnXoa=new JButton("Xóa");

JButton btnThoat=new JButton("Thoát");

pnSouth.add(btnGiai);

pnSouth.add(btnXoa);

pnSouth.add(btnThoat);

pnBorder.add(pnSouth,BorderLayout.SOUTH);

pnSouth.setBackground(Color.LIGHT_GRAY);

Border  southborder

=BorderFactory.createLineBorder(Color.RED);

TitledBorder southTitleBorder=

new TitledBorder(southborder, "Chọn tác vụ");

pnSouth.setBorder(southTitleBorder);

JPanel pnCenter=new JPanel();

pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

pnBorder.add(pnCenter,BorderLayout.CENTER);

Border  centerborder

=BorderFactory.createLineBorder(Color.RED);

TitledBorder centerTitleBorder=

new TitledBorder(centerborder, "nhập a – b- c:");

pnCenter.setBorder(centerTitleBorder);

JPanel pna=new JPanel();

JLabel lbla=new JLabel("nhập a:");

final JTextField txta=new  JTextField(15);

pna.add(lbla);

pna.add(txta);

pnCenter.add(pna);

JPanel pnb=new JPanel();

JLabel lblb=new JLabel("nhập b:");

final JTextField txtb=new  JTextField(15);

pnb.add(lblb);

pnb.add(txtb);

pnCenter.add(pnb);

JPanel pnc=new JPanel();

JLabel lblc=new JLabel("nhập c:");

final JTextField txtc=new  JTextField(15);

pnc.add(lblc);

pnc.add(txtc);

pnCenter.add(pnc);

JPanel pnkq=new JPanel();

JLabel lblkq=new JLabel("kết quả nè:");

final JTextField txtkq=new  JTextField(15);

pnkq.add(lblkq);

pnkq.add(txtkq);

pnCenter.add(pnkq);

lbla.setPreferredSize(lblkq.getPreferredSize());

lblb.setPreferredSize(lblkq.getPreferredSize());

lblc.setPreferredSize(lblkq.getPreferredSize());

btnThoat.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {

int ret=JOptionPane.showConfirmDialog(null, "Muốn thoát hả?", "Thoát", JOptionPane.YES_NO_OPTION);

if(ret==JOptionPane.YES_OPTION)

System.exit(0);

}

});

btnXoa.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {

txtb.setText("");

txtc.setText("");

txtkq.setText("");

txta.requestFocus();

}

});

btnGiai.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {

String sa=txta.getText();

int a=0,b=0,c=0;

try

{

a=Integer.parseInt(sa);

}

catch(Exception ex)

{

JOptionPane.showMessageDialog(null, "Nhập sai định dạng!");

txta.selectAll();

txta.requestFocus();

return;

}

String sb=txtb.getText();

try

{

b=Integer.parseInt(sb);

}

catch(Exception ex)

{

JOptionPane.showMessageDialog(null, "Nhập sai định dạng!");

txtb.selectAll();

txtb.requestFocus();

return;

}

String sc=txtc.getText();

try

{

c=Integer.parseInt(sc);

}

catch(Exception ex)

{

JOptionPane.showMessageDialog(null, "Nhập sai định dạng!");

txtc.selectAll();

txtc.requestFocus();

return;

}

String kq="";

PTB2Engine engine=new PTB2Engine(a, b, c);

kq=engine.compute();

txtkq.setText(kq);

}

});

Container con=getContentPane();

con.add(pnBorder);

}

public static void main(String[] args) {

PTB2UI ui=new PTB2UI("ptb2");

ui.doShow();

}

}


