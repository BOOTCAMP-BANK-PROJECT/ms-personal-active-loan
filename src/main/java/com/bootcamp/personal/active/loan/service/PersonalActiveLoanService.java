package com.bootcamp.personal.active.loan.service;

import com.bootcamp.personal.active.loan.entity.PersonalActiveLoan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalActiveLoanService {
	
    Flux<PersonalActiveLoan> findAll();
    Mono<PersonalActiveLoan> create(PersonalActiveLoan ploan);
    Mono<PersonalActiveLoan> findByDocumentNumber(String num);
    Mono<PersonalActiveLoan> update(PersonalActiveLoan ploan);
    Mono<Void> deleteById(String id);

}
