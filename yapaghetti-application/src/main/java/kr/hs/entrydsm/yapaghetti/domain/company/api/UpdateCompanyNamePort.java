package kr.hs.entrydsm.yapaghetti.domain.company.api;

import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainUpdateCompanyNameRequest;

public interface UpdateCompanyNamePort {
    void execute(DomainUpdateCompanyNameRequest request);
}
