package com.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}