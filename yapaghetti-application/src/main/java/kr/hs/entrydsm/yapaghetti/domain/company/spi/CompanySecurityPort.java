package kr.hs.entrydsm.yapaghetti.domain.company.spi;

import java.util.UUID;

public interface CompanySecurityPort {
    UUID getCurrentUserId();
}
