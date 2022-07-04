package kr.hs.entrydsm.yapaghetti.domain.company.spi;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;

public interface CommandCompanyPort {
    void updateCompany(Company company);
}
