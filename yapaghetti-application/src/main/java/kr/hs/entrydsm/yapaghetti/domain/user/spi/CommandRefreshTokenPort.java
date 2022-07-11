package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.RefreshToken;

public interface CommandRefreshTokenPort {
    void saveRefreshToken(RefreshToken refreshToken);
}
