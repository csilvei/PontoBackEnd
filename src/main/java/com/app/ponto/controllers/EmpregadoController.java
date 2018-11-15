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

import com.app.ponto.models.Empregado;
import com.app.ponto.repository.EmpregadoRepository;




@RestController
@RequestMapping("/empregado")
public class EmpregadoController {
	
	@Autowired
	private EmpregadoRepository er;
	
	 @GetMapping("/all")
     public ResponseEntity<Iterable<Empregado>> list() {
       return ResponseEntity.ok(er.findAll());
     }	
	
	 @PostMapping
	 public ResponseEntity<Empregado> insert(@RequestBody Empregado emp) {
         er.save(emp);  
         return ResponseEntity.ok(emp);
	  }	 	
	 
	 @PostMapping(value = "/buscar")
	 public ResponseEntity<ArrayList<Empregado>> logout(@RequestBody String cpf) {
	 		boolean achou = false;
	 		ArrayList<Empregado> alvo = new ArrayList<Empregado>();
	 		Iterable<Empregado> empregados = er.findAll();
	         for (Empregado empB : empregados) {
	             if(empB.getCpf() == cpf) {
	            	 achou = true;
	            	 alvo.add(empB);
	             }
	         }
	         if(achou){  
                 return ResponseEntity.ok(alvo);
             }else {
            	 return ResponseEntity.ok(alvo);
             }   
	    }
}	
