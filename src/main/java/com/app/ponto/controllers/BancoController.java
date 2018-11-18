package com.app.ponto.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ponto.models.Banco;
import com.app.ponto.repository.BancoRepository;



@RestController
@RequestMapping("/banco")
public class BancoController {
	
	@Autowired
	private BancoRepository br;
	
	
	 @PostMapping
	 public ResponseEntity<ArrayList<Banco>> insert(@RequestBody Banco banco) {
		 
		 ArrayList<Banco> alvo = new ArrayList<Banco>();
	 		Iterable<Banco> bancos = br.findAll();
	 		 boolean achou = false;
	         for (Banco cB : bancos) {
	             if(cB.getuser() == banco.getuser() && cB.getempresa() == banco.getempresa()) {
	            	 achou = true;
	            	 cB.setNeg(banco.getNeg());
	            	 cB.setPos(banco.getPos());
	            	 cB.setTotal(banco.getTotal());
	            	 alvo.add(cB);
	             }
	         }
	         if(achou){  
	        	 return ResponseEntity.ok(alvo);
	         }else {
	        	 br.save(banco); 
	        	 return ResponseEntity.ok(alvo);
	         }   
	  }	 	
	 
	 @GetMapping(value = "/busca/{cpf}/{empresa}")
	 public ResponseEntity<ArrayList<Banco>> find(@PathVariable("cpf") String cpf,@PathVariable("empresa") String empresa) {
	 		boolean achou = false;
	 		ArrayList<Banco> alvo = new ArrayList<Banco>();
	 		Iterable<Banco> bancos = br.findAll();
	         for (Banco cB : bancos) {
	             if(cB.getuser() == cpf && cB.getempresa() == empresa) {
	            	 achou = true;
	            	 alvo.add(cB);
	             }
	         }
	         if(achou){  
                 return ResponseEntity.ok(alvo);
             }else {
            	 return ResponseEntity.ok(alvo);
             }   
	    }
}	
