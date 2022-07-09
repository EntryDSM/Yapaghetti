package kr.hs.entrydsm.yapaghetti.domain.auth.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class AuthCode {

	private final String value;

	private final String authCode;

	private final AuthCodeType type;

	private final Long timeToLive;

	private final boolean isVerify;

}
