package br.com.pipolaris.wishlists.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pipolaris.wishlists.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long>{
	List<Wishlist> findByUserName(String name);
}
