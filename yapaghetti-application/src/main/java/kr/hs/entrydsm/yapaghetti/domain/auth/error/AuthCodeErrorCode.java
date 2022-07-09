package kr.hs.entrydsm.yapaghetti.domain.auth.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AuthCodeErrorCode implements ErrorProperty {

	AUTH_CODE_LIMIT_NOT_FOUND(404, "인증횟수 제한을 찾을 수 없습니다."),

	AUTH_CODE_OVER_LIMIT(429, "Email Code Request Over Limit");

	private final int status;
	private final String message;
}
