package br.com.ricas;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.ricas.model.User;
import br.com.ricas.repository.UserRepository;

@SpringBootApplication
public class TestsWithSeleniumApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsWithSeleniumApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("Rodolfo", "Rodrigo", "Julia", "Fernanda", "Marcos", "Ricardo").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@domain.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}
 
}
