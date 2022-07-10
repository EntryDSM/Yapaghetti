package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import java.time.LocalDateTime;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.SendEmailAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeType;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeOverLimitException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GetAuthPropertiesPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GenerateRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodePort;
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
	private final QueryAuthCodePort queryAuthCodePort;
	private final CommandAuthCodePort commandAuthCodePort;
	private final GetAuthPropertiesPort getAuthPropertiesPort;

	@Override
	public void execute() {
		AuthCodeType type = AuthCodeType.EMAIL;
		Long authTime = getAuthPropertiesPort.getAuthTime();
		String authCode = generateRandomStringPort.getAuthCode();
		AuthCode emailAuthCode;

		User user = authQueryUserPort.queryUserById(
			authSecurityPort.getCurrentUserId()
		);
		String value = user.getEmail();

		if (commandAuthCodePort.existsAuthCodeById(value)) {
			emailAuthCode = queryAuthCodePort.queryAuthCodeById(value);

			if (emailAuthCode.getTimeToLive() > getAuthPropertiesPort.getLimitTime()) {
				throw AuthCodeOverLimitException.EXCEPTION;
			}

			emailAuthCode = emailAuthCode.refresh(authCode, authTime);
		} else {
			emailAuthCode = AuthCode.builder()
				.value(value)
				.authCode(authCode)
				.type(type)
				.isVerify(false)
				.timeToLive(authTime)
				.authTime(LocalDateTime.now().plusSeconds(authTime))
				.build();
		}

		commandAuthCodePort.saveAuthCode(emailAuthCode);

		sendMailPort.sendAuthCode(value, authCode);
	}
}
