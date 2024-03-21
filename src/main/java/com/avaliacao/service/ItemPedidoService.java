package com.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.entities.ItemPedido;
import com.avaliacao.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	private final ItemPedidoRepository ItemPedidoRepository;

	@Autowired
	public ItemPedidoService(ItemPedidoRepository ItemPedidoRepository) {
		this.ItemPedidoRepository = ItemPedidoRepository;
	}

	public List<ItemPedido> buscaTodosItemPedido(){
		return ItemPedidoRepository.findAll();
	}

	public ItemPedido buscaItemPedidoId (Long id) {
		Optional <ItemPedido> Aluno = ItemPedidoRepository.findById(id);
		return Aluno.orElse(null);			
	}

	public ItemPedido salvaItemPedido(ItemPedido ItemPedido) {
		return ItemPedidoRepository.save(ItemPedido);
	}

	public ItemPedido alterarItemPedido(Long id, ItemPedido alterarItemPedido) {
		Optional <ItemPedido> existeItemPedido = ItemPedidoRepository.findById(id);
		if (existeItemPedido.isPresent()) {
			alterarItemPedido.setId(id);
			return ItemPedidoRepository.save(alterarItemPedido);
		}
		return null;
	}

	public boolean apagarItemPedido(Long id) {
		Optional <ItemPedido> existeItemPedido = ItemPedidoRepository.findById(id);
		if (existeItemPedido.isPresent()) {
			ItemPedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}