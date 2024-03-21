package com.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.entities.Produto;
import com.avaliacao.service.ProdutoService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produto")
public class ProdutoController {
		
		private final ProdutoService produtoService;

		@Autowired
		public ProdutoController(ProdutoService produtoService) {
			this.produtoService = produtoService;
		}

		@GetMapping ("/{id}")

		public ResponseEntity<Produto> buscaProdutoIdControlId (@ PathVariable Long id) {
			Produto produto = produtoService.buscaProdutoId(id);
			if (produto != null) {
				return ResponseEntity.ok(produto);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/")
		public ResponseEntity<List<Produto>> buscaTodosProdutoControl(){
			List<Produto> produto = produtoService.buscaTodosProduto();
			return ResponseEntity.ok(produto);
		}
		@PostMapping("/")
		public ResponseEntity<Produto> salvaProdutoControl(@RequestBody  Produto produto){
			Produto salvaProduto= produtoService.salvaProduto(produto);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Produto> alterarProdutoControl(@PathVariable Long id, @RequestBody Produto produto){
			Produto alterarProduto = produtoService.alterarProduto(id, produto);
			if(alterarProduto != null) {
				return ResponseEntity.ok(alterarProduto);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaProdutoControl(@PathVariable Long id){
			boolean produto = produtoService.apagarProduto(id);
			if (produto) {
				return ResponseEntity.ok().body("O produto foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}