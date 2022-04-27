package com.bootcamp.personal.active.loan.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.personal.active.loan.entity.PersonalActiveLoanMovement;
import com.bootcamp.personal.active.loan.service.PersonalActiveLoanMovementServiceImpl;

@RestController
@RequestMapping("enterprise/passive/pyme_current_account")
@Tag(name = "Personal Active Loan Movement Type", description = "Manage Personal Active Loan Movement type")
@CrossOrigin( value = { "*" })
@RequiredArgsConstructor
public class PersonalActiveLoanMovementController {
	
	@Autowired
    public final PersonalActiveLoanMovementServiceImpl service;

    @GetMapping
    public Flux<PersonalActiveLoanMovement> getAll() {
        return service.findAll();
    }
    
    @GetMapping("/find/{num}")
    public Flux<PersonalActiveLoanMovement> findByNum(@PathVariable String num){
    	return service.findByDocumentNumber(num);
    }
    
    @PostMapping
    public Mono<PersonalActiveLoanMovement> create(@RequestBody PersonalActiveLoanMovement p) {
        return service.create(p);
    }

    @PutMapping("/update/{id}")
    public Mono<PersonalActiveLoanMovement> update(@RequestBody PersonalActiveLoanMovement p, @PathVariable String id) {
        return service.update(p);
    }
    
    @DeleteMapping("/deleteById/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.deleteById(id);
    }

}