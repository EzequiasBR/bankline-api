package com.dio.santander.banklineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banklineapi.dto.NovoCorrentista;
import com.dio.santander.banklineapi.model.Correntista;
import com.dio.santander.banklineapi.repository.CorrentistaRepository;
import com.dio.santander.banklineapi.service.CorrentistaService;

@RestController    
@RequestMapping("/correntistas")
public class CorrentistaController {
	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
    public List<Correntista> findAll(){
    	return repository.findAll();
    }
	
	@PostMapping
	private void save(@RequestBody NovoCorrentista correntista) {
		service.save(correntista);
	}
}
