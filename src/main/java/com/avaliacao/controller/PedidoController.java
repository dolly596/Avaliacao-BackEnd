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

import com.avaliacao.entities.Pedido;
import com.avaliacao.service.PedidoService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedido")
public class PedidoController {
		
		private final PedidoService PedidoService;

		@Autowired
		public PedidoController(PedidoService PedidoService) {
			this.PedidoService = PedidoService;
		}

		@GetMapping ("/{id}")

		public ResponseEntity<Pedido> buscaPedidoIdControlId (@ PathVariable Long id) {
			Pedido Pedido = PedidoService.buscaPedidoId(id);
			if (Pedido != null) {
				return ResponseEntity.ok(Pedido);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/")
		public ResponseEntity<List<Pedido>> buscaTodosPedidoControl(){
			List<Pedido> Pedido = PedidoService.buscaTodosPedido();
			return ResponseEntity.ok(Pedido);
		}
		@PostMapping("/")
		public ResponseEntity<Pedido> salvaPedidoControl(@RequestBody  Pedido Pedido){
			Pedido salvaPedido= PedidoService.salvaPedido(Pedido);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Pedido> alterarPedidoControl(@PathVariable Long id, @RequestBody Pedido Pedido){
			Pedido alterarPedido = PedidoService.alterarPedido(id, Pedido);
			if(alterarPedido != null) {
				return ResponseEntity.ok(alterarPedido);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaPedidoControl(@PathVariable Long id){
			boolean Pedido = PedidoService.apagarPedido(id);
			if (Pedido) {
				return ResponseEntity.ok().body("O Pedido foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}