package br.com.pipolaris.wishlists.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	@Column(length = 1000)
	private String image;
	private String cloth;
	private String color;
	private String location;
	private Double price;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "wishlist_id", nullable = false)
	private Wishlist wishlist;
	private Long likes;
	@Column(length = 1000)
	private String url;

	public Item() {
	}

	public Item(String name, String description, String image, String cloth, String color, String location,
			Double price, Wishlist wishlist, Long likes) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.cloth = cloth;
		this.color = color;
		this.location = location;
		this.price = price;
		this.wishlist = wishlist;
		this.likes = likes;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}
}