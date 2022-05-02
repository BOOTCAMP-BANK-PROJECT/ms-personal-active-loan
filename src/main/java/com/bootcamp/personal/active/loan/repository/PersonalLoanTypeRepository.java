package com.bootcamp.personal.active.loan.repository;

import com.bootcamp.personal.active.loan.entity.PersonalLoanType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalLoanTypeRepository extends ReactiveMongoRepository<PersonalLoanType, String> {

}