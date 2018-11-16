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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ponto.models.Empresa;
import com.app.ponto.repository.EmpresaRepository;



@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository er;
	
	 @GetMapping("/all")
     public ResponseEntity<Iterable<Empresa>> list() {
       return ResponseEntity.ok(er.findAll());
     }	
	
	 @PostMapping("/criar")
	 public ResponseEntity <Empresa> insert(@RequestBody Empresa empresa) {
		    boolean achou = false;
	 		Iterable<Empresa> empresas = er.findAll();
	         for (Empresa empresaB : empresas) {
	             if(empresaB.getCnpj() == empresa.getCnpj()) {
	            	 achou = true;
	             }
	         }
	         if(achou){  
	        	 return  (ResponseEntity<Empresa>) ResponseEntity.badRequest();
	         }else {
        	  er.save(empresa);
              return ResponseEntity.ok(empresa);
	         }   
	  }	 	
	 
	 @PostMapping("/busca")
	 public ResponseEntity<ArrayList<Empresa>> findBycnpj(@RequestBody String cnpj) {
	 		boolean achou = false;
	 		ArrayList<Empresa> alvo = new ArrayList<Empresa>();
	 		Iterable<Empresa> empresas = er.findAll();
	         for (Empresa empresaB : empresas) {
	             if(empresaB.getCnpj() == cnpj) {
	            	 achou = true;
	            	 alvo.add(empresaB);
	             }
	         }
	         if(achou){  
                 return ResponseEntity.ok(alvo);
             }else {
            	 return ResponseEntity.ok(alvo);
             }   
	    }
}	
