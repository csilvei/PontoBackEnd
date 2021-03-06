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

import com.app.ponto.models.Empregado;
import com.app.ponto.repository.EmpregadoRepository;
import com.app.ponto.repository.EmpresaRepository;




@RestController
@RequestMapping("/empregado")
public class EmpregadoController {
	
	@Autowired
	private EmpregadoRepository er;
	private EmpresaRepository empr;
	
	 @GetMapping("/all")
     public ResponseEntity<Iterable<Empregado>> list() {
       return ResponseEntity.ok(er.findAll());
     }	
	
	 @PostMapping
	 public ResponseEntity<Empregado> insert(@RequestBody Empregado emp) {
		 boolean achou = false;
	 		ArrayList<Empregado> alvo = new ArrayList<Empregado>();
	 		Iterable<Empregado> empregados = er.findAll();
	         for (Empregado empB : empregados) {
	             if(empB.getCpf() == emp.getCpf()) {
	            	 achou = true;
	            	 alvo.add(empB);
	             }
	         }
		 er.save(emp);  
         return ResponseEntity.ok(emp);
	  }	 	
	 
	 @GetMapping("/busca/{cpf}/{empresa}")
	 public ResponseEntity<ArrayList<Empregado>> find(@PathVariable("cpf") String cpf,@PathVariable("empresa") String empresa) {
	 		boolean achou = false;
	 		ArrayList<Empregado> alvo = new ArrayList<Empregado>();
	 		Iterable<Empregado> empregados = er.findAll();
	         for (Empregado empB : empregados) {
	             if(empB.getCpf().equalsIgnoreCase(cpf) && empB.getEmpresa().equalsIgnoreCase(empresa)) {
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
