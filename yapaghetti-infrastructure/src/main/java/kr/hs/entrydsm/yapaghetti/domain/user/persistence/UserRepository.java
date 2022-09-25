package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID>, UserQuerydslExtension {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(UUID userId);

    Optional<UserEntity> findByRole(UserRole role);
}
