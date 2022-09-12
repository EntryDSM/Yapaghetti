package kr.hs.entrydsm.yapaghetti.domain.auth.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SendEmailAuthCodeResponse {

	private final String email;
}
