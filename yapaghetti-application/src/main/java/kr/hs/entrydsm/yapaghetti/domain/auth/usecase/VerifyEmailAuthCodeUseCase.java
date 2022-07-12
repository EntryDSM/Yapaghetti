package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import java.time.LocalDateTime;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.VerifyEmailAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyTimeOutException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.InvalidAuthCodeException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class VerifyEmailAuthCodeUseCase implements VerifyEmailAuthCodePort {

	private final AuthSecurityPort authSecurityPort;
	private final AuthQueryUserPort authQueryUserPort;
	private final QueryAuthCodePort queryAuthCodePort;
	private final CommandAuthCodePort commandAuthCodePort;

	@Override
	public void execute(String authCode) {
		User user = authQueryUserPort.queryUserById(
			authSecurityPort.getCurrentUserId()
		);
		String value = user.getEmail();

		AuthCode authCodeDomain = queryAuthCodePort.queryAuthCodeById(value);

		if (authCodeDomain.isVerify()) {
			throw AuthCodeAlreadyVerifiedException.EXCEPTION;
		}

		if (authCodeDomain.getAuthTime().isBefore(LocalDateTime.now())) {
			throw AuthCodeAlreadyTimeOutException.EXCEPTION;
		}

		if (!authCodeDomain.getAuthCode().equals(authCode)) {
			throw InvalidAuthCodeException.EXCEPTION;
		}

		commandAuthCodePort.saveAuthCode(
			authCodeDomain.verify()
		);
	}
}
