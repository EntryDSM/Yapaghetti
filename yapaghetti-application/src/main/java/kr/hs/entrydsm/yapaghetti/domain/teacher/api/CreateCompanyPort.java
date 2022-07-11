package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainNewCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.NewCompanyResponse;

public interface CreateCompanyPort {
    NewCompanyResponse execute(DomainNewCompanyRequest request);
}
