package br.com.anunciada.stewards_api.infra.controller.request;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record CreateCategoryRequest(
        @NotBlank
        String name,
        UUID groupId) { }