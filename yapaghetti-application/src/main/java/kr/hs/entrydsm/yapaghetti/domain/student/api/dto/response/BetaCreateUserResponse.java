package kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BetaCreateUserResponse {
	private final String email;
	private final String password;
}
