package br.com.anunciada.stewards_api.infra.persistence.repository;

import br.com.anunciada.stewards_api.infra.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {

    @Query("""
        SELECT t
        FROM TransactionEntity t
        JOIN FETCH t.category
        WHERE t.groupId = :groupId
    """)
    List<TransactionEntity> findAllByGroupId(UUID groupId);
}
