package ru.netology.authserver.exception;

public class InvalidCredentials extends RuntimeException {
	public InvalidCredentials(String msg) {
		super(msg);
	}
}