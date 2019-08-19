package br.com.pipolaris.wishlists.controller.dto;

import java.util.List;

import br.com.pipolaris.wishlists.model.Item;
import br.com.pipolaris.wishlists.model.Wishlist;

public class WishlistDetailsDto {
	private Long id;
	private List<Item> item;
	private String userName;

	public WishlistDetailsDto(Wishlist wishlist) {
		this.id = wishlist.getId();
		this.item = wishlist.getItem();
		this.userName = wishlist.getUser().getName();
	}

	public Long getId() {
		return id;
	}

	public List<Item> getItem() {
		return item;
	}

	public String getUserName() {
		return userName;
	}
}