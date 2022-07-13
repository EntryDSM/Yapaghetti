package kr.hs.entrydsm.yapaghetti.domain.auth.presentation;

import javax.validation.constraints.NotBlank;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.SendEmailAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.SendPhoneNumberAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.VerifyEmailAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.VerifyAuthCodePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthWebAdapter {

	private final SendEmailAuthCodePort sendEmailAuthCodePort;
	private final SendPhoneNumberAuthCodePort sendPhoneNumberAuthCodePort;
	private final VerifyEmailAuthCodePort verifyEmailAuthCodePort;
	private final VerifyAuthCodePort verifyAuthCodePort;

	@PostMapping("/email")
	public void sendEmailAuthCode() {
		sendEmailAuthCodePort.execute();
	}

	@PostMapping("/phone-number")
	public void sendPhoneNumberAuthCode(@RequestBody @NotBlank String phoneNumber) {
		sendPhoneNumberAuthCodePort.execute(phoneNumber);
	}

	@RequestMapping(value = "/email", method = RequestMethod.HEAD)
	public void verifyEmailAuthCode(@RequestParam @NotBlank String authCode) {
		verifyEmailAuthCodePort.execute(authCode);
  }
  
	@RequestMapping(value = "/verify", method = RequestMethod.HEAD)
	public void verifyAuthCode(@RequestParam @NotBlank String authCode, @RequestParam @NotBlank String value) {
		verifyAuthCodePort.execute(authCode, value);
  }
}
