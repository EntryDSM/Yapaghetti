package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainUpdateCompanyRequest;

public interface UpdateCompanyPort {
    void execute(DomainUpdateCompanyRequest request);
}
