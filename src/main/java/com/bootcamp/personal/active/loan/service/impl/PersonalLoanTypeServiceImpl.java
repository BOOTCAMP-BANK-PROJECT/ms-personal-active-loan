package com.bootcamp.personal.active.loan.service.impl;

import com.bootcamp.personal.active.loan.entity.PersonalLoanType;
import com.bootcamp.personal.active.loan.repository.PersonalLoanTypeRepository;
import com.bootcamp.personal.active.loan.service.PersonalLoanTypeService;
import com.bootcamp.personal.active.loan.util.Constant;
import com.bootcamp.personal.active.loan.util.handler.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PersonalLoanTypeServiceImpl implements PersonalLoanTypeService {

    public final PersonalLoanTypeRepository repository;

    @Override
    public Flux<PersonalLoanType> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<PersonalLoanType> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<PersonalLoanType> save(PersonalLoanType personalLoanType) {
        return repository.findById(personalLoanType.getId())
                .map(sa -> {
                    throw new BadRequestException(
                            "ID",
                            "Client have one ore more personalLoanTypes",
                            sa.getId(),
                            PersonalLoanTypeServiceImpl.class,
                            "save.onErrorResume"
                    );
                })
                .switchIfEmpty(Mono.defer(() -> {
                            personalLoanType.setId(null);
                            personalLoanType.setInsertionDate(new Date());
                            return repository.save(personalLoanType);
                        }
                ))
                .onErrorResume(e -> Mono.error(e)).cast(PersonalLoanType.class);
    }

    @Override
    public Mono<PersonalLoanType> update(PersonalLoanType personalLoanType) {

        return repository.findById(personalLoanType.getId())
                .switchIfEmpty(Mono.error(new Exception("An item with the id " + personalLoanType.getId() + " was not found. >> switchIfEmpty")))
                .flatMap(p -> repository.save(personalLoanType))
                .onErrorResume(e -> Mono.error(new BadRequestException(
                        "ID",
                        "An error occurred while trying to update an item.",
                        e.getMessage(),
                        PersonalLoanTypeServiceImpl.class,
                        "update.onErrorResume"
                )));
    }

    @Override
    public Mono<PersonalLoanType> delete(String id) {
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
                        PersonalLoanTypeServiceImpl.class,
                        "update.onErrorResume"
                )));
    }
}