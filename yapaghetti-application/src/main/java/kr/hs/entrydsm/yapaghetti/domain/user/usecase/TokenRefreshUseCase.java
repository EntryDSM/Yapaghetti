    package kr.hs.entrydsm.yapaghetti.domain.user.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.user.api.TokenRefreshPort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response.TokenRefreshResponse;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.RefreshToken;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.*;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.dto.SpiTokenResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class TokenRefreshUseCase implements TokenRefreshPort {

    private final QueryUserPort queryUserPort;
    private final UserSecurityPort userSecurityPort;
    private final QueryRefreshTokenPort queryRefreshTokenPort;
    private final CommandRefreshTokenPort commandRefreshTokenPort;
    private final UserJwtPort userJwtPort;

    @Override
    public TokenRefreshResponse execute(String token) {
        RefreshToken refreshTokenModel = queryRefreshTokenPort.queryRefreshTokenByToken(token);

        User user = queryUserPort.queryUserById(userSecurityPort.getCurrentUserId());

        SpiTokenResponse tokenResponse = userJwtPort.getToken(user.getId(), user.getRole());


        commandRefreshTokenPort.saveRefreshToken(
                refreshTokenModel.update(tokenResponse.getRefreshToken(), tokenResponse.getRefreshExp())
        );

        return new TokenRefreshResponse(
                user.getRole(),
                tokenResponse.getAccessToken(),
                tokenResponse.getRefreshToken()
        );
    }

}
