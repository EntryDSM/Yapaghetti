package kr.hs.entrydsm.yapaghetti.domain.company.persistence;

import java.util.Optional;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.company.persistence.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByUserEntityId(UUID userId);
}
