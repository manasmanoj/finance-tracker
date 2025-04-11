package com.ustg.financetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ustg.financetracker.entity.User;
import com.ustg.financetracker.repository.UserRepo;

@Service
public class UserService {
	// @Autowired
	// private PasswordEncoder pwe;

	// public String encodePassword(String password) {
	// return pwe.encode(password);

	// }

	@Autowired
	private UserRepo userrepo;

	public User save(User user) {
		// user.setPassWord(pwe.encode(user.getPassWord()));
		return userrepo.save(user);
	}

	public User getUserbyId(String id) {
		return userrepo.getById(id);
	}

	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

	public User Update(String id, User user) {
		Optional<User> u = userrepo.findById(id);
		User r = null;
		if (u.isPresent()) {
			User us = u.get();
			us.setPassWord(user.getPassWord());
			us.setMonthly_income(user.getMonthly_income());
			return us;
		}
		return r;
	}

	public void deleteById(String id) {
		userrepo.deleteById(id);
	}
}
