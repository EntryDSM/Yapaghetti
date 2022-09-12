package kr.hs.entrydsm.yapaghetti.domain.company.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.api.QueryCompanyInfoPort;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.QueryCompanyInfoResponse;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanySecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryCompanyInfoUseCase implements QueryCompanyInfoPort {

    private final CompanySecurityPort companySecurityPort;
    private final CompanyQueryUserPort companyQueryUserPort;

    @Override
    public QueryCompanyInfoResponse execute() {
        UUID userId = companySecurityPort.getCurrentUserId();

        User user = companyQueryUserPort.queryUserById(userId);

        return new QueryCompanyInfoResponse(
                user.getLocation(),
                user.getName(),
                user.getPhoneNumber()
        );
    }
}
