package ru.netology.authserver.controller;

import ru.netology.authserver.Authorities;
import ru.netology.authserver.exception.InvalidCredentials;
import ru.netology.authserver.exception.UnauthorizedUser;
import ru.netology.authserver.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
	AuthorizationService service;

	public AuthorizationController(AuthorizationService service) {
		this.service = service;
	}

	@GetMapping("/authorize")
	public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
		return service.getAuthorities(user, password);
	}

	@ExceptionHandler(InvalidCredentials.class)
	ResponseEntity<String> handle(InvalidCredentials e) {
		return new ResponseEntity<>("Error 400: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnauthorizedUser.class)
	ResponseEntity<String> handle(UnauthorizedUser e) {
		System.out.println("Error 401: " + e.getMessage());
		return new ResponseEntity<>("Error 401: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
	}
}

