package kr.hs.entrydsm.yapaghetti.domain.company.usecase;

import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanySecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QueryCompanyInfoUseCaseTest {

    @Mock
    CompanySecurityPort companySecurityPort;

    @Mock
    CompanyQueryUserPort companyQueryUserPort;

    @InjectMocks
    QueryCompanyInfoUseCase queryCompanyInfoUseCase;

    @Test
    void 기업_정보_조회() {
        UUID userId = UUID.randomUUID();

        User user = User.builder()
                .location("테스트")
                .name("테스트")
                .phoneNumber("테스트")
                .build();

        given(companySecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(companyQueryUserPort.queryUserById(userId))
                .willReturn(user);

        queryCompanyInfoUseCase.execute();
    }

}