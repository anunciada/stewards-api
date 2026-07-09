package br.com.anunciada.stewards_api.domain.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Category {

    private UUID id;
    private UUID groupId;
    private String name;

    public Category(UUID id, String name, UUID groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }
}