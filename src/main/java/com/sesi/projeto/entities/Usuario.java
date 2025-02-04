package com.sesi.projeto.entities;

import java.time.Instant;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Usuario {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private Instant momento;
		private StatusDoPedido status;
		
		@ManyToOne
		@JoinColumn(name = "cliente_id")
		private Usuario cliente;
		
		public Pedido() {
			
		}
}
