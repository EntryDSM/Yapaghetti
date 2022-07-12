package kr.hs.entrydsm.yapaghetti.domain.auth.presentation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.SendEmailAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.VerifyAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthWebAdapter {

	private final SendEmailAuthCodePort sendEmailAuthCodePort;
	private final VerifyAuthCodePort verifyAuthCodePort;

	@PostMapping("/email")
	public void sendEmailAuthCode() {
		sendEmailAuthCodePort.execute();
	}

	@RequestMapping(value = "/verify", method = RequestMethod.HEAD)
	public void verifyAuthCode(@RequestParam @NotBlank String authCode,
		@RequestParam @NotNull AuthCodeType type) {
		verifyAuthCodePort.execute(authCode, type);
	}
}
