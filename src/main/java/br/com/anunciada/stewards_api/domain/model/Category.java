package br.com.anunciada.stewards_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Category {

    private UUID id;
    private UUID groupId;
    private String name;

}