package kr.hs.entrydsm.yapaghetti.domain.company.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.api.UpdateCompanyNamePort;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainUpdateCompanyNameRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanySecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.QueryCompanyPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class UpdateCompanyNameUseCase implements UpdateCompanyNamePort {

    private final QueryCompanyPort companyPersistencePort;
    private final CommandCompanyPort commandCompanyPort;
    private final CompanySecurityPort companySecurityPort;

    @Override
    public void execute(DomainUpdateCompanyNameRequest request) {
        UUID userId = companySecurityPort.getCurrentUserId();

        Company company = companyPersistencePort.queryCompanyById(userId)
                .updateCompanyName(request.getCompanyName());

        commandCompanyPort.saveCompany(company);
    }

}