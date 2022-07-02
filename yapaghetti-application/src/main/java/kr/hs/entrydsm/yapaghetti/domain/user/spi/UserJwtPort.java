package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import java.util.UUID;

public interface UserJwtPort {
    String generateAccessToken(UUID publicId, String role);
}
