package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.DeleteCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DeleteCompanyUseCase implements DeleteCompanyPort {

    private final TeacherCommandCompanyPort teacherCommandCompanyPort;
    private final TeacherQueryCompanyPort teacherQueryCompanyPort;

    @Override
    public void execute(UUID companyId) {
        Company company = teacherQueryCompanyPort.queryCompanyById(companyId);

        teacherCommandCompanyPort.deleteCompany(company);
    }
    
}
