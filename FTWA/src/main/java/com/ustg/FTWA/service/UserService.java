package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserByUsername(String username) {
		return userRepository.findById(username);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(String username, User updatedUser) {
		return userRepository.findById(username)
				.map(user -> {
					user.setPassWord(updatedUser.getPassWord());
					user.setMonthly_income(updatedUser.getMonthly_income());
					return userRepository.save(user);
				})
				.orElseGet(() -> {
					updatedUser.setUsername(username);
					return userRepository.save(updatedUser);
				});
	}

	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}
}