package br.com.pipolaris.wishlists.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pipolaris.wishlists.controller.dto.UserDetailsDto;
import br.com.pipolaris.wishlists.controller.dto.UserDto;
import br.com.pipolaris.wishlists.controller.form.UpdateUserForm;
import br.com.pipolaris.wishlists.controller.form.UserForm;
import br.com.pipolaris.wishlists.model.User;
import br.com.pipolaris.wishlists.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
	public List<UserDto> list(String userName, String email) {
		if (userName == null && email == null) {
			List<User> users = userRepository.findAll();
			return UserDto.convert(users);
		} else if (email == null){
			List<User> users = userRepository.findByName(userName);
			return UserDto.convert(users);
		} else {
			List<User> users = userRepository.findByEmail(email);
			return UserDto.convert(users);
		}
	}
    
    @PostMapping
	@Transactional
	public ResponseEntity<UserDto> create(@RequestBody @Valid UserForm form,
			UriComponentsBuilder uriComponentsBuilder) {
		User user = new User(form.getName(), form.getEmail(), form.getPassword());
		userRepository.save(user);

		URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDto(user));
	}
    
    @GetMapping("/{id}")
	public ResponseEntity<UserDetailsDto> detail(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
			return ResponseEntity.ok(new UserDetailsDto(user.get()));
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid UpdateUserForm form) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			User user = form.update(id, userRepository);
			return ResponseEntity.ok(new UserDto(user));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}