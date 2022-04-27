package com.bootcamp.personal.active.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.personal.active.loan.entity.PersonalActiveLoan;
import com.bootcamp.personal.active.loan.repository.PersonalActiveLoanRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonalActiveLoanServiceImpl implements PersonalActiveLoanService {
	
	@Autowired
    public final PersonalActiveLoanRepository repo;

	@Override
	public Flux<PersonalActiveLoan> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return repo.deleteById(id);
	}

	@Override
	public Mono<PersonalActiveLoan> create(PersonalActiveLoan ploan) {
		return repo.save(ploan);
	}

	@Override
	public Mono<PersonalActiveLoan> update(PersonalActiveLoan ploan) {
		return repo.save(ploan);
	}

	@Override
	public Mono<PersonalActiveLoan> findByDocumentNumber(String num) {
		return repo.findByDocumentNumber(num);
	}

}
