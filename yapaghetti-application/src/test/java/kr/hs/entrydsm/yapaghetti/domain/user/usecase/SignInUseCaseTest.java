package kr.hs.entrydsm.yapaghetti.domain.user.usecase;

import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainSignInRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserInvalidPasswordException;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserInvalidRoleException;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandRefreshTokenPort;
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

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SignInUseCaseTest {

    @Mock
    QueryUserPort queryUserPort;

    @Mock
    UserSecurityPort userSecurityPort;

    @Mock
    UserJwtPort userJwtPort;

    @Mock
    CommandRefreshTokenPort commandRefreshTokenPort;

    @InjectMocks
    SignInUseCase signInUseCase;

    @Mock
    DomainSignInRequest request;

    @Test
    void 잘못된_비밀번호() {
        String email = "testEMAIL";
        String password = "testPWD";
        UserRole role = UserRole.STUDENT;

        given(queryUserPort.queryUserByEmail(email)).willReturn(
                User.builder()
                        .email(email)
                        .password(password)
                        .role(role)
                        .build()
        );
        given(userSecurityPort.matches(password, password)).willReturn(false);
        given(request.getEmail()).willReturn(email);
        given(request.getPassword()).willReturn(password);

        assertThatThrownBy(() -> signInUseCase.signIn(request))
                .isInstanceOf(UserInvalidPasswordException.class);
    }

    @Test
    void 잘못된역할() {
        String email = "testEMAIL";
        String password = "testPWD";
        UserRole role = UserRole.STUDENT;

        given(queryUserPort.queryUserByEmail(email)).willReturn(
                User.builder()
                        .email(email)
                        .password(password)
                        .role(UserRole.TEACHER)
                        .build()
        );
        given(userSecurityPort.matches(password, password)).willReturn(true);
        given(request.getEmail()).willReturn(email);
        given(request.getPassword()).willReturn(password);
        given(request.getUserType()).willReturn(role);

        assertThatThrownBy(() -> signInUseCase.signIn(request))
                .isInstanceOf(UserInvalidRoleException.class);
    }

    @Test
    void signIn() {
        String email = "testEMAIL";
        String password = "testPWD";
        UserRole role = UserRole.STUDENT;
        UUID userId = UUID.randomUUID();

        given(queryUserPort.queryUserByEmail(email)).willReturn(
                User.builder()
                        .id(userId)
                        .email(email)
                        .password(password)
                        .role(role)
                        .build()
        );
        given(userSecurityPort.matches(password, password)).willReturn(true);
        given(request.getEmail()).willReturn(email);
        given(request.getPassword()).willReturn(password);
        given(request.getUserType()).willReturn(role);
        given(userJwtPort.getToken(userId, role))
                .willReturn(
                        new SpiTokenResponse("testAccessToken", "testRefreshToken", 100L)
                );

        signInUseCase.signIn(request);
    }

}