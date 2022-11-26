package com.gama.carrinho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gama.carrinho.model.Pedido;


import java.util.List;

import javax.validation.Valid;

import com.gama.carrinho.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> getAll(){
		return ResponseEntity.ok(pedidoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getById(@PathVariable Long id){
		return pedidoRepository.findById(id).map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
		public ResponseEntity<Pedido> postPedido(@Valid @RequestBody  Pedido pedido){
		
			return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
	}
	
	@PutMapping
	public ResponseEntity<Pedido> putPedido(@Valid @RequestBody Pedido pedido){
		return pedidoRepository.findById(pedido.getId())
					.map(response -> ResponseEntity.ok().body(pedidoRepository.save(pedido)))
					.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<Object> deletePedido(@PathVariable Long id){
		return pedidoRepository.findById(id)
				.map(response -> {
						pedidoRepository.deleteById(id);
						return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());	
	}
	

}
