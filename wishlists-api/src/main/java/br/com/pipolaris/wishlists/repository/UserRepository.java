package br.com.pipolaris.wishlists.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pipolaris.wishlists.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name);
	List<User> findByEmail(String email);
}