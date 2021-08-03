package ru.netology.authserver.user;

import org.springframework.validation.annotation.Validated;

@Validated
public class User {

	private String userName;
	private String userPassword;

	public User(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User{" +
						"userName='" + userName + '\'' +
						", userPassword='" + userPassword + '\'' +
						'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;

		User user = (User) o;

		if (!getUserName().equals(user.getUserName())) return false;
		return getUserPassword().equals(user.getUserPassword());
	}

	@Override
	public int hashCode() {
		int result = getUserName().hashCode();
		result = 31 * result + getUserPassword().hashCode();
		return result;
	}
}
