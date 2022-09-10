package kr.hs.entrydsm.yapaghetti.domain.company.usecase;


import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainUpdateCompanyNameRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanySecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.QueryCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UpdateCompanyNameUseCaseTest {

    @Mock
    private QueryCompanyPort queryCompanyPort;

    @Mock
    private CommandCompanyPort commandCompanyPort;

    @Mock
    private CompanySecurityPort companySecurityPort;

    @Mock
    private CompanyQueryUserPort companyQueryUserPort;

    @Mock
    private CompanyCommandUserPort companyCommandUserPort;

    @InjectMocks
    private UpdateCompanyNameUseCase updateCompanyNameUseCase;

    @Test
    void execute() {
        UUID userId = UUID.randomUUID();

        DomainUpdateCompanyNameRequest request = DomainUpdateCompanyNameRequest.builder()
                .companyName("테스트")
                .location("테스트")
                .profileImagePath("테스트")
                .name("테스트")
                .phoneNumber("테스트")
                .build();

        given(companySecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(queryCompanyPort.queryCompanyById(userId))
                .willReturn(
                        Company.builder()
                                .companyName("테스트")
                                .build()
                );
        given(companyQueryUserPort.queryUserById(userId))
                .willReturn(User.builder().build());



        updateCompanyNameUseCase.execute(request);

    }

}