package br.com.fiap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.entity.Cliente;
import br.com.fiap.repository.ClienteRepository;

@Component
public class ClienteService implements IClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllClientes() {
		System.out.println("getAllClientes()");
		List<Cliente> listaCliente = new ArrayList<>();
		clienteRepository.findAll().forEach(e -> listaCliente.add(e));
		return listaCliente;
	}

	@Override
	public Cliente getClienteById(long id) {
		System.out.println("getClienteById()");		
		return clienteRepository.findById(id).get();
	}

	@Override
	public Cliente addCliente(Cliente cliente) {
		System.out.println("addCliente()");		
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		System.out.println("updateCliente()");		
		return clienteRepository.save(cliente);
	}

	@Override
	public void deleteCliente(long id) {
		System.out.println("deleteCliente()");		
		clienteRepository.delete(clienteRepository.findById(id).get());
		
	}

}
