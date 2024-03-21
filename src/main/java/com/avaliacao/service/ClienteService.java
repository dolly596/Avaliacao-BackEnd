package com.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.entities.Cliente;
import com.avaliacao.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository ClienteRepository;

	@Autowired
	public ClienteService(ClienteRepository ClienteRepository) {
		this.ClienteRepository = ClienteRepository;
	}

	public List<Cliente> buscaTodosCliente(){
		return ClienteRepository.findAll();
	}

	public Cliente buscaClienteId (Long id) {
		Optional <Cliente> Aluno = ClienteRepository.findById(id);
		return Aluno.orElse(null);			
	}

	public Cliente salvaCliente(Cliente cliente) {
		return ClienteRepository.save(cliente);
	}

	public Cliente alterarCliente(Long id, Cliente alterarCliente) {
		Optional <Cliente> existeCliente = ClienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			alterarCliente.setId(id);
			return ClienteRepository.save(alterarCliente);
		}
		return null;
	}

	public boolean apagarCliente(Long id) {
		Optional <Cliente> existeCliente = ClienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			ClienteRepository.deleteById(id);
			return true;
		}
		return false;
	}
}