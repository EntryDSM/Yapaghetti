package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

import java.util.UUID;

public interface AuthQueryUserPort {
    User queryUserById(UUID id);
}
