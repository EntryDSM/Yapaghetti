package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import kr.hs.entrydsm.yapaghetti.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.user.spi.CommandUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements QueryUserPort, CommandUserPort {

    private final UserRepository userRepository;
}
