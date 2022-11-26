package com.gama.carrinho.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_pedidos")
public class Pedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("pedido")
	private List<Produto> produto;
	
	
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	



	


	


	
	
	
	
	
	
}
