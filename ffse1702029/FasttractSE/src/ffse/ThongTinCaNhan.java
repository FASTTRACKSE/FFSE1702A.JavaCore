package ffse;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import model.KetNoiSQL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.SwingConstants;

public class ThongTinCaNhan extends JPanel {
	
	private JLabel Id, Ten, Lop, NgaySinh, diaChi, sdt, email, diemcn, diemta, XepLoai, diemtong;
	private JPanel pnMain;
	Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029", "12345");

	public ThongTinCaNhan() {
		addPanels();
		addEvents();
	}

	private void addPanels() {

		pnMain = new JPanel();
		this.add(pnMain);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnTop = new JPanel();
		JPanel pnBot = new JPanel();
		
		pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.X_AXIS));
		pnMain.add(pnTop);
		JPanel pnTopleft = new JPanel();
		pnTopleft.setLayout(new BoxLayout(pnTopleft, BoxLayout.Y_AXIS));
		pnTopleft.setPreferredSize(new Dimension(300,0));
		
		JPanel pnTopright = new JPanel();
		pnTopright.setLayout(new BoxLayout(pnTopright, BoxLayout.Y_AXIS));
		pnTop.add(pnTopleft);
		pnTop.add(pnTopright);
//		pnBot.setLayout(new BoxLayout(pnBot, BoxLayout.X_AXIS));
		this.add(pnBot);

		Id = new JLabel("Mã sinh viên:");
		Id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopleft.add(Id);

		pnTopleft.add(Box.createVerticalStrut(15));

		Ten = new JLabel("Tên:");
		Ten.setFont(new Font("Tahoma",Font.PLAIN, 16));
		pnTopleft.add(Ten);

		pnTopleft.add(Box.createVerticalStrut(15));

		Lop = new JLabel("Lớp:");
		Lop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopleft.add(Lop);

		pnTopleft.add(Box.createVerticalStrut(15));

		NgaySinh = new JLabel("Ngày sinh:");
		NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopleft.add(NgaySinh);

		pnTopleft.add(Box.createVerticalStrut(15));

		diaChi = new JLabel("Địa chỉ:");
		diaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopleft.add(diaChi);
		
		pnTopleft.add(Box.createVerticalStrut(15));
		
		sdt = new JLabel("Số điện thoại:");
		sdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopleft.add(sdt);

		

		email = new JLabel("email:");
		email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopright.add(email);

		pnTopright.add(Box.createVerticalStrut(15));

		diemcn = new JLabel("Điểm công nghệ:");
		diemcn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopright.add(diemcn);

		pnTopright.add(Box.createVerticalStrut(15));

		diemta = new JLabel("Điểm tiếng anh:");
		diemta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopright.add(diemta);

		pnTopright.add(Box.createVerticalStrut(15));

		diemtong = new JLabel("Điểm tiếng anh:");
		diemtong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopright.add(diemtong);

		pnTopright.add(Box.createVerticalStrut(15));

		XepLoai = new JLabel("Xếp loại:");
		XepLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnTopright.add(XepLoai);
		
		JTextField pass = new JTextField();
		pnBot.add(pass);
		pass.setColumns(10);
		ImageIcon check = new ImageIcon(new ImageIcon("check.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		ImageIcon delete = new ImageIcon(new ImageIcon("delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		ImageIcon update = new ImageIcon(new ImageIcon("update.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JButton lbupdate = new JButton("Sửa  ", update);
		lbupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sqlupdate = "UPDATE admin SET Pass=? WHERE ID = '" + LoginHS.mahs + "' ";
				PreparedStatement pst = null;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sqlupdate);
					pst.setString(1, pass.getText());
					
					if (pst.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "sửa thành công", "sửa học sinh", JOptionPane.PLAIN_MESSAGE,
								check);
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi khi sửa ", "sửa học sinh", JOptionPane.PLAIN_MESSAGE,
								delete);
					}
				} catch (SQLException e) {
					System.out.println("insert error \n" + e.toString());
				}
			}
		});
		pnBot.add(lbupdate);
		
		String sql = "SELECT * FROM `admin` WHERE ID = '" + LoginHS.mahs + "'";
		ResultSet rs = null;
		java.sql.Statement st = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Id.setText("Mã Học Sinh: " + rs.getString("Masv"));
				Ten.setText("Họ & Tên: " + rs.getString("Name"));
				Lop.setText("Lớp: " + rs.getString("Lop"));
				NgaySinh.setText("Ngày sinh: " + rs.getString("Ngaysinh"));
				diaChi.setText("Địa chỉ: " + rs.getString("DiaChi"));
				sdt.setText("Số Điện Thoại: " + rs.getString("Phone"));
				email.setText("Email: " + rs.getString("Email"));
				diemcn.setText("Điểm công nghệ: " + rs.getString("Diem_CN"));
				diemta.setText("Điểm tiếng anh: " + rs.getString("Diem_TA"));
				diemtong.setText("Điểm tổng: " + rs.getString("Diem_Tong"));
				XepLoai.setText("Xếp loại: " + rs.getString("Xep_Loai"));

			}
		} catch (Exception ex) {

		} 

	}

	private void addEvents() {

	}
}
