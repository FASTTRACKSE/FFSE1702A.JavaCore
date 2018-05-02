package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Login extends JFrame {
	public Login(String tieude) {
		super(tieude);
		addControls();
		addEvents();

	}

	public void addControls() {

		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel img = new JPanel();
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("1.png").getImage().getScaledInstance(985, 540, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(imageIcon);
		img.add(label);

		JPanel de = new JPanel();
		JLabel pt = new JLabel("Đăng nhập thư viện điện tử");
		pt.setForeground(Color.BLUE);
		pt.setFont(new Font("Times New Roman", Font.BOLD, 33));
		pt.setHorizontalAlignment(SwingConstants.CENTER);
		de.add(pt);

		JPanel User = new JPanel();
		ImageIcon imguser = new ImageIcon(
				new ImageIcon("user.png").getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH));
		JLabel jLabelUser = new JLabel("User: ");
		JLabel iconUser = new JLabel(imguser);
		jLabelUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JTextField textUser = new JTextField(30);
		textUser.setPreferredSize(new Dimension(100, 40));
		User.add(iconUser);
		User.add(jLabelUser);
		User.add(textUser);

		JPanel Pass = new JPanel();
		ImageIcon imgpass = new ImageIcon(
				new ImageIcon("pass.png").getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH));
		JLabel jLabelPass = new JLabel("Pass: ");
		JLabel iconPass = new JLabel(imgpass);
		jLabelPass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JPasswordField textPass = new JPasswordField(30);
		textPass.setPreferredSize(new Dimension(100, 40));
		Pass.add(iconPass);
		Pass.add(jLabelPass);
		Pass.add(textPass);

		JPanel Button = new JPanel();
		ImageIcon imglg = new ImageIcon(
				new ImageIcon("a.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		jButtonLogin = new JButton("  Đăng nhập", imglg);
		jButtonLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jButtonLogin.setFocusPainted(false);
		// jButtonLogin.setBackground(new Color(0, 51, 204));
		// jButtonLogin.setForeground(new Color(255, 255, 255));
		Button.add(jButtonLogin);

		pnMain.add(img);
		pnMain.add(de);
		pnMain.add(User);
		pnMain.add(Pass);
		pnMain.add(Button);
		con.add(pnMain);
	}

	public void addEvents() {
		jButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
				Update myUI = new Update("Quản lý thư viện");
				myUI.showWindow();
			}
		});

	}

	public void showWindow() {
		// JFrame f = new JFrame();
		// try {
		// f.setContentPane(new JLabel(
		// new ImageIcon(ImageIO.read(new
		// File("seven_knight_wallpaper_by_rival100-db0jm82.png")))));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// f.setLayout(null);
		// f.setVisible(true);
		// f.pack();
		this.pack();
		this.setSize(1000, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login myUI = new Login("Quản lý thư viện");
					myUI.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private JButton jButtonLogin;
}
