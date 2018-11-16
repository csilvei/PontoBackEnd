package com.app.ponto.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	 @GetMapping("/all")
     public ResponseEntity<Iterable<Banco>> list() {
       return ResponseEntity.ok(br.findAll());
     }	
	
	 @PostMapping
	 public ResponseEntity<Banco> insert(@RequestBody Banco banco) {
         br.save(banco);  
         return ResponseEntity.ok(banco);
	  }	 	
	 
	 @PostMapping(value = "/buscabanco")
	 public ResponseEntity<ArrayList<Banco>> logout(@RequestBody String cod,String emp) {
	 		boolean achou = false;
	 		ArrayList<Banco> alvo = new ArrayList<Banco>();
	 		Iterable<Banco> bancos = br.findAll();
	         for (Banco cB : bancos) {
	             if(cB.getIduser() == cod && cB.getIdempresa() == emp) {
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
