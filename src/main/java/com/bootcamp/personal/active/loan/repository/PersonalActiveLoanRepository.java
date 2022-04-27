package com.bootcamp.personal.active.loan.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bootcamp.personal.active.loan.entity.PersonalActiveLoan;

import reactor.core.publisher.Mono;

public interface PersonalActiveLoanRepository extends ReactiveCrudRepository<PersonalActiveLoan, String> {
	
	Mono<PersonalActiveLoan> findByDocumentNumber(String num);

}
