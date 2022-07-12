package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import java.time.LocalDateTime;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.VerifyAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeType;
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
public class VerifyAuthCodeUseCase implements VerifyAuthCodePort {

	private final AuthSecurityPort authSecurityPort;
	private final AuthQueryUserPort authQueryUserPort;
	private final QueryAuthCodePort queryAuthCodePort;
	private final CommandAuthCodePort commandAuthCodePort;

	@Override
	public void execute(String authCode, AuthCodeType type) {
		User user = authQueryUserPort.queryUserById(
			authSecurityPort.getCurrentUserId()
		);

		String value;
		if (type.equals(AuthCodeType.EMAIL)) {
			value = user.getEmail();
		} else if (type.equals(AuthCodeType.PHONE)){
			value = user.getPhoneNumber();
		}

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
