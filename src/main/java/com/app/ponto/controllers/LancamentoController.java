package com.app.ponto.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ponto.models.Empresa;
import com.app.ponto.models.Lancamento;
import com.app.ponto.repository.LancamentoRepository;



@RestController
@RequestMapping("/lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoRepository lr;
	

	 @PostMapping
	 public ResponseEntity<Lancamento> insert(@RequestBody Lancamento lanc) {
         lr.save(lanc);  
         return ResponseEntity.ok(lanc);
	  }	 	
	 
	 @PostMapping("/all")
     public ResponseEntity<ArrayList<Lancamento>> list(@RequestBody String cod,String emp) {
		 	emp.replaceAll("-", "/");
	 		ArrayList<Lancamento> alvo = new ArrayList<Lancamento>();
	 		Iterable<Lancamento> lanc = lr.findAll();
	         for (Lancamento l : lanc) {
	             if(l.getUser() == cod && l.getEmpresa() == emp) {

	            	 alvo.add(l);
	             }
	         }
              return ResponseEntity.ok(alvo);
     }	
	 
	 @GetMapping(value = "/busca/{cod}/{emp}/{dia}")
	 public ResponseEntity<ArrayList<Lancamento>> find(@PathVariable("cod") String cod,@PathVariable("emp") String emp,@PathVariable("dia") String dia) throws ParseException {
	 		boolean achou = false;
	 		ArrayList<Lancamento> alvo = new ArrayList<Lancamento>();
	 		Iterable<Lancamento> lanc = lr.findAll();
	         for (Lancamento l : lanc) {
	             if(l.getUser().equalsIgnoreCase(cod) && l.getEmpresa().equalsIgnoreCase(emp) ) {
	            	 SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
	            	 Date data = (Date) formato.parse(dia);
	            	 if(l.getData().equals(data)) {
	            		 achou = true;
		            	 alvo.add(l);
	            	 } 
	             }
	         }
	         if(achou){  
                 return ResponseEntity.ok(alvo);
             }else {
            	 return ResponseEntity.ok(alvo);
             }   
	    }
}	
