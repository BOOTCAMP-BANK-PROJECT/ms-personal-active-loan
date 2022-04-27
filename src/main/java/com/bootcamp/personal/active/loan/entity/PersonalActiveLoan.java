package com.bootcamp.personal.active.loan.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class PersonalActiveLoan {
	
	@Id
	private String id;
    private PersonalClient documentNumber;
    private String creditDate;
    private String loanAmount;
    private String loanTermInMonths;
    private String annualInterestRate;

}
