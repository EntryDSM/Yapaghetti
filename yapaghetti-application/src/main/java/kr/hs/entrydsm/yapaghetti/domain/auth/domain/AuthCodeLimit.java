package kr.hs.entrydsm.yapaghetti.domain.auth.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class AuthCodeLimit {

	private final String value;

	private final AuthCodeType type;

	private final Long timeToLive;

	private final int count;

	public AuthCodeLimit upCount() {
		return AuthCodeLimit.builder()
			.value(this.value)
			.type(this.type)
			.timeToLive(this.timeToLive)
			.count(this.count + 1)
			.build();
	}
}
