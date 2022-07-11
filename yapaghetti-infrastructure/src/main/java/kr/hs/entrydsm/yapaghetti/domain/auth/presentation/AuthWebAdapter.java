package kr.hs.entrydsm.yapaghetti.domain.auth.presentation;

import kr.hs.entrydsm.yapaghetti.domain.auth.api.SendEmailAuthCodePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthWebAdapter {

	private final SendEmailAuthCodePort sendEmailAuthCodePort;

	@PostMapping("/email")
	public void sendEmailAuthCode() {
		sendEmailAuthCodePort.execute();
	}
}
