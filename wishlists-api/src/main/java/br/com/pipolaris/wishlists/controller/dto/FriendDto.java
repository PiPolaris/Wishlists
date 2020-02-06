package br.com.pipolaris.wishlists.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pipolaris.wishlists.model.Friend;
import br.com.pipolaris.wishlists.model.User;

public class FriendDto {
	private Long friends;
	private Long friendsOf;

	public Long getFriends() {
		return friends;
	}

	public void setFriends(Long friends) {
		this.friends = friends;
	}

	public Long getFriendsOf() {
		return friendsOf;
	}

	public void setFriendsOf(Long friendsOf) {
		this.friendsOf = friendsOf;
	}

	public FriendDto(Friend friend) {
		this.friendsOf = friend.getFriendsOf().getId();
		this.friends = friend.getFriends().getId();
	}

	public static List<FriendDto> convert(List<Friend> friends) {
		return friends.stream().map(FriendDto::new).collect(Collectors.toList());
	}
}