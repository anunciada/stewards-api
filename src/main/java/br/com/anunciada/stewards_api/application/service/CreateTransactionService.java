package br.com.anunciada.stewards_api.application.service;

import br.com.anunciada.stewards_api.application.ports.out.TransactionPersistencePort;
import br.com.anunciada.stewards_api.application.usecase.transaction.CreateTransactionUseCase;
import br.com.anunciada.stewards_api.domain.model.Transaction;
import br.com.anunciada.stewards_api.infra.controller.request.CreateTransactionRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class CreateTransactionService implements CreateTransactionUseCase {

    private final TransactionPersistencePort transactionPersistencePort;

    public CreateTransactionService(TransactionPersistencePort transactionPersistencePort) {
        this.transactionPersistencePort = transactionPersistencePort;
    }

    @Override
    public void execute(CreateTransactionRequest request) {
        Transaction transaction = new Transaction(
                        UUID.randomUUID(),
                        UUID.fromString(request.groupId()),
                        UUID.fromString(request.categoryId()),
                        request.description(),
                        request.type(),
                        request.paymentMethod(),
                        request.value(),
                        LocalDate.parse(request.transactionDate())
                );
        transactionPersistencePort.save(transaction);
    }
}
