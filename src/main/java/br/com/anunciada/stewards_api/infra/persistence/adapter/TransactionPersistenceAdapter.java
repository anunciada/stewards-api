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
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class TransactionPersistenceAdapter implements TransactionPersistencePort {

    private final TransactionRepository repository;
    private final CategoryRepository categoryRepository;

    public TransactionPersistenceAdapter(TransactionRepository repository,
                                         CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Transaction transaction) {
        repository.save(
                new TransactionEntity(
                        transaction.getId(),
                        transaction.getGroupId(),
                        this.categoryRepository.findById(transaction.getCategoryId()).orElseThrow(),
                        transaction.getDescription(),
                        transaction.getType(),
                        transaction.getPaymentMethod(),
                        transaction.getValue(),
                        transaction.getTransactionDate()
                )
        );
    }

    @Override
    public List<ListTransactionResponse> findAll(UUID groupId) {
        return repository.findAllByGroupId(groupId)
                .stream()
                .map(transaction -> new ListTransactionResponse(
                        transaction.getId(),
                        transaction.getGroupId(),
                        transaction.getCategory().getName(),
                        transaction.getDescription(),
                        transaction.getType(),
                        transaction.getPaymentMethod(),
                        transaction.getValue(),
                        transaction.getTransactionDate()
                ))
                .toList();
    }
}