package com.BankDemo.bank;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Account")
public class BankController {
	
	@Autowired
	AccService service;
	
	
	@PostMapping("/addAcc")
	public ResponseEntity<String> addAccount(@RequestBody Account acc){	
		return new ResponseEntity<String>(service.addAcc(acc),HttpStatus.CREATED);
	
	}
	
	@GetMapping("/getAcc/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable UUID id){
		return new ResponseEntity<>( service.getAcc(id),HttpStatus.OK);
	
	}
	@DeleteMapping("/deleteAcc/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable UUID id){
		
		return new ResponseEntity<>(service.delAcc(id),HttpStatus.OK);
	
	}
	@PutMapping("/updateAccount/{id}")
	public ResponseEntity<String> updateAccount(@PathVariable UUID id, @RequestBody Account acc){
		
		return new ResponseEntity<>(service.updateAcc(id, acc),HttpStatus.OK);
	
	}
	
	
	

}
