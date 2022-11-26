package com.gama.carrinho.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gama.carrinho.model.Pedido;
import com.gama.carrinho.model.Produto;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long>{
	
	

}
