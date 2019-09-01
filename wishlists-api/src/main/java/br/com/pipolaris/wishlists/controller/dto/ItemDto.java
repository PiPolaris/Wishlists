package br.com.pipolaris.wishlists.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pipolaris.wishlists.model.Item;

public class ItemDto {
	private Long id;
    private String name;
    private String description;
    
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
	public ItemDto(Item item) {
		this.id = item.getId();
		this.name = item.getName();
		this.description = item.getDescription();
	}
    
	public static List<ItemDto> convert(List<Item> items) {
		return items.stream().map(ItemDto::new).collect(Collectors.toList());
	}
}
