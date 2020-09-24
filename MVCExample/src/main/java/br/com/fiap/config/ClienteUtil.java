package br.com.fiap.config;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.entity.Pagamento;

public class ClienteUtil {
	public void getPagamentoByIdDemo(long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/pagamento/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Pagamento> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Pagamento.class, id);
		Pagamento pagamento = responseEntity.getBody();
		System.out.println(pagamento);
	}

	public void getAllPagamentosDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/pagamentos";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Pagamento[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Pagamento[].class);
		Pagamento[] pagamentos = responseEntity.getBody();
		for (Pagamento pagamento : pagamentos) {
			System.out.println(pagamento);
		}
	}

	public void addPagamentoDemo(Pagamento objPagamento) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/pagamento";
		HttpEntity<Pagamento> requestEntity = new HttpEntity<Pagamento>(objPagamento, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
	}

	public void updatePagamentoDemo(Pagamento objPagamento) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/pagamento";
		HttpEntity<Pagamento> requestEntity = new HttpEntity<Pagamento>(objPagamento, headers);
		restTemplate.put(url, requestEntity);
	}

	public void deletePagamentoDemo(long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/pagamento/{id}";
		HttpEntity<Pagamento> requestEntity = new HttpEntity<Pagamento>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, id);
	}

	public static void main(String args[]) {
		ClienteUtil util = new ClienteUtil();

		Pagamento objPagamento = new Pagamento();
		util.addPagamentoDemo(objPagamento);


	}
}
