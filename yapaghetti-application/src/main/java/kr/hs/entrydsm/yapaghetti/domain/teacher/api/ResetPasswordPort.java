package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.ResetCompanyPasswordResponse;

import java.util.UUID;

public interface ResetPasswordPort {
    ResetCompanyPasswordResponse execute(UUID companyId);
}
