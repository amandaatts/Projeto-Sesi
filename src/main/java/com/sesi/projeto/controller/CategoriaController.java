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

import com.sesi.projeto.dto.CategoriaDTO;
import com.sesi.projeto.entities.Categoria;
import com.sesi.projeto.repository.CategoriaRepository;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository repo;

	@GetMapping
	public ResponseEntity<List<Categoria>> mostrarTodos() {
		List<Categoria>  cat = repo.findAll();
		return ResponseEntity.ok(cat);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
		Categoria cat = repo.getById(id);
		return ResponseEntity.ok(cat);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@RequestBody CategoriaDTO dto){
		Categoria cat = new Categoria(dto);
		return ResponseEntity.ok(cat);
	}

}