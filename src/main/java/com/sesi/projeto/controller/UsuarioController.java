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

import com.sesi.projeto.dto.UsuarioDTO;
import com.sesi.projeto.entities.Usuario;
import com.sesi.projeto.repository.UsuarioRepository;


@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository repo;

	@GetMapping
	public ResponseEntity<List<Usuario>> mostrarTodos() {
		List<Usuario> usu = repo.findAll();
		return ResponseEntity.ok(usu);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
		Usuario usu = repo.getById(id);
		return ResponseEntity.ok(usu);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@RequestBody UsuarioDTO dto){
		Usuario usu = new Usuario(dto);
		return ResponseEntity.ok(usu);
	}

}