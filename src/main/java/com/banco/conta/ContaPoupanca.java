package com.banco.conta;

import com.banco.Banco;
import com.banco.Cliente;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Banco banco, Cliente cliente) {
		super(banco, cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupanca ===");
		super.imprimirInformacoesComuns();
	}

}
