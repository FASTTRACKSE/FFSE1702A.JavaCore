package atm_model;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class Session_model {
	
	private static String loginName;
	private static int snCard;

	public Session_model() {
		this.loginName = "";
		this.snCard = 0;
	}
	
	public static String getLoginName() {
		return loginName;
	}

	public static void setLoginName(String loginName) {
		Session_model.loginName = loginName;
	}

	public static int getSnCard() {
		return snCard;
	}

	public static void setSnCard(int atmCard) {
		Session_model.snCard = atmCard;
	}
}
