package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.mapper.UserMapper;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements QueryUserPort, CommandUserPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<UserEntity> findUserByPublicId(UUID publicId) {
        return userRepository.findByPublicId(publicId);
    }

    @Override
    public User queryUserByPublicId(UUID publicId) {
        return userMapper.entityToDomain(
                userRepository.findByPublicId(publicId)
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION)
        );
    }

    @Override
    public User queryUserByEmail(String email) {
        return userMapper.entityToDomain(
                userRepository.findByEmail(email)
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION)
        );
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(userMapper.domainToEntity(user));
    }
}
