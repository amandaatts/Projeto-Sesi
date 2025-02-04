package com.sesi.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sesi.projeto.dto.ProdutoDTO;
import com.sesi.projeto.entities.Pedido;
import com.sesi.projeto.entities.Produto;
import com.sesi.projeto.repository.PedidoRepository;

@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	PedidoRepository repo;

	@GetMapping
	public ResponseEntity<List<Pedido>> mostrarTodos() {
		List<Pedido> ped = repo.findAll();
		return ResponseEntity.ok(ped);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
		Pedido ped = repo.getById(id);
		return ResponseEntity.ok(ped);
	}
	
	@PostMapping
	public ResponseEntity<Produto> criar(@RequestBody ProdutoDTO dto){
		Produto prod = new Produto(dto);
		return ResponseEntity.ok(prod);
	}

}