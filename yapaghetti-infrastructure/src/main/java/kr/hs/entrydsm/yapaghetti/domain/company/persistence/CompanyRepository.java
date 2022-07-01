package kr.hs.entrydsm.yapaghetti.domain.company.persistence;

import java.util.Optional;

import kr.hs.entrydsm.yapaghetti.domain.company.persistence.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
	Optional<CompanyEntity> findByUserEmail(String email);
}
