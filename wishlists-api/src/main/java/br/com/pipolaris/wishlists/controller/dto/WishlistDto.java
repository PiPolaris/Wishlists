package br.com.pipolaris.wishlists.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pipolaris.wishlists.model.Wishlist;

public class WishlistDto {
	private Long id;
	private String user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public WishlistDto(Wishlist wishlist) {
		this.id = wishlist.getId();
		this.user = wishlist.getUser().getName();
	}
	
	public static List<WishlistDto> convert(List<Wishlist> wishlists) {
		return wishlists.stream().map(WishlistDto::new).collect(Collectors.toList());
	}
}
