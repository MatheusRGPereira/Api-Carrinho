package com.gama.carrinho.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.gama.carrinho.model.Item;

import com.gama.carrinho.repository.ItemRepository;


@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;

	
	@GetMapping("/all")
	public ResponseEntity<List<Item>> getAll() {
		return ResponseEntity.ok(itemRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getById(@PathVariable Long id) {

		return itemRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Item> postItem(@Valid @RequestBody Item item){
		return ResponseEntity.status(HttpStatus.CREATED).body(itemRepository.save(item));
	}
	
	@PutMapping
	public ResponseEntity<Item> putItem(@Valid @RequestBody Item item ){
		return itemRepository.findById(item.getId())
				.map(resposta -> ResponseEntity.ok().body(itemRepository.save(item)))
				.orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteItem(@PathVariable Long id) {
		return itemRepository.findById(id)
				.map(resposta -> {
					itemRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
