package br.com.anunciada.stewards_api.infra.controller;

import br.com.anunciada.stewards_api.application.usecase.transaction.CreateTransactionUseCase;
import br.com.anunciada.stewards_api.application.usecase.transaction.ListTransactionsUseCase;
import br.com.anunciada.stewards_api.infra.controller.request.CreateTransactionRequest;
import br.com.anunciada.stewards_api.infra.controller.response.ListCategoryResponse;
import br.com.anunciada.stewards_api.infra.controller.response.ListTransactionResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final CreateTransactionUseCase createTransactionUseCase;
    private final ListTransactionsUseCase listTransactionsUseCase;

    public TransactionController(CreateTransactionUseCase createTransactionUseCase, ListTransactionsUseCase listTransactionsUseCase) {
        this.createTransactionUseCase = createTransactionUseCase;
        this.listTransactionsUseCase = listTransactionsUseCase;
    }


    @GetMapping("/{groupId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ListTransactionResponse> listTransactionByGroup(@PathVariable UUID groupId) {
        return listTransactionsUseCase.execute(groupId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@Valid @RequestBody CreateTransactionRequest request) {
        createTransactionUseCase.execute(request);
    }

}