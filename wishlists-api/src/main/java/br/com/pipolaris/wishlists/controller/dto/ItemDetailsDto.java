package br.com.pipolaris.wishlists.controller.dto;

import br.com.pipolaris.wishlists.model.Item;

public class ItemDetailsDto {
	private Long id;
	private String name;
	private String description;
	private String image;
	private String cloth;
	private String color;
	private String location;
	private Double price;
	private long likes;

	public ItemDetailsDto(Item item) {
		this.id = item.getId();
		this.name = item.getName();
		this.description = item.getDescription();
		this.image = item.getImage();
		this.cloth = item.getCloth();
		this.color = item.getColor();
		this.location = item.getLocation();
		this.price = item.getPrice();
		this.likes = item.getLikes();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public String getCloth() {
		return cloth;
	}

	public String getColor() {
		return color;
	}

	public String getLocation() {
		return location;
	}

	public Double getPrice() {
		return price;
	}

	public long getLikes() {
		return likes;
	}

}
