package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.entity.Pagamento;
import br.com.fiap.service.IPagamentoService;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {
	
	@Autowired
	private IPagamentoService pagamentoService;
	
	@GetMapping("pagamento/{id}")
	public ResponseEntity<Pagamento> getPagamentoById(@PathVariable("id") Long id) {
		Pagamento pagamento = pagamentoService.getPagamentoById(id);
		return new ResponseEntity<Pagamento>(pagamento, HttpStatus.OK);
	}
	
	@GetMapping("pagamentos/{id}")
	public ResponseEntity<List<Pagamento>> getAllPagamento(@PathVariable("id") Long id) {
		List<Pagamento> lista = pagamentoService.getAllPagamento(id);
		return new ResponseEntity<List<Pagamento>>(lista, HttpStatus.OK);
	}
	
	@PostMapping("pagamento")
	public ResponseEntity<Void> addPagamento(@RequestBody Pagamento pagamento, UriComponentsBuilder builder) {
		Pagamento savedPagamento = pagamentoService.addPagamento(pagamento);  
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/pagamento/{id}").buildAndExpand(savedPagamento.id).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("pagamento")
	public ResponseEntity<Pagamento> updatePagamento(@RequestBody Pagamento pagamento) {
		pagamentoService.updatePagamento(pagamento);
		return new ResponseEntity<Pagamento>(pagamento, HttpStatus.OK);
	}
	
	
	
}
