package br.com.pipolaris.wishlists.controller.dto;

import org.springframework.data.domain.Page;

import br.com.pipolaris.wishlists.model.Item;

public class ItemDto {
	private Long id;
	private String name;
	private String description;
	private Long wishlistId;
	private String image;
	private long likes;
	private double price;
	private String url;

	public ItemDto(Item item) {
		this.id = item.getId();
		this.name = item.getName();
		this.description = item.getDescription();
		this.wishlistId = item.getWishlist().getId();
		this.image = item.getImage();
		this.likes = item.getLikes();
		this.price = item.getPrice();
		this.url = item.getUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public static Page<ItemDto> convert(Page<Item> items) {
		return items.map(ItemDto::new);
	}
}
