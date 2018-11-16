package com.app.ponto.controllers;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ponto.models.Lancamento;
import com.app.ponto.repository.LancamentoRepository;



@RestController
@RequestMapping("/lancamento")
public class LançamentoController {
	
	@Autowired
	private LancamentoRepository lr;
	
	 @GetMapping("/all")
     public ResponseEntity<Iterable<Lancamento>> list() {
       return ResponseEntity.ok(lr.findAll());
     }	
	
	 @PostMapping
	 public ResponseEntity<Lancamento> insert(@RequestBody Lancamento lanc) {
         lr.save(lanc);  
         return ResponseEntity.ok(lanc);
	  }	 	
	 
	 @PostMapping(value = "/buscaLan")
	 public ResponseEntity<ArrayList<Lancamento>> logout(@RequestBody String cod,String emp,Date dia) {
	 		boolean achou = false;
	 		ArrayList<Lancamento> alvo = new ArrayList<Lancamento>();
	 		Iterable<Lancamento> lanc = lr.findAll();
	         for (Lancamento l : lanc) {
	             if(l.getIduser() == cod && l.getIdempresa() == emp && l.getData() == dia) {
	            	 achou = true;
	            	 alvo.add(l);
	             }
	         }
	         if(achou){  
                 return ResponseEntity.ok(alvo);
             }else {
            	 return ResponseEntity.ok(alvo);
             }   
	    }
}	
