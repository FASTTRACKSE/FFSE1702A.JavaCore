package ui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.User;

public class UserInfo extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	JPasswordField txtPassword, txtRePassword;
	private User user;
	
	public UserInfo(User user) {
		this.user = user;
		addPanel();
	}
	
	private void addPanel() {

		Border bdrProfile = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttProfile = BorderFactory.createTitledBorder(bdrProfile, " Thông tin đăng nhập ");
		this.setBorder(bttProfile);

		JLabel lblName = new JLabel("Tên đăng nhập:");
		JLabel lblPassword = new JLabel("Mật khẩu:");
		JLabel lblRePassword = new JLabel("Nhập lại mật khẩu");
		
		txtName = new JTextField();
		txtName.setText(user.getUsername());
		txtName.setEditable(false);
		txtPassword = new JPasswordField();
		txtRePassword = new JPasswordField();

		GroupLayout lytProfile = new GroupLayout(this);
		this.setLayout(lytProfile);
		lytProfile.setAutoCreateGaps(true);
		lytProfile.setAutoCreateContainerGaps(true);
		lytProfile.setHorizontalGroup(lytProfile.createSequentialGroup()
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(lblName, 0, 80, Short.MAX_VALUE)
						.addComponent(lblPassword)
						.addComponent(lblRePassword)
				)
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(txtName)
						.addComponent(txtPassword)
						.addComponent(txtRePassword)
				)
		);

		lytProfile.setVerticalGroup(lytProfile.createSequentialGroup()
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtName)
				)
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword)
				)
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblRePassword)
						.addComponent(txtRePassword)
				)
		);

	}

}
