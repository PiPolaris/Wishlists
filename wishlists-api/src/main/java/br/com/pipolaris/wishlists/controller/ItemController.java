package br.com.pipolaris.wishlists.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pipolaris.wishlists.controller.dto.ItemDetailsDto;
import br.com.pipolaris.wishlists.controller.dto.ItemDto;
import br.com.pipolaris.wishlists.controller.form.ItemForm;
import br.com.pipolaris.wishlists.model.Item;
import br.com.pipolaris.wishlists.repository.ItemRepository;
import br.com.pipolaris.wishlists.repository.WishlistRepository;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private WishlistRepository wishlistRepository;

	@GetMapping
	public List<ItemDto> list(String itemName) {
		if (itemName == null) {
			List<Item> items = itemRepository.findAll();
			return ItemDto.convert(items);
		} else {
			List<Item> items = itemRepository.findByName(itemName);
			return ItemDto.convert(items);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ItemDto> create(@RequestBody @Valid ItemForm form,
			UriComponentsBuilder uriComponentsBuilder) {
		Item item = form.convert(form, wishlistRepository);
		itemRepository.save(item);

		URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(item.getId()).toUri();
		return ResponseEntity.created(uri).body(new ItemDto(item));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemDetailsDto> detail(@PathVariable Long id) {
		Optional<Item> item = itemRepository.findById(id);
		if (item.isPresent())
			return ResponseEntity.ok(new ItemDetailsDto(item.get()));
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ItemDto> update(@PathVariable Long id, @RequestBody @Valid ItemForm form) {
		Optional<Item> optional = itemRepository.findById(id);
		if (optional.isPresent()) {
			Item item = form.update(id, itemRepository);
			return ResponseEntity.ok(new ItemDto(item));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Item> item = itemRepository.findById(id);
		if (item.isPresent()) {
			itemRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}