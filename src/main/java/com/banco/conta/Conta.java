package com.banco.conta;

import com.banco.Banco;
import com.banco.Cliente;
import com.banco.exception.SaqueInvalidoException;

import lombok.Data;

@Data
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Banco banco;
	protected Cliente cliente;
	
	public Conta(Banco banco, Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.banco = banco;
		this.banco.adicionarConta(this);
		this.cliente = cliente;
	}
	
	@Override
	public void sacar(double valor) {
		if(this.saldo == 0 || this.saldo < valor)
			throw new SaqueInvalidoException("Saldo insuficiente!");
		saldo -= valor;
	}
	
	@Override
	public void depositar(double valor) {
		saldo += valor;
	}
	
	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	protected void imprimirInformacoesComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Banco: %s", this.banco.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
	}
	
}
