package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResetPasswordResponse {
    private final String password;
}
