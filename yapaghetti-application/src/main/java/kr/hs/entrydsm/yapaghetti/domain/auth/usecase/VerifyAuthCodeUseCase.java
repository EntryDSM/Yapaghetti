package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import java.time.LocalDateTime;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.VerifyAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyTimeOutException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.InvalidAuthCodeException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class VerifyAuthCodeUseCase implements VerifyAuthCodePort {

	private final QueryAuthCodePort queryAuthCodePort;
	private final CommandAuthCodePort commandAuthCodePort;

	@Override
	public void execute(String authCode, String value) {

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
