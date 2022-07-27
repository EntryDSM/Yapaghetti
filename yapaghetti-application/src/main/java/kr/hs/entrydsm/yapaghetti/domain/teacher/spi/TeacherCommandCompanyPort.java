package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;

public interface TeacherCommandCompanyPort {
    void deleteCompany(Company company);

    void saveCompany(Company company);
}
