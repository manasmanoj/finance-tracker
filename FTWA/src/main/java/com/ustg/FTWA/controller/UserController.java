package com.ustg.FTWA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/user")
	public User create(@RequestBody User user) {
		return userservice.save(user);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable String id) {
		return userservice.getUserbyId(id);
	}

	@GetMapping
	public List<User> getallUsers() {
		return userservice.getAllUsers();
	}

	@PutMapping("/{id}")
	public User update(@PathVariable String id, @RequestBody User user) {
		return userservice.Update(id, user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		userservice.deleteById(id);
	}

}
