package br.com.anunciada.stewards_api.application.service;

import br.com.anunciada.stewards_api.application.ports.out.TransactionPersistencePort;
import br.com.anunciada.stewards_api.application.usecase.transaction.ListTransactionsUseCase;
import br.com.anunciada.stewards_api.infra.controller.response.ListTransactionResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListTransactionService implements ListTransactionsUseCase {

    private final TransactionPersistencePort transactionPersistencePort;

    public ListTransactionService(TransactionPersistencePort transactionPersistencePort) {
        this.transactionPersistencePort = transactionPersistencePort;
    }

    @Override
    public List<ListTransactionResponse> execute(UUID groupId) {
        return transactionPersistencePort.findAll(groupId);
    }
}
