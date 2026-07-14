package br.com.anunciada.stewards_api.application.usecase.transaction;

import br.com.anunciada.stewards_api.infra.controller.request.CreateTransactionRequest;

public interface CreateTransactionUseCase {

    void execute(CreateTransactionRequest request);

}
