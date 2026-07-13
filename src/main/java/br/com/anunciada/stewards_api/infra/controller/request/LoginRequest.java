package br.com.anunciada.stewards_api.infra.controller.request;

public record LoginRequest(
        String username,
        String password
) {
}
