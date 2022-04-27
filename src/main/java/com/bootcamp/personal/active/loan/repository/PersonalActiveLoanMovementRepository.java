package com.bootcamp.personal.active.loan.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bootcamp.personal.active.loan.entity.PersonalActiveLoanMovement;

import reactor.core.publisher.Flux;

public interface PersonalActiveLoanMovementRepository extends ReactiveCrudRepository<PersonalActiveLoanMovement, String> {
	
	Flux<PersonalActiveLoanMovement> findByDocumentNumber(String num);

}
