package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import java.util.Optional;
import java.util.UUID;

import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>, UserQuerydslExtension {
	Optional<UserEntity> findByEmail(String email);
	Optional<UserEntity> findByPublicId(UUID publicId);
}
