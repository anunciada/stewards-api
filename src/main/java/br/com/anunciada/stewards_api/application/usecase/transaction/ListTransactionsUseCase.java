package br.com.anunciada.stewards_api.application.usecase.transaction;

import br.com.anunciada.stewards_api.infra.controller.response.ListTransactionResponse;

import java.util.List;

public interface ListTransactionsUseCase {

    List<ListTransactionResponse> execute();

}
