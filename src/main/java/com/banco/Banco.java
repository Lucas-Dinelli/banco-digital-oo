package com.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.banco.conta.Conta;

import lombok.Data;
import lombok.ToString;

@Data
public class Banco {
	
	private String nome;
	
	@ToString.Exclude
	private List<Conta> contas;
	
	public Banco(String nome) {
		this.nome = nome;
		contas = new ArrayList<Conta>();
	}
	
	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}
	
	public List<Cliente> listarClientes() {
		return contas.stream()
				.map(conta -> conta.getCliente())
				.collect(Collectors.toList());
	}

}
