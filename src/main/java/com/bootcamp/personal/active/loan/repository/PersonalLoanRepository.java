package com.bootcamp.personal.active.loan.repository;

import com.bootcamp.personal.active.loan.entity.PersonalLoan;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PersonalLoanRepository extends ReactiveMongoRepository<PersonalLoan, String> {

    Mono<PersonalLoan> findByIdClient(String idClient);
}