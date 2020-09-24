package br.com.fiap.service;

import java.util.List;

import br.com.fiap.entity.Pagamento;

public interface IPagamentoService {
	 Pagamento getPagamentoById(long id);
	 Pagamento addPagamento(Pagamento pagamento);
	 Pagamento updatePagamento(Pagamento pagamento);
	List<Pagamento> getAllPagamento(Iterable<Long> id);
	List<Pagamento> getAllPagamento(long id);
}
