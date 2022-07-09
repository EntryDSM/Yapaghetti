package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.SendEmailAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeLimit;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeType;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeOverLimitException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodeLimitPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GenerateRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodeLimitPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SendEmailAuthCodeUseCase implements SendEmailAuthCodePort {

	private final AuthSecurityPort authSecurityPort;
	private final AuthQueryUserPort authQueryUserPort;
	private final GenerateRandomStringPort generateRandomStringPort;
	private final SendMailPort sendMailPort;
	private final CommandAuthCodePort commandAuthCodePort;
	private final QueryAuthCodeLimitPort queryAuthCodeLimitPort;
	private final CommandAuthCodeLimitPort commandAuthCodeLimitPort;

	@Override
	public void execute() {
		AuthCodeType type = AuthCodeType.EMAIL;
		Long ttl = 300L;

		User user = authQueryUserPort.queryUserById(
			authSecurityPort.getCurrentUserId()
		);

		String value = user.getEmail();
		String authCode = generateRandomStringPort.getAuthCode();
		AuthCodeLimit authCodeLimit;

		if (commandAuthCodePort.existsAuthCodeById(value)) {
			authCodeLimit = queryAuthCodeLimitPort.queryAuthCodeLimitById(value)
				.upCount();

			if (authCodeLimit.getCount() > 5) {
				throw AuthCodeOverLimitException.EXCEPTION;
			}
		} else {
			authCodeLimit = AuthCodeLimit.builder()
				.value(value)
				.type(type)
				.timeToLive(ttl * 10)
				.count(1)
				.build();
		}

		AuthCode emailAuthCode = AuthCode.builder()
			.value(value)
			.authCode(authCode)
			.type(type)
			.isVerify(false)
			.timeToLive(ttl)
			.build();

		commandAuthCodePort.saveAuthCode(emailAuthCode);
		commandAuthCodeLimitPort.saveAuthCodeLimit(authCodeLimit);

		sendMailPort.sendAuthCode(value, authCode);
	}
}
