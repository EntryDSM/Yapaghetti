package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import java.util.UUID;

public interface DeleteCompanyPort {
    void execute(UUID companyId);
}
