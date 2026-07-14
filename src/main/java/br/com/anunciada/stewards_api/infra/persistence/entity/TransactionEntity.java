package br.com.anunciada.stewards_api.infra.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    private UUID id;

    @Column(name = "group_id")
    private UUID groupId;

    @Column(name = "category_id")
    private UUID categoryId;

    private String description;

    private String type;

    @Column(name = "payment_method")
    private String paymentMethod;

    private BigDecimal value;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

}
