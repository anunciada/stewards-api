package br.com.anunciada.stewards_api.application.ports.out;

import br.com.anunciada.stewards_api.domain.model.Transaction;
import br.com.anunciada.stewards_api.infra.controller.response.ListTransactionResponse;

import java.util.List;

public interface TransactionPersistencePort {

    void save(Transaction transaction);

    List<ListTransactionResponse> findAll();

}
