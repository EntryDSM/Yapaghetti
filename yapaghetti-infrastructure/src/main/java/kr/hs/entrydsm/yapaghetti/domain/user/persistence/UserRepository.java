package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID>, UserQuerydslExtension {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(UUID userId);
}
