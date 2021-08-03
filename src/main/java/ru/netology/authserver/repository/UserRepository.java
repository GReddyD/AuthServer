package ru.netology.authserver.repository;

import ru.netology.authserver.Authorities;
import ru.netology.authserver.user.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

	//final Map<List<String>, List<Authorities>> userAuthList = new ConcurrentHashMap<>();
	final HashMap<User, List<Authorities>> userAuthList = new HashMap<>();

	public List<Authorities> getUserAuthorities(String user, String password) {

		List<Authorities> authUser1 = new ArrayList<>();
		List<Authorities> authUser2 = new ArrayList<>();
		List<Authorities> authUser3 = new ArrayList<>();
		authUser1.add(Authorities.DELETE);
		authUser2.add(Authorities.READ);
		authUser3.add(Authorities.WRITE);

		userAuthList.put(new User("Lily", "11111"), authUser1);
		userAuthList.put(new User("Joli", "22222"), authUser2);
		userAuthList.put(new User("Jon", "33333"), authUser3);

		return userAuthList.get(new User(user, password));
	}
}
