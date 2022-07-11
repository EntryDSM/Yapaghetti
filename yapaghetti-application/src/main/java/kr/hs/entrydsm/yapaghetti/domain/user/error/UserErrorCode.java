package kr.hs.entrydsm.yapaghetti.domain.user.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserErrorCode implements ErrorProperty {
    USER_INVALID_PASSWORD(401, "잘못된 비밀번호입니다."),
    USER_INVALID_ROLE(401, "잘못된 역할입니다."),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),

    REFRESH_TOKEN_NOT_FOUND(404, "리프레시 토큰을 찾을 수 없습니다.");

    private final int status;
    private final String message;
}
