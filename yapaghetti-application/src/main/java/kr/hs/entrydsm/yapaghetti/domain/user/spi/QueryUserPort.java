package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

import java.util.UUID;

public interface QueryUserPort {
    User queryUserByPublicId(UUID publicId);
    User queryUserByEmail(String email);
}
