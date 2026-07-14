package br.com.anunciada.stewards_api.infra.controller.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ListTransactionResponse(
        UUID id,
        UUID groupId,
        UUID categoryId,
        String description,
        String type,
        String paymentMethod,
        BigDecimal value,
        LocalDate transactionDate) {
}
