package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.ResetPasswordResponse;

import java.util.UUID;

public interface ResetPasswordPort {
    ResetPasswordResponse execute(UUID companyId);
}
