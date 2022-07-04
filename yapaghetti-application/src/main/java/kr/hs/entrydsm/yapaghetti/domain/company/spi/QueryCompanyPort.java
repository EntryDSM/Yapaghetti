package kr.hs.entrydsm.yapaghetti.domain.company.spi;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;

import java.util.UUID;

public interface QueryCompanyPort {
    Company findCompanyByUserId(UUID id);
}
