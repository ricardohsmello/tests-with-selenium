package br.com.ricas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ricas.model.User;
import br.com.ricas.repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}	

}
