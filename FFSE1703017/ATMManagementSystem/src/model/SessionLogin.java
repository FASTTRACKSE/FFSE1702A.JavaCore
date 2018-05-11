package model;

public class SessionLogin {
	private static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		SessionLogin.user = user;
	}
}
