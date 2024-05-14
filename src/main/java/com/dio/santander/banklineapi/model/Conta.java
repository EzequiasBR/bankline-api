package com.dio.santander.banklineapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Conta {
	@Column(name = "conta_nome")
    private long numero;
	@Column(name = "conta_saldo")
    private Double saldo;
    
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
      
}
