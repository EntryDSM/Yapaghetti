package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResetPasswordResponse {
    private final String password;
}
