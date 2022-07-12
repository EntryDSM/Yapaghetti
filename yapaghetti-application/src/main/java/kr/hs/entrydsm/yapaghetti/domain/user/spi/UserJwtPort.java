package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.dto.SpiTokenResponse;

import java.util.UUID;

public interface UserJwtPort {
    SpiTokenResponse getToken(UUID userId, UserRole userRole);
}
