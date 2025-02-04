package com.sesi.projeto.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "Tb_pedido")
		
public class Pedido {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private StatusDoPedido status;
	
	@ManyToOne
	@JoinColumn(name = "Cliente_id")
	private Usuario cliente;
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {
}
	public Pedido(Long id, Instant momento, StatusDoPedido status) {
		super();
		this.id = id;
		this.momento = momento;
		this.status = status;
		
		
		
	}
	@OneToMany(mappedBy = "id.pedido")
	private Set< ItemDoPedido> items = new HashSet<>();
	public Set< ItemDoPedido > getItems() {
	return items; }
	public List<Object> getProduto() {
	return items.stream().map(x -> x.getProduto()).toList();
	}
	
	public Long getId() {
		return id;
	}
}
