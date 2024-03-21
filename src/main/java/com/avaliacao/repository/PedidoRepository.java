package com.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}