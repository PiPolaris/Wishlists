package br.com.pipolaris.wishlists.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.pipolaris.wishlists.model.Item;
import br.com.pipolaris.wishlists.model.Wishlist;
import br.com.pipolaris.wishlists.repository.ItemRepository;
import br.com.pipolaris.wishlists.repository.WishlistRepository;

public class ItemForm {
	@NotNull
	private long wishlistId;
	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String name;
	private String description = "";
	private String image;
	private String cloth;
	private String color;
	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String location;
	@NotNull
	private Double price;
	private long likes = 0;
	private String url;

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCloth() {
		return cloth;
	}

	public void setCloth(String cloth) {
		this.cloth = cloth;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Item convert(ItemForm itemForm, WishlistRepository wishlistRepository) {
		Wishlist wishlist = wishlistRepository.getOne(wishlistId);
		return new Item(itemForm.name, itemForm.description, itemForm.image, itemForm.cloth, itemForm.color,
				itemForm.location, itemForm.price, wishlist, itemForm.likes);
	}

	public Item update(Long id, ItemRepository itemRepository) {
		Item item = itemRepository.getOne(id);
		item.setCloth(this.cloth);
		item.setColor(this.color);
		item.setDescription(this.description);
		item.setImage(this.image);
		item.setLocation(this.location);
		item.setName(this.name);
		item.setPrice(this.price);
		item.setLikes(this.likes);
		return item;
	}

}
