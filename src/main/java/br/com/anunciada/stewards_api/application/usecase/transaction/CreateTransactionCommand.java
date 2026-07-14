package br.com.anunciada.stewards_api.application.usecase.transaction;

import java.util.UUID;

public record CreateTransactionCommand(String name, UUID groupId) { }