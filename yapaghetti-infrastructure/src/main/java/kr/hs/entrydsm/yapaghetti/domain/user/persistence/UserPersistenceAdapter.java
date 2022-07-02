package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import java.util.Optional;
import java.util.UUID;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.mapper.UserMapper;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements QueryUserPort, CommandUserPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<UserEntity> findUserByPublicId(UUID publicId) {
        return userRepository.findByPublicId(publicId);
    }

    @Override
    public User queryUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return userMapper.entityToDomain(userEntity);
    }
}
