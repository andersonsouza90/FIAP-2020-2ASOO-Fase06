package br.com.fiap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.entity.Pagamento;
import br.com.fiap.repository.PagamentoRepository;

@Component
public class PagamentoService implements IPagamentoService{
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Override
	public List<Pagamento> getAllPagamento(Iterable<Long> id) {
		System.out.println("getAllPagamento()");
		List<Pagamento> listaPagamento = new ArrayList<>();
		pagamentoRepository.findAllById(id).forEach(e -> listaPagamento.add(e));
		return listaPagamento;
	}

	@Override
	public Pagamento getPagamentoById(long id) {
		System.out.println("getPagamentoById()");		
		return pagamentoRepository.findById(id).get();
	}

	@Override
	public Pagamento addPagamento(Pagamento pagamento) {
		System.out.println("addPagamento()");		
		return pagamentoRepository.save(pagamento);
	}

	@Override
	public Pagamento updatePagamento(Pagamento pagamento) {
		System.out.println("updatePagamento()");		
		return pagamentoRepository.save(pagamento);
	}

	@Override
	public List<Pagamento> getAllPagamento(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
