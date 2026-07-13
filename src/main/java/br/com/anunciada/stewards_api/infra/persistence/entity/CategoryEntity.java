package br.com.anunciada.stewards_api.infra.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import java.util.UUID;

@Getter
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    private UUID id;

    private String name;

    @Column(name = "group_id")
    private UUID groupId;

    public CategoryEntity() {
    }

    public CategoryEntity(
            UUID id,
            String name,
            UUID groupId
    ) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

}