package com.bootcamp.personal.active.loan.service;

import com.bootcamp.personal.active.loan.entity.PersonalLoan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PersonalLoanService {

    public Flux<PersonalLoan> getAll();

    public Mono<PersonalLoan> getById(String id);

    public Mono<PersonalLoan> save(PersonalLoan personalLoan);

    public Mono<PersonalLoan> update(PersonalLoan personalLoan);

    public Mono<PersonalLoan> delete(String id);
}