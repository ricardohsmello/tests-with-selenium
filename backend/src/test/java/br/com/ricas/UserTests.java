package br.com.ricas;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.ricas.model.User;
import br.com.ricas.repository.UserRepository;
import br.com.ricas.service.UserService;

public class UserTests {

	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllUsersTest() {

		List<User> list = new ArrayList<>();

		User ricardo = new User("Ricardo", "ricas@gmail.com");
		User henrique = new User("Henrique", "henrique@gmail.com");
		User silva = new User("Silva", "silva@gmail.com");
		User mello = new User("Mello", "mello@gmail.com");

		list.add(ricardo);
		list.add(henrique);
		list.add(silva);
		list.add(mello);

		when(userRepository.findAll()).thenReturn(list);

		List<User> empList = userService.findAll();
		assertEquals(4, empList.size());

		verify(userRepository, times(1)).findAll();
	}

	@Test
	public void shouldCreateAnUser() {
		User user = new User("New user", "new@user.com");
		userService.save(user);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void getUserByIdTest() {
		Optional<User> user = Optional.of(new User("New user", "new@user.com"));

		when(userRepository.findById(1l)).thenReturn(user);
		Optional<User> newUser = userService.findById(1L);

		assertEquals("New user", newUser.get().getName());
		assertEquals("new@user.com", newUser.get().getEmail());
	}

}
