package ru.netology.authserver.exception;

public class UnauthorizedUser extends RuntimeException {
	public UnauthorizedUser(String msg) {
		super(msg);
	}
}
