package br.com.pipolaris.wishlists.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pipolaris.wishlists.controller.dto.WishlistDetailsDto;
import br.com.pipolaris.wishlists.controller.dto.WishlistDto;
import br.com.pipolaris.wishlists.controller.form.WishlistForm;
import br.com.pipolaris.wishlists.model.Wishlist;
import br.com.pipolaris.wishlists.repository.UserRepository;
import br.com.pipolaris.wishlists.repository.WishlistRepository;

@RestController
@RequestMapping("/wishlists")
public class WishlistController {
	@Autowired
    private WishlistRepository wishlistRepository;
	
	@Autowired
	private UserRepository userRepository;

    @GetMapping
	public List<WishlistDto> list(String userName) {
		if (userName == null) {
			List<Wishlist> wishlists = wishlistRepository.findAll();
			return WishlistDto.convert(wishlists);
		} else {
			List<Wishlist> wishlist = wishlistRepository.findByUserName(userName);
			return WishlistDto.convert(wishlist);
		}
	}
    
    @PostMapping
	@Transactional
	public ResponseEntity<WishlistDto> create(@RequestBody @Valid WishlistForm form,
			UriComponentsBuilder uriComponentsBuilder) {
		Wishlist wishlist = form.convert(userRepository);
		wishlistRepository.save(wishlist);

		URI uri = uriComponentsBuilder.path("/wishlists/{id}").buildAndExpand(wishlist.getId()).toUri();
		return ResponseEntity.created(uri).body(new WishlistDto(wishlist));
	}
    
    @GetMapping("/{id}")
	public ResponseEntity<WishlistDetailsDto> detail(@PathVariable Long id) {
		Optional<Wishlist> wishlist = wishlistRepository.findById(id);
		if (wishlist.isPresent())
			return ResponseEntity.ok(new WishlistDetailsDto(wishlist.get()));
		return ResponseEntity.notFound().build();
	}
}
