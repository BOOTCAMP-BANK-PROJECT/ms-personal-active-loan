package com.bootcamp.personal.active.loan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class PersonalLoan {


    @Id
    private String id;
    private String loanNumber;
    private String idClient;
    private String idPersonalLoanType;
    private BigDecimal creditAmount;
    private Date disbursementDay;
    private Date paymentDay;
    private Integer loanPeriod;
    private Integer loangracePeriod;
    private BigDecimal loanMonthInterestRate;
    private BigDecimal creditMoratoriumInterestRate;
    private String isoCurrencyCode;
    private BigDecimal loanInstallment;
    private short registrationStatus;
    private Date insertionDate;
    private String fk_insertionUser;
    private String insertionTerminal;
}
