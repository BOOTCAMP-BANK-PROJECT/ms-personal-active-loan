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
public class PersonalClient {
	
	@Id
	private String id;
	private String documentType;
	private String documentNumber;
	private String firsName;
	private String lastName;
	private String birthday;
	private String address;

}
