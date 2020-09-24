package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pagamento")

public class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public long id_pagador;
	public long id_recebedor;
	public String valor;
	public String data_pagamento;
	
	
	
	public Pagamento(long id, long id_pagador, long id_recebedor, String valor, String data_pagamento) {
		super();
		this.id = id;
		this.id_pagador = id_pagador;
		this.id_recebedor = id_recebedor;
		this.valor = valor;
		this.data_pagamento = data_pagamento;
	}
	
	public Pagamento() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_pagador() {
		return id_pagador;
	}
	public void setId_pagador(long id_pagador) {
		this.id_pagador = id_pagador;
	}
	public long getId_recebedor() {
		return id_recebedor;
	}
	public void setId_recebedor(long id_recebedor) {
		this.id_recebedor = id_recebedor;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getData_pagamento() {
		return data_pagamento;
	}
	public void setData_pagamento(String data_pagamento) {
		this.data_pagamento = data_pagamento;
	}
	
	

}
