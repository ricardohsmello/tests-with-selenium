package br.com.ricas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ricas.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
