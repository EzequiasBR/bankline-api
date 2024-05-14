package com.dio.santander.banklineapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_correntista")
public class Correntista {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(length = 20 )
   private String cpf;
   
   @Column(length = 60 )
   private String nome;
   
   @Embedded
   private Conta conta;
   
   public void setConta(Conta conta) {
	this.conta = conta;
   } 
   
   public Conta getConta() {
	return conta;
   }
   
   public Integer getId() {
	return id;
   }
   public void setId(Integer id) {
	this.id = id;
   }
   public String getCpf() {
	return cpf;
   }
   public void setCpf(String cpf) {
	this.cpf = cpf;
   }
   public String getNome() {
	return nome;
   }
   public void setNome(String nome) {
	this.nome = nome;
   }  
}
