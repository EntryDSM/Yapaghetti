package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import java.time.LocalDateTime;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeOverLimitException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GenerateRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GetAuthPropertiesPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SendEmailAuthCodeUseCaseTest {

	@Mock
	AuthSecurityPort authSecurityPort;

	@Mock
	AuthQueryUserPort authQueryUserPort;

	@Mock
	GenerateRandomStringPort generateRandomStringPort;

	@Mock
	SendMailPort sendMailPort;

	@Mock
	QueryAuthCodePort queryAuthCodePort;

	@Mock
	CommandAuthCodePort commandAuthCodePort;

	@Mock
	GetAuthPropertiesPort getAuthPropertiesPort;

	@InjectMocks
	SendEmailAuthCodeUseCase sendEmailAuthCodeUseCase;

	@Test
	void AuthCodeLimit존재() {
		UUID uuid = UUID.randomUUID();
		String value = "value";
		String authCode = "authCode";
		Long authTime = 1L;
		Long limitTime = 2L;

		given(getAuthPropertiesPort.getAuthTime())
			.willReturn(authTime);
		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(value)
					.build()
			);
		given(commandAuthCodePort.existsAuthCodeById(value))
			.willReturn(true);
		given(queryAuthCodePort.queryAuthCodeById(value))
			.willReturn(
				AuthCode.builder()
					.authTime(LocalDateTime.now())
					.timeToLive(authTime)
					.build()
			);
		given(getAuthPropertiesPort.getLimitTime())
			.willReturn(limitTime);

		sendEmailAuthCodeUseCase.execute();
	}

	@Test
	void AuthCode미존재() {
		UUID uuid = UUID.randomUUID();
		String value = "value";
		String authCode = "authCode";
		Long authTime = 1L;

		given(getAuthPropertiesPort.getAuthTime())
			.willReturn(authTime);
		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(value)
					.build()
			);
		given(commandAuthCodePort.existsAuthCodeById(value))
			.willReturn(false);

		sendEmailAuthCodeUseCase.execute();
	}

	@Test
	void 요청횟수초과() {
		UUID uuid = UUID.randomUUID();
		String value = "value";
		String authCode = "authCode";
		Long authTime = 2L;
		Long limitTime = 1L;

		given(getAuthPropertiesPort.getAuthTime())
			.willReturn(authTime);
		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(value)
					.build()
			);
		given(commandAuthCodePort.existsAuthCodeById(value))
			.willReturn(true);
		given(queryAuthCodePort.queryAuthCodeById(value))
			.willReturn(
				AuthCode.builder()
					.authTime(LocalDateTime.now())
					.timeToLive(authTime)
					.build()
			);
		given(getAuthPropertiesPort.getLimitTime())
			.willReturn(limitTime);

		assertThrows(AuthCodeOverLimitException.class, () -> sendEmailAuthCodeUseCase.execute());
	}

	@Test
	void 이미_인증됨() {
		UUID uuid = UUID.randomUUID();
		String value = "value";
		String authCode = "authCode";
		Long authTime = 1L;

		given(getAuthPropertiesPort.getAuthTime())
			.willReturn(authTime);
		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(value)
					.build()
			);
		given(commandAuthCodePort.existsAuthCodeById(value))
			.willReturn(true);
		given(queryAuthCodePort.queryAuthCodeById(value))
			.willReturn(
				AuthCode.builder()
					.authTime(LocalDateTime.now())
					.isVerify(true)
					.build()
			);
		assertThrows(AuthCodeAlreadyVerifiedException.class, () -> sendEmailAuthCodeUseCase.execute());
	}
}
