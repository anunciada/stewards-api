package br.com.anunciada.stewards_api.infra.controller;

import br.com.anunciada.stewards_api.application.usecase.transaction.CreateTransactionUseCase;
import br.com.anunciada.stewards_api.application.usecase.transaction.ListTransactionsUseCase;
import br.com.anunciada.stewards_api.infra.controller.request.CreateTransactionRequest;
import br.com.anunciada.stewards_api.infra.controller.response.ListTransactionResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final CreateTransactionUseCase createTransactionUseCase;
    private final ListTransactionsUseCase listTransactionsUseCase;

    public TransactionController(CreateTransactionUseCase createTransactionUseCase, ListTransactionsUseCase listTransactionsUseCase) {
        this.createTransactionUseCase = createTransactionUseCase;
        this.listTransactionsUseCase = listTransactionsUseCase;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ListTransactionResponse> listAllTransactions() {
        return listTransactionsUseCase.execute();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@Valid @RequestBody CreateTransactionRequest request) {
        createTransactionUseCase.execute(request);
    }

}