package kr.hs.entrydsm.yapaghetti.domain.user.usecase;


import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainFirstPasswordUpdateRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserInvalidPasswordException;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserJwtPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FirstPasswordUpdateUseCaseTest {

    @Mock
    QueryUserPort queryUserPort;

    @Mock
    CommandUserPort commandUserPort;

    @Mock
    UserSecurityPort userSecurityPort;

    @Mock
    UserJwtPort userJwtPort;

    @InjectMocks
    FirstPasswordUpdateUseCase firstPasswordUseCase;

    @Mock
    DomainFirstPasswordUpdateRequest request;

    @Test
    void 잘못된_비밀번호() {
        String password = "wrongPWD";

        given(request.getPassword()).willReturn(password);
        given(userSecurityPort.getCurrentUserId())
                .willReturn(UUID.randomUUID());
        given(queryUserPort.queryUserById(any()))
                .willReturn(
                        User.builder()
                                .password("PWD")
                                .build()
                );
        given(userSecurityPort.matches(password, "PWD")).willReturn(false);

        assertThatThrownBy(() -> firstPasswordUseCase.firstPasswordUpdate(request))
                .isInstanceOf(UserInvalidPasswordException.class);
    }

    @Test
    void firstPassword() {
        String password = "PWD";
        String newPassword = "testNewPWD";

        given(request.getPassword()).willReturn(password);
        given(request.getNewPassword()).willReturn(newPassword);
        given(userSecurityPort.getCurrentUserId())
                .willReturn(UUID.randomUUID());
        given(queryUserPort.queryUserById(any()))
                .willReturn(
                        User.builder()
                                .password(password)
                                .build()
                );
        given(userSecurityPort.matches(password, password)).willReturn(true);

        firstPasswordUseCase.firstPasswordUpdate(request);
    }

}