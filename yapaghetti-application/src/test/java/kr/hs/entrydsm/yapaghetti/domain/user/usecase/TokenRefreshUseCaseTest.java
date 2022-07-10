package kr.hs.entrydsm.yapaghetti.domain.user.usecase;


import kr.hs.entrydsm.yapaghetti.domain.user.domain.RefreshToken;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandRefreshTokenPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryRefreshTokenPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserJwtPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.dto.SpiTokenResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TokenRefreshUseCaseTest {

    @Mock
    QueryUserPort queryUserPort;

    @Mock
    UserSecurityPort userSecurityPort;

    @Mock
    QueryRefreshTokenPort queryRefreshTokenPort;

    @Mock
    CommandRefreshTokenPort commandRefreshTokenPort;

    @Mock
    UserJwtPort userJwtPort;

    @InjectMocks
    TokenRefreshUseCase tokenRefreshUseCase;

    @Test
    void execute() {
        String token = "TOKEN";
        UserRole role = UserRole.STUDENT;
        UUID userId = UUID.randomUUID();

        given(queryRefreshTokenPort.queryRefreshTokenByToken(token))
                .willReturn(RefreshToken.builder().build());

        given(userSecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(queryUserPort.queryUserById(userId))
                .willReturn(
                        User.builder()
                                .id(userId)
                                .role(role)
                                .build());
        given(userJwtPort.getToken(userId, role))
                .willReturn(
                        new SpiTokenResponse("testAccessToken", "testRefreshToken", 100L)
                );

        tokenRefreshUseCase.execute(token);
    }

}