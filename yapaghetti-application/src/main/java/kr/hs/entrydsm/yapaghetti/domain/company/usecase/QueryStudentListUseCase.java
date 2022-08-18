package kr.hs.entrydsm.yapaghetti.domain.company.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.api.QueryStudentListPort;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainQueryStudentListRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.QueryStudentListResponse;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryStudentPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryStudentListUseCase implements QueryStudentListPort {

    private final CompanyQueryStudentPort companyQueryStudentPort;

    @Override
    public QueryStudentListResponse execute(DomainQueryStudentListRequest request) {
        return new QueryStudentListResponse(companyQueryStudentPort.findStudentByNameAndMajorAndClassNum(
                request.getName(),
                request.getMajorTag(),
                request.getClassNum()
        ));
    }

}
