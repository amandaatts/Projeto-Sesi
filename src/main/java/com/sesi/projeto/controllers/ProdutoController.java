package com.sesi.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.projeto.entities.Produto;
import com.sesi.projeto.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*") 
public class ProdutoController {

    @Autowired
    private ProdutoService ProdutoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = ProdutoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto produto = (Produto) ProdutoService.findById(id);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto novoProduto = ProdutoService.save(produto);
        return ResponseEntity.ok(novoProduto);
    }
}
