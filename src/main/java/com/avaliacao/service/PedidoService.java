package com.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.entities.Pedido;
import com.avaliacao.repository.PedidoRepository;

@Service
public class PedidoService {
	
	private final PedidoRepository PedidoRepository;

	@Autowired
	public PedidoService(PedidoRepository PedidoRepository) {
		this.PedidoRepository = PedidoRepository;
	}

	public List<Pedido> buscaTodosPedido(){
		return PedidoRepository.findAll();
	}

	public Pedido buscaPedidoId (Long id) {
		Optional <Pedido> Aluno = PedidoRepository.findById(id);
		return Aluno.orElse(null);			
	}

	public Pedido salvaPedido(Pedido Pedido) {
		return PedidoRepository.save(Pedido);
	}

	public Pedido alterarPedido(Long id, Pedido alterarPedido) {
		Optional <Pedido> existePedido = PedidoRepository.findById(id);
		if (existePedido.isPresent()) {
			alterarPedido.setId(id);
			return PedidoRepository.save(alterarPedido);
		}
		return null;
	}

	public boolean apagarPedido(Long id) {
		Optional <Pedido> existePedido = PedidoRepository.findById(id);
		if (existePedido.isPresent()) {
			PedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}