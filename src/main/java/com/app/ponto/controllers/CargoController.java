package com.app.ponto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ponto.models.Cargo;
import com.app.ponto.repository.CargoRepository;



@RestController
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	private CargoRepository cr;
	
	 @GetMapping("/all")
     public ResponseEntity<Iterable<Cargo>> list() {
       return ResponseEntity.ok(cr.findAll());
     }	
	
	 @PostMapping
	 public ResponseEntity<Cargo> insert(@RequestBody Cargo cargo) {
         cr.save(cargo);  
         return ResponseEntity.ok(cargo);
	  }	 	
	 
	 @PostMapping(value = "/buscaCargo")
	 public ResponseEntity<Cargo> logout(@RequestBody long cod) {
	 		boolean achou = false;
	 		Cargo alvo = null;
	 		Iterable<Cargo> cargos = cr.findAll();
	         for (Cargo cB : cargos) {
	             if(cB.getId() == cod) {
	            	 achou = true;
	            	 alvo = cB;
	             }
	         }
	         if(achou){  
                 return ResponseEntity.ok(alvo);
             }else {
            	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }   
	    }
}	
