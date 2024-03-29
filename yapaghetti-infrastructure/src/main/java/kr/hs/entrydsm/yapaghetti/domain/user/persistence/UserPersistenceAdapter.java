package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
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
    public boolean existsUserByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public String getTeacherEmail() {
        return userRepository.findByRole(UserRole.TEACHER)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION)
                .getEmail();
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
    public UUID saveUserAndGetId(User user) {
        return userRepository.save(userMapper.domainToEntity(user)).getId();
    }

    @Override
    public User saveUserAndGetUser(User user) {
        return userMapper.entityToDomain(
                userRepository.save(
                        userMapper.domainToEntity(user)
                )
        );
    }
}
