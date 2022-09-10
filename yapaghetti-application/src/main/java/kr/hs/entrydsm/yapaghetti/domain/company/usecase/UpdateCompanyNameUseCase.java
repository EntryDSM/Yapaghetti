package kr.hs.entrydsm.yapaghetti.domain.company.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.api.UpdateCompanyNamePort;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainUpdateCompanyNameRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanySecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.QueryCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class UpdateCompanyNameUseCase implements UpdateCompanyNamePort {

    private final QueryCompanyPort companyPersistencePort;
    private final CommandCompanyPort commandCompanyPort;
    private final CompanyQueryUserPort companyQueryUserPort;
    private final CompanyCommandUserPort companyCommandUserPort;
    private final CompanySecurityPort companySecurityPort;

    @Override
    public void execute(DomainUpdateCompanyNameRequest request) {
        UUID userId = companySecurityPort.getCurrentUserId();

        User user = companyQueryUserPort.queryUserById(userId);

        Company company = companyPersistencePort.queryCompanyById(userId);

        user.setInformation(
                request.getLocation(),
                request.getName(),
                request.getPhoneNumber(),
                request.getProfileImagePath()
        );


        company.updateCompanyName(request.getCompanyName());

        companyCommandUserPort.saveUser(user);
        commandCompanyPort.saveCompany(company);
    }

}