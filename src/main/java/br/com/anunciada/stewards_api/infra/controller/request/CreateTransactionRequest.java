package br.com.anunciada.stewards_api.infra.controller.request;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreateTransactionRequest(
        @NotBlank String groupId,
        @NotBlank String categoryId,
        String description,
        String type,
        String paymentMethod,
        BigDecimal value,
        String transactionDate
) {
}