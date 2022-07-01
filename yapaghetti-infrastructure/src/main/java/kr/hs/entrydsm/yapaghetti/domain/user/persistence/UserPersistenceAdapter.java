package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import java.util.Optional;
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
}
