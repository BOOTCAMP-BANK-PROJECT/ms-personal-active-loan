package com.bootcamp.personal.active.loan.service;

import com.bootcamp.personal.active.loan.entity.PersonalLoanType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PersonalLoanTypeService {

    public Flux<PersonalLoanType> getAll();

    public Mono<PersonalLoanType> getById(String id);

    public Mono<PersonalLoanType> save(PersonalLoanType personalLoanType);

    public Mono<PersonalLoanType> update(PersonalLoanType personalLoanType);

    public Mono<PersonalLoanType> delete(String id);
}