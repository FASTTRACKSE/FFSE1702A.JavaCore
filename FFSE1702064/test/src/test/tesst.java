ActionListener evLogin = new ActionListener() {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (conn != null) {
				String sql = "SELECT * FROM admin WHERE admin=? and Password=?";

				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

					ptmt.setString(1, txtTK.getText());
					ptmt.setString(2, jPassword.getText());

					ResultSet rs = ptmt.executeQuery();

					if (rs.next()) {

						if (rs.getString("admin").equals("qttv14193") && rs.getString("Password").equals("87172195")) {
							PhieuMuon_UI phieu = new PhieuMuon_UI("Phiếu mượn");
							phieu.setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

						}
					} else {
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu chưa đúng!");
					}
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());

				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}

	}