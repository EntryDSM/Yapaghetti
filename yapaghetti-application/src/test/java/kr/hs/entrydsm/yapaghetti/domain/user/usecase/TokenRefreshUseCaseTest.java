package kr.hs.entrydsm.yapaghetti.domain.user.usecase;


import kr.hs.entrydsm.yapaghetti.domain.user.domain.RefreshToken;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.*;
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
        UUID userId = UUID.randomUUID();

        given(queryRefreshTokenPort.queryRefreshTokenByToken(token))
                .willReturn(RefreshToken.builder().build());

        given(userSecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(queryUserPort.queryUserById(userId))
                .willReturn(User.builder().build());
        
        tokenRefreshUseCase.execute(token);
    }

}