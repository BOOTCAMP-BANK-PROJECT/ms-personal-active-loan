package com.bootcamp.personal.active.loan.controlller;

import com.bootcamp.personal.active.loan.entity.PersonalLoan;
import com.bootcamp.personal.active.loan.service.PersonalLoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("personal/passive/saving_personalLoan")
@Tag(name = "Personal Passive Product Saving PersonalLoan Type", description = "Manage Personal Passive Product saving personalLoans type")
@CrossOrigin(value = {"*"})
@RequiredArgsConstructor
public class PersonalLoanController {

    public final PersonalLoanService service;

    @GetMapping//(value = "/fully")
    public Mono<ResponseEntity<Flux<PersonalLoan>>> getAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.getAll())
        );
    }

    @PostMapping
    public Mono<ResponseEntity<PersonalLoan>> create(@RequestBody PersonalLoan personalLoan) {

        return service.save(personalLoan).map(p -> ResponseEntity
                .created(URI.create("/PersonalLoan/".concat(p.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(p)
        );
    }

    @PutMapping
    public Mono<ResponseEntity<PersonalLoan>> update(@RequestBody PersonalLoan personalLoan) {
        return service.update(personalLoan)
                .map(p -> ResponseEntity.created(URI.create("/PersonalLoan/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<ResponseEntity<PersonalLoan>> delete(@RequestBody String id) {
        return service.delete(id)
                .map(p -> ResponseEntity.created(URI.create("/PersonalLoan/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
