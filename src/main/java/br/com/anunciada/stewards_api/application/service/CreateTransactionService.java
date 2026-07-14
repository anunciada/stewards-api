package br.com.anunciada.stewards_api.application.service;

import br.com.anunciada.stewards_api.application.ports.out.TransactionPersistencePort;
import br.com.anunciada.stewards_api.application.usecase.transaction.CreateTransactionUseCase;
import br.com.anunciada.stewards_api.domain.model.Transaction;
import br.com.anunciada.stewards_api.infra.controller.request.CreateTransactionRequest;
import org.springframework.stereotype.Service;

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
                        request.groupId(),
                        request.categoryId(),
                        request.description(),
                        request.type(),
                        request.paymentMethod(),
                        request.value(),
                        request.transactionDate()
                );
        transactionPersistencePort.save(transaction);
    }
}
