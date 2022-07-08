package kr.hs.entrydsm.yapaghetti.domain.company.api;

import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainQueryStudentListRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.QueryStudentListResponse;

public interface QueryStudentListPort {
    QueryStudentListResponse execute(DomainQueryStudentListRequest request);
}
