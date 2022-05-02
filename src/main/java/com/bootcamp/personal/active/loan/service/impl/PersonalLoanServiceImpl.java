package com.bootcamp.personal.active.loan.service.impl;


import com.bootcamp.personal.active.loan.entity.PersonalLoan;
import com.bootcamp.personal.active.loan.repository.PersonalLoanRepository;
import com.bootcamp.personal.active.loan.service.PersonalLoanService;
import com.bootcamp.personal.active.loan.util.Constant;
import com.bootcamp.personal.active.loan.util.handler.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PersonalLoanServiceImpl implements PersonalLoanService {

    public final PersonalLoanRepository repository;

    @Override
    public Flux<PersonalLoan> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<PersonalLoan> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<PersonalLoan> save(PersonalLoan personalLoan) {
        return repository.findByIdClient(personalLoan.getIdClient())
                .map(sa -> {
                    throw new BadRequestException(
                            "ID",
                            "Client have one ore more personalLoans",
                            sa.getId(),
                            PersonalLoanServiceImpl.class,
                            "save.onErrorResume"
                    );
                })
                .switchIfEmpty(Mono.defer(() -> {
                            personalLoan.setId(null);
                            personalLoan.setInsertionDate(new Date());
                            return repository.save(personalLoan);
                        }
                ))
                .onErrorResume(e -> Mono.error(e)).cast(PersonalLoan.class);
    }

    @Override
    public Mono<PersonalLoan> update(PersonalLoan personalLoan) {

        return repository.findById(personalLoan.getId())
                .switchIfEmpty(Mono.error(new Exception("An item with the id " + personalLoan.getId() + " was not found. >> switchIfEmpty")))
                .flatMap(p -> repository.save(personalLoan))
                .onErrorResume(e -> Mono.error(new BadRequestException(
                        "ID",
                        "An error occurred while trying to update an item.",
                        e.getMessage(),
                        PersonalLoanServiceImpl.class,
                        "update.onErrorResume"
                )));
    }

    @Override
    public Mono<PersonalLoan> delete(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("An item with the id " + id + " was not found. >> switchIfEmpty")))
                .flatMap(p -> {
                    p.setRegistrationStatus(Constant.STATUS_INACTIVE);
                    return repository.save(p);
                })
                .onErrorResume(e -> Mono.error(new BadRequestException(
                        "ID",
                        "An error occurred while trying to delete an item.",
                        e.getMessage(),
                        PersonalLoanServiceImpl.class,
                        "update.onErrorResume"
                )));
    }
}