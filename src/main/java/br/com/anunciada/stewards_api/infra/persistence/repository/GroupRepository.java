package br.com.anunciada.stewards_api.infra.persistence.repository;

import br.com.anunciada.stewards_api.infra.persistence.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {

    Optional<GroupEntity> findByUsername(String username);

}
