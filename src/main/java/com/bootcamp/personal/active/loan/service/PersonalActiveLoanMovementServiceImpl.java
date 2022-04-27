package com.bootcamp.personal.active.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.personal.active.loan.entity.PersonalActiveLoanMovement;
import com.bootcamp.personal.active.loan.repository.PersonalActiveLoanMovementRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonalActiveLoanMovementServiceImpl implements PersonalActiveLoanMovementService {
	
	@Autowired
    public final PersonalActiveLoanMovementRepository repo;

	@Override
	public Flux<PersonalActiveLoanMovement> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return repo.deleteById(id);
	}

	@Override
	public Flux<PersonalActiveLoanMovement> findByDocumentNumber(String num) {
		return repo.findByDocumentNumber(num);
	}

	@Override
	public Mono<PersonalActiveLoanMovement> create(PersonalActiveLoanMovement ploanm) {
		return repo.save(ploanm);
	}

	@Override
	public Mono<PersonalActiveLoanMovement> update(PersonalActiveLoanMovement ploanm) {
		return repo.save(ploanm);
	}

}
