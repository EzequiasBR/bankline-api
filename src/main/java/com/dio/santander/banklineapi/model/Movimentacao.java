package com.dio.santander.banklineapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tab_movimentacao")
public class Movimentacao {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(name = "data_hora")
   private String dataHora;
   
   private String descricao;
   private Double valor;
   
   @Enumerated(EnumType.STRING)
   private MovimentacaoTipo tipo;
   
   @Column(name = "id_conta")
   private Integer idConta;
   
   
   public Integer getId() {
	return id;
   }
   public void setId(Integer id) {
	this.id = id;
   }
  
   public String getDataHora() {
	return dataHora;
   }
   public void setDataHora(String string) {
		this.dataHora = string;
   }
   public String getDescricao() {
	return descricao;
   }
   public void setDescricao(String descricao) {
	this.descricao = descricao;
   }
   public Double getValor() {
	return valor;
   }
   public void setValor(Double valor) {
	this.valor = valor;
   }
   public MovimentacaoTipo getTipo() {
	return tipo;
   }
   public void setTipo(MovimentacaoTipo tipo) {
	this.tipo = tipo;
   }
   public Integer getIdConta() {
	return idConta;
   } 
   public void setIdConta(Integer idConta) {
	this.idConta = idConta;
   }
}
