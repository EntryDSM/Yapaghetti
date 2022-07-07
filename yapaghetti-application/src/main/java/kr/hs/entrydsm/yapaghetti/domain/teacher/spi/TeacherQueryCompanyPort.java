package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;

import java.util.UUID;

public interface TeacherQueryCompanyPort {
    Company queryCompanyByUserId(UUID companyId);
}
