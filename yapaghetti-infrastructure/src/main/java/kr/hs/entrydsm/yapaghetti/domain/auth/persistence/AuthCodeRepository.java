package kr.hs.entrydsm.yapaghetti.domain.auth.persistence;

import kr.hs.entrydsm.yapaghetti.domain.auth.persistence.entity.AuthCodeEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthCodeRepository extends CrudRepository<AuthCodeEntity, String> {
}
