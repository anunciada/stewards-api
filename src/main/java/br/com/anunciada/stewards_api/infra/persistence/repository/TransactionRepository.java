package br.com.anunciada.stewards_api.infra.persistence.repository;

import br.com.anunciada.stewards_api.infra.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {

}
