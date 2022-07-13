package kr.hs.entrydsm.yapaghetti.domain.auth.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AuthCodeErrorCode implements ErrorProperty {

	INVALID_AUTH_CODE(401, "잘못된 인증코드 입니다."),

	AUTH_CODE_NOT_FOUND(404, "인증코드를 찾을 수 없습니다."),

	AUTH_CODE_ALREADY_TIMEOUT(408, "인증시간이 초과된 인증코드 입니다."),

	AUTH_CODE_ALREADY_VERIFIED(409, "이미 인증된 인증코드 입니다."),

	AUTH_CODE_OVER_LIMIT(429, "인증 제한 횟수를 초과했습니다.");

	private final int status;
	private final String message;
}
