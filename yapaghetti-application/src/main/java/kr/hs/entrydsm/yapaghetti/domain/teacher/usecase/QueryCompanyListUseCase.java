package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.QueryCompanyListPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.CompanyListResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryCompanyListUseCase implements QueryCompanyListPort {

    private final TeacherQueryCompanyPort teacherQueryCompanyPort;

    @Override
    public CompanyListResponse execute(String name) {
        return new CompanyListResponse(
                teacherQueryCompanyPort.queryCompanyDetailList(name)
        );
    }

}
