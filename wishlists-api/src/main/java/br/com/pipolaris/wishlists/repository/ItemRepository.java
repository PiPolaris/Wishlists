package br.com.pipolaris.wishlists.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pipolaris.wishlists.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	Page<Item> findByWishlistId(Long wishId, Pageable paginacao);
}