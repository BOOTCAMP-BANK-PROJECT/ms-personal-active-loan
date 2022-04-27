package com.bootcamp.personal.active.loan.service;

import com.bootcamp.personal.active.loan.entity.PersonalActiveLoanMovement;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalActiveLoanMovementService {
	
    Flux<PersonalActiveLoanMovement> findAll();
    Mono<PersonalActiveLoanMovement> create(PersonalActiveLoanMovement ploanm);
    Flux<PersonalActiveLoanMovement> findByDocumentNumber(String num);
    Mono<PersonalActiveLoanMovement> update(PersonalActiveLoanMovement ploanm);
    Mono<Void> deleteById(String id);

}
