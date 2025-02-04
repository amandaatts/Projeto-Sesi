package com.sesi.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.projeto.dto.PagamentoDTO;
import com.sesi.projeto.entities.Pagamento;
import com.sesi.projeto.repository.PagamentoRepository;



@RestController
@RequestMapping("pagamento")
public class PagamentoController {

	@Autowired
	PagamentoRepository repo;

	@GetMapping
	public ResponseEntity<List<Pagamento>> mostrarTodos() {
		List<Pagamento> pag = repo.findAll();
		return ResponseEntity.ok(pag);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
		Pagamento pag = repo.getById(id);
		return ResponseEntity.ok(pag);
	}
	
	@PostMapping
	public ResponseEntity<Pagamento> criar(@RequestBody PagamentoDTO dto){
		Pagamento pag = new Pagamento(dto);
		return ResponseEntity.ok(pag);
	}

}