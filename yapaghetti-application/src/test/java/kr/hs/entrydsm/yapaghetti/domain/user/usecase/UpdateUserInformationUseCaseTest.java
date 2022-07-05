package kr.hs.entrydsm.yapaghetti.domain.user.usecase;


import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainUpdateUserInformationRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UpdateUserInformationUseCaseTest {

    @Mock
    UserSecurityPort userSecurityPort;

    @Mock
    QueryUserPort queryUserPort;

    @Mock
    CommandUserPort commandUserPort;

    @InjectMocks
    UpdateUserInformationUseCase updateUserInformationUseCase;

    @Mock
    DomainUpdateUserInformationRequest request;

    @Test
    void execute() {
        UUID userId = UUID.randomUUID();
        given(userSecurityPort.getCurrentUserId()).willReturn(userId);
        given(queryUserPort.queryUserById(userId)).willReturn(
                User.builder()
                        .id(userId)
                        .build()
        );

        updateUserInformationUseCase.execute(request);
    }

}