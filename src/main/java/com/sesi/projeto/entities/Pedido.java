package com.sesi.projeto.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sesi.projeto.dto.PedidoDTO;

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
@Table(name = "Tb_pedido")

public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private StatusDoPedido status;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	@OneToMany(mappedBy = "id.pedido")
	
	private Set<ItemDoPedido> items = new HashSet<>();
	public Set<ItemDoPedido> getItemns(){
		return items; 
		}
	public List<Produto> getProduto(){
		return items.stream().map(x -> x.getProduto()).toList();
	
	}
	
	public Pedido() {
		
	}
	
	public Pedido(PedidoDTO e) {
		this.momento = e.momento();
		this.status = e.status();
	
		}
	
	public Pedido(Long id, Instant momento, StatusDoPedido status) {
	this.id = id;
	this.momento = momento;
	this.status = status;


	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusDoPedido getStatus() {
		return status;
	}

	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}
	
	
}
	