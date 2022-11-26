package com.gama.carrinho.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gama.carrinho.model.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	
	
}
