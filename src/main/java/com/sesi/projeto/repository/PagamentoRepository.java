package com.sesi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.projeto.entities.Pagamento;

public interface PagamentoRepository  extends JpaRepository<Pagamento, Long>{
}
