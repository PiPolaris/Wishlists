package br.com.pipolaris.wishlists.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pipolaris.wishlists.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {
	Optional<Friend> findById(Long id);
}