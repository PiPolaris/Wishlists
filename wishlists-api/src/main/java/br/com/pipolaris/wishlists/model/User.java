package br.com.pipolaris.wishlists.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User {

	private static final long serialVersionUID = 1638799445587638911L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;

	@ManyToMany
	@JoinTable(name = "friends", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "friendId"))
	private List<User> friendsOf;

	@ManyToMany
	@JoinTable(name = "friends", joinColumns = @JoinColumn(name = "friendId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<User> friends;

	public User() {

	}

//	@ManyToMany(fetch = FetchType.EAGER)
//	private List<Perfil> perfis = new ArrayList<>();

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(User friendsOf, User friends) {
		this.friendsOf.add(friendsOf);
		this.friends.add(friends);
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public List<User> getFriendsOf() {
		return friendsOf;
	}

	public void setFriendsOf(List<User> friendsOf) {
		this.friendsOf = friendsOf;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return this.perfis;
//	}
//
//	@Override
//	public String getPassword() {
//		return this.password;
//	}
//
//	@Override
//	public String getUsername() {
//		return this.email;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}

}