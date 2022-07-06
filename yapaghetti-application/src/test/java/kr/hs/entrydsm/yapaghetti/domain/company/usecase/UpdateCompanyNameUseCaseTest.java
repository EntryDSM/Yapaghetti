package kr.hs.entrydsm.yapaghetti.domain.company.usecase;


import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainUpdateCompanyNameRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanySecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.QueryCompanyPort;
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

    @InjectMocks
    private UpdateCompanyNameUseCase updateCompanyNameUseCase;

    @Mock
    DomainUpdateCompanyNameRequest request;

    @Test
    void execute() {
        UUID userId = UUID.randomUUID();
        given(companySecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(queryCompanyPort.queryCompanyByUserId(userId))
                .willReturn(
                        Company.builder()
                                .companyName("테스트")
                                .build()
                );
        given(request.getCompanyName())
                .willReturn("테스트");

        updateCompanyNameUseCase.execute(request);

    }

}