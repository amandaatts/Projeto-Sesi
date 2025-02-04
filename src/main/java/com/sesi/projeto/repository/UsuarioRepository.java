package com.sesi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesi.projeto.entities.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}