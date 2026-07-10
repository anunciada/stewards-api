package br.com.anunciada.stewards_api.infra.controller.response;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record ListCategoryResponse(@NotBlank String name, UUID groupId) {
}
