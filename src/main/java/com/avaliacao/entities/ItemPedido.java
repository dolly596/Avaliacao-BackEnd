package com.avaliacao.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itempedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_itempedido", nullable = false)
	private Long id;
	
	@Column(name = "quantidade", nullable = false, length = 100)
	private int quantidade;
	
	@Column(name = "valor_unitario", nullable = false, length = 100)
	private BigDecimal valor_unitario;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto",nullable = false)
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido",nullable = false)
	private Pedido pedido;
	
	
}