package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.mapper.UserMapper;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class UserPersistenceAdapter implements UserPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<UserEntity> findUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public User queryUserById(UUID userId) {
        return userMapper.entityToDomain(
                userRepository.findById(userId)
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

    @Override
    public UUID saveuserandgetUserId(User user) {
        return userRepository.save(
                userMapper.domainToEntity(user)
        ).getId();
    }
}
