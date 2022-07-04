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

    private final QueryCompanyPort companyPersistenceAdapter;
    private final CommandCompanyPort commandCompanyPort;
    private final CompanySecurityPort companySecurityAdapter;

    @Override
    public void execute(DomainUpdateCompanyNameRequest request) {
        UUID userId = companySecurityAdapter.getCurrentUserId();

        Company company = companyPersistenceAdapter.findCompanyByUserId(userId)
                .updateCompanyName(request.getCompanyName());

        commandCompanyPort.updateCompany(company);
    }

}