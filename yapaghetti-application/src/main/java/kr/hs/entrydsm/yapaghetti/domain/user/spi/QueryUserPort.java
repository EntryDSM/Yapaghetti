package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

import java.util.UUID;

public interface QueryUserPort {
    User queryUserById(UUID id);
    User queryUserByEmail(String email);
}
