package kr.hs.entrydsm.yapaghetti.domain.company.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.api.QueryStudentListPort;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.QueryStudentListResponse;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryStudentPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class QueryStudentListUseCase implements QueryStudentListPort {

    private final CompanyQueryStudentPort companyQueryStudentPort;


    @Override
    public QueryStudentListResponse execute() {
        return null;
    }

}