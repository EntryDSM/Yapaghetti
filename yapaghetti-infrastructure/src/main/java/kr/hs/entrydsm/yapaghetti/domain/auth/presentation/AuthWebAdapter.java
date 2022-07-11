package kr.hs.entrydsm.yapaghetti.domain.auth.presentation;

import javax.validation.constraints.NotBlank;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.SendEmailAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.VerifyEmailAuthCodePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthWebAdapter {

	private final SendEmailAuthCodePort sendEmailAuthCodePort;
	private final VerifyEmailAuthCodePort verifyEmailAuthCodePort;

	@PostMapping("/email")
	public void sendEmailAuthCode() {
		sendEmailAuthCodePort.execute();
	}

	@RequestMapping(value = "/email", method = RequestMethod.HEAD)
	public void verifyEmailAuthCode(@NotBlank String authCode) {
		verifyEmailAuthCodePort.execute(authCode);
	}
}
