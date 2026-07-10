package br.com.anunciada.stewards_api.application.usecase.category;

import java.util.UUID;

public record CategoryCommand(UUID id, String name, UUID groupId) { }
