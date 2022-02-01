package com.banco;

import com.banco.conta.Conta;
import com.banco.conta.ContaCorrente;
import com.banco.conta.ContaPoupanca;

public class App {
    
    public static void main(String[] args) {
    	
    	// ---------------------------- Instanciando bancos ----------------------------
    	Banco bancoX = new Banco("Banco X");
    	Banco bancoY = new Banco("Banco Y");
    	// ------------------------------------------------------------------------------
    	
    	
    	// ---------------------------- Instanciando contas -----------------------------
    	Conta contaPoupanca = new ContaPoupanca(bancoX, new Cliente("Cláudio Da Costa"));
    	
    	Conta contaCorrente = new ContaCorrente(bancoY, new Cliente("Maria de Oliveira"));
    	
    	Conta segundaContaCorrente = new ContaCorrente(bancoX, new Cliente("Aline Walker"));
    	// ------------------------------------------------------------------------------
    	
    	
    	// ------------------------------ Movimentações ---------------------------------
    	contaPoupanca.depositar(500);
    	contaPoupanca.depositar(100);
    	contaPoupanca.sacar(500);
    	
    	contaCorrente.depositar(1500);
    	contaCorrente.sacar(1000);
    	
    	segundaContaCorrente.depositar(2000.25);
    	segundaContaCorrente.transferir(99.5, contaPoupanca);
    	// ------------------------------------------------------------------------------
    	
    	
    	// --------------------------------- Extratos -----------------------------------
    	contaPoupanca.imprimirExtrato();
    	separar();
    	
    	contaCorrente.imprimirExtrato();
    	separar();
    	
    	segundaContaCorrente.imprimirExtrato();
    	separar();
    	// ------------------------------------------------------------------------------
    	
    	
    	// -------------------- Visualizando bancos e seus clientes ---------------------
    	System.out.println(bancoX.getNome() + " => " + bancoX.listarClientes());
    	System.out.println(bancoY.getNome() + " => " + bancoY.listarClientes());
    	// -------------------------------------------------------------------------------
    	
    }
    
    private static void separar() {
    	System.out.println("-".repeat(100));
    }
    
}
