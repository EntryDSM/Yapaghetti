package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.UpdateCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainUpdateCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UpdateCompanyUseCase implements UpdateCompanyPort {

    private final TeacherCommandUserPort teacherCommandUserPort;
    private final TeacherQueryUserPort teacherQueryUserPort;
    private final TeacherCommandCompanyPort teacherCommandCompanyPort;
    private final TeacherQueryCompanyPort teacherQueryCompanyPort;

    @Override
    public void execute(DomainUpdateCompanyRequest request) {

        Company company = teacherQueryCompanyPort.queryCompanyById(request.getCompanyId());

        teacherCommandCompanyPort.updateCompany(
                company.updateCompanyNameAndDates(
                        request.getCompanyName(),
                        request.getStartAt(),
                        request.getEndAt()
                )
        );
    }

}
