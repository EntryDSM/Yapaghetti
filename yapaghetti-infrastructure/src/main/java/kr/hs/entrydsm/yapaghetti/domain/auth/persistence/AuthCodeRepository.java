package kr.hs.entrydsm.yapaghetti.domain.auth.persistence;

import java.util.Optional;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeType;
import kr.hs.entrydsm.yapaghetti.domain.auth.persistence.entity.AuthCodeEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthCodeRepository extends CrudRepository<AuthCodeEntity, String> {

	Optional<AuthCodeEntity> findByValueAndType(String value, AuthCodeType type);
}
