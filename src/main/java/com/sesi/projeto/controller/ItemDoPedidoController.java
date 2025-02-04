package com.sesi.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.projeto.dto.ItemDoPedidoDTO;
import com.sesi.projeto.entities.ItemDoPedido;
import com.sesi.projeto.repository.ItemDoPedidoRepository;



@RestController
@RequestMapping("itemdopedido")
public class ItemDoPedidoController {

	@Autowired
	ItemDoPedidoRepository repo;

	@GetMapping
	public ResponseEntity<List<Long>> mostrarTodos() {
		List<Long> item = repo.findAll();
		return ResponseEntity.ok(item);
	}
	
	@PostMapping
	public ResponseEntity<ItemDoPedido> criar(@RequestBody ItemDoPedidoDTO dto){
		ItemDoPedido item = new ItemDoPedido();
		return ResponseEntity.ok(item);
	}

}