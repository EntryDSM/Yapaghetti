package kr.hs.entrydsm.yapaghetti.domain.auth.domain;

import java.time.LocalDateTime;
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

	private final LocalDateTime authTime;

	private final boolean isVerify;

	public AuthCode refresh(String authCode, Long authTime) {
		return AuthCode.builder()
			.value(this.getValue())
			.authCode(authCode)
			.type(this.getType())
			.timeToLive(timeToLive + authTime)
			.authTime(this.authTime.plusSeconds(authTime))
			.isVerify(this.isVerify)
			.build();
	}

}
