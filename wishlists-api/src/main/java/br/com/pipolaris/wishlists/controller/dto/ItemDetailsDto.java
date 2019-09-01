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
    
	public ItemDetailsDto(Item item) {
		super();
		this.id = item.getId();
		this.name = item.getName();
		this.description = item.getDescription();
		this.image = item.getImage();
		this.cloth = item.getCloth();
		this.color = item.getColor();
		this.location = item.getLocation();
		this.price = item.getPrice();
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
    
    
}
