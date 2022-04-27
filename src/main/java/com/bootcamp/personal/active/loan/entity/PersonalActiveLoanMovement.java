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
public class PersonalActiveLoanMovement {
	
	@Id
	private String id;
    private PersonalClient documentNumber;
    private String movementType; //A = APERTURA, I = INGRESO
    private String movementDate;
    private String amount;

}
