package br.com.pipolaris.wishlists.controller.dto;

import br.com.pipolaris.wishlists.model.User;

public class UserDetailsDto {
	private Long id;
	private String name;
	private String email;
	private String password;

	public UserDetailsDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
