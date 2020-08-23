package br.com.ricas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricas.model.User;
import br.com.ricas.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.findAll();
	}

	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.save(user);
	}
}