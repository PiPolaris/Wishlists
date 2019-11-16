package br.com.pipolaris.wishlists.controller.dto;

public class LoginDto {
	private UserDetailsDto user;

	public LoginDto(UserDetailsDto user) {
		this.user = user;
	}

	public UserDetailsDto getUser() {
		return user;
	}

	public void setUser(UserDetailsDto user) {
		this.user = user;
	}
}
