package br.com.anunciada.stewards_api.application.usecase.category;

import java.util.UUID;

public record CreateCategoryCommand(String name, UUID groupId) { }