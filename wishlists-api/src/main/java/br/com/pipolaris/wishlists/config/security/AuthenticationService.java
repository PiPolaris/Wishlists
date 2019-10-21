package br.com.pipolaris.wishlists.config.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pipolaris.wishlists.model.User;
import br.com.pipolaris.wishlists.repository.UserRepository;


@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User usuario = repository.findByEmail(email).get(0);
		if (usuario.getUsername().equals(email)) {
			return (UserDetails) usuario;
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}
}
