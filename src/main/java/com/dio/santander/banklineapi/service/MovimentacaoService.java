 package com.dio.santander.banklineapi.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banklineapi.dto.NovaMovimentacao;
import com.dio.santander.banklineapi.model.Correntista;
import com.dio.santander.banklineapi.model.Movimentacao;
import com.dio.santander.banklineapi.model.MovimentacaoTipo;
import com.dio.santander.banklineapi.repository.CorrentistaRepository;
import com.dio.santander.banklineapi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	 @Autowired
	 private MovimentacaoRepository repository;
	 
	 @Autowired
	 private CorrentistaRepository correntistaRepository;
	 
     public void save(NovaMovimentacao novaMovimentacao) {
    	 Movimentacao movimentacao = new Movimentacao();
    	 
    	 double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
     
    	 LocalDateTime agora = LocalDateTime.now();

          // Format ISO_LOCAL_DATE_TIME
         DateTimeFormatter formatoISO = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
           
    	 movimentacao.setDataHora(agora.format(formatoISO));
    	 movimentacao.setDescricao(novaMovimentacao.getDescricao());
    	 movimentacao.setIdConta(novaMovimentacao.getIdConta());
    	 movimentacao.setTipo(novaMovimentacao.getTipo());
    	 movimentacao.setValor(valor);
    	 
    	 Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
    	 if(correntista != null) {
    		 correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
    		 correntistaRepository.save(correntista);
    	 }
    	 
    	 repository.save(movimentacao);
     }
}
