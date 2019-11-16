package br.com.pipolaris.wishlists.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pipolaris.wishlists.controller.dto.LoginDto;
import br.com.pipolaris.wishlists.controller.dto.UserDetailsDto;
//import br.com.pipolaris.wishlists.config.security.TokenService;
//import br.com.pipolaris.wishlists.controller.dto.TokenDto;
import br.com.pipolaris.wishlists.controller.form.LoginForm;
import br.com.pipolaris.wishlists.model.User;
import br.com.pipolaris.wishlists.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class AuthenticationController {
//	@Autowired
//	private AuthenticationManager authManager;
//
//	@Autowired
//	private TokenService tokenService;

	@Autowired
	private UserRepository userRepository;

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<UserDetailsDto> autenticar(@RequestBody @Valid LoginForm form) {
		// UsernamePasswordAuthenticationToken dadosLogin = form.convert();

		try {
//			Authentication authentication = authManager.authenticate(dadosLogin);
//			String token = tokenService.gerarToken(authentication);
//			return ResponseEntity.ok(new TokenDto(token, "Bearer"));

			List<User> user = userRepository.findByEmail(form.getEmail());

			if (user.get(0).getPassword().equals(form.getSenha())) {
				return ResponseEntity.ok(new UserDetailsDto(user.get(0)));
			} else {
				return ResponseEntity.badRequest().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
