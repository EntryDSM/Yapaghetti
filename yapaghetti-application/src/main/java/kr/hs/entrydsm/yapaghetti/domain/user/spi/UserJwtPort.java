package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;

import java.util.UUID;

public interface UserJwtPort {
    String generateAccessToken(UUID publicId, UserRole role);
}
