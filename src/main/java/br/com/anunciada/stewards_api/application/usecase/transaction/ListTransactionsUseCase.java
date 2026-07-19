package br.com.anunciada.stewards_api.application.usecase.transaction;

import br.com.anunciada.stewards_api.infra.controller.response.ListTransactionResponse;

import java.util.List;
import java.util.UUID;

public interface ListTransactionsUseCase {

    List<ListTransactionResponse> execute(UUID groupId);

}
