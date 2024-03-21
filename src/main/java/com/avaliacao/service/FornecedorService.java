package com.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.entities.Fornecedor;
import com.avaliacao.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	private final FornecedorRepository FornecedorRepository;

	@Autowired
	public FornecedorService(FornecedorRepository FornecedorRepository) {
		this.FornecedorRepository = FornecedorRepository;
	}

	public List<Fornecedor> buscaTodosFornecedor(){
		return FornecedorRepository.findAll();
	}

	public Fornecedor buscaFornecedorId (Long id) {
		Optional <Fornecedor> Aluno = FornecedorRepository.findById(id);
		return Aluno.orElse(null);			
	}

	public Fornecedor salvaFornecedor(Fornecedor Fornecedor) {
		return FornecedorRepository.save(Fornecedor);
	}

	public Fornecedor alterarFornecedor(Long id, Fornecedor alterarFornecedor) {
		Optional <Fornecedor> existeFornecedor = FornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			alterarFornecedor.setId(id);
			return FornecedorRepository.save(alterarFornecedor);
		}
		return null;
	}

	public boolean apagarFornecedor(Long id) {
		Optional <Fornecedor> existeFornecedor = FornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			FornecedorRepository.deleteById(id);
			return true;
		}
		return false;
	}
}