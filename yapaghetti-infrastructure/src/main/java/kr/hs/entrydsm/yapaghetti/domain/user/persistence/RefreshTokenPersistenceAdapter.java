package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.RefreshToken;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.RefreshTokenNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.mapper.RefreshTokenMapper;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.RefreshTokenPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class RefreshTokenPersistenceAdapter implements RefreshTokenPort {

    private final RefreshTokenRepository refreshTokenRepository;
    private final RefreshTokenMapper refreshTokenMapper;

    @Override
    public RefreshToken queryRefreshTokenByToken(String token) {
        return refreshTokenMapper
                .entityToDomain(refreshTokenRepository.findByRefreshToken(token)
                        .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION));
    }

    @Override
    public void saveRefreshToken(RefreshToken refreshToken) {
        refreshTokenRepository.save(
                refreshTokenMapper.domainToEntity(refreshToken)
        );
    }
}
