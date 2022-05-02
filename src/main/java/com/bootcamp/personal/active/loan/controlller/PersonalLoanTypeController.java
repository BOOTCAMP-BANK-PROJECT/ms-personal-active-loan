package com.bootcamp.personal.active.loan.controlller;

import com.bootcamp.personal.active.loan.entity.PersonalLoanType;
import com.bootcamp.personal.active.loan.service.PersonalLoanTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("personal/passive/saving_personalLoanType")
@Tag(name = "Personal Passive Product Saving PersonalLoanType Type", description = "Manage Personal Passive Product saving personalLoanTypes type")
@CrossOrigin(value = {"*"})
@RequiredArgsConstructor
public class PersonalLoanTypeController {

    public final PersonalLoanTypeService service;

    @GetMapping//(value = "/fully")
    public Mono<ResponseEntity<Flux<PersonalLoanType>>> getAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.getAll())
        );
    }

    @PostMapping
    public Mono<ResponseEntity<PersonalLoanType>> create(@RequestBody PersonalLoanType personalLoanType) {

        return service.save(personalLoanType).map(p -> ResponseEntity
                .created(URI.create("/PersonalLoanType/".concat(p.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(p)
        );
    }

    @PutMapping
    public Mono<ResponseEntity<PersonalLoanType>> update(@RequestBody PersonalLoanType personalLoanType) {
        return service.update(personalLoanType)
                .map(p -> ResponseEntity.created(URI.create("/PersonalLoanType/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<ResponseEntity<PersonalLoanType>> delete(@RequestBody String id) {
        return service.delete(id)
                .map(p -> ResponseEntity.created(URI.create("/PersonalLoanType/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
