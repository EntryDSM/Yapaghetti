package kr.hs.entrydsm.yapaghetti.domain.user.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.user.api.SignInPort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainSignInRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response.SignInResponse;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserInvalidPasswordException;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserInvalidRoleException;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserJwtPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SignInUseCase implements SignInPort {

    private final QueryUserPort queryUserPort;
    private final UserSecurityPort userSecurityPort;
    private final UserJwtPort userJwtPort;

    @Override
    public SignInResponse signIn(DomainSignInRequest request) {
        User user = queryUserPort.queryUserByEmail(request.getEmail());

        if (!userSecurityPort.matches(request.getPassword(), user.getPassword())) {
            throw UserInvalidPasswordException.EXCEPTION;
        }

        if (!user.getRole().equals(request.getUserType())) {
            throw UserInvalidRoleException.EXCEPTION;
        }

        return SignInResponse.builder()
                .firstLogin(user.isVisited())
                .userType(user.getRole())
                .accessToken(userJwtPort.generateAccessToken(user.getId(), user.getRole().name()))
                //TODO refreshToken
                .build();
    }

}
