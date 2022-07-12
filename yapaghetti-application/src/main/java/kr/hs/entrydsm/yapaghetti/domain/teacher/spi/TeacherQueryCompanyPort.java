package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.CompanyElement;

import java.util.List;
import java.util.UUID;

public interface TeacherQueryCompanyPort {
    Company queryCompanyById(UUID companyId);
    List<CompanyElement> queryCompanyDetailList(String name);
}
