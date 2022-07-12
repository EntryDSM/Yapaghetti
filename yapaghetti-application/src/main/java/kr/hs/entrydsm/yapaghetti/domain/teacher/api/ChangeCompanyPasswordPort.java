package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.ChangeCompanyPasswordResponse;

import java.util.UUID;

public interface ChangeCompanyPasswordPort {
    ChangeCompanyPasswordResponse execute(UUID companyId);
}
