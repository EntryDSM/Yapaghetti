package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import java.util.Optional;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements QueryUserPort, CommandUserPort {

    private final UserRepository userRepository;

    public Optional<UserEntity> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User queryUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return User.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .name(userEntity.getName())
                .profileImagePath(userEntity.getProfileImagePath())
                .phoneNumber(userEntity.getPhoneNumber())
                .location(userEntity.getLocation())
                .isVisited(userEntity.isVisited())
                .publicId(userEntity.getPublicId())
                .role(userEntity.getRole())
                .build();
    }
}
