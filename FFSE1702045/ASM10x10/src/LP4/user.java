package LP4;

import LP4.connect;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class user extends JFrame {
	Container con = getContentPane();
	static JButton logout = new JButton("Đăng Xuất");
	JButton ChangePass = new JButton("Đổi mật khẩu");
	JButton Luu = new JButton("Thay đổi");
	JButton Huy = new JButton("Huỷ");
	static JPasswordField oldPass, pass1, pass2;

	public user() {
		Controls();
		Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	public void Controls() {
		JPanel PanelMain = new JPanel();
		JPanel pass = new JPanel();
		JPanel JPanelinfo = new JPanel();
		JPanel JPanelHead = new JPanel();
		JPanel JPanelLogOut = new JPanel();
		JPanel JPanelInfoCon = new JPanel(); 	
		JPanel Choose = new JPanel();
		oldPass = new JPasswordField(20);
		pass1 = new JPasswordField(20);
		pass2 = new JPasswordField(20);

		PanelMain.add(JPanelinfo);
		JLabel JLabelID = new JLabel();
		JLabel JLabelName = new JLabel();
		JLabel JLabelUserName = new JLabel();
		JLabel JLabelPassWord = new JLabel();
		JLabel JLabelLevel = new JLabel();
		JLabel JLTitle = new JLabel();

		Border border = BorderFactory.createLineBorder(Color.black);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Thông Tin người dùng");

		JPanelLogOut.setBorder(borderTittle);

		JPanel JPanelInfoCon1 = new JPanel();
		JLabelID.setText("ID              :   " + Login.idString);
		JLabelName.setText("Họ Tên      :   " + Login.NameString);
		JLabelUserName.setText("Username  :   " + Login.UserNameString);
		JLabelLevel.setText("Level         :   " + Login.levelString);

		JPanelInfoCon1.setPreferredSize(new Dimension(650, 0));

		JLTitle.setFont(new java.awt.Font("Times New Roman", 1, 28));
		JLabelID.setFont(new java.awt.Font("Times New Roman", 1, 18));
		JLabelName.setFont(new java.awt.Font("Times New Roman", 1, 18));
		JLabelUserName.setFont(new java.awt.Font("Times New Roman", 1, 18));
		JLabelLevel.setFont(new java.awt.Font("Times New Roman", 1, 18));
		JPanelinfo.setLayout(new BoxLayout(JPanelinfo, BoxLayout.Y_AXIS));
		JPanelInfoCon.setLayout(new BoxLayout(JPanelInfoCon, BoxLayout.Y_AXIS));
		PanelMain.setLayout(new BoxLayout(PanelMain, BoxLayout.Y_AXIS));
		JPanelHead.setLayout(new BoxLayout(JPanelHead, BoxLayout.X_AXIS));
		pass.setLayout(new BoxLayout(pass, BoxLayout.Y_AXIS));
		pass.setVisible(false);
		
		ChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass.setVisible(true);
			}
		});
		Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pass1.getText().length() < 1 || pass1.getText().length() < 1) {
					JOptionPane.showMessageDialog(null, "mật khẩu không được để trống");
				} else {
					if (pass1.getText().equals(pass2.getText())) {
						connect.ChangePass();
						pass.setVisible(false);
						pass1.setText("");
						pass2.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "2 mật khẩu không trùng nhau");
					}
				}
			}
		});
		Huy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass.setVisible(false);
				pass1.setText("");
				pass2.setText("");
			}
		});
		JPanel JPanelpass1 = new JPanel();
		JPanel JPanelpass2 = new JPanel();

		JLabel JLabelpass1 = new JLabel("Mật khẩu mới");
		JLabel JLabelpass2 = new JLabel("Mật khẩu mới");

		JPanelpass1.add(JLabelpass1);
		JPanelpass1.add(pass1);

		JPanelpass2.add(JLabelpass2);
		JPanelpass2.add(pass2);

		Choose.add(Luu);
		Choose.add(Huy);

		pass.add(JPanelpass1);
		pass.add(JPanelpass2);
		pass.add(Choose);

		JPanelinfo.add(JLabelID);
		JPanelinfo.add(JLabelName);
		JPanelinfo.add(JLabelUserName);
		JPanelinfo.add(JLabelPassWord);
		JPanelinfo.add(JLabelLevel);
		JPanelInfoCon.add(JPanelinfo);

		JPanelLogOut.add(JPanelInfoCon);
		JPanelLogOut.add(JPanelInfoCon1);
		JPanelLogOut.add(ChangePass);
		JPanelLogOut.add(logout);

		JPanelHead.add(JPanelLogOut);
		JPanelInfoCon.add(pass);
		PanelMain.add(JPanelHead);
		con.add(PanelMain);

	}

}
