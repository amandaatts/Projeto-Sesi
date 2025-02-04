package com.sesi.projeto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sesi.projeto.entities.Produto;
import com.sesi.projeto.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Produto update(Long id, Produto novoProduto) {
        return repository.findById(id).map(produto -> {
            produto.setNome(novoProduto.getNome());
            produto.setDescricao(novoProduto.getDescricao());
            produto.setPreco(novoProduto.getPreco());
            produto.setImgUrl(novoProduto.getImgUrl());
            return repository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
