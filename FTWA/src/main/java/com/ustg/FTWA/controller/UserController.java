package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{username}")
	public Optional<User> getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{username}")
	public User updateUser(@PathVariable String username, @RequestBody User user) {
		return userService.updateUser(username, user);
	}

	@DeleteMapping("/{username}")
	public void deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
	}
}