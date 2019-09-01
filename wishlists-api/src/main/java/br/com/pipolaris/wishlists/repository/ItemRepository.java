package br.com.pipolaris.wishlists.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pipolaris.wishlists.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByName(String name);
}