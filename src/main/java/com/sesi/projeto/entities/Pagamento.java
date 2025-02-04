package com.sesi.projeto.entities;

import java.time.Instant;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	
	@OneToOne 
	@MapsId
	private Pedido pedido;
	
	public Pagamento () {
		
	}
	
	
}
