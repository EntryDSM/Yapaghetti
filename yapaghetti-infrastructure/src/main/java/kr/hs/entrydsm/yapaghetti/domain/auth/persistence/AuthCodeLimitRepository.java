package kr.hs.entrydsm.yapaghetti.domain.auth.persistence;

import kr.hs.entrydsm.yapaghetti.domain.auth.persistence.entity.AuthCodeLimitEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthCodeLimitRepository extends CrudRepository<AuthCodeLimitEntity, String> {

}
