package br.com.anunciada.stewards_api.infra.persistence.adapter;

import br.com.anunciada.stewards_api.application.ports.out.CategoryPersistencePort;
import br.com.anunciada.stewards_api.application.ports.out.TransactionPersistencePort;
import br.com.anunciada.stewards_api.domain.model.Category;
import br.com.anunciada.stewards_api.domain.model.Transaction;
import br.com.anunciada.stewards_api.infra.controller.response.ListCategoryResponse;
import br.com.anunciada.stewards_api.infra.controller.response.ListTransactionResponse;
import br.com.anunciada.stewards_api.infra.persistence.entity.CategoryEntity;
import br.com.anunciada.stewards_api.infra.persistence.entity.TransactionEntity;
import br.com.anunciada.stewards_api.infra.persistence.repository.CategoryRepository;
import br.com.anunciada.stewards_api.infra.persistence.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TransactionPersistenceAdapter implements TransactionPersistencePort {

    private final TransactionRepository repository;

    public TransactionPersistenceAdapter(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Transaction transaction) {
        repository.save(
                new TransactionEntity(
                        transaction.getId(),
                        transaction.getGroupId(),
                        transaction.getCategoryId(),
                        transaction.getDescription(),
                        transaction.getType(),
                        transaction.getPaymentMethod(),
                        transaction.getValue(),
                        transaction.getTransactionDate()
                )
        );
    }

    @Override
    public List<ListTransactionResponse> findAll() {
        return repository.findAll()
            .stream()
            .map(transaction ->
                    new ListTransactionResponse(
                            transaction.getId(),
                            transaction.getGroupId(),
                            transaction.getCategoryId(),
                            transaction.getDescription(),
                            transaction.getType(),
                            transaction.getPaymentMethod(),
                            transaction.getValue(),
                            transaction.getTransactionDate()))
            .toList();
    }

}