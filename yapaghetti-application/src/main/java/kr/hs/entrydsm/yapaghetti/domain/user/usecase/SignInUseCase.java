package kr.hs.entrydsm.yapaghetti.domain.user.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.user.api.SignInPort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainSignInRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response.SignInResponse;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.RefreshToken;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserInvalidPasswordException;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserInvalidRoleException;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandRefreshTokenPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserJwtPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.dto.SpiTokenResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SignInUseCase implements SignInPort {

    private final QueryUserPort queryUserPort;
    private final UserSecurityPort userSecurityPort;
    private final UserJwtPort userJwtPort;
    private final CommandRefreshTokenPort commandRefreshTokenPort;

    @Override
    public SignInResponse signIn(DomainSignInRequest request) {
        User user = queryUserPort.queryUserByEmail(request.getEmail());

        if (!userSecurityPort.matches(request.getPassword(), user.getPassword())) {
            throw UserInvalidPasswordException.EXCEPTION;
        }

        if (!user.getRole().equals(request.getUserType())) {
            throw UserInvalidRoleException.EXCEPTION;
        }

        SpiTokenResponse tokenResponse = userJwtPort.getToken(user.getId(), user.getRole());

        commandRefreshTokenPort.saveRefreshToken(
                RefreshToken.builder()
                        .id(user.getId().toString())
                        .refreshToken(tokenResponse.getRefreshToken())
                        .ttl(tokenResponse.getRefreshExp())
                        .build()
        );

        return SignInResponse.builder()
                .firstLogin(!user.isVisited())
                .userType(user.getRole())
                .accessToken(tokenResponse.getAccessToken())
                .refreshToken(tokenResponse.getRefreshToken())
                .build();
    }

}
