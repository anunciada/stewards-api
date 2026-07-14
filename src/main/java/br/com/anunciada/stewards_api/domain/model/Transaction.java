package br.com.anunciada.stewards_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Transaction {

    private UUID id;
    private UUID groupId;
    private UUID categoryId;
    private String description;
    private String type;
    private String paymentMethod;
    private BigDecimal value;
    private LocalDate transactionDate;

}